package com.buildingLogic.sortingSpecial;
/**
 *  Selection Sort:
 *  ---------------
	The selection sort algorithm sorts an array by repeatedly finding the minimum element 
	(considering ascending order) from unsorted part and putting it at the beginning. 
	The algorithm maintains two subarrays in a given array.
	1) The subarray which is already sorted.
	2) Remaining subarray which is unsorted.
	In every iteration of selection sort, the minimum element (considering ascending 
	order) from the unsorted subarray is picked and moved to the sorted subarray.
	
	Following example explains the above steps:
	
	arr[] = 64 25 12 22 11
	
	// Find the minimum element in arr[0...4]
	// and place it at beginning
	11 25 12 22 64
	
	// Find the minimum element in arr[1...4]
	// and place it at beginning of arr[1...4]
	11 12 25 22 64
	
	// Find the minimum element in arr[2...4]
	// and place it at beginning of arr[2...4]
	11 12 22 25 64
	
	// Find the minimum element in arr[3...4]
	// and place it at beginning of arr[3...4]
	11 12 22 25 64 
	
	Time Complexity: O(n2) as there are two nested loops.
    
    Auxiliary Space: O(1)
    
    Online: No
    
    Stable: No
    
    Inplace: Yes
    
    The good thing about selection sort is it never makes more than O(n) swaps and can 
    be useful when memory write is a costly operation.
 * 
 * @author Raju Rockzz :P
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] inputArray={3,2,5,9,7};
		
		selectionSort(inputArray);

	}

	private static void selectionSort(int[] inputArray) {
		int inputArrayLength=inputArray.length;
		for (int i = 0; i < inputArrayLength-1; i++) {
			int minIndex=i;
			for (int j = i+1; j < inputArrayLength; j++) {
				if(inputArray[minIndex] > inputArray[j]){
					minIndex=j;
				}
			}
			int temp=inputArray[i];
			inputArray[i]=inputArray[minIndex];
			inputArray[minIndex]=temp;
		}
		
		for (int i = 0; i < inputArrayLength; ++i) {
			System.out.print(inputArray[i] +"\t");
		}
	}

}
