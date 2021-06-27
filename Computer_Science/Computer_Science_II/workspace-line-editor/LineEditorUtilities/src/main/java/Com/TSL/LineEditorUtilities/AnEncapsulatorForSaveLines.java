package Com.TSL.LineEditorUtilities;


/**
 * AnEncapsulatorForSaveLines encapsulates a version of the edit method by which the line editor saves the lines in
 * its buffer of strings to a file at a provided path.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/26/21
 */

public class AnEncapsulatorForSaveLines extends AnEncapsulatorForEdit {
	
	
	/**
	 * edit allows the line editor to clear all lines in its buffer of strings.
	 */
	
	public void edit(String[] theArrayOfArguments) {
		
		String theFilename = theArrayOfArguments[0];
		
		LineEditor.bufferOfStrings.save(theFilename);
		
		System.out.println(
			"The lines in the line editor's buffer of strings were saved to a file at " + theFilename + "."
		);
		
	}
	
}