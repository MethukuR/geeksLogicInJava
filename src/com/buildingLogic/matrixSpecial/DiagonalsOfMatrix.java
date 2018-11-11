package com.buildingLogic.matrixSpecial;

/**
 * Print Matrix Diagonally :
 * =========================
	Given a 2D matrix, print all elements of the given matrix in diagonal order. For 
	example, consider the following 5 X 4 input matrix.
	
	    1     2     3     4
	    5     6     7     8
	    9    10    11    12
	   13    14    15    16
	   17    18    19    20
	   
	Diagonal printing of the above matrix is :
	
	    1
	    5     2
	    9     6     3
	   13    10     7     4
	   17    14    11     8
	   18    15    12
	   19    16
	   20
 * @author Ranger Raju :P
 *
 */
public class DiagonalsOfMatrix {

	public static void main(String[] args) {
		int[][] inpMatrix={ {1, 2, 3, 4},
			                {5, 6, 7, 8},
			                {9, 10, 11, 12},
			                {13, 14, 15, 16}
			               };
		
		printMatrixDiagonallyOne(inpMatrix);

	}

	private static void printMatrixDiagonallyOne(int[][] inpMatrix) {
		int len=inpMatrix.length;
		int i=0;
		while(i < len){
			printDiagonal(0, i,inpMatrix,len);
			++i;
		}
		i=1;
		while(i < len){
			printDiagonal(i, len-1,inpMatrix,len);
			++i;
		}
	}

	private static void printDiagonal(int x, int y, int[][] inpMatrix, int len) {
		System.out.println();
		while(y >= 0 && x <= len-1){
			System.out.print(inpMatrix[x][y]);
			--y;
			++x;
		}
	}

}
