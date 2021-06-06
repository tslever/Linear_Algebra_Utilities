package Com.TSL.RecursionWithArrays;


import java.util.Arrays;
import org.junit.jupiter.api.Test;


/** ***********************************************************************************************************
 * MainTest encapsulates a JUnit test of core functionality of the method main of class RecursiveMethodsArrays.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 05/21/21
 *********************************************************************************************************** */

public class MainTest {

	
	/** -------------------------------------------------------------------------------------------------------------
	 * testMain tests the method main by running smallest with one argument, smallest with two arguments, and repeat.
	 * repeat is given valid arguments. The case where repeat has a negative number of instances is tested in the
	 * main program execution.
	 ------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void testMainWithValidArgumentsAndArrays ()
	{
		
        int[] arr = {2, 4, 3, 89, 0, -9};

        System.out.println(RecursiveMethodsArrays.smallest(arr));

        int[][] ar = {{1, 2, 3, 4, 1, 0}, {0, -8, -90}};

        System.out.println(RecursiveMethodsArrays.smallest(ar));

        try
        {
        	System.out.println(RecursiveMethodsArrays.repeat("Java", Integer.parseInt("3")));
        }
        catch (IllegalArgumentException theIllegalArgumentException)
        {
        	System.out.println(theIllegalArgumentException.getMessage());
        }
		
	}
	
	
	/** --------------------------------------------------------------------------------------------
	 * testMainWithValidArgumentsAndAnEmptyArray tests main with valid arguments and an empty array.
	 -------------------------------------------------------------------------------------------- */
	
	@Test
	public void testMainWithValidArgumentsAndAnEmptyArray ()
	{
		
		int[] arr = {};
		
		try {
	        if (arr.length == 0)
	        {
	    	    throw new ANoMinimumExistsException (
	    	    	"Exception: No minimum exists in array arr = " + Arrays.toString(arr));
	        }
		}
		
		catch (ANoMinimumExistsException theNoMinimumExistsException)
		{
			System.out.println("\n" + theNoMinimumExistsException.getMessage());
		}
		
	}
	
}
