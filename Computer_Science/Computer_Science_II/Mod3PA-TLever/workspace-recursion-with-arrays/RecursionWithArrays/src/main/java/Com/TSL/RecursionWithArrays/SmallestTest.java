package Com.TSL.RecursionWithArrays;


import java.util.Arrays;
import org.junit.jupiter.api.Test;


/** **************************************************************************************************************
 * SmallestTest encapsulates JUnit tests of core functionality of the method main of class RecursiveMethodsArrays.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 05/21/21
 ************************************************************************************************************* */

public class SmallestTest {

	
	/** -----------------------------------------------------------------------------------------------------------------
	 * testSmallestWithOneParameter tests the method smallest with one parameter by ad infinitum creating one-dimensional
	 * arrays of various sizes of various integers and demonstrating that smallest finds the same minimum integer as
	 * a min method in Java's Arrays package for each array. testSmallestWithOneParameter stops if a different minimum
	 * is found.
	 ----------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void testSmallestWithOneParameter ()
	{
		final int THE_LOWEST_ARRAY_SIZE = 1;
		final int THE_HIGHEST_ARRAY_SIZE = 100;
		
		final int THE_LOWEST_INTEGER = -1073741823;
		final int THE_HIGHEST_INTEGER = 1073741823;
		
		
		int[] theArrayForWhichToFindAMinimum;
		
		while (true)
		{
			
			try
			{
				theArrayForWhichToFindAMinimum = new int [
				    TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween (
				    	THE_LOWEST_ARRAY_SIZE, THE_HIGHEST_ARRAY_SIZE
				    )
				];
				
				
				for (int i = 0; i < theArrayForWhichToFindAMinimum.length; i++)
				{
					theArrayForWhichToFindAMinimum [i] =
						TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween (
							THE_LOWEST_INTEGER, THE_HIGHEST_INTEGER
						);
				}
				
				
				if (Arrays.stream (theArrayForWhichToFindAMinimum).min ().getAsInt () ==
					RecursiveMethodsArrays.smallest (theArrayForWhichToFindAMinimum))
				{
					System.out.println (
						Arrays.stream (theArrayForWhichToFindAMinimum).min ().getAsInt () + " equals " +
						RecursiveMethodsArrays.smallest (theArrayForWhichToFindAMinimum) + "."
					);
				}
				else
				{
					System.out.println (
						Arrays.stream (theArrayForWhichToFindAMinimum).min ().getAsInt () + " does not equal " +
						RecursiveMethodsArrays.smallest (theArrayForWhichToFindAMinimum) + "."
					);
					break;
				}
				
				
			}
			catch (AnIntegerOverflowException theIntegerOverflowException)
			{
				System.out.println (theIntegerOverflowException.getMessage ());
			}
						
		}
		
	}
	
}
