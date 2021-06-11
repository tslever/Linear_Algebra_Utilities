package Com.TSL.StockTransactionUtilities;


/**
 * Hello world!
 *
 */

public class StockTransactionHistory 
{
	
    public static void main( String[] args )
    {
    	
    	StockTransaction theQueueOfStocks = new StockTransaction();
    	
    	double capitalGain = 0.0;
    	
    	
    	theQueueOfStocks.buy(120, 25.00);
    	
    	theQueueOfStocks.buy(20, 75.00);
    	
    	capitalGain += theQueueOfStocks.sell(30, 65.00);
    	
    	capitalGain += theQueueOfStocks.sell(10, 65.00);
    	
    	theQueueOfStocks.buy(100, 10.00);
    	
    	theQueueOfStocks.buy(130, 4.00);
    	
    	theQueueOfStocks.buy(200, 16.00);
    	
    	capitalGain += theQueueOfStocks.sell(10, 65.00);
    	
    	capitalGain += theQueueOfStocks.sell(150, 30.00);
    	
    	System.out.println("Capital gain over stock transaction history is $" + capitalGain + ".");

    }
    
}