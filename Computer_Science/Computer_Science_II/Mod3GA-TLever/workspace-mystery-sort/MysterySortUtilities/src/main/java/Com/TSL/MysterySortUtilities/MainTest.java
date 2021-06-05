package Com.TSL.MysterySortUtilities;


import java.util.Arrays;
import org.junit.jupiter.api.Test;


/** *******************************************************************************************************************
 * MainTest encapsulates a JUnit test that performs multiple sorting processes with mysterySort and an array of various
 * sizes and random integers.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/05/21
 ******************************************************************************************************************* */

public class MainTest {
	
	
	/** ----------------------------------------------------------------------------------------------------------------
	 * testMain performs multiple sorting processes with mystery sort and an array of various sizes and random integers.
	 * 
	 * @throws AnIntegerOverflowException
	 ---------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void testMain() throws AnIntegerOverflowException
	{
		int[] theArraySizes = {0, 1, 2, 3, 5, 10};
		
		for (int i = 0; i < theArraySizes.length; i++)
		{

	    	int[] theArrayToSort = new int[theArraySizes[i]];
	    	for (int j = 0; j < theArraySizes[i]; j++)
	    	{
	    		theArrayToSort[j] =
	    			TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween(0, MysterySort.THE_MAXIMUM_INTEGER - 1);
	    	}
	    	System.out.println("The array to sort: " + Arrays.toString(theArrayToSort));
	    	TheInputAndOutputManager.printsWhetherOrNotIsSorted(theArrayToSort);
	    	
	    	
	    	System.out.println("Executing mysterySort.");
	    	MysterySort.mysterySort(theArrayToSort);
	    	System.out.println("The array after sorting: " + Arrays.toString(theArrayToSort));    	
	    	TheInputAndOutputManager.printsWhetherOrNotIsSorted(theArrayToSort);
	    	System.out.println("\n");
    	
		}
		
	}
	
}
