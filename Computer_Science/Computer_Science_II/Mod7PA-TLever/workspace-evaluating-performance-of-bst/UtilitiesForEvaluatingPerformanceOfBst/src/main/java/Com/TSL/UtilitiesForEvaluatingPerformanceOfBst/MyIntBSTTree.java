package Com.TSL.UtilitiesForEvaluatingPerformanceOfBst;


/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-05-24 16:50
*
* Student name:  Tom Lever
* Completion date: 07/03/21
*
* MyIntBSTTree represents the structure for a binary search tree of nodes with integers.
*/


import java.util.*;


public class MyIntBSTTree{  
	
	
   private Node root;
   
   
   /**
    * MyIntBSTTree is the zero-parameter constructor for MyIntBSTTree, which sets this tree's reference to a root node
    * to null.
    */
   
   public MyIntBSTTree() {
	   
      root = null;
      
   }
   
   
   public MyIntBSTTree buildBalancedTree(int[] arr){
     
     // *** Student task ***  
      /* Requirements: 
         This method builds a balanced tree with values from the int arr and returns the tree.

       *** Enter your code below *** 
     */

	    Arrays.sort(arr);
	   
	    Node[] theSortedArrayOfNodes = new Node[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	    	theSortedArrayOfNodes[i] = new Node(arr[i]);
	    }
	    
	    MyIntBSTTree theBalancedBinarySearchTree = new MyIntBSTTree();
	    
	    grow(theBalancedBinarySearchTree, theSortedArrayOfNodes, 0, theSortedArrayOfNodes.length - 1);
	    
	    return theBalancedBinarySearchTree;

   }
   
   
   public MyIntBSTTree buildTree(int[] arr) {

     // *** Student task ***  
      /* Requirements: 
         This method builds a tree with values from the int arr and returns the tree.
         You may simply add all values to the tree in the same sequence as in the int arr.

       *** Enter your code below *** 
     */
	   
	   MyIntBSTTree theBinarySearchTreeOfIntegers = new MyIntBSTTree();
	   
	   for (int i = 0; i < arr.length; i++) {
		   theBinarySearchTreeOfIntegers.add(arr[i]);
	   }
	   
	   return theBinarySearchTreeOfIntegers;

   }
   
   
   public MyIntBSTTree buildWorstTree(int[] arr) {
     
     // *** Student task ***  
      /* Requirements: 
         Build and return a tree whose height is arr.length - 1

       *** Enter your code below *** 
     */
	   
	   Arrays.sort(arr);
	   
	   MyIntBSTTree theWorstBinarySearchTree = new MyIntBSTTree();
	   theWorstBinarySearchTree = theWorstBinarySearchTree.buildTree(arr);
	   
	   return theWorstBinarySearchTree;

   }
   
   
   /**
    * comparisons(int val) returns the number of comparisons of a provided integer with the integer of a node of this
    * tree that are required to determine whether or not the provided integer is in this tree.
    * 
    * @param val
    * @return
    */
   
   public int comparisons(int val) {

      // *** Student task ***  
      /* Requirements: 
       Overloaded method - Count and return how many comparisons performed to search for the node whose data equals the argument val.

       *** Enter your code below *** 
     */

	   return searchFor(val, this.root);

   }
   
   
   /**
    * comparisons(Node node) returns the number of comparisons of the integer of a provided node with the integer of
    * this a node of this tree that are required to determine whether or not the integer of the provided node is in
    * this tree.
    * 
    * @param node
    * @return
    */
   
   public int comparisons(Node node) {
      // *** Student task ***  
      /* Requirements: 
        Count and return how many comparisons performed to search for the argument node

       *** Enter your code below *** 
     */
	   
	   if (node == null) {
		   return 0;
	   }

       return searchFor(node.getData(), this.root);
      
   }
   
   
   /**
    * enqueueInOrder is a recursive method. If a provided reference to a node is null, this method does nothing. This
    * method passes itself the reference to the left child node of the provided reference to a node and a reference to
    * the queue in which to enqueue nodes with integers in ascending order. After this method's descendant returns,
    * this method enqueues the node referenced by the provided reference to a node. Finally, this method passes itself
    * the reference to the right child node of the provided reference to a node and a reference to the queue.
    * 
    * @param theNode
    * @param theQueue
    */
   
   private void enqueueInOrder(Node theNode, Queue<Node> theQueue) {
	   
	   if (theNode == null) {
		   return;
	   }
	   
	   enqueueInOrder(theNode.getLeft(), theQueue);
	   theQueue.add(theNode);
	   enqueueInOrder(theNode.getRight(), theQueue);
	   
   }
   
   
   /**
    * getTheHeightOfTheTreeWithRootNode provides the height of a binary search tree with a provided root.
    * 
    * @param theRootOfTheTree
    * @return
    */
   
   private int getTheHeightOfTheTreeWithRootNode(Node theRootOfTheTree) {
	   
	   if (theRootOfTheTree == null) {
		   return -1;
	   }
	   
	   return
	       1 + Math.max(
               getTheHeightOfTheTreeWithRootNode(theRootOfTheTree.getLeft()),
               getTheHeightOfTheTreeWithRootNode(theRootOfTheTree.getRight())
           );
	   
   }
   
   
   /**
    * grow grows a binary tree with elements of a sorted array of nodes with integers between the first index of the
    * array and the last index of the array inclusive.
    * 
    * @param theTreeToGrow
    * @param theSortedArrayOfNodes
    * @param theIndexOfTheFirstElement
    * @param theIndexOfTheLastElement
    */
   
   private void grow(
       MyIntBSTTree theTreeToGrow,
       Node[] theSortedArrayOfNodes,
       int theIndexOfTheFirstElement,
       int theIndexOfTheLastElement
   ) {
	   if (theIndexOfTheFirstElement == theIndexOfTheLastElement) {
		   theTreeToGrow.add(theSortedArrayOfNodes[theIndexOfTheFirstElement].getData());
	   }
	   else if ((theIndexOfTheFirstElement + 1) == theIndexOfTheLastElement) {
		   theTreeToGrow.add(theSortedArrayOfNodes[theIndexOfTheFirstElement].getData());
		   theTreeToGrow.add(theSortedArrayOfNodes[theIndexOfTheLastElement].getData());
	   }
	   else {
		   int theIndexOfTheMiddleElement = (theIndexOfTheFirstElement + theIndexOfTheLastElement) / 2;
		   theTreeToGrow.add(theSortedArrayOfNodes[theIndexOfTheMiddleElement].getData());
		   grow(theTreeToGrow, theSortedArrayOfNodes, theIndexOfTheFirstElement, theIndexOfTheMiddleElement - 1);
		   grow(theTreeToGrow, theSortedArrayOfNodes, theIndexOfTheMiddleElement + 1, theIndexOfTheLastElement);
	   }
   }
   
   
   public int height() {
      // *** Student task ***  
      /* Requirements: 
        The height of a binary tree is the largest number of edges in a path from the root node to a leaf node. 
        Essentially, it is the height of the root node. Note that if a tree has only one node, then that node 
        is at the same time the root node and the only leaf node, so the height of the tree is 0, similary, 
        the height of a tree with only two nodes is 1. Implement this method to return height of the tree

       *** Enter your code below *** 
     */

	   return getTheHeightOfTheTreeWithRootNode(this.root);
      
   }
   
   
   /**
    * searchFor is a recursive method. Ultimately, it returns the number of comparisons 
    * 
    * @param theIntegerToFind
    * @param theRootOfTheTree
    * @return
    */
   
   public int searchFor(int theIntegerToFind, Node theRootOfTheTree) {
	   
	   if (theRootOfTheTree == null) {
		   return 0;
	   }
	   else if (theIntegerToFind < theRootOfTheTree.getData()) {
		   return 1 + searchFor(theIntegerToFind, theRootOfTheTree.getLeft());
	   }
	   else if (theIntegerToFind > theRootOfTheTree.getData()) {
		   return 1 + searchFor(theIntegerToFind, theRootOfTheTree.getRight());
	   }
	   else {
		   return 1;
	   }
	   
   }
   
   
   // **** DO NOT MODIFY CODE BEYOND THIS POINT ***
   public void add(int data) {
       root = addHelper(root, data);
   }

   
   private Node addHelper(Node node, int data) {//add node helper
       if (node == null){
          node = new Node(data);
       }else if (data <= node.getData()){
           node.setLeft(addHelper(node.getLeft(), data));
       }else{
           node.setRight(addHelper(node.getRight(), data));//System.out.println(data);
       }
       return node;
   }
   

   public void display(){
      //print tree structure
      displayHelper(root, 0);
   }

   
   private void displayHelper(Node t, int level){
      if(t==null) return ;
      displayHelper(t.getRight(), level + 1);
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getData());
      displayHelper(t.getLeft(), level + 1); //recurse left
   }
   
}