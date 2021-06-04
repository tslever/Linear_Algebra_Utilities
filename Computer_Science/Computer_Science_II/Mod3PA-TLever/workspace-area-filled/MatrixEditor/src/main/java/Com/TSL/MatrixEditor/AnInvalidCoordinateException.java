package Com.TSL.MatrixEditor;


/** ******************************************************************************************************************
* AnInvalidCoordinateException represents the structure for an exception that occurs if a row or column coordinate for
* a matrix is negative.
* 
* @author Tom Lever
* @version 1.0
* @since 05/18/21
******************************************************************************************************************* */

class AnInvalidCoordinateException extends Exception {

	
	/** -----------------------------------------------------------------------------------------------------------------
	 * AnInvalidCoordinateException() is a conventional zero-argument constructor for AnInvalidCoordinateException, which
	 * calls Exception's zero-argument constructor.
	 ----------------------------------------------------------------------------------------------------------------- */
	
	AnInvalidCoordinateException() {
		super();
	}
	
	
	/** -----------------------------------------------------------------------------------------------------------------
	 * AnInvalidCoordinateException(String message) is a one-argument constructor for AnInvalidCoordinateException, which
	 * passes an error message to Exception's one-argument constructor with a message argument.
	 * 
	 * @param message
	 ----------------------------------------------------------------------------------------------------------------- */
	
	AnInvalidCoordinateException(String message) {
		super(message);
	}
	
}