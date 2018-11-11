package com.improvingLogic.matrixSpecial;
/**
 * 
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
 * @author Raju Rockzz :P
 */
public class SearchInSortedMatrix {

	public static void main(String[] args) {

	}

}
