package Com.TSL.MatrixEditor;


/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-02
*
* Student name: Tom Lever
* Completion date: 06/04/21
*
* AreaFill.txt: the template file of AreaFill.java
* Student tasks: implement tasks #1, #2 and #3 as specified in this file
*/


import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
 

public class AreaFill{
     
      public static void main(String[] args) throws Exception
      { 
         // YOU ARE NOT SUPPOSED TO MAKE ANY CHANGES HERE
        char[][] matrix = buildMatrix (new File (args[0]));
        
        System.out.println("Original Matrix:");
        print(matrix);
        int row=Integer.parseInt(args[1]);
        int col=Integer.parseInt(args[2]);
        fill(matrix,row,col,matrix[row][col]);
        System.out.println("after filling\n");
        print(matrix);
        
      } 

      
    public static char[][] buildMatrix(File file) throws AMatrixFileParsingException, IOException
    { 
      
    // *** Student task #1 ***  

    /* 
    Requirements: 
    This method reads data from the file and build and return a 2D char array. 
    The first line in the data file contains two numbers R and C, followed by R lines 
    and each line contains C characters.

    *** Enter your code below *** 
    */

        FileReader theFileReader = new FileReader(file, StandardCharsets.UTF_8);
        BufferedReader theBufferedReader = new BufferedReader(theFileReader);
    
        System.out.println("Original data in file\n");
        String theLineOfTheMatrixFileRepresentingTheHeightAndWidthOfTheMatrix = theBufferedReader.readLine();
        System.out.println(theLineOfTheMatrixFileRepresentingTheHeightAndWidthOfTheMatrix);
        
        String[] theHeightAndWidthOfTheMatrixAsAnArrayOfStrings =
            theLineOfTheMatrixFileRepresentingTheHeightAndWidthOfTheMatrix.split(" ");
        
        if (theHeightAndWidthOfTheMatrixAsAnArrayOfStrings.length != 2)
        {
            throw new AMatrixFileParsingException(
         	    "Exception: The matrix file does not have a first line containing a matrix height and width."
         	);
        }
         
        String theHeightOfTheMatrixAsAString = theHeightAndWidthOfTheMatrixAsAnArrayOfStrings[0];
        String theWidthOfTheMatrixAsAString = theHeightAndWidthOfTheMatrixAsAnArrayOfStrings[1];
        
        int theHeightOfTheMatrix = 0;
        int theWidthOfTheMatrix = 0;
        
        // parseInt throws NumberFormatException.
        theHeightOfTheMatrix = Integer.parseInt(theHeightOfTheMatrixAsAString);
        theWidthOfTheMatrix = Integer.parseInt(theWidthOfTheMatrixAsAString);
        
        if (theHeightOfTheMatrix < 0 || theWidthOfTheMatrix < 0)
        {
            throw new AMatrixFileParsingException(
         		"Exception: Either the height of the matrix or the width of the matrix is negative."
         	);
        }
 		
     	char[][] theMatrixOfCharacters = new char[theHeightOfTheMatrix][theWidthOfTheMatrix];
     	
     	int theIndexOfThePresentMatrixRow = 0;
     	String theLineRepresentingAMatrixRow;
     	int theNumberOfLinesRepresentingMatrixRows = 0;
     	
     	while ((theLineRepresentingAMatrixRow = theBufferedReader.readLine()) != null)
     	{
     		theNumberOfLinesRepresentingMatrixRows++;
     		if (theNumberOfLinesRepresentingMatrixRows > theHeightOfTheMatrix)
     		{
     			throw new AMatrixFileParsingException(
     				"Exception: The number of lines representing matrix rows is greater than the height of the " +
     				"matrix " + theHeightOfTheMatrix + "."
     			);
     		}
     		
     		System.out.println(theLineRepresentingAMatrixRow);
     		
     		if (theLineRepresentingAMatrixRow.length() != theWidthOfTheMatrix)
     		{
     			throw new AMatrixFileParsingException(
     				"Exception: The length of the line representing a matrix row \"" + theLineRepresentingAMatrixRow +
     				"\" is greater than the width of the matrix " + theHeightOfTheMatrix + "."
     			);
     		}
     		
     		for (int i = 0; i < theLineRepresentingAMatrixRow.length(); i++)
     		{
     			theMatrixOfCharacters[theIndexOfThePresentMatrixRow][i] = theLineRepresentingAMatrixRow.charAt(i);
     		}
     		theIndexOfThePresentMatrixRow++;
     	}
     	
     	theBufferedReader.close();
     	
     	if (theNumberOfLinesRepresentingMatrixRows < theHeightOfTheMatrix)
     	{
     		throw new AMatrixFileParsingException(
     			"Exception: The number of lines representing matrix rows is less than the height of the matrix " +
     			theHeightOfTheMatrix + "."
     		);
     	}

     	System.out.println("\n");
     	
        return theMatrixOfCharacters;

    }
     
     
     public static void fill(char[][] grid, int row, int col, char ch){
     // *** Student task #2 ***  

     /* 
     Requirements: 
     This is a recursive method. It fills the cell at [row, col] 
     with * if matrix[row][col] is ch, then recurs up, down, left, and right, 
     (but NOT diagonally) and replaces similar characters with ‘*’.
     
     *** Enter your code below ***       
     */
     
    	 grid[row][col] = '*';
    	 
    	 if (col > 0 && grid[row][col - 1] == ch)
    	 {
    		 fill(grid, row, col - 1, ch);
    	 }
    	 
    	 if (col < grid[0].length - 1 && grid[row][col + 1] == ch)
    	 {
    		 fill(grid, row, col + 1, ch);
    	 }
    	 
    	 if (row > 0 && grid[row - 1][col] == ch)
    	 {
    		 fill(grid, row - 1, col, ch);
    	 }
    	 
    	 if (row < grid.length - 1 && grid[row + 1][col] == ch)
    	 {
    		 fill(grid, row + 1, col, ch);
    	 }
     
     }

     public static void print(char[][] area)
     {
     
     // *** Student task #3 ***  

     /* 
     Requirements: 
     This method prints the matrix in a table format as shown below:
         ....00
         .0..00
         ..0000

     *** Enter your code below *** 
     */

         for (int i = 0; i < area.length; i++)
         {
         	for (int j = 0; j < area[0].length; j++)
         	{
         		System.out.print(area[i][j]);
         	}
         	
         	System.out.println();
         }
         
         System.out.println("\n");
  
     }
     
}