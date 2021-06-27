package Com.TSL.LineEditorUtilities;


import java.io.IOException;


/**
 * LineEditor encapsulates a buffer of strings and the entry point of this program, which offers file-manipulation and
 * line-editing functionality.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/27/21
 */

public class LineEditor 
{
	
	public static final LineList bufferOfStrings = new LineList();
	
	
	/**
	 * main is the entry point of this program, which offers file-manipulation and line-editing functionality.
	 * 
	 * @param args
	 * @throws ACommandMenuHasBeenSetUpException
	 * @throws ACommandMenuHasNotBeenSetUpException
	 * @throws AnInsertsCommandException
	 * @throws AnInvalidCommandException
	 */
	
    public static void main(String[] args) throws
    	ABufferOfStringsIsNotEmptyException,
    	ACommandMenuHasBeenSetUpException,
    	ACommandMenuHasNotBeenSetUpException,
    	AnInsertsCommandException,
    	AnInvalidCharacterException,
    	AnInvalidCommandException,
    	IOException
    {
    	
    	// TODO: Check command-line arguments for a path to a text file. If a path is present, load the lines in the
    	// corresponding file into bufferOfStrings.
    	
    	AnInputManager theInputManager = new AnInputManager();
    	theInputManager.loadsAnyFileSpecifiedByTheFirstArgumentIn(args);
    	
    	TheCommandMenuGenerator.setsUpTheCommandMenu();
    	
    	theInputManager.providesAnIntroduction();
    	theInputManager.listensForAndExecutesCommands();
    	
    }
    
}
