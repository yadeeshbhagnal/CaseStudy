
/**
 * The DBConnUtil class is a utility class that provides methods for establishing
 * and managing database connections using JDBC (Java Database Connectivity).
 */
package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * The DBConnUtil class provides a single method, `getDBConnection()`, to obtain a
 * connection to the database using the specified connection properties.
 */
public class DBConnUtil {
	static Connection connection;
	static DBPropertyUtil propertyutil= new DBPropertyUtil();
	
	
	 /**
     * Establishes a connection to the database using the connection properties
     * obtained from the DBPropertyUtil class.
     *
     * @return A Connection object representing the database connection.
     */
	public Connection getDBConnection()
	{
		String connectionString = DBPropertyUtil.getPropertyString();
		String [] connectionStringSplit = connectionString.split(" ");
		
		try {
			connection = DriverManager.getConnection(connectionStringSplit[0],connectionStringSplit[1],connectionStringSplit[2]);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
}