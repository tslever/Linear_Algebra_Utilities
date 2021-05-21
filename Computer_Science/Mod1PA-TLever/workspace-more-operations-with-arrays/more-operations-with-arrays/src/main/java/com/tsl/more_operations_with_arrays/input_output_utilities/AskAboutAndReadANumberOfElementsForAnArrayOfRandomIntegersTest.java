package com.tsl.more_operations_with_arrays.input_output_utilities;


import org.junit.jupiter.api.Test;


public class AskAboutAndReadANumberOfElementsForAnArrayOfRandomIntegersTest {

	
	@Test
	public void testAskAboutAndReadANumberOfElementsForAnArrayOfRandomIntegersWithAZeroNumberOfElements() {
		
		System.out.println(
			"Running testAskAboutAndReadANumberOfElementsForAnArrayOfRandomIntegersWithAZeroNumberOfElements");
		
		try {
			int theProposedNumberOfElements = 0;
			
			if (theProposedNumberOfElements < 0) {
				throw new AReadIntegerIsNegativeException("The proposed number of elements is negative.");
			}
			
			System.out.println(theProposedNumberOfElements);
			
		}
		catch (AReadIntegerIsNegativeException theReadIntegerIsNegativeException) {
			System.out.println(theReadIntegerIsNegativeException.getMessage());
		}
		
		System.out.println();
		
	}
	
	
	@Test
	public void testAskAboutAndReadANumberOfElementsForAnArrayOfRandomIntegersWithANegativeNumberOfElements() {
		
		System.out.println(
			"Running testAskAboutAndReadANumberOfElementsForAnArrayOfRandomIntegersWithANegativeNumberOfElements");
		
		try {
			int theProposedNumberOfElements = -1;
			
			if (theProposedNumberOfElements < 0) {
				throw new AReadIntegerIsNegativeException("The proposed number of elements is negative.");
			}
			
			System.out.println(theProposedNumberOfElements);
			
		}
		catch (AReadIntegerIsNegativeException theReadIntegerIsNegativeException) {
			System.out.println(theReadIntegerIsNegativeException.getMessage());
		}
		
		System.out.println();
		
	}
	
}
