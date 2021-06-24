package Com.TSL.DoublyLinkedListUtilities;


public class ADoublyLinkedList<T> {

	
	private ADoublyLinkedListNode<T> head;
	private ADoublyLinkedListNode<T> currentDoublyLinkedListNode;
	private ADoublyLinkedListNode<T> tail;
	private int numberOfElements;
	
	
	public ADoublyLinkedList() {
		
		this.head = null;
		this.currentDoublyLinkedListNode = null;
		this.tail = null;
		this.numberOfElements = 0;
		
	}
	
	
	public void addsToItsHead(T theElement) {
		
		if (theElement == null) {
			throw new RuntimeException(
				"addToItsHead of a doubly linked list was requested with a reference to an element of null."
			);
		}
		
		if (this.head == null) {
			this.head = new ADoublyLinkedListNode<T>(theElement, null, null);
			this.tail = this.head;
		}
		
		else {
			ADoublyLinkedListNode<T> theDoublyLinkedListNodeForTheElement =
				new ADoublyLinkedListNode<T>(theElement, null, this.head);
			this.head.setsItsReferenceToThePreviousNodeTo(theDoublyLinkedListNodeForTheElement);
			this.head = theDoublyLinkedListNodeForTheElement;
		}
		
		this.numberOfElements++;
		
	}
	
	
	public void addsToItsTail(T theElement) {
		
		if (theElement == null) {
			throw new RuntimeException(
				"addToItsHead of a doubly linked list was requested with a reference to an element of null."
			);
		}
		
		if (this.tail == null) {
			this.head = new ADoublyLinkedListNode<T>(theElement, null, null);
			this.tail = this.head;
		}
		
		else {		
			ADoublyLinkedListNode<T> theDoublyLinkedListNodeForTheElement =
				new ADoublyLinkedListNode<T>(theElement, this.tail, null);
			this.tail.setsItsReferenceToTheNextNodeTo(theDoublyLinkedListNodeForTheElement);
			this.tail = this.tail.providesItsReferenceToTheNextNode();
		}
		
		this.numberOfElements++;
		
	}
	
	
	public int providesItsNumberOfElements() {
		
		return this.numberOfElements;
		
	}
	
	
	public void insertsAtItsMidpoint(T theElement) {
		
		if (theElement == null) {
			throw new RuntimeException(
				"addToItsHead of a doubly linked list was requested with a reference to an element of null."
			);
		}
		
		if (this.head == null) {
			this.head = new ADoublyLinkedListNode<T>(theElement, null, null);
			this.tail = this.head;
		}
		
		else {
		
			ADoublyLinkedListNode<T> theCurrentDoublyLinkedListNode = this.head;
			int theIndexOfTheCurrentNode = 0;
			
			while (theIndexOfTheCurrentNode < (int)((double)this.numberOfElements / 2.0)) {
				theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
				theIndexOfTheCurrentNode++;
			}
			
			if (theCurrentDoublyLinkedListNode == this.head) {
				addsToItsHead(theElement);
			}
			
			else {
			
				ADoublyLinkedListNode<T> theDoublyLinkedListNodeForTheElement = new ADoublyLinkedListNode<T>(
					theElement,
					theCurrentDoublyLinkedListNode.providesItsReferenceToThePreviousNode(),
					theCurrentDoublyLinkedListNode
				);
				
				theCurrentDoublyLinkedListNode.providesItsReferenceToThePreviousNode().setsItsReferenceToTheNextNodeTo(
					theDoublyLinkedListNodeForTheElement
				);
					
				theCurrentDoublyLinkedListNode.setsItsReferenceToThePreviousNodeTo(
					theDoublyLinkedListNodeForTheElement
				);
			
			}
		
		}
		
		this.numberOfElements++;
		
	}
	
	
	public void removesTheNodeAtItsHead() {
		
		if (this.head == null) {
			throw new RuntimeException("There is no node in the doubly linked list to remove.");
		}
		
		this.head = this.head.providesItsReferenceToTheNextNode();
		
		this.numberOfElements--;
		
	}
	
	
	public void setsItsCurrentNodeToItsTail() {
		
		this.currentDoublyLinkedListNode = this.tail;
		
	}
	
	
	public T providesTheElementOfItsCurrentNode() {
		
		if (this.currentDoublyLinkedListNode == null) {
			throw new RuntimeException(
				"providesTheElementOfItsCurrentNode of a doubly linked list was requested when the list's reference " +
				"to a current node was null."
			);
		}
		
		return this.currentDoublyLinkedListNode.providesItsData();
		
	}
	
	
	public void movesItsCurrentNodeAwayFromItsTailAndTowardsItsHead() {
		
		if (this.currentDoublyLinkedListNode == null) {
			throw new RuntimeException("The reference to the current node of this doubly linked list is null.");
		}
		
		if (this.currentDoublyLinkedListNode.providesItsReferenceToThePreviousNode() == null) {
			throw new RuntimeException(
				"The reference to the current node of this doubly linked list would become null."
			);
		}
		
		this.currentDoublyLinkedListNode = this.currentDoublyLinkedListNode.providesItsReferenceToThePreviousNode();
		
	}
	
	
	public void removesTheNodeAtItsMidpoint() {
		
		if (this.head == null) {
			throw new RuntimeException("There is no node in the doubly linked list to remove.");
		}
		
		ADoublyLinkedListNode<T> theCurrentDoublyLinkedListNode = this.head;
		int theIndexOfTheCurrentNode = 0;
		
		while (theIndexOfTheCurrentNode < (int)((double)this.numberOfElements / 2.0)) {
			theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
			theIndexOfTheCurrentNode++;
		}
		
		if (theCurrentDoublyLinkedListNode == this.head) {
			this.head = null;
		}
		
		else {
			theCurrentDoublyLinkedListNode.providesItsReferenceToThePreviousNode().setsItsReferenceToTheNextNodeTo(
				theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode()
			);
		}
		
		this.numberOfElements--;
		
	}
	
	
	public T finds(T theElement) {
		
		ADoublyLinkedListNode<T> theCurrentDoublyLinkedListNode = this.head;
		
		while (theCurrentDoublyLinkedListNode != null) {
			if (theCurrentDoublyLinkedListNode.providesItsData().equals(theElement)) {
				return theCurrentDoublyLinkedListNode.providesItsData();
			}
			theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
		}
		
		return null;
		
	}
	
	
	public String toString() {
		
		String theRepresentationOfThisDoublyLinkedList = "[";
		
		ADoublyLinkedListNode<T> theCurrentDoublyLinkedListNode = this.head;
		while (theCurrentDoublyLinkedListNode != null) {
			theRepresentationOfThisDoublyLinkedList += "\n\t" + theCurrentDoublyLinkedListNode.providesItsData();
			theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
		}
		
		theRepresentationOfThisDoublyLinkedList += "\n]";
		
		return theRepresentationOfThisDoublyLinkedList;
		
	}
	
	
	private class ADoublyLinkedListNode<T> {
		
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
	
}
