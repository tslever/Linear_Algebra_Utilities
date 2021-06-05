package Com.TSL.BubbleAndInsertionSortingUtilities;


public class TheSwapper
{
	
    static void swaps(int[] theArrayToSort, int theFirstIndex, int theSecondIndex)
    {
    	int thePlaceholder = theArrayToSort[theFirstIndex];
    	theArrayToSort[theFirstIndex] = theArrayToSort[theSecondIndex];
    	theArrayToSort[theSecondIndex] = thePlaceholder;
    }

}
