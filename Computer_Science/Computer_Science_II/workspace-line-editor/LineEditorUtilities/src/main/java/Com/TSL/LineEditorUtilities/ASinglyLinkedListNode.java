package Com.TSL.LineEditorUtilities;


/**
 * A SinglyLinkedListNode represents the structure for a singly linked list node.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/26/21
 *
 * @param <T>
 */

public class ASinglyLinkedListNode<T> {

	
	private T data;
	private ASinglyLinkedListNode<T> referenceToTheNextNode;
	
	
	/**
	 * ASinglyLinkedListNode(T theDataToUse, ASinglyLinkedListNode<T> theReferenceToTheNextNodeToUse) is the
	 * two-parameter constructor for ASinglyLinkedListNode, which sets this node's data to theDataToUse and sets this
	 * node's reference to the next node to theReferenceToTheNextNodeToUse.
	 * 
	 * @param theDataToUse
	 * @param theReferenceToTheNextNodeToUse
	 */
	
	public ASinglyLinkedListNode(T theDataToUse, ASinglyLinkedListNode<T> theReferenceToTheNextNodeToUse) {
		
		this.data = theDataToUse;
		this.referenceToTheNextNode = theReferenceToTheNextNodeToUse;
		
	}
	
	
	/**
	 * setsItsReferenceToTheNextNodeTo sets this node's reference to the next node to theReferenceToTheNextNodeToUse.
	 * 
	 * @param theReferenceToTheNextNodeToUse
	 */
	
	public void setsItsReferenceToTheNextNodeTo(ASinglyLinkedListNode<T> theReferenceToTheNextNodeToUse) {
		this.referenceToTheNextNode = theReferenceToTheNextNodeToUse;
	}
	
	
	/**
	 * providesItsData provides this node's data.
	 * 
	 * @return
	 */
	
	public T providesItsData() {
		return this.data;
	}
	
	
	/**
	 * providesItsReferenceToTheNextNode provides this node's reference to the next node.
	 * 
	 * @return
	 */
	
	public ASinglyLinkedListNode<T> providesItsReferenceToTheNextNode() {
		return this.referenceToTheNextNode;
	}
	
}