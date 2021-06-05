package Com.TSL.SelectionSortUtilities;


import java.util.Arrays;


/**
 * Hello world!
 *
 */

public class SelectionSortPA 
{
	
	private static int[] theArrayOfIntegers;
	
	
    public static void main( String[] args ) throws AnInvalidArraySizeException, AnIntegerOverflowException
    {

    	int theArraySize = TheInputAndOutputManager.providesTheArraySizeAsAnIntegerBasedOn(args[0]);
    	
    	theArrayOfIntegers = new int[theArraySize];
    	
    	for (int i = 0; i < theArraySize; i++)
    	{
    		theArrayOfIntegers[i] =
    			TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween(0, Integer.MAX_VALUE - 1);
    	}
    	
		System.out.println("The array to sort: " + Arrays.toString(theArrayOfIntegers));
		System.out.println("The number of elements in the array: " + theArrayOfIntegers.length);
		TheInputAndOutputManager.printsWhetherOrNotIsSorted(theArrayOfIntegers);
		
		System.out.println("\nExecuting a selection sort.");
		long theStartTime = System.nanoTime();
		selectionSort(theArrayOfIntegers);
		long theEndTime = System.nanoTime();
		System.out.println("The merge sort (with printing) took " + (theEndTime - theStartTime) + " nanoseconds.");	
	
		System.out.println("\nThe array after sorting: " + Arrays.toString(theArrayOfIntegers));
		TheInputAndOutputManager.printsWhetherOrNotIsSorted(theArrayOfIntegers);
		
    }
    
    
    public static void selectionSort(int[] arr)
    {
    	// Refer to the program for MergeSort in Module 3B Guided Assignment: Problem 2.
    	
    	int theIndexOfTheLastIntegerInTheArray = arr.length - 1;
    	for (int i = 0; i < theIndexOfTheLastIntegerInTheArray; i++)
    	{
    		swapTheIntegersInTheArrayAt(
    			i, getTheIndexOfTheMinimumIntegerInTheSubArrayInclusivelyBetween(i, theIndexOfTheLastIntegerInTheArray)
    		);
    		
    		System.out.println(
    			"\tThe array of integers after iteration " + i + " of Selection Sort: " +
    			Arrays.toString(theArrayOfIntegers)
    		);
    	}
    	
    }
    
    
    private static int getTheIndexOfTheMinimumIntegerInTheSubArrayInclusivelyBetween(
    	int theIndexOfTheFirstIntegerInTheSubArray, int theIndexOfTheLastIntegerInTheSubArray
    )
    {
    	int theIndexOfTheMinimumIntegerInTheSubArray = theIndexOfTheFirstIntegerInTheSubArray;
    	
    	for (int j = theIndexOfTheFirstIntegerInTheSubArray + 1; j <= theIndexOfTheLastIntegerInTheSubArray; j++)
    	{
    		if (theArrayOfIntegers[j] < theArrayOfIntegers[theIndexOfTheMinimumIntegerInTheSubArray])
    		{
    			theIndexOfTheMinimumIntegerInTheSubArray = j;
    		}
    	}
    	
    	return theIndexOfTheMinimumIntegerInTheSubArray;
    	
    }
    
    
    private static void swapTheIntegersInTheArrayAt(int theFirstIndex, int theSecondIndex)
    {
    	int thePlaceholder = theArrayOfIntegers[theFirstIndex];
    	
    	theArrayOfIntegers[theFirstIndex] = theArrayOfIntegers[theSecondIndex];
    	
    	theArrayOfIntegers[theSecondIndex] = thePlaceholder;
    }
    
    
    /** ----------------------------------------------------
     * isSorted indicates whether or not an array is sorted.
     * 
     * @param arr
     * @return
     --------------------------------------------------- */
    
    public static boolean isSorted(int[] theArray)
    {
        for(int i = 1; i < theArray.length; i++)
        {
            if(theArray[i] < theArray[i-1]) {
            	return false;
            }
     	}
     	
        return true;
    }
    
}
