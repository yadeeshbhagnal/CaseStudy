/**
 * The UserIdNotFoundException class is a custom exception class that extends the base Exception class.
 * It is used to indicate that a user ID is not found in the Virtual Art Gallery.
 */
package com.hexaware.exception;

public class UserIdNotFoundException extends Exception {
	
	 /**
     * Constructs a new UserIdNotFoundException with the specified error message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
	public UserIdNotFoundException (String message)
	{
		super(message);
	}
}
