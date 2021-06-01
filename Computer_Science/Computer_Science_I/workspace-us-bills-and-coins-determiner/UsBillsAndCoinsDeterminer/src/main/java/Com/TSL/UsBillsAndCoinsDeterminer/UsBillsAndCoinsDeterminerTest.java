package Com.TSL.UsBillsAndCoinsDeterminer;


import java.util.Random;
import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;


/** *******************************************************************************************
 * UsBillsAndCoinsDeterminerTest encapsulates a method to test the main method of this program.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/01/21
 ******************************************************************************************* */

public class UsBillsAndCoinsDeterminerTest {

    
    /** ------------------------------------------------------------------------------------------------------------
     * testMain tests whether a calculated United-States monetary amount is not equal to a provided amount exception
     * ever occurs within the scope of method main.
     ------------------------------------------------------------------------------------------------------------ */
    
    @Test
    public void testMain()
    {
        
        final int THE_MAXIMUM_INTEGER = 2147483646;
        
        int theRandomNumberOfDollars;
        int theRandomNumberOfCents;
        
        double theRandomUsMonetaryAmount;
        
        
        while (true)
        {
        
            try
            {
                theRandomNumberOfDollars =
                    TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween (0, THE_MAXIMUM_INTEGER);
                
                theRandomNumberOfCents =
                    TheRandomNumberGenerator.getARandomIntegerInclusivelyBetween (0, 100);
                
                theRandomUsMonetaryAmount =
                    Precision.round ( (double)theRandomNumberOfDollars + (double)theRandomNumberOfCents / 100.0, 2);
                
                AnAccountOfUsBillsAndCoins theAccountOfUsBillsAndCoins =
                    new AnAccountOfUsBillsAndCoins (theRandomUsMonetaryAmount);
            }
            
            catch (AnIntegerOverflowException theIntegerOverflowException)
            {
                System.out.println (theIntegerOverflowException.getMessage ());
            }
            
            catch (ACalculatedUsMonetaryAmountIsNotEqualToProvidedAmountException e)
            {
                System.out.println (e.getMessage ());
            }
        
        }
        
    }
    
}
