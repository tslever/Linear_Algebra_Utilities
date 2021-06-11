package Com.TSL.UtilitiesForFindingTheMaximumProductOfTwoDigitIntegersThatIsAPalindrome;


class APalindromicityTester {
	
	
	protected boolean tests(int theProduct) {
		
		NumericPalindrome<Integer> theQueueOfDigits = getTheQueueOfDigitsIn(theProduct);
    	
		AnArrayBasedBoundedStack<Integer> theStackOfDigits =
			new AnArrayBasedBoundedStack<Integer>(theQueueOfDigits.providesItsNumberOfElements());
		
		int theNumberOfDigits = theQueueOfDigits.providesItsNumberOfElements();
    	for (int i = 0; i < theNumberOfDigits; i++) {
    		
    		int thePresentDigit = theQueueOfDigits.dequeue();
    		theQueueOfDigits.enqueue(thePresentDigit);
    		
    		theStackOfDigits.push(thePresentDigit);
    		
    	}
    	
    	if (isPalindromeTheIntegerRepresentedBy(theQueueOfDigits, theStackOfDigits)) {
    		return true;
    	}
    	
    	return false;
		
	}
	
	
    private int findTheNumberOfDigitsIn(int theProduct) {
    	
        int theConsumedVersionOfTheProduct = theProduct;
    	
        int theNumberOfDigits = 0;
        
        while (theConsumedVersionOfTheProduct > 0) {
        	
        	theNumberOfDigits++;
        	
        	theConsumedVersionOfTheProduct /= 10;
        	
        }
        
        return theNumberOfDigits;
    	
    }
	
    
    private NumericPalindrome<Integer> getTheQueueOfDigitsIn(int theProduct) {
    
    	int theConsumedVersionOfTheProduct = theProduct;
    	
    	int theNumberOfDigits = findTheNumberOfDigitsIn(theProduct);
    	
    	NumericPalindrome<Integer> theQueueOfDigits = new NumericPalindrome<Integer>(theNumberOfDigits);
    	
    	for (int i = theNumberOfDigits - 1; i >= 0; i--) {
    		
    		theQueueOfDigits.enqueue(theConsumedVersionOfTheProduct % 10);
    		
    		theConsumedVersionOfTheProduct /= 10;
    		
    	}
    	
    	return theQueueOfDigits;
    	
    }
    
    
    private boolean isPalindromeTheIntegerRepresentedBy(
    	NumericPalindrome<Integer> theQueueOfDigits, AnArrayBasedBoundedStack<Integer> theStackOfDigits) {
    	
    	boolean theIntegerIsAPalindrome = true;
    	
    	int theIntegerAtTheTopOfTheStack;
    	
    	int theNumberOfDigits = theQueueOfDigits.providesItsNumberOfElements();
    	
    	for (int i = 0; i < theNumberOfDigits; i++) {
    		
    		theIntegerAtTheTopOfTheStack = theStackOfDigits.top();
    		theStackOfDigits.pop();
    		
    		if (theQueueOfDigits.dequeue() != theIntegerAtTheTopOfTheStack) {
    			
    			theIntegerIsAPalindrome = false;
    			
    		}
    		
    	}
    	
    	return theIntegerIsAPalindrome;
    	
    }
	
}
