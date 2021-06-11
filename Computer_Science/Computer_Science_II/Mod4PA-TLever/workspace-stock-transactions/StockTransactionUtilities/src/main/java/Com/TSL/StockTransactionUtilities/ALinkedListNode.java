package Com.TSL.StockTransactionUtilities;


public class ALinkedListNode<T> {

	
	private ALinkedListNode<T> reference;
	private T element;
	
	
	public ALinkedListNode(T theElementToUse) {
		
		this.element = theElementToUse;
		this.reference = null;
		
	}
	
	
	public void setsItsElementTo(T theElementToUse) {
		
		this.element = theElementToUse;
		
	}
	
	
	public T providesItsElement() {
		
		return this.element;
		
	}
	
	
	public void setsItsReferenceTo(ALinkedListNode<T> theReferenceToUse) {
		
		this.reference = theReferenceToUse;
		
	}
	
	
	public ALinkedListNode<T> providesItsReference() {
		
		return this.reference;
		
	}
	
	
}
