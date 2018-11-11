package com.buildingLogic.matrixSpecial;

/**
 * @author laxminarasimha.m
 * Given an n x n matrix, where every row and column is sorted in increasing order. 
 * Given a number x, how to decide whether this x is in the matrix. 
 * The designed algorithm should have linear time complexity.
1) Start with top right element
2) Loop: compare this element e with x
	i) if they are equal then return its position
    ii) e < x then move it to down (if out of bound of matrix then break return false) 
	iii) e > x then move it to left (if out of bound of matrix then break return false)
3) repeat the i), ii) and iii) till you find element or returned false
 *
 */
public class SearchRCWSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] mat = {  {10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50},
                       };
		boolean found=searchMatrix(mat,4,35);
		if(found){
			System.out.println("Number found");
		}
		else{
			System.out.println("Number not found");
		}
	}
	
	static boolean searchMatrix(int mat[][], int size, int number){
		int row=0;
		int column=size-1;
		while(row<size || column>=0){
			System.out.println(mat[row][column]);
			if(mat[row][column] == number){
				return true;
			}
			else if(mat[row][column] > number){
				column--;
			}
			else{
				row++;
			}
		}
		return false;
	}

}
