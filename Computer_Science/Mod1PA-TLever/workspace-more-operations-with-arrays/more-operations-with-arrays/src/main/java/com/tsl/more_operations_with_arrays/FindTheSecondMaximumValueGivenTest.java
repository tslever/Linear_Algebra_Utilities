package com.tsl.more_operations_with_arrays;


import org.junit.jupiter.api.Test;


public class FindTheSecondMaximumValueGivenTest {

	
	@Test
	public void testFindTheSecondMaximumValueGivenForAnArrayWithTwoElements() {
		
		System.out.println("Running testFindTheSecondMaximumValueGivenForAnArrayWithTwoElements.");
		
		int[] theArrayOfRandomIntegers = {1, 2};
		
		try {
			int theSecondMaximumValue = App.findTheSecondMaximumValueGiven(theArrayOfRandomIntegers, 1);
			System.out.println("The second maximum value is: " + theSecondMaximumValue);
		}
		catch (ASecondMaximumValueDoesNotExistException theSecondMaximumValueDoesNotExistException) {
			System.out.println(theSecondMaximumValueDoesNotExistException.getMessage());
		}
		
		System.out.println();
		
	}
	
	
	@Test
	public void testFindTheSecondMaximumValueGivenForAnArrayWithOneElement() {
		
		System.out.println("Running testFindTheSecondMaximumValueGivenForAnArrayWithOneElement.");
		
		int[] theArrayOfRandomIntegers = {1};
		
		try {
			int theSecondMaximumValue = App.findTheSecondMaximumValueGiven(theArrayOfRandomIntegers, 0);
			System.out.println("The second maximum value is: " + theSecondMaximumValue);
		}
		catch (ASecondMaximumValueDoesNotExistException theSecondMaximumValueDoesNotExistException) {
			System.out.println(theSecondMaximumValueDoesNotExistException.getMessage());
		}
		
		System.out.println();
		
	}
	
	
}
