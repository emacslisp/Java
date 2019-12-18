package org.apache.tomcat.util.res;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class StringManager {
	private static int LOCALE_CACHE_SIZE = 10;

	/**
	 * The ResourceBundle for this StringManager.
	 */
	private final ResourceBundle bundle;
	private final Locale locale;
	
	private StringManager(String packageName, Locale locale) {
		String bundleName = packageName + ".LocalStrings";
		ResourceBundle bnd = null;
		try {
			bnd = ResourceBundle.getBundle(bundleName, locale);
		} catch (MissingResourceException ex) {
			// Try from the current loader (that's the case for trusted apps)
			// Should only be required if using a TC5 style classloader
			// structure
			// where common != shared != server
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if (cl != null) {
				try {
					bnd = ResourceBundle.getBundle(bundleName, locale, cl);
				} catch (MissingResourceException ex2) {
					// Ignore
				}
			}
		}
		bundle = bnd;
		// Get the actual locale, which may be different from the requested one
		if (bundle != null) {
			Locale bundleLocale = bundle.getLocale();
			if (bundleLocale.equals(Locale.ROOT)) {
				this.locale = Locale.ENGLISH;
			} else {
				this.locale = bundleLocale;
			}
		} else {
			this.locale = null;
		}
	}
	
	public String getString(String key)
	{
		if (key == null) {
			String msg = "key may not have a null value";
			throw new IllegalArgumentException(msg);
		}

		String str = null;

		try {
			// Avoid NPE if bundle is null and treat it like an MRE
			if (bundle != null) {
				str = bundle.getString(key);
			}
		} catch (MissingResourceException mre) {
			// bad: shouldn't mask an exception the following way:
			// str = "[cannot find message associated with key '" + key +
			// "' due to " + mre + "]";
			// because it hides the fact that the String was missing
			// from the calling code.
			// good: could just throw the exception (or wrap it in another)
			// but that would probably cause much havoc on existing
			// code.
			// better: consistent with container pattern to
			// simply return null. Calling code can then do
			// a null check.
			str = null;
		}

		return str;
	}
	
	public String getString(final String key, final Object... args)
	{
		String value = getString(key);
		if (value == null) {
			value = key;
		}

		MessageFormat mf = new MessageFormat(value);
		mf.setLocale(locale);
		return mf.format(args, new StringBuffer(), null).toString();
	}
	
	public Locale getLocale()
	{
		return locale;
	}
	
	private static final Map<String, Map<Locale, StringManager>> managers = new Hashtable<>();
	
	public static final StringManager getManager(Class<?> clazz)
	{Thread.dumpStack();
		return getManager(clazz.getPackage().getName());
	}

	/**
	 * Get the StringManager for a particular package. If a manager for a
	 * package already exists, it will be reused, else a new StringManager will
	 * be created and returned.
	 *
	 * @param packageName
	 *            The package name
	 *
	 * @return The instance associated with the given package and the default
	 *         Locale
	 */
	public static final StringManager getManager(String packageName)
	{
		return getManager(packageName, Locale.getDefault());
	}

	/**
	 * Get the StringManager for a particular package and Locale. If a manager
	 * for a package/Locale combination already exists, it will be reused, else
	 * a new StringManager will be created and returned.
	 *
	 * @param packageName
	 *            The package name
	 * @param locale
	 *            The Locale
	 *
	 * @return The instance associated with the given package and Locale
	 */
	public static final synchronized StringManager getManager(String packageName, Locale locale)
	{
		Map<Locale, StringManager> map = managers.get(packageName);
		if (map == null) {
			/*
			 * Don't want the HashMap to be expanded beyond LOCALE_CACHE_SIZE.
			 * Expansion occurs when size() exceeds capacity. Therefore keep
			 * size at or below capacity. removeEldestEntry() executes after
			 * insertion therefore the test for removal needs to use one less
			 * than the maximum desired size
			 *
			 */
			map = new LinkedHashMap<Locale, StringManager>(LOCALE_CACHE_SIZE, 1, true) {
				private static final long serialVersionUID = 1L;

				@Override
				protected boolean removeEldestEntry(Map.Entry<Locale, StringManager> eldest)
				{
					if (size() > (LOCALE_CACHE_SIZE - 1)) {
						return true;
					}
					return false;
				}
			};
			managers.put(packageName, map);
		}

		StringManager mgr = map.get(locale);
		if (mgr == null) {
			mgr = new StringManager(packageName, locale);
			map.put(locale, mgr);
		}
		return mgr;
	}

	/**
	 * Retrieve the StringManager for a list of Locales. The first StringManager
	 * found will be returned.
	 *
	 * @param packageName
	 *            The package for which the StringManager was requested
	 * @param requestedLocales
	 *            The list of Locales
	 *
	 * @return the found StringManager or the default StringManager
	 */
	public static StringManager getManager(String packageName, Enumeration<Locale> requestedLocales)
	{
		while (requestedLocales.hasMoreElements()) {
			Locale locale = requestedLocales.nextElement();
			StringManager result = getManager(packageName, locale);
			if (result.getLocale().equals(locale)) {
				return result;
			}
		}
		// Return the default
		return getManager(packageName);
	}
}
