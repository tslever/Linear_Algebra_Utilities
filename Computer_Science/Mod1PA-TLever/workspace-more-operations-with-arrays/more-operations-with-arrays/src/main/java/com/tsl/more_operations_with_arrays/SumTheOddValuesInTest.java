package com.tsl.more_operations_with_arrays;


import org.junit.jupiter.api.Test;


class SumTheOddValuesInTest {

	
	@Test
	public void testSumTheOddValuesInWithAnArrayWithAnExtremelyWideRange() {
		
		System.out.println("Running testSumTheOddValuesInWithAnArrayWithAnExtremelyWideRange.");
        
        int[] theArrayOfRandomIntegers = new int[] {
        	-2147483648,
        	-2147483647,
        	-2147483646,
        	-2147483645,
        	 2147483647,
        	 2147483646,
        	 2147483645,
        	 2147483644,
        	 2147483643
        };
        
        try {
        	int theSumOfTheOddValuesInTheArray = App.sumTheOddValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The sum of odd values in the array is: " + theSumOfTheOddValuesInTheArray);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
        catch (ASumDoesNotExistException theSumDoesNotExistException) {
        	System.out.println(theSumDoesNotExistException.getMessage());
        }
		
		System.out.println();
		
	}
	
	
	@Test
	public void testSumTheOddValuesInWithAnArrayOfLargePositiveIntegers() {
	
		System.out.println("Running testSumTheOddValuesInWithAnArrayOfLargePositiveIntegers.");
		
		int[] theArrayOfRandomIntegers = new int[] {App.THE_MAXIMUM_INTEGER, App.THE_MAXIMUM_INTEGER};
		
        try {
        	int theSumOfTheOddValuesInTheArray = App.sumTheOddValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The sum of odd values in the array is: " + theSumOfTheOddValuesInTheArray);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
        catch (ASumDoesNotExistException theSumDoesNotExistException) {
        	System.out.println(theSumDoesNotExistException.getMessage());
        }
		
        System.out.println();
        
	}
	
	
	@Test
	public void testSumTheOddValuesInWithAnArrayOfLargeNegativeIntegers() {
	
		System.out.println("Running testSumTheOddValuesInWithAnArrayOfLargeNegativeIntegers.");
		
		int[] theArrayOfRandomIntegers = new int[] {App.THE_MINIMUM_INTEGER+1, App.THE_MINIMUM_INTEGER+1};
		
        try {
        	int theSumOfTheOddValuesInTheArray = App.sumTheOddValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The sum of odd values in the array is: " + theSumOfTheOddValuesInTheArray);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
        catch (ASumDoesNotExistException theSumDoesNotExistException) {
        	System.out.println(theSumDoesNotExistException.getMessage());
        }
        
        System.out.println();
		
	}
	
	@Test
	public void testSumTheOddValuesInWithAnArrayOfOneElement() {
		
		System.out.println("Running testSumTheOddValuesInWithAnArrayOfOneElement.");
		
		int[] theArrayOfRandomIntegers = new int[] {1};
		
        try {
        	int theSumOfTheOddValuesInTheArray = App.sumTheOddValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The sum of odd values in the array is: " + theSumOfTheOddValuesInTheArray);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
        catch (ASumDoesNotExistException theSumDoesNotExistException) {
        	System.out.println(theSumDoesNotExistException.getMessage());
        }
		
		System.out.println();
		
	}
	
	@Test
	public void testSumTheOddValuesInWithAnArrayOfZeroElements() {
		
		System.out.println("Running testSumTheOddValuesInWithAnArrayOfZeroElements.");
		
		int[] theArrayOfRandomIntegers = new int[] {};
		
        try {
        	int theSumOfTheOddValuesInTheArray = App.sumTheOddValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The sum of odd values in the array is: " + theSumOfTheOddValuesInTheArray);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
        catch (ASumDoesNotExistException theSumDoesNotExistException) {
        	System.out.println(theSumDoesNotExistException.getMessage());
        }
		
		System.out.println();
		
	}
	
}