package Com.TSL.LineEditorUtilities;


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * AnInputManager represents the structure for an input manager, which may provide an introduction or listen for and
 * execute commands.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/27/21
 */

public class AnInputManager {

	
	/**
	 * listensForAndExecutesCommands listens for commands to the line editor and executes those commands.
	 * 
	 * @throws AnInvalidCommandException
	 * @throws ACommandMenuHasNotBeenSetUpException
	 */

	public void listensForAndExecutesCommands() throws AnInvalidCommandException, ACommandMenuHasNotBeenSetUpException {
		
		Scanner theScannerForACommand = new Scanner(System.in);
		
		while (true) {
		
			System.out.print("--> ");
			String theCommand = theScannerForACommand.nextLine();
			
			if (theCommand.equals("")) {
				System.out.println("An input manager received a reference to a command that was empty.");
				continue;
			}
			
			ACommandMenu theCommandMenu = TheCommandMenuGenerator.providesItsCommandMenu();
			
			String[] theArrayOfComponentsOfTheCommand = theCommand.split(" ");
						
			switch (theArrayOfComponentsOfTheCommand[0].toLowerCase()) {
			
			case "a":
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand("Append line to the line editor's buffer", "a", null))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
				
			case "cls":
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand("Clear all lines from the line editor's buffer", "cls", null))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;

			case "lines":
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand(
					"Display the number of lines of the line editor's buffer of strings", "lines", null
			    ))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
			case "p":
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand("Print lines in the line editor's buffer", "p", null))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;

			case "save":
				if (theArrayOfComponentsOfTheCommand.length < 2) {
					System.out.println("An input manager received command \"save\" without a filename.");
					continue;
				}
				
				theCommandMenu
				.providesTheFirstInstanceOf(
					new ACommand("Save the lines in the line editor's buffer of strings to a file", "save <filename>", null)
				)
				.providesItsEncapsulatorForEdit()
				.edit(new String[] {theArrayOfComponentsOfTheCommand[1]});
				break;
				
			case "quit":
				theScannerForACommand.close();
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand("Quit the line editor", "quit", null))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
			}
		
		}
		
	}
	
	
	/**
	 * loadsAnyFileSpecifiedByTheFirstArgumentIn appends the lines 
	 * 
	 * @param args
	 * @throws AnInvalidCharacterException
	 * @throws IOException
	 */
	
	public void loadsAnyFileSpecifiedByTheFirstArgumentIn(String[] args)
		throws ABufferOfStringsIsNotEmptyException, AnInvalidCharacterException, IOException {
		
		if (args.length == 0) {
			return;
		}
		
		if (LineEditor.bufferOfStrings.lines() != 0) {
			throw new ABufferOfStringsIsNotEmptyException(
				"An input manager considered loading a file specified by a command-line argument when the line " +
				"editor's buffer of strings was not empty."
			);
		}
		
		String thePath = args[0];
		File theFile = new File(thePath);
		FileReader theFileReader = new FileReader(theFile, StandardCharsets.UTF_8);
		BufferedReader theBufferedReader = new BufferedReader(theFileReader);
		
		int thePresentCharacterAsAnInteger;
		char thePresentCharacter;
		StringBuilder theStringBuilder = new StringBuilder();
		while ((thePresentCharacterAsAnInteger = theBufferedReader.read()) != -1) {
			
			thePresentCharacter = (char)thePresentCharacterAsAnInteger;
			
			if ((thePresentCharacter != '\t') &&
				(thePresentCharacter != '\n') &&
				(thePresentCharacter != '\r') &&
				!((thePresentCharacter >= ' ') && (thePresentCharacter <= '[')) &&
				!((thePresentCharacter >= ']') && (thePresentCharacter <= '~'))
			   ) {
				throw new AnInvalidCharacterException(
					"The UTF-8 character with index " + thePresentCharacterAsAnInteger + " is invalid."
				);
			}
			
			theStringBuilder.append(thePresentCharacter);
			
			if (thePresentCharacter == '\n') {
				LineEditor.bufferOfStrings.addLine(theStringBuilder.toString());
				theStringBuilder = new StringBuilder();
			}
		}
		if (theStringBuilder.length() != 0) {
			LineEditor.bufferOfStrings.addLine(theStringBuilder.toString());
		}
		
		System.out.println(
			"The line editor added to its buffer of strings " + LineEditor.bufferOfStrings.lines() +
			" lines from the file at \"" + thePath + "\".\n"
		);
		
		theBufferedReader.close();
		
	}
	
	
	/**
	 * providesAnIntroduction provides an introduction for the line editor.
	 * 
	 * @throws ACommandMenuHasNotBeenSetUpException
	 */
	
	public void providesAnIntroduction() throws ACommandMenuHasNotBeenSetUpException {
		
		System.out.print("Welcome to LineEditor\n\n" + TheCommandMenuGenerator.providesItsCommandMenu() + "\n\n");
		
	}

}
