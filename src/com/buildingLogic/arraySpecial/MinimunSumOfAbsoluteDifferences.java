package com.buildingLogic.arraySpecial;

import java.util.Arrays;

/**
 *  Given two arrays a[] and b[] of equal length n. The task is to pair each element of 
 *  array a to an element in array b, such that sum S of absolute differences of all the 
 *  pairs is minimum.

	Suppose, two elements a[i] and a[j] (i != j) of a are paired with elements b[p] and 
	b[q] of b respectively,then p should not be equal to q.
	
	Examples:
	
	Input :  a[] = {3, 2, 1}
	         b[] = {2, 1, 3}
	Output : 0
	
	Input :  n = 4
	         a[] = {4, 1, 8, 7}
	         b[] = {2, 3, 6, 5}
	Output : 6
	
	The solution to the problem is a simple greedy approach. It consists of two steps.
	Step 1 : Sort both the arrays in O (n log n) time.
	Step 2 : Find absolute difference of each pair of corresponding elements (elements 
	at same index) of both arrays and add the result to the sum S. The time complexity 
	of this step is O(n).

	Hence, the overall time complexity of the program is O(n log n).
 * 
 * @author Ranger Raju :P
 *
 */
public class MinimunSumOfAbsoluteDifferences {

	public static void main(String[] args) {
		int[] inpArrOne={4, 1, 8, 7};
		int[] inpArrTwo={2, 3, 6, 5};
		
		findMinSumOfAbsoluteDiff(inpArrOne,inpArrTwo);
	}

	private static void findMinSumOfAbsoluteDiff(int[] inpArrOne,int[] inpArrTwo) {
		Arrays.sort(inpArrOne);
		Arrays.sort(inpArrTwo);
		
		int sum=0;
		int arrLen=inpArrOne.length;
		
		for (int i = 0; i < arrLen; i++) {
			sum+=Math.abs(inpArrOne[i]-inpArrTwo[i]);
		}
		
		System.out.println("Absolute Sum : "+sum);
		
	}

}
