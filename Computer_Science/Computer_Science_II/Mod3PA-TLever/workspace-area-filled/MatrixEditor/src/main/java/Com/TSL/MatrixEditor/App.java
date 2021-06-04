package Com.TSL.MatrixEditor;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * Hello world!
 *
 */

public class App 
{
	
    public static void main (String[] args) throws
    	AnInvalidCoordinateException,	
    	FileNotFoundException,
    	UnsupportedEncodingException,
    	IOException,
    	AMatrixFileParsingException
    {
    	
    	int theRowCoordinate = TheInputAndOutputManager.providesTheCoordinateAsAnIntegerBasedOn(args[0]);
    	int theColumnCoordinate = TheInputAndOutputManager.providesTheCoordinateAsAnIntegerBasedOn(args[1]);
    	
    	
    	char[][] theMatrixOfCharacters = TheInputAndOutputManager.providesTheMatrixOfCharactersInTheFileAt(args[2]);
    	
    	System.out.println("\n\nOriginal Matrix:\n");
    	TheInputAndOutputManager.displays(theMatrixOfCharacters);
    	
    	
    	ACharacterReplacer theCharacterReplacer = new ACharacterReplacer(theMatrixOfCharacters);
    	
    	char theCharacterToReplace = theCharacterReplacer.getsTheCharacterAt(theRowCoordinate, theColumnCoordinate);
    	
    	theCharacterReplacer.replacesTheCharacterAt(theRowCoordinate, theColumnCoordinate);
    	
    	theCharacterReplacer.replacesCharactersAtOrLeftOfAndMatching(
    		theRowCoordinate, theColumnCoordinate - 1, theCharacterToReplace
    	);
    	
    	theCharacterReplacer.replacesCharactersAtOrRightOfAndMatching(
    		theRowCoordinate, theColumnCoordinate - 1, theCharacterToReplace
    	);
    	
    	theCharacterReplacer.replacesCharactersAtOrAboveAndOnEachSideOfAndMatching(
    		theRowCoordinate - 1, theColumnCoordinate, theCharacterToReplace
    	);

    	theCharacterReplacer.replacesCharactersAtOrBelowAndOnEachSideOfAndMatching(
    		theRowCoordinate + 1, theColumnCoordinate, theCharacterToReplace
    	);    	
    	
    	System.out.println("\n\nAfter replacing characters:");
    	TheInputAndOutputManager.displays(theMatrixOfCharacters);
    	
    }
    
}