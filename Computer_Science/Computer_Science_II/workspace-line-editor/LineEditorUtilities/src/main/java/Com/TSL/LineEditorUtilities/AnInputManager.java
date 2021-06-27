package Com.TSL.LineEditorUtilities;


import java.util.Scanner;
import java.util.Arrays;


public class AnInputManager {

	
	public void providesAnIntroduction() throws ACommandMenuHasNotBeenSetUpException {
		
		System.out.print("Welcome to LineEditor\n\n" + TheCommandMenuGenerator.providesItsCommandMenu() + "\n\n");
		
	}
	

	public void listensForAndExecutesCommands() throws AnInvalidCommandException, ACommandMenuHasNotBeenSetUpException {
		
		Scanner theScanner = new Scanner(System.in);
		
		while (true) {
		
			System.out.print("--> ");
			String theCommand = theScanner.nextLine();
			
			if (theCommand.equals("")) {
				System.out.println("An input manager received a reference to a command that was empty.");
				continue;
			}
			
			String[] theArrayOfComponentsOfTheCommand = theCommand.split(" ");
			
			if (theArrayOfComponentsOfTheCommand[0].equalsIgnoreCase("quit")) {
				TheCommandMenuGenerator
					.providesItsCommandMenu()
					.providesTheFirstInstanceOf(new ACommand("Quit LineEditor", "quit", null))
					.providesItsEncapsulatorForEdit()
					.edit();
			}
		
		}
		
	}

	
}
