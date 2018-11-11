package com.buildingLogic.arraySpecial;
/**
 *  Title: The left Rotation:
 *  ========================
	Problem: A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left. For example, if 2 left rotations are performed on array [1,2,3,4,5] , then the array would become[3,4,5,1,2] .
	Given an array of n integers and a number, d, perform d left rotations on the array. Then print the updated array as a single line of space-separated integers.
	Input: First line contains n and d separated by space.
	Next line containes n space separated integers, the elements of array.
	Output: Print a single line of n space-separated integers denoting the final state of the array after performing d left rotations.
	
	Constraints: 
	1≤n≤100000
	1≤d≤n
	1 ≤ Element of array ≤ 1000000
	
	Sample Input: 5 4
	1 2 3 4 5
	Sample Output: 
	5 1 2 3 4
	
 * @author Ranger Raju :P
 *
 */
public class ArrayRotation {

	public static void main(String[] args) {
		
		int[] inpArr={1, 2, 3, 4, 5};
		int noOfRotations=3;
		
		leftRotate(inpArr,noOfRotations);

	}

	private static void leftRotate(int[] inpArr, int noOfRotations) {
		for (int i = 0; i < noOfRotations; ++i) {
			leftRotateByOne(inpArr);
		}
		int len=inpArr.length;
		for (int i = 0; i < len; ++i) {
			System.out.print(inpArr[i]);
		}
	}

	private static void leftRotateByOne(int[] inpArr) {
		int len=inpArr.length;
		int temp=inpArr[0];
		int i=0;
		for (i = 0; i < len-1; ++i) {
			inpArr[i]=inpArr[i+1];
		}
		inpArr[i]=temp;
		
	}

}
