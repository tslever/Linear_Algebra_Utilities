package Com.TSL.BubbleAndInsertionSortingUtilities;


class TheInputAndOutputManager
{	
	
	static int providesTheArraySizeAsAnIntegerBasedOn(String theArraySizeAsAString) throws AnInvalidArraySizeException
	{
		int theArraySizeAsAnInteger = Integer.parseInt(theArraySizeAsAString);
		
    	if (theArraySizeAsAnInteger < 0)
    	{
    		throw new AnInvalidArraySizeException("Exception: The array size is negative.");
    	}
    	
    	return theArraySizeAsAnInteger;
    	
	}
	
}