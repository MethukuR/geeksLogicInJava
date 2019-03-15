package com.buildingLogic.ms.arrays;

public class SearchInRotatedSortedArray {

  public static void main(String[] args) {
    int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
    System.out.println(pivotedBinarySearch(arr, 11));
  }

  private static int pivotedBinarySearch(int[] arr, int key) {
    int pivot = findPivot(arr, 0, arr.length-1);
    System.out.println(pivot);
    if(pivot == -1) {
      return binarySearch(arr,key, 0, arr.length-1);
    }
    
    if(arr[pivot] == key) {
      return pivot;
    }
    if(arr[0] > key) {
      return binarySearch(arr, key, pivot+1, arr.length-1);
    }else {
      return binarySearch(arr, key, 0, pivot-1);
    }
  }

  private static int binarySearch(int[] arr, int key, int low, int high) {
    
    if(high < low) {
      return -1;
    }
    
    int mid = low + (high - low)/2;
    
    if(arr[mid] == key) {
      return mid;
    }else if(arr[mid] > key) {
      return binarySearch(arr, key, low, mid-1);
    }else {
      return binarySearch(arr, key, mid+1, high);
    }
  }

  private static int findPivot(int[] arr, int low, int high) {
    if(high < low) {
      return -1;
    }
    
    if(high == low) { // only one element
      return low;
    }
    
    int mid = (low) + (high - low)/2;
    if( mid > low && arr[mid] < arr[mid-1]) {
      return  mid-1;
    }
    
    if(mid < high && arr[mid] > arr[mid+1]) {
      return mid;
    }
    
    if(arr[low] >= arr[mid]) {
      return findPivot(arr, low, mid-1);
    }
    
    return findPivot(arr, mid+1, high);
  }

  
}
