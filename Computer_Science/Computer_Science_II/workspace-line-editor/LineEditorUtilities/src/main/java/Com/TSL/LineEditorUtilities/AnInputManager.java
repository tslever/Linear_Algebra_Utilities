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
				.providesTheFirstInstanceOf(
					new ACommand("Append line to the line editor's buffer of strings", "a", null)
				)
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
				
			case "cls":
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand(
					"Clear all lines from the line editor's buffer of strings", "cls", null
				))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
			case "line":
				if (theArrayOfComponentsOfTheCommand.length < 2) {
					System.out.println("An input manager received command \"line\" without an index.");
					continue;
				}
				
				theCommandMenu
				.providesTheFirstInstanceOf(
					new ACommand("Display the line in the buffer of strings with a given index", "line", null)
				)
				.providesItsEncapsulatorForEdit()
				.edit(new String[] {theArrayOfComponentsOfTheCommand[1]});
				break;
				

			case "lines":
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand(
					"Display the number of lines of the line editor's buffer of strings", "lines", null
			    ))
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
			case "load":
				if (theArrayOfComponentsOfTheCommand.length < 3) {
					System.out.println(
						"An input manager received command \"load\" without a path and without an append / " +
						"overwrite option.");
					continue;
				}
				
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand(
					"Load lines from a file into the line editor's buffer of strings",
					"load <path relative to project directory> <append / overwrite option (true / false)>",
					null
				))
				.providesItsEncapsulatorForEdit()
				.edit(new String[] {theArrayOfComponentsOfTheCommand[1], theArrayOfComponentsOfTheCommand[2]});
				break;
				
			case "m":
				System.out.print(theCommandMenu + "\n\n");
				break;
				
			case "p":
				theCommandMenu
				.providesTheFirstInstanceOf(
					new ACommand("Print lines in the line editor's buffer of strings", "p", null)
				)
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;

			case "save":
				if (theArrayOfComponentsOfTheCommand.length < 2) {
					System.out.println("An input manager received command \"save\" without a path.");
					continue;
				}
				
				theCommandMenu
				.providesTheFirstInstanceOf(new ACommand(
					"Save the lines in the line editor's buffer of strings to a file",
					"save <path relative to project directory>",
					null
				))
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
				
			case "words":
				theCommandMenu
				.providesTheFirstInstanceOf(
					new ACommand("Display the number of words in the line editor's buffer of strings", "words", null)
				)
				.providesItsEncapsulatorForEdit()
				.edit(null);
				break;
				
			}
		
		}
		
	}

}
