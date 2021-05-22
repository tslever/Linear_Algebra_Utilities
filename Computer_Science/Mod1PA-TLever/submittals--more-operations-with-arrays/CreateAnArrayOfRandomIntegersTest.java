//package com.tsl.more_operations_with_arrays;


import org.junit.jupiter.api.Test;


/**
 * CreateAnArrayOfRandomIntegersTest encapsulates JUnit tests of core functionality of the method
 * createAnArrayOfRandomIntegers of class App.
 * @author Tom Lever
 * @version 1.0
 * @since 05/21/21
 *
 */
public class CreateAnArrayOfRandomIntegersTest {

	/**
	 * testCreateAnArrayOfRandomIntegers tests createAnArrayOfRandomIntegers by displaying the message of an integer
	 * overflow exception thrown when arithmetic involving a proposed lower limit and a proposed upper limit would
	 * result in integer overflow.
	 */
	@Test
	public void testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForRangeTooWide() {
		
		System.out.println("Running testCreateAnArrayOfRandomIntegers.");
		
		int theProposedLowerLimit = -1073741824;
		int theProposedUpperLimit =  1073741824;
		
		try {		
			
			if (theProposedUpperLimit > App.THE_MAXIMUM_INTEGER + theProposedLowerLimit - 1) {
				throw new AnIntegerOverflowException(
					"The proposed range [lower limit, upper limit] is too wide for a random number generator.\n" +
					"A possible range is [-1,073,741,823, 1,073,741,823]."
				);
			}
			
			System.out.println(
				"The proposed lower and upper limits are " +
				theProposedLowerLimit +
				" and " +
				theProposedUpperLimit +
				"."
			);
			
		}
		
		catch (AnIntegerOverflowException theIntegerOverflowException) {
			System.out.println(theIntegerOverflowException.getMessage());
		}
		
		System.out.println();
		
	}
	
}