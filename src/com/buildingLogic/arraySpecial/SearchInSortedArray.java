package com.buildingLogic.arraySpecial;
/**
 * Consider a Java array say X which is sorted and no two elements in it are same. 
 * How best can you find an index say i such that element at that index is also i. That is 
 * X[i] = i.

	As clarification she also gave me an example:
	
	      Array X : -3 -1 0 3 5 7 
	      index   :  0  1 2 3 4 5
	
	      Answer is 3 as X[3] = 3.
	      
	Explanation:
	============
	
	This can be done in O(logN) time and O(1) space by using a slightly modified binary 
	search.

	Consider a new array Y such that Y[i] = X[i] - i
	
	Array X : -3 -1   0  3  5  7
	index   :  0  1   2  3  4  5
	Array Y : -3 -2  -2  0  1  2
	
	Since the elements in X are in increasing order, the elements in the new array Y will 
	be in non-decreasing order. So a binary search for 0 in Y will give the answer.
	
	But creating Y will take O(N) space and O(N) time. So instead of creating the new 
	array you just modify the binary search such that a reference to Y[i] is replaced by 
	X[i] - i.
 * 
 * @author Ranger Raju :P
 *
 */
public class SearchInSortedArray {

	public static void main(String[] args) {
		int[] inpArr={-3, -1, 0, 3, 5, 7};
		int index=-1;
		index=findIndex(inpArr);
		System.out.println(index);
		index=findIndexOptimized(inpArr);
		System.out.println(index);
	}

	private static int findIndex(int[] inpArr) {
		int inpLen=inpArr.length;
		
		for (int i = 0; i < inpLen; ++i) {
			if(inpArr[i] == i){
				return i;
			}
		}
		return -1;
	}
	
	private static int findIndexOptimized(int[] inpArr) {
		int inpLen=inpArr.length;
		
		int first=0;
		int last=inpLen-1;
		
		while(first <= last){
			int mid= first + (last - first)/2;
			
			if(inpArr[mid] - mid == 0){
				return mid;
			}
			else if(inpArr[mid] - mid < 0){
				first= mid+1;
			}
			else if(inpArr[mid] - mid > 0){
				last=mid-1;
			}
		}
		return -1;
	}

}
