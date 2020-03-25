package org.apache.catalina.startup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.catalina.Globals;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.apache.catalina.startup.ClassLoaderFactory.RepositoryType;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class Bootstrap {
	private static final Log log = LogFactory.getLog(Bootstrap.class);
	private static Bootstrap daemon = null;

	private static final File catalinaBaseFile;
	private static final File catalinaHomeFile;

	private static final Pattern PATH_PATTERN = Pattern.compile("(\".*?\")|(([^,])*)");
	static {
		String userDir = System.getProperty("user.dir");

		// Home first
		String home = System.getProperty(Globals.CATALINA_HOME_PROP);
		File homeFile = null;

		if (home != null) {
			File f = new File(home);
			try {
				homeFile = f.getCanonicalFile();
			} catch (IOException ioe) {
				homeFile = f.getAbsoluteFile();
			}
		}
		
		if (homeFile == null) {
			// First fall-back. See if current directory is a bin directory
			// in a normal Tomcat install
			File bootstrapJar = new File(userDir, "bootstrap.jar");

			if (bootstrapJar.exists()) {
				File f = new File(userDir, "..");
				try {
					homeFile = f.getCanonicalFile();
				} catch (IOException ioe) {
					homeFile = f.getAbsoluteFile();
				}
			}
		}

		if (homeFile == null) {
			// Second fall-back. Use current directory
			File f = new File(userDir);
			try {
				homeFile = f.getCanonicalFile();
			} catch (IOException ioe) {
				homeFile = f.getAbsoluteFile();
			}
		}

		catalinaHomeFile = homeFile;
		System.setProperty(Globals.CATALINA_HOME_PROP, catalinaHomeFile.getPath());

		// Then base
		String base = System.getProperty(Globals.CATALINA_BASE_PROP);
		if (base == null) {
			catalinaBaseFile = catalinaHomeFile;
		} else {
			File baseFile = new File(base);
			try {
				baseFile = baseFile.getCanonicalFile();
			} catch (IOException ioe) {
				baseFile = baseFile.getAbsoluteFile();
			}
			catalinaBaseFile = baseFile;
		}
		System.setProperty(Globals.CATALINA_BASE_PROP, catalinaBaseFile.getPath());
	}
	
	/**
	 * Daemon reference.
	 */
	private Object catalinaDaemon = null;

	ClassLoader commonLoader = null;
	ClassLoader catalinaLoader = null;
	ClassLoader sharedLoader = null;

	private void initClassLoaders()
	{
		try {
			commonLoader = createClassLoader("common", null);
			if (commonLoader == null) {
				// no config file, default to this loader - we might be in a
				// 'single' env.
				commonLoader = this.getClass().getClassLoader();
			}
			catalinaLoader = createClassLoader("server", commonLoader);
			sharedLoader = createClassLoader("shared", commonLoader);
		} catch (Throwable t) {
			handleThrowable(t);
			log.error("Class loader creation threw exception", t);
			System.exit(1);
		}
	}
	
	private static void handleThrowable(Throwable t)
	{
		if (t instanceof ThreadDeath) {
			throw (ThreadDeath) t;
		}
		if (t instanceof VirtualMachineError) {
			throw (VirtualMachineError) t;
		}
		// All other instances of Throwable will be silently swallowed
	}
	
	public static String getCatalinaHome()
	{
		return catalinaHomeFile.getPath();
	}
	
	public static String getCatalinaBase()
	{
		return catalinaBaseFile.getPath();
	}
	
	protected String replace(String str)
	{
		// Implementation is copied from ClassLoaderLogManager.replace(),
		// but added special processing for catalina.home and catalina.base.
		String result = str;
		int pos_start = str.indexOf("${");
		if (pos_start >= 0) {
			StringBuilder builder = new StringBuilder();
			int pos_end = -1;
			while (pos_start >= 0) {
				builder.append(str, pos_end + 1, pos_start);
				pos_end = str.indexOf('}', pos_start + 2);
				if (pos_end < 0) {
					pos_end = pos_start - 1;
					break;
				}
				String propName = str.substring(pos_start + 2, pos_end);
				String replacement;
				if (propName.length() == 0) {
					replacement = null;
				} else if (Globals.CATALINA_HOME_PROP.equals(propName)) {
					replacement = getCatalinaHome();
				} else if (Globals.CATALINA_BASE_PROP.equals(propName)) {
					replacement = getCatalinaBase();
				} else {
					replacement = System.getProperty(propName);
				}
				if (replacement != null) {
					builder.append(replacement);
				} else {
					builder.append(str, pos_start, pos_end + 1);
				}
				pos_start = str.indexOf("${", pos_end + 1);
			}
			builder.append(str, pos_end + 1, str.length());
			result = builder.toString();
		}
		return result;
	}
	
	protected static String[] getPaths(String value)
	{
		List<String> result = new ArrayList<>();
		Matcher matcher = PATH_PATTERN.matcher(value);

		while (matcher.find()) {
			String path = value.substring(matcher.start(), matcher.end());

			path = path.trim();
			if (path.length() == 0) {
				continue;
			}

			char first = path.charAt(0);
			char last = path.charAt(path.length() - 1);

			if (first == '"' && last == '"' && path.length() > 1) {
				path = path.substring(1, path.length() - 1);
				path = path.trim();
				if (path.length() == 0) {
					continue;
				}
			} else if (path.contains("\"")) {
				// Unbalanced quotes
				// Too early to use standard i18n support. The class path hasn't
				// been configured.
				throw new IllegalArgumentException(
						"The double quote [\"] character only be used to quote paths. It must "
								+ "not appear in a path. This loader path is not valid: [" + value + "]");
			} else {
				// Not quoted - NO-OP
			}

			result.add(path);
		}
		return result.toArray(new String[result.size()]);
	}
	
	private ClassLoader createClassLoader(String name, ClassLoader parent) throws Exception {
		String value = CatalinaProperties.getProperty(name + ".loader");
		if ((value == null) || (value.equals("")))
			return parent;

		value = replace(value);

		List<Repository> repositories = new ArrayList<>();
		
		String[] repositoryPaths = getPaths(value);

		for (String repository : repositoryPaths) {
			// Check for a JAR URL repository
			try {
				@SuppressWarnings("unused")
				URL url = new URL(repository);
				repositories.add(new Repository(repository, RepositoryType.URL));
				continue;
			} catch (MalformedURLException e) {
				// Ignore
			}

			// Local repository
			if (repository.endsWith("*.jar")) {
				repository = repository.substring(0, repository.length() - "*.jar".length());
				repositories.add(new Repository(repository, RepositoryType.GLOB));
			} else if (repository.endsWith(".jar")) {
				repositories.add(new Repository(repository, RepositoryType.JAR));
			} else {
				repositories.add(new Repository(repository, RepositoryType.DIR));
			}
		}

		return ClassLoaderFactory.createClassLoader(repositories, parent);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
