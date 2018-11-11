package com.buildingLogic.matrixSpecial;
/**
 *  You have to find addition and subtraction of two matrices.
	The matrices are assumed to all have the same dimensions.
	
	Example:
	
	First Matrix :-
	1 2
	3 4
	Second matrix :-
	4 5
	-1 5
	then output of the program (sum of First and Second matrix) will be
	5 7
	2 9
	
	then output of the program (difference of First and Second matrix) will be
	
	-3 -3
	 4 -1 
 * 
 * @author Raju Rockzz :P
 *
 */
public class AdditionAndSubtractionOfMatrices {

	public static void main(String[] args) {
		int[][] firstMatrix={{1,2},{3,4}};
		int[][] secondMatrix={{4,5},{-1,5}};
		
		additionOfMatrices(firstMatrix,secondMatrix);
		subtractionOfMatrices(firstMatrix,secondMatrix);

	}

	private static void subtractionOfMatrices(int[][] firstMatrix,int[][] secondMatrix) {

		int noOfRows=firstMatrix.length;
		int noOfColumns=firstMatrix[0].length;
		
		int[][] resultMatrix=new int[noOfRows][noOfColumns];
		
		for (int i = 0; i < noOfRows; ++i) {
			for (int j = 0; j < noOfColumns; ++j) {
				resultMatrix[i][j]=firstMatrix[i][j] - secondMatrix[i][j];
			}
		}
		
		System.out.println("Subtraction of given matrices is ");
		
		for (int i = 0; i < noOfRows; ++i) {
			for (int j = 0; j < noOfColumns; ++j) {
				System.out.print(resultMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	
	}

	private static void additionOfMatrices(int[][] firstMatrix,int[][] secondMatrix) {
		int noOfRows=firstMatrix.length;
		int noOfColumns=firstMatrix[0].length;
		
		int[][] resultMatrix=new int[noOfRows][noOfColumns];
		
		for (int i = 0; i < noOfRows; ++i) {
			for (int j = 0; j < noOfColumns; ++j) {
				resultMatrix[i][j]=firstMatrix[i][j] + secondMatrix[i][j];
			}
		}
		
		System.out.println("Addition of given matrices is ");
		
		for (int i = 0; i < noOfRows; ++i) {
			for (int j = 0; j < noOfColumns; ++j) {
				System.out.print(resultMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
