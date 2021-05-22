package com.tsl.polynomials;


/**
 * AnUnimplementedException represents the structure for an exception that occurs when a program expects to run
 * instructions but corresponding code has not been implemented yet.
 * @author Tom Lever
 * @version 1.0
 * @since 05/18/21
 */
public class AnUnimplementedException extends Exception {

	/**
	 * AnUnimplementedException() is a conventional zero-argument constructor for AnUnimplementedException, which
	 * calls Exception's zero-argument constructor.
	 */
	AnUnimplementedException() {
		super();
	}
	
	
	/**
	 * AnUnimplementedException(String message) is a one-argument constructor for AnUnimplementedException, which
	 * passes an error message to Exception's one-argument constructor with a message argument.
	 * @param message
	 */
	public AnUnimplementedException(String message) {
		super(message);
	}
	
}