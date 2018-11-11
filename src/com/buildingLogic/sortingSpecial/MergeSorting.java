package com.buildingLogic.sortingSpecial;

import java.util.Arrays;

public class MergeSorting {

	public static void main(String[] args) {
		int arr[] = {6, 10, 5, 4, 9, 120};
		mergeSort(arr,0,arr.length-1);
		System.out.println("Sorted Array::"+Arrays.toString(arr));
	}
	
	static  void mergeSort(int[] arr,int low,int high){
		if(low<high){
			int mid=low+(high-low)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
			
		}
		
	}
	
	
	static void merge(int[] arr, int low, int mid, int high){
		
		int leftArrIndex=0;
		int rightArrIndex=0;
		int resultIndex=0;
		int leftArrLengh= mid-low+1;
		int rightArrLength=high-mid;
		int[] leftArr=new int[leftArrLengh];
		int[] rightArr = new int[rightArrLength];
		
		System.arraycopy(arr, 0, leftArr, 0, leftArrLengh);
		System.arraycopy(arr,leftArrLengh, rightArr, 0, rightArrLength);
		
		while(leftArrIndex < leftArr.length && rightArrIndex < rightArr.length){
			if(leftArr[leftArrIndex] <rightArr[rightArrIndex]){
				arr[resultIndex]=leftArr[leftArrIndex];
				++leftArrIndex;
			}
			else{
				arr[resultIndex]=rightArr[rightArrIndex];
				++rightArrIndex;
			}
			++resultIndex;
		}
			System.arraycopy(leftArr, leftArrIndex, arr, resultIndex, leftArr.length-leftArrIndex);
			System.arraycopy(rightArr, rightArrIndex, arr, resultIndex, rightArr.length-rightArrIndex);
	}

}