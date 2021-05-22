package com.tsl.polynomials;

import java.util.Arrays;

class Polynomial {

	private final int THE_MINIMUM_INTEGER = -2147483648;
	public static final int THE_MAXIMUM_INTEGER = 2147483647;
	
	
	/**
	 * degree is an attribute of Polynomial. degree represents the degree of a polynomial.
	 * If an instance of Polynomial is "zero", degree must be -1.
	 * If the proposed degree given by a user is negative, store the opposite of that integer in degree.
	 */
	private int degree;

	
	/**
	 * coefficients is a component of Polynomial. coefficients is an array of integers representing the coefficients
	 * of the polynomial. The integer at index 0 corresponds to x^0; the integer at index coefficients.length - 1
	 * corresponds to x^{degree}.
	 */
	private int[] coefficients;
	
	
	/**
	 * Polynomial(int theDegreeToUse, int[] theCoefficientsToUse) is the two-argument constructor for Polynomial,
	 * which sets degree to theDegreeToUse and coefficients to theCoefficientsToUse.
	 * @param theDegreeToUse
	 * @param theCoefficientsToUse
	 */
	public Polynomial(int theDegreeToUse, int[] theArrayOfCoefficients)
		throws AnInvalidDegreeException, AnInvalidArrayOfCoefficientsGivenDegreeException {
		
		if (theDegreeToUse == THE_MINIMUM_INTEGER) {
			throw new AnInvalidDegreeException("Degree must be larger than " + THE_MINIMUM_INTEGER);
		}
		
		if (theDegreeToUse < 0) {
			System.out.println(
				"Warning: Proposed degree " +
				theDegreeToUse +
				" is negative; making the polynomial degree equal to the magnitude of the proposed degree."
			);
			this.degree = -theDegreeToUse;
		}
		else {
			this.degree = theDegreeToUse;
		}
		
		if (theArrayOfCoefficients.length != this.degree + 1) {
			throw new AnInvalidArrayOfCoefficientsGivenDegreeException(
				"Given degree " +
				this.degree +
				", the array of coefficients must have " +
				(this.degree + 1) +
				" element(s)."
			);
		}
		
		if (areAllValuesZeroIn(theArrayOfCoefficients)) {
			this.degree = -1;
			this.coefficients = new int[] {0};
		}
		else {
			this.coefficients = theArrayOfCoefficients;	
		}
		
	}
	
	
	public boolean areAllValuesZeroIn(int[] theArrayOfCoefficients) {
		
		boolean areAllValuesZero = true;
		
		for (int i = 0; i < theArrayOfCoefficients.length; i++) {
			if (theArrayOfCoefficients[i] != 0) {
				areAllValuesZero = false;
				break;
			}
		}
		
		return areAllValuesZero;
		
	}
	
	
	/**
	 * adjustPoly adjusts the degree and array of coefficients of this polynomial if the value of the coefficient of the
	 * highest degree is zero.
	 */
	public void adjustPoly() {
		
		if (this.degree <= 0) {
			return;
		}
		
		else if (this.coefficients[this.degree] == 0) {
			degree -= 1;
			this.coefficients = Arrays.copyOfRange(coefficients, 0, this.degree - 1);
		}
		
	}
	
	
	/**
	 * getDegree provides this polynomial's degree.
	 * @return
	 */
	public int getDegree() {
		return this.degree;
	}
	
	
	/**
	 * getCoefficients provides this polynomial's array of coefficients.
	 * @return
	 */
	public int[] getCoefficients() {
		return this.coefficients;
	}
	
	
	public void checkTheMultiplicationOf(int theFirstInteger, int theSecondInteger) throws AnIntegerOverflowException {
		
		if (((theFirstInteger > 0) && (theSecondInteger > 0) && (theFirstInteger > THE_MAXIMUM_INTEGER / theSecondInteger)) ||
			((theFirstInteger < 0) && (theSecondInteger > 0) && (Math.abs(theFirstInteger) > THE_MAXIMUM_INTEGER / theSecondInteger)) ||
			((theFirstInteger < 0) && (theSecondInteger < 0) && (theFirstInteger < THE_MAXIMUM_INTEGER / theSecondInteger))) {
			
			throw new AnIntegerOverflowException(
				"Integer-overflow exception: the product of " +
				theFirstInteger +
				" and " +
				theSecondInteger +
				" exceed " +
				THE_MAXIMUM_INTEGER +
				"."
			);
			
		}
		
	}
	
	
	public int exponentiate(int theBase, int thePower) throws AnUnimplementedException, AnIntegerOverflowException {
		
		if (thePower < 0) {
			throw new AnUnimplementedException(
				"Exponentiation with negative integer powers has not been implemented yet.");
		}
		
		if (thePower == 0) {
			return 1;
		}
		
		if (thePower == 1) {
			return theBase;
		}
		
		int theProduct = theBase;
		
		for (int i = 2; i <= thePower; i++) {
			
			checkTheMultiplicationOf(theBase, theProduct);
			
			theProduct *= theBase;
			
		}
		
		return theProduct;
		
	}
	
	
	public void checkTheAdditionOf(int theFirstInteger, int theSecondInteger) throws AnIntegerOverflowException {
		
		if ((theFirstInteger > 0) && (theSecondInteger > 0) && (theFirstInteger > THE_MAXIMUM_INTEGER - theSecondInteger)) {
			throw new AnIntegerOverflowException(
				"Integer-overflow exception: the sum of " +
				theFirstInteger +
				" and " +
				theSecondInteger +
				" exceeds " +
				THE_MAXIMUM_INTEGER +
				"."
			);
		}
		
		if ((theFirstInteger < 0) && (theSecondInteger < 0) && (theFirstInteger < THE_MINIMUM_INTEGER - theSecondInteger)) {
			throw new AnIntegerOverflowException(
				"Integer-overflow exception: the sum of " +
				theFirstInteger +
				" and " +
				theSecondInteger +
				" is less than " +
				THE_MINIMUM_INTEGER +
				"."
			);
		}
		
	}
	
	
	public int multiply(int theFirstInteger, int theSecondInteger) throws AnIntegerOverflowException {
		
		checkTheMultiplicationOf(theFirstInteger, theSecondInteger);
		
		return theFirstInteger * theSecondInteger;
		
	}
	
	
	/**
	 * evaluate provides the scalar output of this polynomial given input x.
	 * @param x
	 */
	public int evaluate(int x) throws AnUnimplementedException, AnIntegerOverflowException {
		
		int theScalarOutput = 0;
		
		int thePresentTerm;
		for (int i = 0; i < this.coefficients.length; i++) {
			
			thePresentTerm = multiply(this.coefficients[i], exponentiate(x, i));
			
			checkTheAdditionOf(thePresentTerm, theScalarOutput);
			
			theScalarOutput += thePresentTerm;
		}
		
		return theScalarOutput;
		
	}
	
	
	/**
	 * addPoly provides the algebraic sum of this polynomial and polynomial p.
	 * @param p
	 * @return
	 */
	public Polynomial addPoly(Polynomial p)
		throws AnIntegerOverflowException, AnInvalidDegreeException, AnInvalidArrayOfCoefficientsGivenDegreeException {
		
		Polynomial thePolynomialWithTheLargerDegree = (this.degree > p.degree) ? this : p; 
		
		Polynomial thePolynomialWithTheSmallerDegree = (this.degree > p.degree) ? p : this; 
		
		int[] theArrayOfCoefficientsForTheSum = thePolynomialWithTheLargerDegree.coefficients.clone();
		
		for (int i = 0; i < thePolynomialWithTheSmallerDegree.coefficients.length; i++) {
			
			checkTheAdditionOf(theArrayOfCoefficientsForTheSum[i], thePolynomialWithTheSmallerDegree.coefficients[i]);
			
			theArrayOfCoefficientsForTheSum[i] += thePolynomialWithTheSmallerDegree.coefficients[i];
		}
		
		return new Polynomial(thePolynomialWithTheLargerDegree.degree, theArrayOfCoefficientsForTheSum);
		
	}
	
	
	public Polynomial subtractPoly(Polynomial p)
		throws AnIntegerOverflowException, AnInvalidDegreeException, AnInvalidArrayOfCoefficientsGivenDegreeException {
		
		int[] theCoefficientsOfThePolynomialOppositeP = p.coefficients.clone();
		
		for (int i = 0; i < theCoefficientsOfThePolynomialOppositeP.length; i++) {
			theCoefficientsOfThePolynomialOppositeP[i] = multiply(p.coefficients[i], -1);
		}
		
		return addPoly(new Polynomial(p.degree, theCoefficientsOfThePolynomialOppositeP));
		
	}
	
	
	public Polynomial derivative()
		throws AnIntegerOverflowException, AnInvalidDegreeException, AnInvalidArrayOfCoefficientsGivenDegreeException {
		
		int[] theCoefficientsOfTheDerivative = Arrays.copyOfRange(this.coefficients, 1, this.coefficients.length);
		
		for (int i = 0; i < theCoefficientsOfTheDerivative.length; i++) {
			theCoefficientsOfTheDerivative[i] = multiply(theCoefficientsOfTheDerivative[i], i+1);
		}
		
		return new Polynomial(this.degree - 1, theCoefficientsOfTheDerivative);
		
	}
	
	
	public boolean equals(Polynomial p) {
		
		return ((this.degree == p.degree) && (Arrays.equals(this.coefficients, p.coefficients)));
		
	}
	
	
	@Override
	public String toString() {
		
		String theOutputString = "";
		
		if (this.degree > 1) {
			if (this.coefficients[this.degree] > 1) {
				theOutputString += this.coefficients[this.degree] + "x^" + this.degree;
			}
			else if (this.coefficients[this.degree] == 1) {
				theOutputString += "x^" + this.degree;
			}
			else if (this.coefficients[this.degree] == -1) {
				theOutputString += "-x^" + this.degree;
			}
			else if (this.coefficients[this.degree] < -1) {
				theOutputString += this.coefficients[this.degree] + "x^" + this.degree;
			}
		}
		
		for (int i = this.degree - 1; i > 1; i--) {
			
			if (this.coefficients[i] > 1) {
				theOutputString += " + " + this.coefficients[i] + "x^" + i;
			}
			else if (this.coefficients[i] == 1) {
				theOutputString += " + x^" + i;
			}
			else if (this.coefficients[i] == -1) {
				theOutputString += " - x^" + i;
			}
			else if (this.coefficients[i] < -1) {
				theOutputString += " - " + -this.coefficients[i] + "x^" + i;
			}
			
		}
		
		if (this.degree > 0) {
			if (this.coefficients[1] > 1) {
				theOutputString += " + " + this.coefficients[1] + "x";
			}
			else if (this.coefficients[1] == 1) {
				theOutputString += " + x";
			}
			else if (this.coefficients[1] == -1) {
				theOutputString += " - x";
			}
			else if (this.coefficients[1] < -1) {
				theOutputString += " - " + -this.coefficients[1] + "x";
			}
		}
		
		if (this.coefficients[0] > 0) {
			theOutputString += " + " + this.coefficients[0];
		}
		else if (this.coefficients[0] < 0) {
			theOutputString += " - " + -this.coefficients[0];
		}
		else if (this.coefficients.length == 1) {
			theOutputString += "0";
		}
		
		return theOutputString;
		
	}
	
}
