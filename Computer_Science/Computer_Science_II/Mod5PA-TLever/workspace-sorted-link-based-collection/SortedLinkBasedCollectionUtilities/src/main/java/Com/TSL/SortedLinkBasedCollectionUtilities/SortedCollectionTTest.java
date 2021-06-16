package Com.TSL.SortedLinkBasedCollectionUtilities;


import org.junit.jupiter.api.Test;


public class SortedCollectionTTest {

	
	@Test
	public void testSortedCollectionT() {
		
        SortedCollectionT<String> theSortedCollectionOfStrings = new SortedCollectionT<String>();
        
        theSortedCollectionOfStrings.add("1");
        theSortedCollectionOfStrings.add("9");
        theSortedCollectionOfStrings.add("7");
        theSortedCollectionOfStrings.add("8");
        theSortedCollectionOfStrings.add("6");
        theSortedCollectionOfStrings.add("4");
        theSortedCollectionOfStrings.add("5");
        theSortedCollectionOfStrings.add("5");
        theSortedCollectionOfStrings.add("3");
        theSortedCollectionOfStrings.add("1");
        theSortedCollectionOfStrings.add("2");
        theSortedCollectionOfStrings.add("9");
        
        theSortedCollectionOfStrings.remove("5");
		
	}
	
	
}
