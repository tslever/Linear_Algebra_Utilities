package Com.TSL.LineEditorUtilities;


/**
 * ABufferOfStrings represents the structure for a buffer of strings.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 06/26/21
 */

public class ABufferOfStrings {

	
	ASinglyLinkedListNode<String> frontNode;
	
	
	public ABufferOfStrings() {
		
		this.frontNode = null;
		
	}
	
	
	public void appends(String theLine) throws AnAppendsStringException {
		
    	if (theLine == null) {
    		throw new AnAppendsStringException(
    			"A buffer of strings found that a reference to a string to append was null."
    		);
    	}
    	
    	if (theLine.equals("")) {
    		throw new AnAppendsStringException(
    			"A buffer of strings found that a reference to a string to append was empty."
    		);
    	}
		
		ASinglyLinkedListNode<String> theSinglyLinkedListNodeForTheLine =
			new ASinglyLinkedListNode<String>(theLine, null);
		
		if (this.frontNode == null) {
			this.frontNode = theSinglyLinkedListNodeForTheLine;
			return;
		}
		
		ASinglyLinkedListNode<String> theCurrentSinglyLinkedListNode = this.frontNode;
		while (theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode() != null) {
			theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
		}
		
		theCurrentSinglyLinkedListNode.setsItsReferenceToTheNextNodeTo(theSinglyLinkedListNodeForTheLine);
		
	}
	
	
	@Override
	public String toString() {
		
		String theRepresentationOfThisBuffer = "Buffer of Strings: [";
		
		ASinglyLinkedListNode<String> theCurrentSinglyLinkedListNode = this.frontNode;
		while (theCurrentSinglyLinkedListNode != null) {
			theRepresentationOfThisBuffer += "\t" + theCurrentSinglyLinkedListNode.providesItsData() + "\n";
			theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
		}
		
		theRepresentationOfThisBuffer += "]";
		
		return theRepresentationOfThisBuffer;
		
	}
	
}
