package Com.TSL.MatrixEditor;


class ACharacterReplacer
{
	
	private char[][] matrixOfCharacters;
	
	
	ACharacterReplacer(char[][] theMatrixOfCharactersToUse)
	{
		this.matrixOfCharacters = theMatrixOfCharactersToUse;
	}
	
	
	char getsTheCharacterAt(int theRowCoordinate, int theColumnCoordinate)
	{
		return this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate];
	}
	
	
	void replacesTheCharacterAt(int theRowCoordinate, int theColumnCoordinate)
	{
		this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] = '*';
	}
	
	
	void replacesCharactersAtOrAboveAndOnEachSideOfAndMatching(
		int theRowCoordinate, int theColumnCoordinate, char theCharacterToReplace
	)
	{
		
		if (theRowCoordinate > 0)
		{
			replacesCharactersAtOrAboveAndOnEachSideOfAndMatching(
				theRowCoordinate - 1, theColumnCoordinate, theCharacterToReplace
			);
		}
		
		if (theColumnCoordinate > 0)
		{
			replacesCharactersAtOrLeftOfAndMatching(theRowCoordinate, theColumnCoordinate - 1, theCharacterToReplace);
		}
		
		if (this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] == theCharacterToReplace)
		{
			this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] = '*';		
		}
		
		if (theColumnCoordinate < this.matrixOfCharacters[0].length - 1)
		{
			replacesCharactersAtOrRightOfAndMatching(theRowCoordinate, theColumnCoordinate + 1, theCharacterToReplace);
		}
		
	}
	
	
	void replacesCharactersAtOrBelowAndOnEachSideOfAndMatching(
		int theRowCoordinate, int theColumnCoordinate, char theCharacterToReplace
	)
	{
		if (theRowCoordinate < this.matrixOfCharacters.length - 1)
		{
			replacesCharactersAtOrBelowAndOnEachSideOfAndMatching(
				theRowCoordinate + 1, theColumnCoordinate, theCharacterToReplace
			);
		}
		
		if (theColumnCoordinate > 0)
		{
			replacesCharactersAtOrLeftOfAndMatching(theRowCoordinate, theColumnCoordinate - 1, theCharacterToReplace);
		}
		
		if (theColumnCoordinate < this.matrixOfCharacters[0].length - 1)
		{
			replacesCharactersAtOrRightOfAndMatching(theRowCoordinate, theColumnCoordinate + 1, theCharacterToReplace);
		}
		
		if (this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] == theCharacterToReplace)
		{
			this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] = '*';
		}
		
	}
	
	
	void replacesCharactersAtOrLeftOfAndMatching(
		int theRowCoordinate, int theColumnCoordinate, char theCharacterToReplace
	)
	{
		if (theColumnCoordinate > 0)
		{
			replacesCharactersAtOrLeftOfAndMatching(theRowCoordinate, theColumnCoordinate - 1, theCharacterToReplace);
		}
		
		if (this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] == theCharacterToReplace)
		{
			this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] = '*';
		}
		
	}
	
	
	void replacesCharactersAtOrRightOfAndMatching(
		int theRowCoordinate, int theColumnCoordinate, char theCharacterToReplace
	)
	{
		if (theColumnCoordinate < this.matrixOfCharacters[0].length - 1)
		{
			replacesCharactersAtOrRightOfAndMatching(theRowCoordinate, theColumnCoordinate + 1, theCharacterToReplace);
		}
		
		if (this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] == theCharacterToReplace)
		{
			this.matrixOfCharacters[theRowCoordinate][theColumnCoordinate] = '*';
		}
		
	}
	
}