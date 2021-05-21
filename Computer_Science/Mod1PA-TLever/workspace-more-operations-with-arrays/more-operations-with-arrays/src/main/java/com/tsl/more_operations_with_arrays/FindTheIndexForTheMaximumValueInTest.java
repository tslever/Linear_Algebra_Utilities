package com.tsl.more_operations_with_arrays;


import org.junit.jupiter.api.Test;


public class FindTheIndexForTheMaximumValueInTest {

	
	@Test
	public void testFindTheIndexForTheMaximumValueInForANonEmptyArray() {
		
		System.out.println("Running testFindTheIndexForTheMaximumValueInForANonEmptyArray.");
		
		int[] theArrayOfRandomIntegers = new int[] {1};
		
		try {
			int theIndexOfTheMaximumValue = App.findTheIndexForTheMaximumValueIn(theArrayOfRandomIntegers);
			System.out.println("The index of the maximum value is: " + theIndexOfTheMaximumValue);
		}
		catch (AMaximumValueDoesNotExistException theMaximumValueDoesNotExistException) {
			System.out.println(theMaximumValueDoesNotExistException.getMessage());
		}
		
		System.out.println();
		
	}
	
	
	@Test
	public void testFindTheIndexForTheMaximumValueInForAnEmptyArray() {
		
		System.out.println("Running testFindTheIndexForTheMaximumValueInForAnEmptyArray.");
		
		int[] theArrayOfRandomIntegers = new int[] {};
		
		try {
			int theIndexOfTheMaximumValue = App.findTheIndexForTheMaximumValueIn(theArrayOfRandomIntegers);
			System.out.println("The index of the maximum value is: " + theIndexOfTheMaximumValue);
		}
		catch (AMaximumValueDoesNotExistException theMaximumValueDoesNotExistException) {
			System.out.println(theMaximumValueDoesNotExistException.getMessage());
		}
		
		System.out.println();
		
	}
	
}
