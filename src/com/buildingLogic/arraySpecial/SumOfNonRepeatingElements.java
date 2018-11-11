package com.buildingLogic.arraySpecial;

import java.util.Arrays;

/**
 * Find sum of non-repeating (distinct) elements in an array:
 * ========================================================== Given an integer
 * array with repeated elements, the task is to find sum of all distinct
 * elements in array.
 * 
 * Examples:
 * 
 * Input : arr[] = {12, 10, 9, 45, 2, 10, 10, 45,10}; Output : 78 Here we take
 * 12, 10, 9, 45, 2 for sum because it's distinct elements
 * 
 * Input : arr[] = {1, 10, 9, 4, 2, 10, 10, 45 , 4}; Output : 71
 * 
 * A Simple Solution is to use two nested loops. The outer loop picks an element
 * one by one starting from the leftmost element. The inner loop checks if the
 * element is present on left side of it. If present, then ignores the element.
 * 
 * Time Complexity : O(n2) Auxiliary Space : O(1)
 * 
 * A Better Solution of this problem is that using sorting technique we firstly
 * sort all elements of array in ascending order and and find one by one
 * distinct elements in array.
 * 
 * @author Ranger Raju :P
 *
 */
public class SumOfNonRepeatingElements {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 1, 4, 5, 6, 6 };

		findDistinctElementsSum(arr);

	}

	private static void findDistinctElementsSum(int[] arr) {
		Arrays.sort(arr);

		int arrLen = arr.length;
		int sum = arr[0];
		int i;
		for (i = 1; i < arrLen; ++i) {
			if (arr[i - 1] != arr[i]) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}

}
