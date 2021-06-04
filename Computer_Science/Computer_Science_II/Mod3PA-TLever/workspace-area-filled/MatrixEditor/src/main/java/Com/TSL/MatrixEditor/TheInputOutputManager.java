package Com.TSL.MatrixEditor;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


class TheInputAndOutputManager
{	
	
	static int providesTheCoordinateAsAnIntegerBasedOn(String theCoordinateAsAString)
		throws AnInvalidCoordinateException
	{
		int theCoordinateAsAnInteger = Integer.parseInt(theCoordinateAsAString);
		
    	if (theCoordinateAsAnInteger < 0)
    	{
    		throw new AnInvalidCoordinateException(
    			"Exception: Either the row coordinate or the column coordinate is negative."
    		);
    	}
    	
    	return theCoordinateAsAnInteger;
    	
	}
	
	
	static char[][] providesTheMatrixOfCharactersInTheFileAt(String thePath)
		throws FileNotFoundException, UnsupportedEncodingException, IOException, AMatrixFileParsingException
	{
		
        File theFile = new File(thePath);
        FileReader theFileReader = new FileReader(theFile, StandardCharsets.UTF_8);
        BufferedReader theBufferedReader = new BufferedReader(theFileReader);
        
        System.out.println("Original data in " + thePath + "\n");
        String theLineOfTheMatrixFileRepresentingTheHeightAndWidthOfTheMatrix = theBufferedReader.readLine();
        System.out.println(theLineOfTheMatrixFileRepresentingTheHeightAndWidthOfTheMatrix);
        
        String[] theHeightAndWidthOfTheMatrixAsAnArrayOfStrings =
        	theLineOfTheMatrixFileRepresentingTheHeightAndWidthOfTheMatrix.split(" ");
        
        if (theHeightAndWidthOfTheMatrixAsAnArrayOfStrings.length != 2)
        {
        	throw new AMatrixFileParsingException(
        		"Exception: The matrix file at the following path does not have a first line containing a matrix " +
        		"height and width: " + thePath
        	);
        }
        
        String theHeightOfTheMatrixAsAString = theHeightAndWidthOfTheMatrixAsAnArrayOfStrings[0];
        String theWidthOfTheMatrixAsAString = theHeightAndWidthOfTheMatrixAsAnArrayOfStrings[1];
        
        int theHeightOfTheMatrix = 0;
        int theWidthOfTheMatrix = 0;
        
        // parseInt throws NumberFormatException.
        theHeightOfTheMatrix = Integer.parseInt(theHeightOfTheMatrixAsAString);
        theWidthOfTheMatrix = Integer.parseInt(theWidthOfTheMatrixAsAString);
        
        if (theHeightOfTheMatrix < 0 || theWidthOfTheMatrix < 0)
        {
        	throw new AMatrixFileParsingException(
        		"Exception: Either the height of the matrix or the width of the matrix is negative."
        	);
        }
		
    	char[][] theMatrixOfCharacters = new char[theHeightOfTheMatrix][theWidthOfTheMatrix];
    	
    	int theIndexOfThePresentMatrixRow = 0;
    	String theLineRepresentingAMatrixRow;
    	int theNumberOfLinesRepresentingMatrixRows = 0;
    	
    	while ((theLineRepresentingAMatrixRow = theBufferedReader.readLine()) != null)
    	{
    		theNumberOfLinesRepresentingMatrixRows++;
    		if (theNumberOfLinesRepresentingMatrixRows > theHeightOfTheMatrix)
    		{
    			throw new AMatrixFileParsingException(
    				"Exception: The number of lines representing matrix rows is greater than the height of the " +
    				"matrix " + theHeightOfTheMatrix + "."
    			);
    		}
    		
    		System.out.println(theLineRepresentingAMatrixRow);
    		
    		if (theLineRepresentingAMatrixRow.length() != theWidthOfTheMatrix)
    		{
    			throw new AMatrixFileParsingException(
    				"Exception: The length of the line representing a matrix row \"" + theLineRepresentingAMatrixRow +
    				"\" is greater than the width of the matrix " + theHeightOfTheMatrix + "."
    			);
    		}
    		
    		for (int i = 0; i < theLineRepresentingAMatrixRow.length(); i++)
    		{
    			theMatrixOfCharacters[theIndexOfThePresentMatrixRow][i] = theLineRepresentingAMatrixRow.charAt(i);
    		}
    		theIndexOfThePresentMatrixRow++;
    	}
    	
    	theBufferedReader.close();
    	
    	if (theNumberOfLinesRepresentingMatrixRows < theHeightOfTheMatrix)
    	{
    		throw new AMatrixFileParsingException(
    			"Exception: The number of lines representing matrix rows is less than the height of the matrix " +
    			theHeightOfTheMatrix + "."
    		);
    	}    	
    	
        return theMatrixOfCharacters;
		
	}
	
	
	static void displays(char[][] theMatrixOfCharacters)
	{
        for (int i = 0; i < theMatrixOfCharacters.length; i++)
        {
        	for (int j = 0; j < theMatrixOfCharacters[0].length; j++)
        	{
        		System.out.print(theMatrixOfCharacters[i][j]);
        	}
        	
        	System.out.println();
        }
	}
	
}