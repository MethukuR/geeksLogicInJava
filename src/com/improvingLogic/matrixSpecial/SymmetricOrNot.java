package com.improvingLogic.matrixSpecial;

import java.util.Arrays;

public class SymmetricOrNot {

	public static void main(String[] args) {
		int[][] matrix={{7,5,1},{6,8,2},{1,3,5}};
		isGivenMatrixSymmetricOne(matrix);
		isGivenMatrixSymmetricTwo(matrix);
	}

	private static void isGivenMatrixSymmetricTwo(int[][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		boolean isSymmetric=true;
		for(int i=0; i< rows; ++i){
			for(int j=0; j< cols; ++j){
				if(matrix[i][j]!=matrix[j][i]){
					isSymmetric=false;
					break;
				}
			}
		}
		if(isSymmetric){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}

	private static void isGivenMatrixSymmetricOne(int[][] matrix) {
		
		
		int rows=matrix.length;
		int cols=matrix[0].length;
		int[][]tempMatrix=new int[rows][cols];
		for(int i=0; i< rows; ++i){
			for(int j=0; j< cols; ++j){
				tempMatrix[i][j]=matrix[i][j];
					
			}
		}
		int[][] transpose=TransposeOfMatrix.findTranspose(tempMatrix, rows, cols);
		
		if(Arrays.deepEquals(matrix, transpose)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
