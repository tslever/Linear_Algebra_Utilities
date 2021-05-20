package com.tsl.more_operations_with_arrays;


import java.util.Random;


/**
 * ARandomNumberGenerator represents the structure for some random number generators.
 * @author Tom Lever
 * @version 1.0
 * @since 05/17/21
 *
 */
class ARandomNumberGenerator {
	
	/**
	 * thePopularRandomNumberGenerator is a component of ARandomNumberGenerator.
	 */
	private Random thePopularRandomNumberGenerator;
	
	
	/**
	 * ARandomNumberGenerator() is the constructor for ARandomNumberGenerator.
	 */
	public ARandomNumberGenerator() {
		
		thePopularRandomNumberGenerator = new Random();
		
	}
	
	
	/**
	 * getARandomIntegerInclusivelyBetween provides a integer between a lower limit and an upper limit inclusive.
	 * @param theLowerLimit
	 * @param theUpperLimit
	 * @return
	 */
    public int getARandomIntegerInclusivelyBetween(int theLowerLimit, int theUpperLimit) {
    	return this.thePopularRandomNumberGenerator.nextInt((theUpperLimit - theLowerLimit) + 1) + theLowerLimit;
    }
	
}