package Com.TSL.UsBillsAndCoinsDeterminer;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.commons.math3.util.Precision;


/** ********************************************************************************************************************
 * UsBillsAndCoinsDeterminer encapsulates the entry point to this program, which, given a United-States monetary amount,
 * determines the numbers of each United-States bill and coin needed to represent that amount with the smallest total
 * number of bills and coins. Types of United-States bills and coins include ten-dollar bill, five-dollar bill,
 * one-dollar bill, quarter, dime, nickel, and penny.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 05/31/21
 ******************************************************************************************************************** */

public class UsBillsAndCoinsDeterminer 
{

    /** ------------------------------------------------------------------------------------------------------------
	 * main is the entry point to this program, which, given a United-States monetary amount, determines the numbers
	 * number of each United-States bill and coin needed to represent that amount with the smallest total number of
	 * bills and coins.
	 * 
	 * @param args
	 ------------------------------------------------------------------------------------------------------------ */

    public static void main(String[] args)
    {
        System.out.println(
             "This program, given a United-States monetary amount, determines the numbers of each United-States bill " +
             "and coin needed to\nrepresent that amount with the smallest total number of bills and coins.\n"
        );
        
        double theUsMonetaryAmount = TheInputManager.requestsAUsMonetaryAmount();

        double theNumberOfTenDollarBills =
            Precision.round(theUsMonetaryAmount / 10.0, 0, RoundingMethod.ROUND_DOWN.ordinal());
        
        double theRemainder = theUsMonetaryAmount - theNumberOfTenDollarBills * 10.0;
        
        double theNumberOfFiveDollarBills = Precision.round(theRemainder / 5.0, 0, RoundingMethod.ROUND_DOWN.ordinal());
        
        theRemainder -= theNumberOfFiveDollarBills * 5.0;
        
        double theNumberOfOneDollarBills = Precision.round(theRemainder / 1.0, 0, RoundingMethod.ROUND_DOWN.ordinal());
        
        theRemainder -= theNumberOfOneDollarBills * 1.0;
        
        double theNumberOfQuarters = Precision.round(theRemainder / 0.25, 0, RoundingMethod.ROUND_DOWN.ordinal());
        
        theRemainder -= theNumberOfQuarters * 0.25;
        
        double theNumberOfDimes = Precision.round(theRemainder / 0.10, 0, RoundingMethod.ROUND_DOWN.ordinal());
        
        theRemainder -= theNumberOfDimes * 0.10;
        
        double theNumberOfNickels = Precision.round(theRemainder / 0.05, 0, RoundingMethod.ROUND_DOWN.ordinal());
        
        theRemainder -= theNumberOfNickels * 0.05;
        
        double theNumberOfPennies = Precision.round(theRemainder / 0.01, 0, RoundingMethod.ROUND_HALF_UP.ordinal());
        
        theRemainder -= theNumberOfPennies * 0.01;
        
        
        System.out.println(
            "\nBelow are the numbers of each United-States bill and coin needed to represent the United-States " +
            "monetary amount " + theUsMonetaryAmount + " with the\nsmallest total number of bills and coins."
        );
        System.out.printf("%.0f ten dollar bills\n", theNumberOfTenDollarBills);
        System.out.printf("%.0f five dollar bills\n", theNumberOfFiveDollarBills);
        System.out.printf("%.0f one dollar bills\n", theNumberOfOneDollarBills);
        System.out.printf("%.0f quarters\n", theNumberOfQuarters);
        System.out.printf("%.0f dimes\n", theNumberOfDimes);
        System.out.printf("%.0f nickels\n", theNumberOfNickels);
        System.out.printf("%.0f pennies\n\n", theNumberOfPennies);
        
        System.out.println(
            "There exists a remainder of " + theRemainder + " since the decimal United-States monetary amount " +
            theUsMonetaryAmount + ((theRemainder == 0.0) ? " can" : " cannot") + " be represented\nexactly using the " +
            "binary number system."
        );
        
    }
    
}


/** ********************************************************************************************************************
 * AnInvalidMonetaryAmountException represents the structure for an exception that occurs when the program receives from
 * the user via the standard input stream an invalid monetary amount.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 05/31/21
 ******************************************************************************************************************** */

class AnInvalidMonetaryAmountException extends Exception
{
    
    /** -------------------------------------------------------------------------------------------------------------
     * AnInvalidMonetaryAmountException(String theMessage) is the one-parameter constructor for
     * AnInvalidMonetaryAmountException. This constructor passes the argument represented by its parameter theMessage
     * to the one-parameter constructor of Exception.
     * 
     * @param theMessage
     ------------------------------------------------------------------------------------------------------------- */
    
    AnInvalidMonetaryAmountException(String theMessage)
    {
        super(theMessage);
    }
    
}


/** ***************************************************
 * Rounding method enumerates various rounding methods.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 05/31/21
 *************************************************** */

enum RoundingMethod
{
    ROUND_UP,
    ROUND_DOWN,
    ROUND_CEILING,
    ROUND_FLOOR,
    ROUND_HALF_UP,
    ROUND_HALF_DOWN,
    ROUND_HALF_EVEN,
    ROUND_UNNECESSARY
}



/** **************************************************************
 * AnInputManager manages input of United-States monetary amounts.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 05/31/21
 ************************************************************** */

class TheInputManager
{
	
    /** ---------------------------------------------------------------------------------------------------------
	 * requestsAndProvidesAUsMonetaryAmount requests a valid monetary amount from the user via the standard input
	 * stream, and provides the monetary amount to the calling method.
	 * 
	 * @return
	 --------------------------------------------------------------------------------------------------------- */
    
    static double requestsAUsMonetaryAmount()
    {

        double theProposedUsMonetaryAmount = 0.0;
            
        System.out.print("Please enter a United-States monetary amount, without '$': ");
        Scanner theScannerOfTheStandardInputStream = new Scanner(System.in);
        
        try
        {
            // nextDouble throws an input mismatch exception if the next double does not match the Double regular
            // expression or the double is out of range. nextDouble throws a NoSuchElementException if the program
            // is terminated after input is requested and before input is received. nextDouble throws an
            // IllegalStateException if the scanner is closed when nextDouble is called.
            theProposedUsMonetaryAmount = theScannerOfTheStandardInputStream.nextDouble();
            theScannerOfTheStandardInputStream.close();
            
            // check throws AnInvalidMonetaryAmountException if the proposed monetary amount is invalid.
            check(theProposedUsMonetaryAmount);
        }
        catch (InputMismatchException theInputMismatchException)
        {
            theScannerOfTheStandardInputStream.close();
            throw new InputMismatchException("Input Mismatch Exception: The program received a non-double value.");
        }
        catch (NoSuchElementException theNoSuchElementException)
        {
            System.out.println(
                "No Such Element Exception: The program was terminated after input was requested from the user and " +
                "before input was received."
            );
        }
        catch (IllegalStateException theIllegalStateException)
        {
            throw new IllegalStateException("Illegal State Exception: Scanner was closed before nextDouble was called.");
        }
        catch (AnInvalidMonetaryAmountException theInvalidMonetaryAmountException)
        {
            theScannerOfTheStandardInputStream.close();
            System.out.println(theInvalidMonetaryAmountException.getMessage());
        }
            
        return theProposedUsMonetaryAmount;
    
    }
    
    
    /** -------------------------------------------------------------------------
     * check evaluates whether a proposed United-States monetary amount is valid.
     * 
     * @param theProposedUsMonetaryAmount
     * @throws AnInvalidMonetaryAmountException
     ------------------------------------------------------------------------- */
    
    private static void check(double theProposedUsMonetaryAmount) throws AnInvalidMonetaryAmountException
    {   
        
        if (theProposedUsMonetaryAmount != Precision.round(theProposedUsMonetaryAmount, 2))
        {
            throw new AnInvalidMonetaryAmountException("Exception: The program received an invalid monetary amount.");
        }
        
    }

}