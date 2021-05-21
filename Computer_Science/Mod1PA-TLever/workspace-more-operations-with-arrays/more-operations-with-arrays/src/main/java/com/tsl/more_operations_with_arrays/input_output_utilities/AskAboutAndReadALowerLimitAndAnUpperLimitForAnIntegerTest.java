package com.tsl.more_operations_with_arrays.input_output_utilities;


import org.junit.jupiter.api.Test;

import com.tsl.more_operations_with_arrays.AnIntegerOverflowException;
import com.tsl.more_operations_with_arrays.App;


public class AskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerTest {
	
	@Test
	public void testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForValidRange() {
		
		System.out.println("Running testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForValidRange.");
		
		int theProposedLowerLimit = -1073741823;
		int theProposedUpperLimit =  1073741823;
		
		try {		
			if (theProposedLowerLimit > theProposedUpperLimit) {
				throw new ALowerLimitIsGreaterThanUpperLimitException(
					"The proposed lower limit is greater than the proposed upper limit.");
			}
			
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
		
		catch (ALowerLimitIsGreaterThanUpperLimitException theLowerLimitIsGreaterThanUpperLimitException) {
			System.out.println(theLowerLimitIsGreaterThanUpperLimitException.getMessage());
		}
		
		catch (AnIntegerOverflowException theIntegerOverflowException) {
			System.out.println(theIntegerOverflowException.getMessage());
		}
		
		System.out.println();
		
	}
	
	@Test
	public void testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForLowerLimitHigher() {
		
		System.out.println("Running testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForLowerLimitHigher.");
		
		int theProposedLowerLimit = 1;
		int theProposedUpperLimit = -1;
		
		try {		
			if (theProposedLowerLimit > theProposedUpperLimit) {
				throw new ALowerLimitIsGreaterThanUpperLimitException(
					"The proposed lower limit is greater than the proposed upper limit.");
			}
			
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
		
		catch (ALowerLimitIsGreaterThanUpperLimitException theLowerLimitIsGreaterThanUpperLimitException) {
			System.out.println(theLowerLimitIsGreaterThanUpperLimitException.getMessage());
		}
		
		catch (AnIntegerOverflowException theIntegerOverflowException) {
			System.out.println(theIntegerOverflowException.getMessage());
		}
		
		System.out.println();
		
	}
	
	@Test
	public void testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForRangeTooWide() {
		
		System.out.println("Running testAskAboutAndReadALowerLimitAndAnUpperLimitForAnIntegerForRangeTooWide.");
		
		int theProposedLowerLimit = -1073741824;
		int theProposedUpperLimit =  1073741824;
		
		try {		
			if (theProposedLowerLimit > theProposedUpperLimit) {
				throw new ALowerLimitIsGreaterThanUpperLimitException(
					"The proposed lower limit is greater than the proposed upper limit.");
			}
			
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
		
		catch (ALowerLimitIsGreaterThanUpperLimitException theLowerLimitIsGreaterThanUpperLimitException) {
			System.out.println(theLowerLimitIsGreaterThanUpperLimitException.getMessage());
		}
		
		catch (AnIntegerOverflowException theIntegerOverflowException) {
			System.out.println(theIntegerOverflowException.getMessage());
		}
		
		System.out.println();
		
	}
	
	
}
