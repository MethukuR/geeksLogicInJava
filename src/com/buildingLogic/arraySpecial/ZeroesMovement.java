package com.buildingLogic.arraySpecial;

/**
 * Move all zeroes to end of array :
 * ================================
	Given an array of random numbers, Push all the zero’s of a given array to the end of 
	the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it 
	should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other 
	elements should be same. Expected time complexity is O(n) and extra space is O(1).
	
	Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
	Output : arr[] = {1, 2, 4, 3, 5, 0, 0};
	
	Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
	Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
	
	There can be many ways to solve this problem. Following is a simple and interesting 
	way to solve this problem.
	
	Traverse the given array ‘arr’ from left to right. While traversing, maintain count 
	of non-zero elements in array. Let the count be ‘count’. For every non-zero element 
	arr[i], put the element at ‘arr[count]’ and increment ‘count’. After complete 
	traversal, all non-zero elements have already been shifted to front end and ‘count’ 
	is set as index of first 0. Now all we need to do is that run a loop which makes all 
	elements zero from ‘count’ till end of the array.
 * 
 * @author Ranger Raju :P
 *
 */
public class ZeroesMovement {

	public static void main(String[] args) {
		int inpArr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		pushZerosToRightEnd(inpArr);
		pushZerosToLeftEnd(inpArr);
	}

	private static void pushZerosToLeftEnd(int[] inpArr) {
		
		
		int inpArrLen=inpArr.length;
		int count=inpArr.length-1;
		
		for (int i=inpArrLen-1 ; i >= 0 ; --i) {
			if(inpArr[i] != 0){
				inpArr[count--]=inpArr[i];
			}
		}
		
		while(count >= 0){
			inpArr[count--]=0;
		}
		System.out.println();
		for (int i : inpArr) {
			System.out.print(i + "\t");
		}
	}

	private static void pushZerosToRightEnd(int[] inpArr) {
		int count=0;
		
		int inpArrLen=inpArr.length;
		
		for (int i=0 ; i < inpArrLen ; ++i) {
			if(inpArr[i] != 0){
				inpArr[count++]=inpArr[i];
			}
		}
		
		while(count < inpArrLen){
			inpArr[count++]=0;
		}
		
		for (int i : inpArr) {
			System.out.print(i + "\t");
		}
	}

}
