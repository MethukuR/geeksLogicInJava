package com.buildingLogic.matrixSpecial;
/**
 *  Problem :

	Write a java program or function to find saddle point of a matrix. Your program should 
	take input matrix from the user, display the matrix and find the saddle point of that 
	matrix.
	
	
	 
	What Is Saddle Point Of A Matrix?
	
	Saddle point of a matrix is an element in the matrix which is smallest in its row and 
	largest in its column. A matrix can have many or no saddle points. For example,
	
	6    3    1
	9    7    8
	2    4    5
	
	In this matrix, 7 is the saddle point. Because it is the smallest in its row (2nd row) 
	and largest in its column (2nd column).
	
	How To Find Saddle Point Of A Matrix In Java?
	
	Step 1 : For each row of the matrix, find the smallest element in a row and store it 
	in rowMin and also store its column index in colIndex.
	
	for (int i = 0; i < matrix.length; i++) 
	{
	        int rowMin = matrix[i][0];
	        int colIndex = 0;
	
	        for (int j = 1; j < matrix[i].length; j++)
	        {
	                if(matrix[i][j] < rowMin)
	                {
	                        rowMin = matrix[i][j];
	                        colIndex = j;
	                }
	        }
	}
	
	Step 2 : Check whether rowMin is also the largest element in its column i.e colIndex.
	
	for (int j = 0; j < matrix.length; j++)
	{
	        if(matrix[j][colIndex] > rowMin)
	        {
	                saddlePoint = false;
	                break;
	        }
	}
	
	Step 3 : If rowMin is also the largest element in its column, then declare that 
	element as saddle point.
	
	Step 4 : Repeat above steps for all the rows of a matrix.
 * 
 * @author Raju Rockzz :P B-)
 *
 */
public class SaddlePointInMatrix {

	public static void main(String[] args) {
		int[][] inputMatrix={{6,3,1},{9,7,8},{2,4,5}};
		findSaddlePoint(inputMatrix);
	}

	private static void findSaddlePoint(int[][] inputMatrix) {
		int rows=inputMatrix.length;
		int columns=inputMatrix[0].length;
		
		for (int i = 0; i < rows; ++i) {
			int rowMin=inputMatrix[i][0];
			int minColumnIndex=0;
			
			for (int j = 1; j < columns; j++) {
				if(inputMatrix[i][j] < rowMin){
					rowMin=inputMatrix[i][j];
					minColumnIndex=j;
				}
			}
			//System.out.println("rowMin : "+rowMin);
			boolean isSaddlePoint=checkSaddlePoint(rowMin,minColumnIndex,columns,inputMatrix);
			
			if(isSaddlePoint){
				System.out.println(rowMin);
			}
			
		}
	}

	private static boolean checkSaddlePoint(int rowMin,int minColumnIndex,int columns, int[][] inputMatrix) {
		for (int i = 0; i < columns; i++) {
			if(inputMatrix[i][minColumnIndex] > rowMin){
				return false;
			}
		}
		return true;
	}

}
