
/**
 * The DBPropertyUtil class is a utility class that provides methods for reading
 * database connection properties from a configuration file.
 */
package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * The DBPropertyUtil class provides a single method, `getPropertyString()`, to read
 * database connection properties (URL, username, password) from a configuration file.
 */
public class DBPropertyUtil {
	
	 /**
     * Reads database connection properties from a configuration file and returns
     * a formatted string containing URL, username, and password.
     *
     * @return A formatted string containing database connection properties.
     */
	public static String getPropertyString ()
	{
		Properties properties = new Properties();
		FileInputStream fis = null;
		String fileName = "src/main/java/com/hexaware/util/db.properties";
		
		String url = null;
		String username = null;
		String password = null;
		
		try
		{
			fis = new FileInputStream(fileName);
			properties.load(fis);
			url = properties.getProperty("db.url");
			username =  properties.getProperty("db.username");
			password =  properties.getProperty("db.password");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return url + " " + username + " " + password;
	}
}
