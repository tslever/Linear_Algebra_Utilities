package com.tsl.more_operations_with_arrays;


import org.junit.jupiter.api.Test;


public class CalculateTheArrayOfTheSquaresOfTheValuesInTest {
	
	
	@Test
	public void testCalculateTheArrayOfTheSquaresOfTheValuesInForTheWidestValidCenteredRange() {
		
		System.out.println("Running testCalculateTheArrayOfTheSquaresOfTheValuesInForTheWidestValidCenteredRange.");
        
		int[] theArrayOfRandomIntegers = setUpAnArrayOfRandomIntegersGiven(-46340, 46340);
		
        try {
        	int[] theArrayOfSquares = App.calculateTheArrayOfTheSquaresOfTheValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The array of squares has the following values:");
        	App.display(theArrayOfSquares);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
		
		System.out.println();
		
	}
	
	
	@Test
	public void testCalculateTheArrayOfTheSquaresOfTheValuesInForAnArrayOfValuesTooSmall() {
		
		System.out.println("Running testCalculateTheArrayOfTheSquaresOfTheValuesInForAnArrayOfValuesTooSmall.");
        
		int[] theArrayOfRandomIntegers = setUpAnArrayOfRandomIntegersGiven(-46341, -46341);
		
        try {
        	int[] theArrayOfSquares = App.calculateTheArrayOfTheSquaresOfTheValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The array of squares has the following values:");
        	App.display(theArrayOfSquares);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
		
		System.out.println();
		
	}
	
	
	@Test
	public void testCalculateTheArrayOfTheSquaresOfTheValuesInForAnArrayOfValuesTooLarge() {
		
		System.out.println("Running testCalculateTheArrayOfTheSquaresOfTheValuesInForAnArrayOfValuesTooLarge.");
        
		int[] theArrayOfRandomIntegers = setUpAnArrayOfRandomIntegersGiven(46341, 46341);
		
        try {
        	int[] theArrayOfSquares = App.calculateTheArrayOfTheSquaresOfTheValuesIn(theArrayOfRandomIntegers);
        	System.out.println("The array of squares has the following values:");
        	App.display(theArrayOfSquares);
        }
        catch (AnIntegerOverflowException theIntegerOverflowException) {
        	System.out.println(theIntegerOverflowException.getMessage());
        }
		
		System.out.println();
		
	}
	
	
	private int[] setUpAnArrayOfRandomIntegersGiven(int theLowerLimit, int theUpperLimit) {
		
		int[] theArrayOfRandomIntegers = new int[1000];
		
        int[] theLowerLimitAndTheUpperLimitForAnInteger = new int[] {theLowerLimit, theUpperLimit};
        
        ARandomNumberGenerator theRandomNumberGenerator = new ARandomNumberGenerator();
        
        for (int i = 0; i < theArrayOfRandomIntegers.length; i++) {
        	theArrayOfRandomIntegers[i] =
        		theRandomNumberGenerator.getARandomIntegerInclusivelyBetween(
        			theLowerLimitAndTheUpperLimitForAnInteger[0], theLowerLimitAndTheUpperLimitForAnInteger[1]);
        }
        
        return theArrayOfRandomIntegers;
		
	}
	
}
