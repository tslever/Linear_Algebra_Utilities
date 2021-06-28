package Com.TSL.LineEditorUtilities;


/**
 * TheCommandMenuGenerator encapsulates a command menu, an indicator of whether or not the command menu has been set up,
 * a method to set up the command menu, and a method to provide the command menu.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/27/21
 */

public class TheCommandMenuGenerator {

	
	private static ACommandMenu commandMenu;
	private static boolean theCommandMenuHasBeenSetUp = false;
	
	
	/**
	 * setsUpTheCommandMenu sets up this generator's command menu, if the command menu has not been set up already.
	 * 
	 * @throws ACommandMenuHasBeenSetUpException
	 * @throws AnInsertsCommandException
	 */
	
	public static void setsUpTheCommandMenu() throws ACommandMenuHasBeenSetUpException, AnInsertsCommandException {
		
		if (theCommandMenuHasBeenSetUp) {
			throw new ACommandMenuHasBeenSetUpException(
				"The command-menu generator tried to set up a command menu that was already set up."
			);
		}
		
    	commandMenu = new ACommandMenu();
    	
    	// On receiving command "a", the line editor prompts the user to enter a line of text. If the line is
    	// empty, the line editor provides a warning and prompts the user for another command. Otherwise, the line editor
    	// appends the line of text to the line editor's buffer of strings.
    	commandMenu.inserts(
    		new ACommand("Append line to the line editor's buffer of strings", "a", new AnEncapsulatorForAppendLine())
    	);
    	
    	// On receiving command "cls", the line editor clears all lines from the line editor's buffer of strings. 
    	commandMenu.inserts(new ACommand(
    		"Clear all lines from the line editor's buffer of strings", "cls", new AnEncapsulatorForClearBuffer()
    	));
    	
//theCommandMenu.inserts(new ACommand("Count words", "count_words"));
//theCommandMenu.inserts(new ACommand("Delete line", "delete_line <line number>"));
    	
    	commandMenu.inserts(new ACommand(
    		"Display the line in the buffer of strings with a given index",
    		"line <index>",
    		new AnEncapsulatorForDisplayLine()
    	));
    	
    	// On receiving command "lines", the line editor outputs the number of lines in its buffer of strings to the
    	// standard output stream.
    	commandMenu.inserts(new ACommand(
    		"Display the number of lines of the line editor's buffer of strings",
    		"lines",
    		new AnEncapsulatorForGetNumberOfLines()
    	));
    	
//theCommandMenu.inserts(new ACommand("Insert line", "insert <line number>"));
    	
    	// On receiving command "load", the line editor clears its buffer of strings if an append / overwrite option is
    	// false, loads the file at the provided path, and appends the lines in that file to the line editor's buffer
    	// of strings.
    	commandMenu.inserts(new ACommand(
			"Load lines from a file into the line editor's buffer of strings",
			"load <path relative to project directory> <append / overwrite option (true / false)>",
			new AnEncapsulatorForLoadFile()
		));
			
    	commandMenu.inserts(new ACommand("Display this command menu", "m", null));
    	
    	// On receiving command "p", the line editor outputs all lines in its buffer of strings, along with their
    	// indices, to the standard output stream.
    	commandMenu.inserts(
    		new ACommand("Print lines in the line editor's buffer of strings", "p", new AnEncapsulatorForPrintLines())
    	);
    	
    	// On received command "quit", the line editor indicates that it is quitting and quits.
    	commandMenu.inserts(new ACommand("Quit the line editor", "quit", new AnEncapsulatorForQuit()));
    	
//theCommandMenu.inserts(new ACommand("Replace instances of first word with second word", "replace_instances_of <first word> <second word>"));

    	// On receiving command "save", the line editor saves the lines in its buffer of lines to a file at a provided
    	// path.
    	commandMenu.inserts(new ACommand(
    		"Save the lines in the line editor's buffer of strings to a file",
    		"save <path relative to project directory>",
    		new AnEncapsulatorForSaveLines())
    	);
    	
    	theCommandMenuHasBeenSetUp = true;
		
	}
	
	
	/**
	 * providesItsCommandMenu provides the command menu of this generator.
	 * 
	 * @return
	 * @throws ACommandMenuHasNotBeenSetUpException
	 */
	
	public static ACommandMenu providesItsCommandMenu() throws ACommandMenuHasNotBeenSetUpException {
		
		if (!theCommandMenuHasBeenSetUp) {
			throw new ACommandMenuHasNotBeenSetUpException(
				"The command-menu generator tried to provide a command menu that was not set up."
			);
		}
    	
    	return commandMenu;
		
	}
	
}
