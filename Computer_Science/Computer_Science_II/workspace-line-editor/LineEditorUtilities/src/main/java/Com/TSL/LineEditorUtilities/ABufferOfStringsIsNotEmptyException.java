package Com.TSL.LineEditorUtilities;


/**
 * ABufferOfStringsIsNotEmptyException represents the structure for an exception that occurs when an input manager
 * considers loading a file specified by a command-line argument and the line editor's buffer of strings is not empty.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/26/21
 */

public class ABufferOfStringsIsNotEmptyException extends Exception {

	
	/**
	 * ABufferOfStringsIsNotEmptyException(String message) is the one-parameter constructor for
	 * ABufferOfStringsIsNotEmptyException, which passes a provided message to Exception's one-parameter constructor.
	 * 
	 * @param message
	 */
	
	public ABufferOfStringsIsNotEmptyException(String message) {
		super(message);
	}
	
}