package Com.TSL.LineEditorUtilities;


public class TheCommandMenuGenerator {

	
	private static ACommandMenu commandMenu;
	private static boolean theCommandMenuHasBeenSetUp;
	
	
	public static void setsUpTheCommandMenu() throws AnInsertsCommandException {
		
    	commandMenu = new ACommandMenu();
    	
    	// On receiving command append_line <line>, if line does not exist, this program prompts the user for another
    	// command. Otherwise, ABufferOfStrings.append appends the typed string into the buffer of strings.
    	//theCommandMenu.inserts(new ACommand("Append line", "append_line <line>"));
    	
    	//theCommandMenu.inserts(new ACommand("Clear document", "clear_document"));
    	//theCommandMenu.inserts(new ACommand("Count words", "count_words"));
    	//theCommandMenu.inserts(new ACommand("Delete line", "delete_line <line number>"));
    	//theCommandMenu.inserts(new ACommand("Display line", "display_line <line number>"));
    	//theCommandMenu.inserts(new ACommand("Display number of lines", "display_number_of_lines"));
    	//theCommandMenu.inserts(new ACommand("Insert line", "insert <line number>"));
    	//theCommandMenu.inserts(new ACommand("Load file", "load_file_at <filename> <append option (1: append, 0: new list)>"));
    	//theCommandMenu.inserts(new ACommand("Menu", "menu"));
    	//theCommandMenu.inserts(new ACommand("Print", "print"));
    	commandMenu.inserts(new ACommand("Quit LineEditor", "quit", new AnEncapsulatorForQuit()));
    	//theCommandMenu.inserts(new ACommand("Replace instances of first word with second word", "replace_instances_of <first word> <second word>"));
    	//theCommandMenu.inserts(new ACommand("Save to a file", "save_to <filename>"));
    	
    	theCommandMenuHasBeenSetUp = true;
		
	}
	
	
	public static ACommandMenu providesItsCommandMenu() throws ACommandMenuHasNotBeenSetUpException {
		
		if (!theCommandMenuHasBeenSetUp) {
			throw new ACommandMenuHasNotBeenSetUpException(
				"The command-menu generator tried to provide a command menu that was not set up."
			);
		}
    	
    	return commandMenu;
		
	}
	
}
