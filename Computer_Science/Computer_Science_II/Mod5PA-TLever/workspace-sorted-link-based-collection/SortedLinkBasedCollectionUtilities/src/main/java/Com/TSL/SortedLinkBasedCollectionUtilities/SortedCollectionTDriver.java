package Com.TSL.SortedLinkBasedCollectionUtilities;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/**
 * Hello world!
 *
 */

public class SortedCollectionTDriver 
{
	
    public static void main(String[] args) throws FileNotFoundException
    {
    	
        String theFilename = args[0];
        FileReader theFileReader = new FileReader(theFilename);
        
        Scanner theScannerOfTheTextFile = new Scanner(theFileReader);
        
        SortedCollectionT<String> theSortedCollectionOfStrings = new SortedCollectionT<String>();
        
        while (theScannerOfTheTextFile.hasNext()) {
        	
        	String theStringToPotentiallyAdd = theScannerOfTheTextFile.next().toLowerCase();
        	if (theSortedCollectionOfStrings.find(theStringToPotentiallyAdd) == null) {
        		theSortedCollectionOfStrings.add(theStringToPotentiallyAdd);
        	}
        	
        }
        
        theScannerOfTheTextFile.close();
        
        System.out.println("The sorted collection of strings after parsing " + theFilename + ":");
        theSortedCollectionOfStrings.print();
        System.out.println();
        
        System.out.println("The sorted collection of strings after removing \"k\" and \"h\":");
        theSortedCollectionOfStrings.remove("k");
        theSortedCollectionOfStrings.remove("h");
        theSortedCollectionOfStrings.print();
        
    }
    
}
