package Com.TSL.UtilitiesForFindingTheMaximumProductOfTwoDigitIntegersThatIsAPalindrome;


/**
 * Hello world!
 *
 */

public class HighestPalindromeProduct 
{
	
    public static void main( String[] args )
    {
    	
    	APalindromicityTester thePalindromicityTester = new APalindromicityTester();
    	
    	int j;
    	int theProduct;
    	boolean aProductWasAPalindrome = false;
    	
    	for (int i = 99; i >= 10; i--) {
    		
    		if (aProductWasAPalindrome) {
    			break;
    		}
    		
    		for (j = 99; j >= 10; j--) {
    			
    			theProduct = i * j;
    			
    			if (thePalindromicityTester.tests(theProduct)) {
    				
    				System.out.println(
    					i + " * " + j + " = " + theProduct + " is the maximum product of two digit numbers that is a " +
    					"palindrome."
    				);
    				
    				aProductWasAPalindrome = true;
    				
    				break;
    				
    			}
    			
    		}
    		
    	}
    	
    	if (!aProductWasAPalindrome) {
    		System.out.println("No product of two-digit integers was a palindrome.");
    	}
        
    }
    
}