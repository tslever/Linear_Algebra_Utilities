package com.tsl.more_operations_with_arrays.input_output_utilities;


/**
 * AReadIntegerIsNegativeException represents the structure for an exception that occurs when a read integer
 * is not positive.
 * @author Tom Lever
 * @version 1.0
 * @since 05/18/21
 */
class AReadIntegerIsNegativeException extends Exception {

	
	/**
	 * AReadIntegerIsNegativeException() is a conventional zero-argument constructor for
	 * AReadIntegerIsNegativeException, which calls Exception's zero-argument constructor.
	 */
	AReadIntegerIsNegativeException() {
		super();
	}
	
	
	/**
	 * AReadIntegerIsNegativeException(String message) is a one-argument constructor for
	 * AReadIntegerIsNegativeException, which passes an error message to Exception's one-argument
	 * constructor with a message argument.
	 * @param message
	 */
	public AReadIntegerIsNegativeException(String message) {
		super(message);
	}
	
}