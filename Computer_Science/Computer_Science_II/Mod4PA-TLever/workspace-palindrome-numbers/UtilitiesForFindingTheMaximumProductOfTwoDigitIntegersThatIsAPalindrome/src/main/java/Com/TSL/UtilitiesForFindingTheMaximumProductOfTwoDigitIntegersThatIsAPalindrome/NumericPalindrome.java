package Com.TSL.UtilitiesForFindingTheMaximumProductOfTwoDigitIntegersThatIsAPalindrome;


public class NumericPalindrome<T> {

	
	private T[] elements;
	private int numberOfElements;
	private int indexOfTheFrontElement;
	private int indexOfTheRearElement;
	
	
	public NumericPalindrome(int theCapacity) {
		
		this.elements = (T[]) new Object[theCapacity];
		this.indexOfTheRearElement = theCapacity - 1;
		
	}
	
	
	public void enqueue(T theElement) {
		
		if (isFull()) {
			throw new AQueueOverflowException("Exception: enqueue for a full queue was requested.");
		}
		
		this.indexOfTheRearElement = (this.indexOfTheRearElement + 1) % this.elements.length;
		this.elements[this.indexOfTheRearElement] = theElement;
		this.numberOfElements++;
		
	}
	
	
	public T dequeue() {
		
		if (isEmpty()) {
			throw new AQueueUnderflowException("Exception: dequeue for an empty queue was requested.");
		}
		
		T theElementToDequeue = this.elements[this.indexOfTheFrontElement];
		this.elements[this.indexOfTheFrontElement] = null;
		this.indexOfTheFrontElement = (this.indexOfTheFrontElement + 1) % this.elements.length;
		this.numberOfElements--;
		
		return theElementToDequeue;
		
	}
	
	
	public boolean isEmpty() {
		
		return (this.numberOfElements == 0);
		
	}
	
	
	public boolean isFull() {
		
		return (this.numberOfElements == this.elements.length);
		
	}
	
	
	public int providesItsNumberOfElements() {
		
		return this.numberOfElements;
		
	}
	
	
	@Override
	public String toString() {
		
		String theRepresentationOfThisQueue = "[";
		
		for (int i = 0; i < this.numberOfElements - 1; i++) {
			theRepresentationOfThisQueue += this.elements[i] + ", ";
		}
		
		theRepresentationOfThisQueue += this.elements[this.numberOfElements - 1] + "]";
		
		return theRepresentationOfThisQueue;
		
	}
	
	
}
