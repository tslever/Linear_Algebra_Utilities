package Com.TSL.RecursiveMultiplicationUtilities;


/**
* ANotSufficientlyImplementedException represents the structure for an exception that occurs when a program expects to
* run instructions but corresponding code has not been implemented yet.
* @author Tom Lever
* @version 1.0
* @since 05/18/21
*/
class ANotSufficientlyImplementedException extends Exception {

	/**
	 * ANotSufficientlyImplementedException() is a conventional zero-argument constructor for
	 * ANotSufficientlyImplementedException, which calls Exception's zero-argument constructor.
	 */
	ANotSufficientlyImplementedException() {
		super();
	}
	
	
	/**
	 * ANotSufficientlyImplementedException(String message) is a one-argument constructor for
	 * ANotSufficientlyImplementedException, which passes an error message to Exception's one-argument constructor with
	 * a message argument.
	 * @param message
	 */
	ANotSufficientlyImplementedException(String message) {
		super(message);
	}
	
}