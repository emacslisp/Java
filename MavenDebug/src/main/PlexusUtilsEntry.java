package main;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.codehaus.plexus.util.Os;

public class PlexusUtilsEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Properties tmp = new Properties();
         boolean caseSensitive = !Os.isFamily( Os.FAMILY_WINDOWS );
         
         System.out.println(caseSensitive);
         
         for ( Map.Entry<String, String> entry : System.getenv().entrySet() )
         {
             String key =
                 "env." + ( caseSensitive ? entry.getKey() : entry.getKey().toUpperCase( Locale.ENGLISH ) );
             tmp.setProperty( key, entry.getValue() );
         }
         
         for (Object key: tmp.keySet()) {
             System.out.println(key + ": " + tmp.getProperty(key.toString()));
         }
	}

}
