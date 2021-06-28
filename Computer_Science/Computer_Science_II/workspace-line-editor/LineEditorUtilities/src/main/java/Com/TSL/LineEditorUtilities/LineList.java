package Com.TSL.LineEditorUtilities;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/** 
* LineList is a linked-based list that represents the contents of a document.
*
* Student name: Tom Lever
* Completion date: 06/27/21
*/

public class LineList {


    private Node<String> head;

    
    /**
     * LineList is the zero-parameter constructor for LineList, which sets this list's reference to its head node to
     * null.
     */

    public LineList() {
 
        head = null;

    }


    /**
     * addLine(String line) appends a provided line to the end of this list of lines.
     * 
     * @param line
     */
    
    public void addLine(String line) {

    	if (line == null) {
    		throw new AnAppendsStringException(
    			"A buffer of strings found that a reference to a string to append was null."
    		);
    	}
    	
    	if (line.equals("")) {
    		throw new AnAppendsStringException(
    			"A buffer of strings found that a reference to a string to append was empty."
    		);
    	}
		
		Node<String> theSinglyLinkedListNodeForTheLine = new Node<String>(line, null);
		
		if (this.head == null) {
			this.head = theSinglyLinkedListNodeForTheLine;
			return;
		}
		
		Node<String> theCurrentSinglyLinkedListNode = this.head;
		while (theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode() != null) {
			theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
		}
		
		theCurrentSinglyLinkedListNode.setsItsReferenceToTheNextNodeTo(theSinglyLinkedListNodeForTheLine);
    	
    }
    
    
    /**
     * empty clears this list of all lines.
     */
    
    public void empty() {
    	
    	this.head = null;
    	
		System.out.println("The line editor's buffer of strings was cleared.");
    	
    }
    
    
    /**
     * line outputs the line with a provided index to the standard output stream.
     * 
     * @param n
     */
    
    public void line(int n) {
      	// Print nth line in the document. (The nth node in the list)
    	
    	if (n >= lines()) {
    		System.out.println("Line " + n + " does not exist.\n");
    		return;
    	}
    	
    	Node<String> theCurrentSinglyLinkedListNode = this.head;
    	int theIndexOfTheCurrentNode = 0;
    	while (theIndexOfTheCurrentNode < n) {
    		theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
    		theIndexOfTheCurrentNode++;
    	}
    	
    	System.out.print(
    		theCurrentSinglyLinkedListNode.providesItsData()
    		.replace("\t", "\\t")
    		.replace("\n", "\\n")
    		.replace("\r", "\\r") +
    		"\n\n"
    	);

    }
    
    
    /**
     * lines provides the number of lines in this list.
     * 
     * @return
     */
    
    public int lines() {
    	
    	int theNumberOfLines = 0;
    	
    	Node<String> theCurrentSinglyLinkedListNode = this.head;
    	while (theCurrentSinglyLinkedListNode != null) {
    		theNumberOfLines++;
    		theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
    	}
    	
    	return theNumberOfLines;
    	
    }
    
    
    /**
     * load clears the line editor's buffer of strings if a append / overwrite indicate is false, loads the file at the
     * provided path, and appends the lines in that file to the line editor's buffer of strings.
     * 
     * @param fileName
     * @param append
     */
    
    public void load(String fileName, boolean append) {

    	if (!append) {
    		empty();
    	}
    	
    	try {
    		AnInputManager.loadsTheFileAt(fileName);
    	}
    	catch (IOException theIOException) {
    		System.out.println(theIOException.getMessage() + "\n");
    	}
    	catch (AnInvalidCharacterException theInvalidCharacterException) {
    		System.out.println(theInvalidCharacterException.getMessage() + "\n");
    	}
    	
    }
    
    
    /**
     * print outputs the lines in this list, along with their indices, to the standard output stream.
     */
    
    public void print() {
    	
	    Node<String> theCurrentSinglyLinkedListNode = this.head;
	    int theIndexOfTheCurrentLine = 0;
		
		String theCurrentLine;
		while (theCurrentSinglyLinkedListNode != null) {
			theCurrentLine = theCurrentSinglyLinkedListNode.providesItsData();
			System.out.println(
				theIndexOfTheCurrentLine + ": " +
				theCurrentLine.replace("\t", "\\t").replace("\n", "\\n").replace("\r", "\\r")
			);
			theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
			theIndexOfTheCurrentLine++;
		}
		
		System.out.println();

    }
    
    
    /**
     * save saves the lines in this list to a file at a provided path.
     * 
     * @param fileName
     */
    
    public void save(String fileName) {
    	
    	FileWriter theFileWriter;
    	try {
    		theFileWriter = new FileWriter(fileName);
    	}
    	catch (IOException theIOException) {
    		System.out.println(
    			"The line editor was unable to save the lines in its buffer of strings because the file specified " +
    			"by the path that the line editor received could not be opened."
    		);
    		return;
    	}
    	
    	BufferedWriter theBufferedWriter = new BufferedWriter(theFileWriter);
    	
    	Node<String> theCurrentSinglyLinkedListNode = this.head;
    	String theCurrentLine;
    	while (theCurrentSinglyLinkedListNode != null) {
    		theCurrentLine = theCurrentSinglyLinkedListNode.providesItsData();
    		try {
    			theBufferedWriter.write(theCurrentLine);
    		}
    		catch (IOException theIOException) {
    			System.out.println("The line editor could not write the line \"" + theCurrentLine + "\".");
    		}
    		theCurrentSinglyLinkedListNode = theCurrentSinglyLinkedListNode.providesItsReferenceToTheNextNode();
    	}
    	
    	try {
    		theBufferedWriter.flush();
    	}
    	catch (IOException theIOException) {
    		System.out.println("The line editor could not flush a buffered writer.");
    	}
    	
    	try {
    		theBufferedWriter.close();
    	}
    	catch (IOException theIOException) {
    		System.out.println("The line editor could not close a buffered writer.");
    	}
    	
    	try {
    		theFileWriter.close();
    	}
    	catch (IOException theIOException) {
    		System.out.println("The line editor could not close a file writer.");
    	}

    }
    
}