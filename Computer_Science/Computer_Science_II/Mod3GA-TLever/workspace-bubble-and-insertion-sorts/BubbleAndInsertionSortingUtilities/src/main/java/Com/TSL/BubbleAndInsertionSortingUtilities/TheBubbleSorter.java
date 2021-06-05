package Com.TSL.BubbleAndInsertionSortingUtilities;


class TheBubbleSorter
{
	
	static void bubbleSorts(int[] theArrayToSort)
	{
		
        for (int i = 0; i < theArrayToSort.length; i++)
        {
        	for (int j = 0; j < theArrayToSort.length - i - 1; j++)
        	{
        		if (theArrayToSort[j] > theArrayToSort[j + 1])
        		{
        			TheSwapper.swaps(theArrayToSort, j, j + 1);
        		}
        	}
        }
        
	}
	
}