package Com.TSL.SortedLinkBasedCollectionUtilities;


/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* Student name:  Tom Lever
* Completion date: 06/16/21
*
* SortedCollectionT.txt: the template file of SortedCollectionT.java
* Student tasks: implement tasks #1 and #2 as specified in this file
*
* A link-based implementation of our sorted Collection ADT
* In this implementation, duplicate elements are not allowed
*/

public class SortedCollectionT<T extends Comparable<T>> implements SortedCollectionInterface<T>{

	
   private LLNode<T> head;
   
   
   
   /**
    * SortedCollectionT() is the zero-parameter constructor for SortedCollectionT, which sets this sorted collection's
    * head reference to null.
    */
   
   public SortedCollectionT(){
	   
      head=null;
      
   }
   
   
   public void add(T ele){

      // *** Student task #1 ***  

      /* 
      Requirements: 
      If the collection is full then double the array size before adding
      However, theoretically, a linked list node implementation has no capacy limit.
      In this implementation, duplicate elements are not allowed

       *** Enter your code below *** 
       */

	   
	   if (isFull()) {
		   
		   // double the array size. What array size?
		   // The only way I know to double the size (i.e., the number of elements) in a linked list based collection
		   // is to append a linked list of <size> nodes to the collection. Each of these subsequent nodes will have a
	       // null reference to an object of type T.
		   
		   LLNode<T> theCurrentLinkedListNode = this.head;
		   
		   if (theCurrentLinkedListNode != null) {
			   LLNode<T> theLinkedListToAppend = new LLNode<T>(null, null);
			   
			   while (theCurrentLinkedListNode.getNext() != null) {
				   LLNode<T> theLinkedListNodeToAdd = new LLNode<T>(null, theLinkedListToAppend);
				   theLinkedListToAppend = theLinkedListNodeToAdd;
				   theCurrentLinkedListNode = theCurrentLinkedListNode.getNext();
			   }
			   
			   theCurrentLinkedListNode.setNext(theLinkedListToAppend);
		   }
		      
	   }

	   
	   // TODO: Replace nodes with null references established by the isFull block.
	   
	   if (this.head == null || ele.compareTo(this.head.getData()) <= 0) {
		   LLNode<T> theLinkedListNodeForTheElement = new LLNode<T>(ele, this.head);
		   this.head = theLinkedListNodeForTheElement;
	   }
	   
	   else {
		   
		   LLNode<T> theCurrentLinkedListNode = this.head;
		   
		   while ((theCurrentLinkedListNode.getNext() != null) &&
				  (ele.compareTo(theCurrentLinkedListNode.getNext().getData()) > 0)) {
			   theCurrentLinkedListNode = theCurrentLinkedListNode.getNext();
		   }
		   
		   LLNode<T> theLinkedListNodeForTheElement = new LLNode<T>(ele, theCurrentLinkedListNode.getNext());
		   theCurrentLinkedListNode.setNext(theLinkedListNodeForTheElement);
		   
	   }

   }
   
   
   public void remove(T ele){
      // *** Student task #2 ***  

      /* 
      Requirements: 
      Removes the element e from this collection such that e.equals(ele)

       *** Enter your code below *** 
      */
	  
	  if (isEmpty()) {
		  throw new ACollectionUnderflowException("Exception: remove for an empty collection requested.");
	  }
	  
	  while ((this.head != null) && (ele.equals(this.head.getData()))) {
		  this.head = this.head.getNext();
	  }
	  
	  if (this.head == null) {
		  return;
	  }
	  
	  LLNode<T> thePreviousLinkedListNode = this.head;
	  LLNode<T> theCurrentLinkedListNode = this.head.getNext();
	  
	  while (theCurrentLinkedListNode != null) {
		  if (ele.equals(theCurrentLinkedListNode.getData())) {
			  thePreviousLinkedListNode.setNext(theCurrentLinkedListNode.getNext());
		  }
		  else {
			  thePreviousLinkedListNode = theCurrentLinkedListNode;
		  }
		  theCurrentLinkedListNode = theCurrentLinkedListNode.getNext();
	  }

   }
   
   
   /**
    * isFull indicates whether or not this sorted collection is full.
    */
   
   public boolean isFull(){//theoretically, a linked list node implementation has no capacy limit
      return false;
   }
   
   
   /**
    * isEmpty indicates whether or not this sorted collection is empty.
    */
   
   public boolean isEmpty(){
      return head==null;
   }
   
   
   /**
    * size provides the number of elements in this sorted collection.
    */
   
   public int size(){
      LLNode<T> tmp=head;
      int count=0;
      while(tmp !=null){
         tmp=tmp.getNext();
         count++;
      }
      return count;
   }
   
   
   /**
    * find provides an element in the sorted collection that is equal to an input element, or provides a null reference.
    */
   
   public T find(T ele){
      LLNode<T> tmp=head;
      while(tmp != null){
         if(tmp.getData().equals(ele))
            return tmp.getData();
         tmp = tmp.getNext();
      }
      return null;
   }
   
   
   /**
    * print displays a representation of this sorted collection.
    */
   
   public void print(){
      String res="";
      LLNode<T> tmp=head;
      while(tmp!=null){
         res += tmp.getData().toString()+", ";
         tmp = tmp.getNext();
      }
      if(res.length()>0){
         res = res.substring(0, res.length() -2);
      }
      System.out.println("["+res+"]");
   }
   
}
