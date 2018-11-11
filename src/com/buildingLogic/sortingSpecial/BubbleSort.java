package com.buildingLogic.sortingSpecial;
/**
 *  Bubble Sort:
 *  -----------
	Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the 
	adjacent elements if they are in wrong order.
	Example:
	
	First Pass:
	( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and 
	swaps since 5 > 1.
	( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
	( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
	( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order 
	(8 > 5), algorithm does not swap them.
	
	Second Pass:
	( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
	( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
	Now, the array is already sorted, but our algorithm does not know if it is completed. 
	The algorithm needs one whole pass without any swap to know it is sorted.
	
	Third Pass:
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	
	Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is 
	reverse sorted.
	
	Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
	
	Auxiliary Space: O(1)
	
	Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already 
	sorted.
	
	
	Sorting In Place: Yes
	
	Stable: Yes
	
	Online: No
	
	Due to its simplicity, bubble sort is often used to introduce the concept of a sorting 
	algorithm.In computer graphics it is popular for its capability to detect a very 
	small error (like swap of just two elements) in almost-sorted arrays and fix it with 
	just linear complexity (2n). For example, it is used in a polygon filling algorithm, 
	where bounding lines are sorted by their x coordinate at a specific scan line 
	(a line parallel to x axis) and with incrementing y their order changes 
	(two elements are swapped) only at intersections of two lines 
 * 
 * @author Raju Rockzz :P
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] inputArray={3,2,5,9,7};
		bubbleSort(inputArray);
	}

	private static void bubbleSort(int[] inputArray) {
		int inputArrayLength=inputArray.length;
		for (int i = 0; i < inputArrayLength; ++i) {
			boolean isAlreadySorted=true;
			for (int j = 0; j < inputArrayLength-i-1; ++j) {
				if(inputArray[j] > inputArray[j+1]){
					int temp=inputArray[j];
					inputArray[j]=inputArray[j+1];
					inputArray[j+1]=temp;
					isAlreadySorted=false;
				}
			}
			
			if(isAlreadySorted){
				break;
			}
		}
		
		for (int i = 0; i < inputArrayLength; ++i) {
			System.out.print(inputArray[i] +"\t");
		}
	}

}
