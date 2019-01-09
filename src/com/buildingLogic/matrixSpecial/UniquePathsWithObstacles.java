package com.buildingLogic.matrixSpecial;

public class UniquePathsWithObstacles {

	public static void main(String[] args) {
		
		int[][] grid = {
		                {0,0,0},
		                {0,1,0}
		};
		int count = uniquePathsWithObstacles(grid);
		System.out.println(count);
	}

	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;

	    int n = obstacleGrid[0].length;

	    int[][] count = new int[m][n];

	    count[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;


	    for (int i = 1; i < m; i++) {
	        count[i][0] = (obstacleGrid[i][0] == 0) ? count[i-1][0] : 0;
	    }

	    for (int i = 1; i < n; i++) {
	        count[0][i] = (obstacleGrid[0][i] == 0) ? count[0][i-1] : 0;

	    }

	    for (int i = 1; i < m; ++i) {
	        for (int j = 1; j < n; ++j) {
	            count[i][j] = (obstacleGrid[i][j] == 0) ? count[i-1][j] + count[i][j-1] : 0;
	        }
	    }

	    return count[m-1][n-1];
	}
	
	

}
