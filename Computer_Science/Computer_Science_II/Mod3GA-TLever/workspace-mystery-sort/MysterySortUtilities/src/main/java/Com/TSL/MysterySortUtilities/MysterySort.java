package Com.TSL.MysterySortUtilities;


import java.util.Arrays;


/** *****************************************************************************************************************
 * MysterySort encapsulates the entry point of this program, which creates an array of random integers, displays the
 * created array, indicates whether or not the created array is already sorted, executes a mystery sort, displays the
 * sorted array, and indicates whether or not the sorted array is actually sorted.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/05/21
 **************************************************************************************************************** */

public class MysterySort
{
	
	// TODO: Change to private before deployment.
	static final int THE_MAXIMUM_INTEGER = 2147483647;
	
	private static int theNumberOfComparisons = 0;
	
	
	/** ----------------------------------------------------------------------------------------------------------------
	 * main is the entry point of this program, which creates an array of random integers, displays the created array,
	 * indicates whether or not the created array is already sorted, executes a mystery sort, displays the sorted array,
	 * and indicates whether or not the sorted array is actually sorted.
	 ---------------------------------------------------------------------------------------------------------------- */
	
    public static void main( String[] args ) throws AnInvalidArraySizeException, AnIntegerOverflowException
    {
    	
    	int theArraySize = TheInputAndOutputManager.providesTheArraySizeAsAnIntegerBasedOn(args[0]);
    	
    	
    	int[] theArrayToSort = new int[theArraySize];
    	for (int i = 0; i < theArraySize; i++)
    	{
    		theArrayToSort[i] =
    			TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween(0, THE_MAXIMUM_INTEGER - 1);
    		//theArrayToSort[i] = TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween(0, 99);
    	}
    	System.out.println("The array to sort: " + Arrays.toString(theArrayToSort));
    	TheInputAndOutputManager.printsWhetherOrNotIsSorted(theArrayToSort);
    	
    	
    	System.out.println("Executing mysterySort.");
    	mysterySort(theArrayToSort);
    	System.out.println("The array after sorting: " + Arrays.toString(theArrayToSort));    	
    	TheInputAndOutputManager.printsWhetherOrNotIsSorted(theArrayToSort);
    	System.out.println("mysterySort performed " + theNumberOfComparisons + " comparisons.");
        
    }
    
    
    /** ----------------------------------------------------
     * isSorted indicates whether or not an array is sorted.
     * 
     * @param arr
     * @return
     --------------------------------------------------- */
    
    public static Boolean isSorted(int[] arr)
    {
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] < arr[i-1]) {
            	return false;
            }
     	}
     	
        return true;
    }
    
    
    /** -----------------------------------------------
     * mysterySort performs a mystery sort of an array.
     * 
     * @param arr
     ----------------------------------------------- */
    
    public static void mysterySort(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int k=0; k<arr.length-i-1; k++)
            {
            	theNumberOfComparisons++;
            	
                if(arr[k]>arr[k+1])
                {
               	    int hold=arr[k+1];
               	    
               	    arr[k+1]=arr[k];
               	    
               	    arr[k]=hold;
            	}
         	}
      	}
    }
        
}
