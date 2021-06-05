package Com.TSL.MysterySortUtilities;


import java.util.Random;


/** ************************************************************
* TheRandomNumberGenerator represents a random number generator.
* 
* @author Tom Lever
* @version 1.0
* @since 05/28/21
************************************************************* */
class TheRandomNumberGenerator {

  
  /** -------------------------------------------------------------
   * THE_MAXIMUM_INTEGER is an attribute of ARandomNumberGenerator.
   ------------------------------------------------------------- */
	
  private static final int THE_STATIC_MAXIMUM_INTEGER = 2147483647;
  
  
  /** ------------------------------------------------------------------------
   * thePopularRandomNumberGenerator is a component of ARandomNumberGenerator.
   ------------------------------------------------------------------------ */
  
  private static Random thePopularRandomNumberGenerator = new Random ();
  
  
  /** ---------------------------------------------------------------------------------------------------------
   * getARandomIntegerInclusivelyBetween provides a integer between a lower limit and an upper limit inclusive.
   * 
   * @param theLowerLimit
   * @param theUpperLimit
   * @return
   -------------------------------------------------------------------------------------------------------- */
  
  protected static int getARandomIntegerInclusivelyBetween (int theLowerLimit, int theUpperLimit)
      throws AnIntegerOverflowException {
  
      /*if (theUpperLimit > THE_STATIC_MAXIMUM_INTEGER + theLowerLimit - 1) {
          throw new AnIntegerOverflowException (
              "Exception: The proposed range [lower limit, upper limit] is too wide for a random number generator.\n" +
              "A possible range is [-1,073,741,823, 1,073,741,823]."
          );
      }*/
  
      return thePopularRandomNumberGenerator.nextInt((theUpperLimit - theLowerLimit) + 1) + theLowerLimit;
  
  }
  
}