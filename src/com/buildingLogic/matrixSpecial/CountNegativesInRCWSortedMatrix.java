package com.buildingLogic.matrixSpecial;
/**
 *  Count Negative Numbers in a Column-Wise and Row-Wise Sorted Matrix
	Find the number of negative numbers in a column-wise / row-wise sorted matrix M[][]. 
	Suppose M has n rows and m columns.
	
	Example:
	
	Input:  M =  [-3, -2, -1,  1]
	             [-2,  2,  3,  4]
	             [4,   5,  7,  8]
	Output : 4
	We have 4 negative numbers in this matrix
	
	Here’s a more efficient solution:

	We start from the top right corner and find the position of the last negative number 
	in the first row.
	Using this information, we find the position of the last negative number in the 
	second row.
	We keep repeating this process until we either run out of negative numbers or we get 
	to the last row.
	
	With the given example:
	[-3, -2, -1,  1]
	[-2,  2,  3,  4]
	[4,   5,  7,  8]
	
	Here's the idea:
	[-3, -2,  ↓,  ←] -> Found 3 negative numbers in this row
	[ ↓,  ←,  ←,  4] -> Found 1 negative number in this row
	[ ←,  5,  7,  8] -> No negative numbers in this row 
	
 * @author Ranger Raju :P
 *
 */
public class CountNegativesInRCWSortedMatrix {

	public static void main(String[] args) {
		int[][] inpMatrix={
				  {-3, -2, -1,  1},
			      {-2,  2,  3,  4},
			      {4,   5,  7,  8}
		};
		
		countNegatives(inpMatrix);
	}

	private static void countNegatives(int[][] inpMatrix) {
		int len=inpMatrix.length;
		
		int i=0;
		int j=len-1;
		int count=0;
		while(i < len && j >= 0){
			if(inpMatrix[i][j] < 0){
				count+=(j+1);
				++i;
			}
			else{
				--j;
			}
		}
		System.out.println(count);
	}

}
