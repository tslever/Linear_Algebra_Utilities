package Com.TSL.LineEditorUtilities;


/**
 * AnAppendsStringException represents the structure for an exception that occurs when a buffer of strings receives a
 * null reference to a string or a reference to an empty string.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/26/21
 */

public class AnAppendsStringException extends Exception {

	
	/**
	 * AnAppendsStringException(String message) is the one-parameter constructor for AnAppendsStringException, which
	 * passes a provided message to Exception's one-parameter constructor.
	 * 
	 * @param message
	 */
	
	public AnAppendsStringException(String message) {
		super(message);
	}
	
}