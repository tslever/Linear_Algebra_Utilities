package Com.TSL.MinimizingKeystrokesUtilities;


import cc.redberry.combinatorics.CombinatorialIterator;
import cc.redberry.combinatorics.Combinatorics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class KeystrokeMinimizer 
{	
	
	private static HashMap<ArrayList<ArrayList<Integer>>, Integer> theHashMapOfPermutationsOfIndicesAndNumberOfKeyStrokes =
		new HashMap<ArrayList<ArrayList<Integer>>, Integer>();
	
	

    public static void main (String[] args)
    {
    	
    	int[] fre = {5, 2, 20, 9, 90};
    	int[] keys = {2, 3};
    	
    	int res = minimalKeyStrokes(fre, keys);
    	System.out.println("The minimum number of key strokes: " + res);
    	
    	char[] letters = {'A', 'B', 'C', 'D', 'E'};
    	String arrangement = keyPadArrangement(fre, keys, letters);
    	System.out.println(
            "The structured permutations of letters corresponding to the minimum number of key strokes:\n" +
            arrangement
        );
        
    }
    
    
    public static int minimalKeyStrokes(int[] frequencies, int[] keyLimits)
    {
    	ArrayList<int[]> theArrayListOfCompositionsOfTheNumberOfSymbols = new ArrayList<int[]>();
    	
        CombinatorialIterator<int[]> theCombinatorialIterator =
        	Combinatorics.compositions(frequencies.length, keyLimits.length);
        
        while (theCombinatorialIterator.hasNext()) {
        	
        	int[] thePresentCompositionOfTheNumberOfSymbols = theCombinatorialIterator.next();
        	
        	boolean allPropositionsOfANumberOfSymbolsForAKeyAreLessThanOrEqualToTheKeyLimit = true;
        	for (int i = 0; i < thePresentCompositionOfTheNumberOfSymbols.length; i++) 
        	{
        		if (thePresentCompositionOfTheNumberOfSymbols[i] > keyLimits[i])
        		{
        			allPropositionsOfANumberOfSymbolsForAKeyAreLessThanOrEqualToTheKeyLimit = false;
        		}
        	}
        	
        	if (allPropositionsOfANumberOfSymbolsForAKeyAreLessThanOrEqualToTheKeyLimit)
        	{
        		theArrayListOfCompositionsOfTheNumberOfSymbols.add(thePresentCompositionOfTheNumberOfSymbols);
        	}
        	
        }
        
        
        int[] theArrayOfIndicesForSymbols = new int[frequencies.length];
        for (int i = 0; i < frequencies.length; i++)
        {
        	theArrayOfIndicesForSymbols[i] = i;
        }
        
        
        ArrayList<ArrayList<Integer>> theArrayListOfAllPermutationsOfAnArrayOfIndicesForSymbols =
        	ThePermutationGenerator.permute(theArrayOfIndicesForSymbols);
               
        
        for (int[] theCompositionOfTheNumberOfSymbols : theArrayListOfCompositionsOfTheNumberOfSymbols)
        {
    		for (ArrayList<Integer> thePermutationOfIndicesForSymbols : theArrayListOfAllPermutationsOfAnArrayOfIndicesForSymbols)
    		{	
    			ArrayList<ArrayList<Integer>> theStructuredPermutationOfIndicesForSymbols =
    				new ArrayList<ArrayList<Integer>>();
    			
    			int theNumberOfKeyStrokes = 0;
    			int offset = 0;
    			
            	for (int i = 0; i < theCompositionOfTheNumberOfSymbols.length; i++)
            	{
            		ArrayList<Integer> theIndicesForThisNumberOfSymbols = new ArrayList<Integer>();
            		
            		for (int j = 0; j < theCompositionOfTheNumberOfSymbols[i]; j++)
            		{
            			theNumberOfKeyStrokes +=
            				(j + 1) * frequencies[thePermutationOfIndicesForSymbols.get(offset + j)];
            			
            			theIndicesForThisNumberOfSymbols.add(thePermutationOfIndicesForSymbols.get(offset + j));
            		}
            		
            		offset += theCompositionOfTheNumberOfSymbols[i];
            		
            		theStructuredPermutationOfIndicesForSymbols.add(theIndicesForThisNumberOfSymbols);
            	}
            	
            	theHashMapOfPermutationsOfIndicesAndNumberOfKeyStrokes.put(
            		theStructuredPermutationOfIndicesForSymbols, theNumberOfKeyStrokes);
    		}
        }
        
        
        int theMinimumNumberOfKeyStrokes = Integer.MAX_VALUE;
        
        for (Map.Entry<ArrayList<ArrayList<Integer>>, Integer> theKeyValuePair : theHashMapOfPermutationsOfIndicesAndNumberOfKeyStrokes.entrySet())
        {
        	if (theKeyValuePair.getValue() < theMinimumNumberOfKeyStrokes)
        	{
        		theMinimumNumberOfKeyStrokes = theKeyValuePair.getValue();
        	}
        }
        
        return theMinimumNumberOfKeyStrokes;
    }
    
    
    public static String keyPadArrangement(int[] frequencies, int[] keyLimits, char[] letters)
    {
    	
    	int theMinimumNumberOfKeyStrokes = minimalKeyStrokes(frequencies, keyLimits);

    	ArrayList<ArrayList<ArrayList<Integer>>> thePermutationsOfIndicesForSymbolsCorrespondingToTheMinimumNumberOfKeyStrokes =
    		new ArrayList<ArrayList<ArrayList<Integer>>>();
        
        for (Map.Entry<ArrayList<ArrayList<Integer>>, Integer> theKeyValuePair : theHashMapOfPermutationsOfIndicesAndNumberOfKeyStrokes.entrySet())
        {
        	if (theKeyValuePair.getValue() == theMinimumNumberOfKeyStrokes)
        	{
                thePermutationsOfIndicesForSymbolsCorrespondingToTheMinimumNumberOfKeyStrokes.add(
                	theKeyValuePair.getKey()
                );
        	}
        }
        
        ArrayList<ArrayList<ArrayList<Character>>> thePermutationsOfLettersCorrespondingToTheMinimumNumberOfKeyStrokes =
        	new ArrayList<ArrayList<ArrayList<Character>>>();
        
        for (ArrayList<ArrayList<Integer>> theStructuredPermutationOfIndicesForSymbols : thePermutationsOfIndicesForSymbolsCorrespondingToTheMinimumNumberOfKeyStrokes)
        {
        	ArrayList<ArrayList<Character>> thePermutationOfLetters = new ArrayList<ArrayList<Character>>();
        	
        	for (int i = 0; i < theStructuredPermutationOfIndicesForSymbols.size(); i++)
        	{
    			ArrayList<Character> theArrayOfLetters = new ArrayList<Character>();
        		
        		for (int j = 0; j < theStructuredPermutationOfIndicesForSymbols.get(i).size(); j++)
        		{        			
        			theArrayOfLetters.add(letters[theStructuredPermutationOfIndicesForSymbols.get(i).get(j)]);
        		}
        		
        		thePermutationOfLetters.add(theArrayOfLetters);
        	}
        	
        	thePermutationsOfLettersCorrespondingToTheMinimumNumberOfKeyStrokes.add(thePermutationOfLetters);
        }
        
        String theRepresentationOfTheStructuredPermutationsOfLetters = "";
        
        for (int i = 0; i < thePermutationsOfLettersCorrespondingToTheMinimumNumberOfKeyStrokes.size(); i++)
        {
        	ArrayList<ArrayList<Character>> theStructuredPermutation =
        		thePermutationsOfLettersCorrespondingToTheMinimumNumberOfKeyStrokes.get(i);
	        
        	theRepresentationOfTheStructuredPermutationsOfLetters += "\t";
        	
        	for (ArrayList<Character> theArrayOfCharacters : theStructuredPermutation)
        	{
        		theRepresentationOfTheStructuredPermutationsOfLetters += "[";
        		
        		for (int j = 0; j < theArrayOfCharacters.size(); j++)
        		{
        			theRepresentationOfTheStructuredPermutationsOfLetters += theArrayOfCharacters.get(j);
        		}
        		
        		theRepresentationOfTheStructuredPermutationsOfLetters += "]";
        	}
        	
        	theRepresentationOfTheStructuredPermutationsOfLetters += "\n";
	        
        }

        
        return theRepresentationOfTheStructuredPermutationsOfLetters;
        
    }
    
}
