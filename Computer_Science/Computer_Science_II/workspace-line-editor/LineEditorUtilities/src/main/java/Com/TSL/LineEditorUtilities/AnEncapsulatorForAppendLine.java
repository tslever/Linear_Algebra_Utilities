package Com.TSL.LineEditorUtilities;


import java.util.Scanner;


/**
 * AnEncapsulatorForAppendLine encapsulates a version of the edit method by which LineEditor appends a line to the
 * line editor's buffer of strings.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/26/21
 */

public class AnEncapsulatorForAppendLine extends AnEncapsulatorForEdit {
	
	
	/**
	 * edit allows LineEditor to listen for a line of text and append that line to the line editor's buffer of
	 * strings.
	 */
	
	public void edit(String[] theArrayOfArguments) {
		
		System.out.print("Type a line: ");
		Scanner theScannerForAppendLine = new Scanner(System.in);
		String theLine = theScannerForAppendLine.nextLine();
		
		if (theLine.equals("")) {
			System.out.println("An encapsulator for append_line received a reference to a line that was empty.");
			return;
		}
		
		try {
			LineEditor.bufferOfStrings.addLine(theLine);
		}
		catch (AnAppendsStringException theAppendsStringException) {
			System.out.println(theAppendsStringException.getMessage());
			return;
		}
		catch (AnInvalidCharacterException theInvalidCharacterException) {
			System.out.println(theInvalidCharacterException.getMessage());
			return;
		}
		
		System.out.println("The following line was added to the line editor's buffer of strings: \"" + theLine + "\".");
		
	}
	
}