package Com.TSL.BubbleAndInsertionSortingUtilities;


class TheInsertionSorter
{
	
	static void insertionSorts(int[] theArrayToSort)
	{
		
        for (int i = 0; i < theArrayToSort.length; i++)
        {
        	for (int j = i; j > 0; j--)
        	{
        		if (theArrayToSort[j - 1] > theArrayToSort[j])
        		{
        			TheSwapper.swaps(theArrayToSort, j - 1, j);
        		}
        	}
        }
        
	}
	
}