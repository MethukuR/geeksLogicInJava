package com.buildingLogic.arraySpecial;

import java.util.PriorityQueue;

public class KthLargestInArray {

  public static void main(String[] args) {
    int arr[] = {12, 3, 5, 7, 19}; 
    System.out.println(findKthLargest(arr, 2));
  }

  private static int findKthLargest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    
    for (Integer element : arr) {
      pq.add(element);
      if(pq.size() > k) {
        pq.remove();
      }
    }
    return pq.remove();
  }

}
