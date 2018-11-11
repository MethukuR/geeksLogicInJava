package com.buildingLogic.numberSpecial;
/**
 * Print Pascal triangle:
 * 
	         1 
	        1 1 
	       1 2 1 
	      1 3 3 1 
	     1 4 6 4 1 
	    1 5 10 10 5 1 
	   1 6 15 20 15 6 1 
	  1 7 21 35 35 21 7 1 
	 1 8 28 56 70 56 28 8 1 
	 
 * @author Raju :)
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		int noOfRows=9;
		printPascalTriangle(noOfRows);
	}

	private static void printPascalTriangle(int noOfRows) {
		for (int row = 0; row < noOfRows; ++row) {
			for (int j = noOfRows-row; j > 0; --j) {
				System.out.print(" ");
			}
			
			int n=1;
			
			for (int col = 0; col <= row; ++col) {
				System.out.print(n+" ");
				n=n*(row-col)/(col+1);
			}
			System.out.println();
		}
		
	}

}
