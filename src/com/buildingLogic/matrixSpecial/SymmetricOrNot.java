package com.buildingLogic.matrixSpecial;
/**
 * What Is Symmetric Matrix?

   Symmetric matrix is a square matrix which is equal to its transpose. In the other 
   words, if A[][] is a square matrix with (M x M) order, then this matrix is said to be 
   symmetric if every element at ith row and jth column is equal to element at jth row 
   and ith column i.e A[i][j] == A[j][i].

	Problem :

	Write a java program to check whether the given matrix is symmetric or not. Your 
	program must take input matrix from the user, display it and check whether the matrix 
	is symmetric or not.

	How To Check Whether The Matrix Is Symmetric Or Not?

	First check whether the given matrix is a square matrix or not. i.e check 
	(Number Of Rows) = (Number Of Columns). If the matrix is square, then check whether 
	every element at ith row and jth column is equal to element at jth row and ith column. 
	If the given matrix satisfy these two conditions, then that matrix is a symmetric 
	matrix.

 * @author Raju Rockzz :P
 *
 */
public class SymmetricOrNot {

	public static void main(String[] args) {
		int[][] inputMatrix={{7,5,1},{5,8,3},{1,3,5}};

		isGivenMatrixSymmetric(inputMatrix);

	}

	private static void isGivenMatrixSymmetric(int[][] inputMatrix) {
		int noOfRows=inputMatrix.length;
		int noOfColumns=inputMatrix[0].length;

		if(noOfColumns != noOfRows){
			System.out.println("The given matrix is not a square matrix, so it can't be symmetric.");
		}
		else{
			boolean isSymmetric=true;

			for (int i = 0; i < noOfRows; ++i) {
				for (int j = 0; j < noOfColumns; ++j) {
					if(inputMatrix[i][j] != inputMatrix[j][i]){
						isSymmetric=false;
						break;
					}
				}
			}
			if(isSymmetric){
				System.out.println("The given matrix is symmetric...");
			}
			else{
				System.out.println("The given matrix is not symmetric...");
			}
		}

	}
}
