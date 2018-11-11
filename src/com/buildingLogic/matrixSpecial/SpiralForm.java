package com.buildingLogic.matrixSpecial;

public class SpiralForm {

	public static void main(String[] args) {
		int[][] inpMatrix={ {1,  2,  3,  4,  5,  6},
					        {7,  8,  9,  10, 11, 12},
					        {13, 14, 15, 16, 17, 18}
		    			};
		
		printInSpiralForm(inpMatrix);
	}

	private static void printInSpiralForm(int[][] inpMatrix) {
		int k=0;
		int l=0;
		int m=inpMatrix.length;//noOfRows
		int n=inpMatrix[0].length;//noOfColumns
		
		while((k < m) && (l < n)){
			
			for (int i = l; i < n; ++i) {
				System.out.print(inpMatrix[k][i] +"\t");
			}
			++k;
			
			for (int i = k; i < m; ++i) {
				System.out.print(inpMatrix[i][n-1]+"\t");
			}
			--n;
			
			if(k < m){
				for (int i = n-1; i >= l; --i) {
					System.out.print(inpMatrix[m-1][i]+"\t");
				}
				--m;
			}
			
			if(l < n){
				for (int i = m-1; i >= k; --i) {
					System.out.print(inpMatrix[i][l]+"\t");
				}
				++l;
			}
		}
	}

}
