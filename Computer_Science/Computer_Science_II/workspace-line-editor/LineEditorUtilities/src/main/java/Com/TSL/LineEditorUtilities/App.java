package Com.TSL.LineEditorUtilities;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    	throws ACommandMenuHasNotBeenSetUpException, AnInsertsCommandException, AnInvalidCommandException
    {
    	
    	TheCommandMenuGenerator.setsUpTheCommandMenu();
    	
    	AnInputManager theInputManager = new AnInputManager();
    	theInputManager.providesAnIntroduction();
    	theInputManager.listensForAndExecutesCommands();
    	
    }
    
}
