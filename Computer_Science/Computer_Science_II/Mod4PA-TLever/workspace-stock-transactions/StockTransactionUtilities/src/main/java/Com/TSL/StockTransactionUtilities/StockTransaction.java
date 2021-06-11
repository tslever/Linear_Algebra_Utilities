package Com.TSL.StockTransactionUtilities;


public class StockTransaction {

	
	private ALinkedListNode<Stock> frontLinkedListNode;
	private ALinkedListNode<Stock> rearLinkedListNode;
	private int numberOfElements;
	
	
	public StockTransaction() {
		
		this.frontLinkedListNode = null;
		this.rearLinkedListNode = null;
		
	}
	
	
	public void buyOneShare(Stock theStock) {
		
		ALinkedListNode<Stock> theLinkedListNodeForTheStock = new ALinkedListNode<Stock>(theStock);
		
		if (this.rearLinkedListNode == null) {
			this.frontLinkedListNode = theLinkedListNodeForTheStock;
		}
		
		else {
			this.rearLinkedListNode.setsItsReferenceTo(theLinkedListNodeForTheStock);
		}
		
		this.rearLinkedListNode = theLinkedListNodeForTheStock;
		this.numberOfElements++;
		
	}
	
	
	public void buy(int theNumberOfSharesToBuy, double thePurchasePrice) {
		
    	for (int i = 0; i < theNumberOfSharesToBuy; i++) {
    		buyOneShare(new Stock(thePurchasePrice));
    	}
    	
    	System.out.println("Buying " + theNumberOfSharesToBuy + " shares at $" + thePurchasePrice + " each.\n");
		
	}
	
	
	public Stock sellsOneShare() {
		
		if (isEmpty()) {
			throw new AQueueUnderflowException("Exception: sell for an empty queue of stocks was requested.");
		}
		
		Stock theStockToSell = this.frontLinkedListNode.providesItsElement();
		this.frontLinkedListNode = this.frontLinkedListNode.providesItsReference();
		
		if (this.frontLinkedListNode == null) {
			this.rearLinkedListNode = null;
		}
		
		this.numberOfElements--;
		
		return theStockToSell;
		
	}
	
	
	public double sell(int theNumberOfStocksToSell, double theSalePrice) {
		
    	double theIncomeFromSellingMultipleStocks = 0.0;
    	double theTotalCostOfTheStocks = 0.0;
    	
    	for (int i = 0; i < theNumberOfStocksToSell; i++) {
    		theIncomeFromSellingMultipleStocks += theSalePrice;
    		theTotalCostOfTheStocks += sellsOneShare().providesItsShareCost();
    	}
    	
    	double theCapitalGain = theIncomeFromSellingMultipleStocks - theTotalCostOfTheStocks; 
    	
    	System.out.println(
    		"Selling " + theNumberOfStocksToSell + " shares.\n" +
    		"Income from selling " + theNumberOfStocksToSell + " shares at $" + theSalePrice + " is $" +
    		theIncomeFromSellingMultipleStocks + ".\n" +
    		"Total cost of shares is $" + theTotalCostOfTheStocks + ".\n" +
    		"Capital gain from selling " + theNumberOfStocksToSell + " shares at $" + theSalePrice + " is $" +
    		theCapitalGain + ".\n"
    	);
    	
    	return theCapitalGain;
		
	}
	
	
	public boolean isEmpty() {
		
		return (this.frontLinkedListNode == null);
		
	}
	
	
	@Override
	public String toString() {
		
		String theRepresentationOfThisQueue = "[";
		
		ALinkedListNode<Stock> theCurrentLinkedListNodeInTheQueue = this.frontLinkedListNode;
		while (theCurrentLinkedListNodeInTheQueue.providesItsReference() != null) {
			theRepresentationOfThisQueue += theCurrentLinkedListNodeInTheQueue.providesItsElement() + ", ";
			theCurrentLinkedListNodeInTheQueue = theCurrentLinkedListNodeInTheQueue.providesItsReference();
		}
		
		theRepresentationOfThisQueue += theCurrentLinkedListNodeInTheQueue.providesItsElement() + "]";
		
		return theRepresentationOfThisQueue;
		
	}
	
}
