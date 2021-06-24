package Com.TSL.UtilitiesForShoppingListSortedByCategoryAndName;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Hello world!
 *
 */

public class ShoppingList 
{
	
	ADoublyLinkedListNode<Item> head;
	int numberOfUniqueItems;
	
	
	public ShoppingList() {
		
		this.head = null;
		this.numberOfUniqueItems = 0;
		
	}
	
	
    public boolean isEmpty() {
    	return (this.head == null);
    }
    
    
    public boolean isFull() {
    	return false;
    }
    
    
    public int size() {
    	return this.numberOfUniqueItems;
    }
    
    
    public int totalItems() {
    	
    	int theTotalNumberOfItems = 0;
    	
    	ADoublyLinkedListNode<Item> theCurrentDoublyLinkedListNode = this.head;
    	while (theCurrentDoublyLinkedListNode != null) {
    		theTotalNumberOfItems += theCurrentDoublyLinkedListNode.providesItsData().providesItsQuantity();
    		theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
    	}
    	
    	return theTotalNumberOfItems;
    	
    }
    
    
    public double grandTotal() {
    	
    	double theTotalOfAllSubtotals = 0.0;
    	
    	ADoublyLinkedListNode<Item> theCurrentDoublyLinkedListNode = this.head;
    	while (theCurrentDoublyLinkedListNode != null) {
    		theTotalOfAllSubtotals += theCurrentDoublyLinkedListNode.providesItsData().Subtotal();
    		theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
    	}
    	
    	return theTotalOfAllSubtotals;
    	
    }
    
    
    public void printNames() {
    	
    	String theRepresentationOfTheNamesOfItems = "[";
    	
    	if (this.head != null) {
    		
        	ADoublyLinkedListNode<Item> theCurrentDoublyLinkedListNode = this.head;
    	
	    	while (theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode() != null) {
	    		theRepresentationOfTheNamesOfItems +=
	    			theCurrentDoublyLinkedListNode.providesItsData().providesItsName() + ", ";
	    		theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
	    	}
	    	
	    	theRepresentationOfTheNamesOfItems +=
	    		theCurrentDoublyLinkedListNode.providesItsData().providesItsName();
    	
    	}
    	
    	theRepresentationOfTheNamesOfItems += "]";
    	
    	System.out.println(theRepresentationOfTheNamesOfItems);
    	
    }
    
    
    private String aStringOfSpacesBasedOn(String theString, int theWidthOfTheColumn) {
    	
    	String theStringOfSpaces = "";
    	
    	for (int i = 0; i < theWidthOfTheColumn - theString.length(); i++) {
    		theStringOfSpaces += " ";
    	}
    	
    	return theStringOfSpaces;
    	
    }
    
    
    private String aStringRepresentationOf(double theUsMonetaryAmount) {
    	
    	NumberFormat theNumberFormat = NumberFormat.getInstance(Locale.US);
    	theNumberFormat.setMinimumIntegerDigits(4);
    	
    	return theNumberFormat.format(theUsMonetaryAmount);
    	
    }
    
    
    public void print() {
    	
    	System.out.print("Name");
    	int theWidthOfTheNameColumn = 62;
    	System.out.print(aStringOfSpacesBasedOn("Name", theWidthOfTheNameColumn));
    	System.out.print("Quantity");
    	int theWidthOfTheQuantityColumn = 11;
    	System.out.print(aStringOfSpacesBasedOn("Quantity", theWidthOfTheQuantityColumn));
    	System.out.println("Subtotal ($)");
    	System.out.println("=====================================================================================");
    	
    	if (this.head != null) {
    	
	    	String thePresentCategory = "";
	    	int theIndexOfTheItemInThePresentCategory = 1;
	    	
	    	ADoublyLinkedListNode<Item> theCurrentDoublyLinkedListNode = this.head;
	    	while (theCurrentDoublyLinkedListNode != null) {
	    		
	    		Item theItem = theCurrentDoublyLinkedListNode.providesItsData();
	    		if (theItem.providesItsCategory() != thePresentCategory) {
	    			thePresentCategory = theItem.providesItsCategory();
	    			System.out.println("\n" + thePresentCategory + ":");
	    			theIndexOfTheItemInThePresentCategory = 1;
	    		}
	    		
	    		String theIndexedName = theIndexOfTheItemInThePresentCategory + ". " + theItem.providesItsName();
	    		System.out.println(
	    			theIndexedName + aStringOfSpacesBasedOn(theIndexedName, theWidthOfTheNameColumn) +
	    			theItem.providesItsQuantity() + aStringOfSpacesBasedOn(Integer.toString(theItem.providesItsQuantity()), theWidthOfTheQuantityColumn) +
	    			aStringRepresentationOf(theItem.Subtotal())
	    		);
	    		theIndexOfTheItemInThePresentCategory++;
	    		theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
	    		
	    	}
	    	
    	}
    	
    	System.out.println("=====================================================================================");
    	
    	String theLabeledNumberOfItems = "Number of Items: " + totalItems();
    	System.out.print(
    		theLabeledNumberOfItems +
    		aStringOfSpacesBasedOn(theLabeledNumberOfItems, theWidthOfTheNameColumn + theWidthOfTheQuantityColumn) +
    		"Grand Total: " + aStringRepresentationOf(grandTotal()) + "\n"
    	);
    	
    }
    
    
    public Item providesTheFirstInstanceOf(Item theItem) {
    	
    	ADoublyLinkedListNode<Item> theCurrentDoublyLinkedListNode = this.head;
    	
    	while (theCurrentDoublyLinkedListNode != null) {
    		if (theCurrentDoublyLinkedListNode.providesItsData().compareTo(theItem) == 0) {
    			return theCurrentDoublyLinkedListNode.providesItsData();
    		}
    		theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
    	}
    	
    	return null;
    	
    }
    
    
    public void insert(Item item) {
    	
    	if (item == null) {
    		System.out.println("Warning: A reference to an item to insert into a shopping list was null.");
    		return;
    	}
    	
    	Item theFirstInstanceOfTheItem = providesTheFirstInstanceOf(item);
    	if (theFirstInstanceOfTheItem != null) {
    		theFirstInstanceOfTheItem.increasesItsQuantityBy(item.providesItsQuantity());
    		return;
    	}
    	
    	if (this.head == null) {
    		this.head = new ADoublyLinkedListNode<Item>(item, null, null);
    	}
    	
    	else if (item.compareTo(this.head.providesItsData()) < 0) {
			ADoublyLinkedListNode<Item> theDoublyLinkedListNodeForTheItem = new ADoublyLinkedListNode<Item>(
				item, null, this.head
			);
			this.head.setsItsReferenceToThePreviousNodeTo(theDoublyLinkedListNodeForTheItem);
			this.head = theDoublyLinkedListNodeForTheItem;
    	}
    	
    	else {
    	
	    	ADoublyLinkedListNode<Item> theCurrentDoublyLinkedListNode = this.head;
	    	
	    	while ((theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode() != null) &&
	    		   (item.compareTo(theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode().providesItsData()) > 0)) {
	    		theCurrentDoublyLinkedListNode = theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode();
	    	}
	    	
	    	ADoublyLinkedListNode<Item> theDoublyLinkedListNodeForTheItem = new ADoublyLinkedListNode<Item>(
	    		item, theCurrentDoublyLinkedListNode, theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode()
	    	);
	    	
	    	if (theCurrentDoublyLinkedListNode.providesItsReferenceToTheNextNode() != null) {
	    		theDoublyLinkedListNodeForTheItem
	    			.providesItsReferenceToTheNextNode()
	    			.setsItsReferenceToThePreviousNodeTo(theDoublyLinkedListNodeForTheItem);
	    	}
	    	
	    	theCurrentDoublyLinkedListNode.setsItsReferenceToTheNextNodeTo(theDoublyLinkedListNodeForTheItem);
    	
    	}
    	
    	this.numberOfUniqueItems++;
    	
    }
    
    
    public void remove(Item item) {
    	
    	if (item == null) {
    		System.out.println("Warning: A reference to an item to remove from a shopping list was null.");
    		return;
    	}
    	
    	Item theFirstInstanceOfTheItem = providesTheFirstInstanceOf(item);
    	if (theFirstInstanceOfTheItem == null) {
    		System.out.println("Warning: The item does not exist in the list.");
    		return;
    	}
    	
    	if (theFirstInstanceOfTheItem == this.head.providesItsData()) {
    		this.head = this.head.providesItsReferenceToTheNextNode();
    	}
    	
    	ADoublyLinkedListNode<Item> theDoublyLinkedListNodeForTheItem = this.head;
    	while (theDoublyLinkedListNodeForTheItem.providesItsData() != theFirstInstanceOfTheItem) {
    		theDoublyLinkedListNodeForTheItem = theDoublyLinkedListNodeForTheItem.providesItsReferenceToTheNextNode();
    	}
    	
    	    	
    	if (theDoublyLinkedListNodeForTheItem.providesItsReferenceToTheNextNode() != null) {
	    	theDoublyLinkedListNodeForTheItem.providesItsReferenceToTheNextNode().setsItsReferenceToThePreviousNodeTo(
	    		theDoublyLinkedListNodeForTheItem.providesItsReferenceToThePreviousNode()
	    	);
    	}
    	
    	theDoublyLinkedListNodeForTheItem.providesItsReferenceToThePreviousNode().setsItsReferenceToTheNextNodeTo(
    		theDoublyLinkedListNodeForTheItem.providesItsReferenceToTheNextNode()
    	);
    	
    }
    
}
