package Com.TSL.StockTransactionUtilities;


public class Stock {

	
	private int numberToBuy;
	private double cost;
	
	
	public Stock(double theShareCost) {
		
		this.cost = theShareCost;
		
	}
	
	
	/*public Stock(int theNumberToBuy, double theShareCost) {
		
		this.numberToBuy = theNumberToBuy;
		this.cost = theShareCost;
		
	}*/
	
	
	public void setsItsShareCostTo(double theShareCost) {
		
		this.cost = theShareCost;
		
	}
	
	
	public double providesItsShareCost() {
		
		return this.cost;
		
	}
	
	
	@Override
	public String toString() {
		
		return Double.toString(this.cost);
		
	}
	
}
