package com.buildingLogic.arraySpecial;
/**
 *  Rearrange an array in maximum minimum form :
 *  ------------------------------------------
	Given a sorted array of positive integers, rearrange the array alternately i.e first element
	should be maximum value, second minimum value, third second max, fourth second min and so 
	on.
	
	Examples:
	--------
	Input  : arr[] = {1, 2, 3, 4, 5, 6, 7} 
	Output : arr[] = {7, 1, 6, 2, 5, 3, 4}
	
	Input  : arr[] = {1, 2, 3, 4, 5, 6} 
	Output : arr[] = {6, 1, 5, 2, 4, 3}
	
	Expected time complexity is O(n).
	
	This problems becomes very easy if extra space is allowed. We can copy the array to another array 
	and then place elements at alternate positions.

	How to do in-place? 
	-------------------
	The idea is to use the fact that numbers are positive. One by one place numbers 
	at their correct positions and mark them negative.
	
	How to find correct or output position for an element arr[i]? we can observe that the output follows 
	below pattern for an input array.

	// Output index j for an element arr[i]
	If (i < n/2) 
	   j = 2*i + 1 
	Else
	   j = 2*(n-1-i); 
	
	@author Raju Rockzz :P
 */
public class MaxMinArray {

	public static void main(String[] args) {
		int inputArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		printMinMaxArray(inputArr);
	}
	
	static void printMinMaxArray(int[] arr){
		int arrLength=arr.length;
		
		for (int i = 0; i < arrLength; ++i) {
			
			int temp=arr[i];
			
			// If number is negative then we have already
	        // processed it. Else process all numbers which
	        // are to be replaced by each other in cyclic way
			while(temp > 0){
				
				int j = (i < arrLength/2) ? (2*i + 1 ) : (2*(arrLength-1-i));
				
				// If arr[i] is already at its correct
	            // position, mark it as negative
				if(i == j){
					arr[i]=-temp;
					break;
				}
				
				// Swap the number 'temp' with the current number
	            // at its target position
				int tempVar = arr[j];
				arr[j]=temp;
				temp=tempVar;
				
				// Mark the number as processed
	            arr[j] = -arr[j];
	 
	            // Next process the previous number at target position
	            i = j;
				
			}
		}
		
		for (int i=0; i < arrLength; ++i)
	        arr[i] = -arr[i];
		
		for (int i = 0; i < arrLength; ++i) {
			System.out.print(arr[i]+ "\t");
		}
}

}
