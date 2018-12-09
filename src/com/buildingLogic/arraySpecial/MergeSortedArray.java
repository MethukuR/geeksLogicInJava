package com.buildingLogic.arraySpecial;

public class MergeSortedArray {
	
	/*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
    	
    	for(int element : B) {
    		int position = getInsertPosition(A, m, element);
    		if(position == m) {
    			A[m] = element;
    			++m;
    			continue;
    		}
    		
    		for(int i = m-1 ; i >= position; --i) {
    			A[i+1] = A[i];
    		}
    		A[position] = element;
    		++m;
    	}
    	
    	for(int element : A) {
    		System.out.print(element + "->");
    	}
    }
    
    public static int getInsertPosition(int[] arr, int arrLength, int target) {
    	if(arrLength == 0 || target < arr[0]){
            return 0;
        }

        if(target > arr[arrLength-1]){
            return arrLength;
        }

        int low = 0;
        int high = arrLength -1;
        int mid;
        int position = -1;
        while(low <= high){
            mid = (high - low )/2  + low;
            if(arr[mid] == target){
                position = mid;
                break;
            }else if(arr[mid] > target){
                high = mid-1;
                position = mid;
            }else{
                low = mid+1;
                position = mid+1;
            }
        }

        return position;
    }

	public static void main(String[] args) {
		int[] A = new int[9];
		A[0] = 9;
		A[1] = 10;
		A[2] = 11;
		A[3] = 12;
		A[4] = 13;
		
		int[] B = new int[] {4,5,6,7};
		mergeSortedArray(A,5,B,4);

	}

}
