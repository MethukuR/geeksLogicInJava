package com.improvingLogic.matrixSpecial;

public class SaddlePoint {

	public static void main(String[] args) {
		int[][] matrix={{7,5,1},
						{6,8,2},
						{1,3,0}
				};
		
		findSaddlePoint(matrix);
	}

	private static void findSaddlePoint(int[][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		
		for(int i=0; i < rows; ++i){
			int min=matrix[i][0];
			int minColIndex=0;
			for(int j=1; j < cols; ++j){
				if(min>matrix[i][j]){
					min=matrix[i][j];
					minColIndex=j;
				}
			}
			boolean isSaddlePoint=true;
			for(int k=0; k < rows; ++k){
					
				if(k!=i && matrix[k][minColIndex]>min){
					isSaddlePoint=false;
				}
			}
			if(isSaddlePoint){
				System.out.println(min);
				break;
			}
			
			
			
		}
		
	}

}
