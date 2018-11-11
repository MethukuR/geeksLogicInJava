package com.buildingLogic.matrixSpecial;
/**
 * Java Program to Display Transpose Matrix
 * The matrix before Transpose is 
	1 2 3  
	4 5 6  
	7 8 9  
	
	The matrix after Transpose is 
	1 4 7  
	2 5 8  
	3 6 9
 * 
 * @author Raju Rockzz :P 
 *
 */
public class TransposeOfGivenMatrix {

	public static void main(String[] args) {
		int[][] inputMatrix={{1,2},{4,5},{7,8}};
		
		findTranspose(inputMatrix);

	}

	private static void findTranspose(int[][] inputMatrix) {
		int noOfRows=inputMatrix.length;
		int noOfColumns=inputMatrix[0].length;
		
		int[][] transposedMatrix=new int[noOfColumns][noOfRows];
		
		for (int i = 0; i < noOfColumns; ++i) {
			for (int j = 0; j < noOfRows; ++j) {
				transposedMatrix[i][j]=inputMatrix[j][i];
			}
		}
		
		System.out.println("Transpose of given matrix is ");
		
		for (int i = 0; i < noOfColumns; ++i) {
			for (int j = 0; j < noOfRows; ++j) {
				System.out.print(transposedMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
