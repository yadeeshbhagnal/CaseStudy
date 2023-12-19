
/**
 * The ArtworkNotFoundException class is a custom exception class that extends the base Exception class.
 * It is used to indicate that an artwork is not found in the Virtual Art Gallery.
 */
package com.hexaware.exception;

public class ArtworkNotFoundException extends Exception {
	
	 /**
     * Constructs a new ArtworkNotFoundException with the specified error message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
	public ArtworkNotFoundException (String message)
	{
		super(message);
	}
}
