package com.buildingLogic.sortingSpecial;
/**
 *  Insertion Sort:
 *  ---------------
	Insertion sort is a simple sorting algorithm that works the way we sort playing cards 
	in our hands.
	
	Algorithm:
	----------
	// Sort an arr[] of size n
	insertionSort(arr, n)
	Loop from i = 1 to n-1.
	……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
	
	Another Example: 
	----------------
	12, 11, 13, 5, 6
	Let us loop for i = 1 (second element of the array) to 5 (Size of input array)
	i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
	11, 12, 13, 5, 6
	i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
	11, 12, 13, 5, 6
	i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
	5, 11, 12, 13, 6
	i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
	5, 6, 11, 12, 13
	
	Time Complexity: O(n*n)
	
	Auxiliary Space: O(1)
	
	Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in 
	reverse order. And it takes minimum time (Order of n) when elements are already sorted.
	
	Algorithmic Paradigm: Incremental Approach
	
	Sorting In Place: Yes
	
	Stable: Yes
	
	Online: Yes
	
	What is Online?
	
	In computer science, an online algorithm is one that can only process its input 
	piece-by-piece in a serial fashion, i.e., in the order that the input is fed to the 
	algorithm, without having the entire input available from the start.

    In contrast, an offline algorithm is given the whole problem data from the beginning 
    and is required to output an answer which solves the problem at hand.

    As an example, consider the sorting algorithms selection sort and insertion sort: 
    Selection sort repeatedly selects the minimum element from the unsorted remainder and 
    places it at the front, which requires access to the entire input; it is thus an 
    offline algorithm. On the other hand, insertion sort considers one input element per 
    iteration and produces a partial solution without considering future elements. Thus 
    insertion sort is an online algorithm.
    
	Uses: Insertion sort is used when number of elements is small. It can also be useful 
	when input array is almost sorted, only few elements are misplaced in complete big 
	array.
	
	What is Binary Insertion Sort?
	
	We can use binary search to reduce the number of comparisons in normal insertion sort. 
	Binary Insertion Sort find use binary search to find the proper location to insert the 
	selected item at each iteration. In normal insertion, sort it takes O(i) 
	(at ith iteration) in worst case. we can reduce it to O(logi) by using binary search. 
	The algorithm as a whole still has a running worst case running time of O(n^2) because 
	of the series of swaps required for each insertion. 
	
	How to implement Insertion Sort for Linked List?
	
	Below is simple insertion sort algorithm for linked list:
	---------------------------------------------------------
	
	1) Create an empty sorted (or result) list
	2) Traverse the given list, do following for every node.
	......a) Insert current node in sorted way in sorted or result list.
	3) Change head of given linked list to head of sorted (or result) list. 
 * 
 * @author Raju Rockzz :P
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
			int[] inputArray={ 12, 4, 5, 1, 2, 3, 8, 7 };
			insertionSort(inputArray);
	}

	private static void insertionSort(int[] inputArray) {
		int inputArrayLength=inputArray.length;
		for (int i = 1; i < inputArrayLength; i++) {
			int value=inputArray[i];
			int hole=i;
			
			while(hole > 0 && (inputArray[hole-1] > value)){
				inputArray[hole]=inputArray[hole-1];
				hole=hole-1;
			}
			inputArray[hole]=value;
			System.out.println("");
			for (int j = 0; j < inputArrayLength; ++j) {
				System.out.print(inputArray[j] +"\t");
			}
		}

		for (int i = 0; i < inputArrayLength; ++i) {
			System.out.print(inputArray[i] +"\t");
		}
	}

}
