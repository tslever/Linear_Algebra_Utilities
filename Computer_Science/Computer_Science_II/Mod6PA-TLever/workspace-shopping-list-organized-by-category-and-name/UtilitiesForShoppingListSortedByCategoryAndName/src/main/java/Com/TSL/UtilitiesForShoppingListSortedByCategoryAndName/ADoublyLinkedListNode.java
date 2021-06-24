package Com.TSL.UtilitiesForShoppingListSortedByCategoryAndName;


public class ADoublyLinkedListNode<T> {

	
	private T data;
	private ADoublyLinkedListNode<T> referenceToThePreviousNode;
	private ADoublyLinkedListNode<T> referenceToTheNextNode;
	
	
	public ADoublyLinkedListNode(
		T theDataToUse,
		ADoublyLinkedListNode<T> theReferenceToThePreviousNodeToUse,
		ADoublyLinkedListNode<T> theReferenceToTheNextNodeToUse
	) {
		
		this.data = theDataToUse;
		this.referenceToThePreviousNode = theReferenceToThePreviousNodeToUse;
		this.referenceToTheNextNode = theReferenceToTheNextNodeToUse;
		
	}
	
	
	public void setsItsReferenceToThePreviousNodeTo(ADoublyLinkedListNode<T> theReferenceToThePreviousNodeToUse) {
		this.referenceToThePreviousNode = theReferenceToThePreviousNodeToUse;
	}
	
	
	public void setsItsReferenceToTheNextNodeTo(ADoublyLinkedListNode<T> theReferenceToTheNextNodeToUse) {
		this.referenceToTheNextNode = theReferenceToTheNextNodeToUse;
	}
	
	
	public T providesItsData() {
		return this.data;
	}

	
	public ADoublyLinkedListNode<T> providesItsReferenceToThePreviousNode() {
		return this.referenceToThePreviousNode;
	}
	
	
	public ADoublyLinkedListNode<T> providesItsReferenceToTheNextNode() {
		return this.referenceToTheNextNode;
	}
	
}
