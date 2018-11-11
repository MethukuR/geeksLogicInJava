package com.improvingLogic.matrixSpecial;

public class TransposeOfMatrix {

	public static void main(String[] args) {
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		int rows=matrix.length;
		int cols=matrix[0].length;
		printMatrix(matrix,rows,cols);
		findTranspose(matrix,rows,cols);
	}

	private static void printMatrix(int[][] matrix, int rows, int cols) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] findTranspose(int[][] matrix, int rows, int cols) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if(i < j){
					int temp=matrix[i][j];
					matrix[i][j]=matrix[j][i];
					matrix[j][i]=temp;
				}
			}
		}
		System.out.println();
		printMatrix(matrix, rows, cols);
		return matrix;
	}

}
