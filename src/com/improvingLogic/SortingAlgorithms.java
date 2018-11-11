package com.improvingLogic;

import java.util.Arrays;

/**
 *  1.Insertion Sort:
 *  
	Insertion sort is a simple sorting algorithm that works the way we sort playing cards 
	in our hands.
	
	Algorithm:
	// Sort an arr[] of size n
	insertionSort(arr, n)
	Loop from i = 1 to n-1.
	……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
	
	Example:
	
	12, 11, 13, 5, 6
	Let us loop for i = 1 (second element of the array) to 5 (Size of input array)
	i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
	11, 12, 13, 5, 6
	i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
	11, 12, 13, 5, 6
	i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one 
	position ahead of their current position.
	5, 11, 12, 13, 6
	i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one 
	position ahead of their current position.
	5, 6, 11, 12, 13
	
	Time Complexity: O(n*n)
	Auxiliary Space: O(1)
	Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in 
	reverse order. And it takes minimum time (Order of n) when elements are already 
	sorted.
	Algorithmic Paradigm: Incremental Approach
	Sorting In Place: Yes
	Stable: Yes
	Online: Yes
	Uses: Insertion sort is used when number of elements is small. It can also be useful 
	when input array is almost sorted, only few elements are misplaced in complete big 
	array.
	
	What is Binary Insertion Sort?
	We can use binary search to reduce the number of comparisons in normal insertion sort.
	Binary Insertion Sort find use binary search to find the proper location to insert 
	the selected item at each iteration. In normal insertion, sort it takes O(i) 
	(at ith iteration) in worst case. we can reduce it to O(logi) by using binary search. 
	The algorithm as a whole still has a running worst case running time of O(n2) because 
	of the series of swaps required for each insertion.
	
	2.Selection Sort:
	
	The selection sort algorithm sorts an array by repeatedly finding the minimum element
	(considering ascending order) from unsorted part and putting it at the beginning. The 
	algorithm maintains two subarrays in a given array.
	1) The subarray which is already sorted.
	2) Remaining subarray which is unsorted.
	In every iteration of selection sort, the minimum element (considering ascending order) 
	from the unsorted subarray is picked and moved to the sorted subarray.
	
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
	
	Time Complexity: O(n2) as there are two nested loops.
	Auxiliary Space: O(1)
	The good thing about selection sort is it never makes more than O(n) swaps and can be 
	useful when memory write is a costly operation.
	  
	3.Bubble Sort : 
	
	Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the 
	adjacent elements if they are in wrong order.
	
	Example:
	
	First Pass:
	
	( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and 
	swaps since 5 > 1.
	( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
	( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
	( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), 
	algorithm does not swap them.
	
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
	Sorting In Place(i.e, constant or no extra space): Yes
	Stable: Yes
	
	Due to its simplicity, bubble sort is often used to introduce the concept of a sorting 
	algorithm.
	In computer graphics it is popular for its capability to detect a very small error 
	(like swap of just two elements) in almost-sorted arrays and fix it with just linear 
	complexity (2n). For example, it is used in a polygon filling algorithm, where 
	bounding lines are sorted by their x coordinate at a specific scan line (a line 
	parallel to x axis) and with incrementing y their order changes (two elements are 
	swapped) only at intersections of two lines 
		
	Merge Sort:
	
	MergeSort is a Divide and Conquer algorithm. It divides input array in two halves, 
	calls itself for the two halves and then merges the two sorted halves. The merge() 
	function is used for merging two halves. The merge(arr, l, m, r) is key process that 
	assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays 
	into one.
	
	MergeSort(arr[], l,  r)
	If r > l
	     1. Find the middle point to divide the array into two halves:  
	             middle m = (l+r)/2
	     2. Call mergeSort for first half:   
	             Call mergeSort(arr, l, m)
	     3. Call mergeSort for second half:
	             Call mergeSort(arr, m+1, r)
	     4. Merge the two halves sorted in step 2 and 3:
	             Call merge(arr, l, m, r)
	             
	Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive 
	algorithm and time complexity can be expressed as following recurrence relation.
	T(n) = 2T(n/2) + \Theta(n)
	The above recurrence can be solved either using Recurrence Tree method or Master 
	method. It falls in case II of Master Method and solution of the recurrence is \Theta(nLogn).
	Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and 
	best) as merge sort always divides the array in two halves and take linear time to 
	merge two halves.
	
	Auxiliary Space: O(n)
	Algorithmic Paradigm: Divide and Conquer
	Sorting In Place(i.e, constant or no extra space): No in a typical implementation
	Stable: Yes
	
	Applications of Merge Sort:
	
	1.Merge Sort is useful for sorting linked lists in O(nLogn) time.In case of linked 
	lists the case is different mainly due to difference in memory allocation of arrays 
	and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. 
	Unlike array, in linked list, we can insert items in the middle in O(1) extra space 
	and O(1) time. Therefore merge operation of merge sort can be implemented without 
	extra space for linked lists.
	In arrays, we can do random access as elements are continuous in memory. Let us say 
	we have an integer (4-byte) array A and let the address of A[0] be x then to access 
	A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do 
	random access in linked list. Quick Sort requires a lot of this kind of access. In 
	linked list to access i’th index, we have to travel each and every node from the head 
	to i’th node as we don’t have continuous block of memory. Therefore, the overhead 
	increases for quick sort. Merge sort accesses data sequentially and the need of 
	random access is low.
	2.Inversion Count Problem
	3.Used in External Sorting
	
	QuickSort:
	
	Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as 
	pivot and partitions the given array around the picked pivot. There are many different 
	versions of quickSort that pick pivot in different ways.
	
	1.Always pick first element as pivot.
	2.Always pick last element as pivot (implemented below)
	3.Pick a random element as pivot.
	4.Pick median as pivot.
	
	The key process in quickSort is partition(). Target of partitions is, given an array 
	and an element x of array as pivot, put x at its correct position in sorted array and 
	put all smaller elements (smaller than x) before x, and put all greater elements 
	(greater than x) after x. All this should be done in linear time.
	
	Illustration of partition() :
	
	arr[] = {10, 80, 30, 90, 40, 50, 70}
	Indexes:  0   1   2   3   4   5   6 
	
	low = 0, high =  6, pivot = arr[h] = 70
	Initialize index of smaller element, i = -1
	
	Traverse elements from j = low to high-1
	j = 0 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
	i = 0 
	arr[] = {10, 80, 30, 90, 40, 50, 70} // No change as i and j 
	                                     // are same
	
	j = 1 : Since arr[j] > pivot, do nothing
	// No change in i and arr[]
	
	j = 2 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
	i = 1
	arr[] = {10, 30, 80, 90, 40, 50, 70} // We swap 80 and 30 
	
	j = 3 : Since arr[j] > pivot, do nothing
	// No change in i and arr[]
	
	j = 4 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
	i = 2
	arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 and 40 Swapped
	j = 5 : Since arr[j] <= pivot, do i++ and swap arr[i] with arr[j] 
	i = 3 
	arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped 
	
	We come out of loop because j is now equal to high-1.
	Finally we place pivot at correct position by swapping
	arr[i+1] and arr[high] (or pivot) 
	arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped 
	
	Now 70 is at its correct place. All elements smaller than
	70 are before it and all elements greater than 70 are after
	it.
	
	Analysis of QuickSort:
	
	Time taken by QuickSort in general can be written as following.
	T(n) = T(k) + T(n-k-1) + \theta(n)
	The first two terms are for two recursive calls, the last term is for the partition 
	process. k is the number of elements which are smaller than pivot.
	The time taken by QuickSort depends upon the input array and partition strategy. 
	Following are three cases.
	Worst Case: The worst case occurs when the partition process always picks greatest or 
	smallest element as pivot. If we consider above partition strategy where last element 
	is always picked as pivot, the worst case would occur when the array is already sorted 
	in increasing or decreasing order. Following is recurrence for worst case.
	 T(n) = T(0) + T(n-1) + \theta(n)
	which is equivalent to  
	 T(n) = T(n-1) + \theta(n)
	The solution of above recurrence is \theta(n2).
	Best Case: The best case occurs when the partition process always picks the middle 
	element as pivot. Following is recurrence for best case.
	 T(n) = 2T(n/2) + \theta(n)
	The solution of above recurrence is \theta(nLogn). It can be solved using case 2 of 
	Master Theorem.
	
	Average Case:
	
	To do average case analysis, we need to consider all possible permutation of array and 
	calculate time taken by every permutation which doesn’t look easy.
	We can get an idea of average case by considering the case when partition puts O(n/9) 
	elements in one set and O(9n/10) elements in other set. Following is recurrence for 
	this case.
	 T(n) = T(n/9) + T(9n/10) + \theta(n)
	Solution of above recurrence is also O(nLogn)
	Although the worst case time complexity of QuickSort is O(n2) which is more than many 
	other sorting algorithms like Merge Sort and Heap Sort, QuickSort is faster in practice, because its inner loop can be efficiently implemented on most architectures, and in most real-world data. QuickSort can be implemented in different ways by changing the choice of pivot, so that the worst case rarely occurs for a given type of data. However, merge sort is generally considered better when data is huge and stored in external storage.
	
	What is 3-Way QuickSort?
	
	In simple QuickSort algorithm, we select an element as pivot, partition the array 
	around pivot and recur for subarrays on left and right of pivot.
	Consider an array which has many redundant elements. For example, {1, 4, 2, 4, 2, 4, 1,
	2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4}. If 4 is picked as pivot in Simple QuickSort, we 
	fix only one 4 and recursively process remaining occurrences. In 3 Way QuickSort, an 
	array arr[l..r] is divided in 3 parts:
	a) arr[l..i] elements less than pivot.
	b) arr[i+1..j-1] elements equal to pivot.
	c) arr[j..r] elements greater than pivot.
	See this for implementation.
	
	How to implement QuickSort for Linked Lists?
	
	QuickSort on Singly Linked List
	QuickSort on Doubly Linked List
	
	Can we implement QuickSort Iteratively?
	
	Yes.
	
	Why Quick Sort is preferred over MergeSort for sorting Arrays?
	
	Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra 
	storage) whereas merge sort requires O(N) extra storage, N denoting the array size 
	which may be quite expensive. Allocating and de-allocating the extra space used for 
	merge sort increases the running time of the algorithm. Comparing average complexity 
	we find that both type of sorts have O(NlogN) average complexity but the constants 
	differ. For arrays, merge sort loses due to the use of extra O(N) storage space.
	Most practical implementations of Quick Sort use randomized version. The randomized 
	version has expected time complexity of O(nLogn). The worst case is possible in 
	randomized version also, but worst case doesn’t occur for a particular pattern 
	(like sorted array) and randomized Quick Sort works well in practice.
	Quick Sort is also a cache friendly sorting algorithm as it has good locality of 
	reference when used for arrays.
	Quick Sort is also tail recursive, therefore tail call optimizations is done.
	
	Why MergeSort is preferred over QuickSort for Linked Lists?
	
	In case of linked lists the case is different mainly due to difference in memory 
	allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be 
	adjacent in memory. Unlike array, in linked list, we can insert items in the middle 
	in O(1) extra space and O(1) time. Therefore merge operation of merge sort can be 
	implemented without extra space for linked lists.
	In arrays, we can do random access as elements are continuous in memory. Let us say 
	we have an integer (4-byte) array A and let the address of A[0] be x then to access 
	A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do 
	random access in linked list. Quick Sort requires a lot of this kind of access. In 
	linked list to access i’th index, we have to travel each and every node from the 
	head to i’th node as we don’t have continuous block of memory. Therefore, the 
	overhead increases for quick sort. Merge sort accesses data sequentially and the 
	need of random access is low.

	
 * @author Raju Rockzz :P
 *
 */
public class SortingAlgorithms {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6};
		int arrLength=arr.length;
		System.out.println("Array before sorting : "+ Arrays.toString(arr));
		//insertionSort(arr,arrLength);
		//selectionSort(arr,arrLength);
		//bubbleSort(arr,arrLength);
		binaryInsertionSort(arr, arrLength);
		//mergeSort(arr, 0, arrLength-1);
		//System.out.println("Array after merge sort : "+Arrays.toString(arr));


	}
	
	static void insertionSort(int[] arr,int arrLength){
		
		for (int i = 1; i < arrLength; ++i) {
			int value=arr[i];
			int position =i;
			
			while(position > 0 && arr[position-1] > value){
				arr[position]=arr[position-1];
				position=position-1;
			}
			
			arr[position]=value;
			
		}
		
		System.out.println("Array after Insertion Sort : "+Arrays.toString(arr));
	}
	
	static void binaryInsertionSort(int[] arr,int arrLength){
		for (int i = 1; i < arrLength; ++i) {
			int position=i-1;
			int value=arr[i];
			int loc=binarySearch(arr, value, 0, position);
			while(position >= loc){
				 arr[position+1] = arr[position];
		         --position;
			}
			arr[position+1] = value;
		}
		System.out.println("Array after Binary Insertion Sort : "+Arrays.toString(arr));

	}
	
	static int binarySearch(int[] arr,int item,int low,int high){
		 if (high <= low){
		        return (item > arr[low])?  (low + 1): low;
		 }
		 
		 int mid = low + (high-low)/2;
		 
		 if(item == arr[mid]){
		        return mid+1;
		 }
		 
		  if(item > arr[mid]){
		        return binarySearch(arr, item, mid+1, high);
		  }
		  else{
			   return binarySearch(arr, item, low, mid-1);
		  }
		
	}
	
	static void selectionSort(int[] arr, int arrLength){
		
		for (int i = 0; i < arrLength-1; ++i) {
			int tempIndex=i;
			boolean status=false;
			for (int j = i+1; j < arrLength; j++) {
				if(arr[tempIndex] > arr[j]){
					tempIndex = j; 
					status=true;
				}
			}
			if(status){
				int temp=arr[i];
				arr[i]=arr[tempIndex];
				arr[tempIndex]=temp;
			}
		}
		System.out.println("Array after Selection Sort : "+Arrays.toString(arr));
	}
	
	static void bubbleSort(int[] arr , int arrLength){
		
		for (int i = 0; i < arrLength; ++i) {
			boolean status=false;
			for (int j = 0; j < arrLength-i-1; ++j) {
				if(arr[j] > arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					status=true;
				}
			}
			if(!status){
				break;
			}
		}
		
		System.out.println("Array after Bubble Sort : "+Arrays.toString(arr));

	}
	
	static void mergeSort(int[] arr,int startIndex,int endIndex){
		if(startIndex < endIndex){
			int midIndex=startIndex+(endIndex-startIndex)/2;
			mergeSort(arr,startIndex,midIndex);
			mergeSort(arr, midIndex+1, endIndex);
			merge(arr,startIndex,midIndex,endIndex);
		}
	}	
	
	static void merge(int[] arr,int startIndex,int midIndex, int endIndex){
		int leftArrLength=midIndex-startIndex+1;
		int rightArrLength=endIndex-midIndex;
		
		int[] leftArr= new int[leftArrLength];
		int[] rightArr= new int[rightArrLength];
		
		System.arraycopy(arr, 0, leftArr, 0,leftArrLength);
		System.arraycopy(arr, leftArrLength, rightArr, 0, rightArrLength);
		
		int leftIndex=0,rightIndex=0,arrIndex=0;
		
		while(leftIndex < leftArrLength && rightIndex < rightArrLength){
			if(leftArr[leftIndex] < rightArr[rightIndex]){
				arr[arrIndex]=leftArr[leftIndex];
				++leftIndex;
			}
			else{
				arr[arrIndex]=rightArr[rightIndex];
				++rightIndex;
			}
			++arrIndex;
		}
		
		if(leftIndex < leftArrLength){
			System.arraycopy(leftArr, leftIndex, arr, arrIndex, leftArrLength-leftIndex);
		}
		else if(rightIndex < rightArrLength){
			System.arraycopy(rightArr, rightIndex, arr, arrIndex, rightArrLength-rightIndex);
		}
	}
	
	

}
