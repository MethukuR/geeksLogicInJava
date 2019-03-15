/**
 * Kadane's Algorithm
 */

package com.buildingLogic.ms.arrays;

public class MaxSumSubArray {

  public static void main(String[] args) {
    int[] arr = {1, -3, 2, 1, -1};
    System.out.println(findMaxSum(arr));
  }

  private static int findMaxSum(int[] arr) {
    if(arr.length == 0) {
      return Integer.MIN_VALUE;
    }
    
    if(arr.length == 1) {
      return arr[0];
    }
    
    int maxGlobal = arr[0] ,maxCurrent = 0;
    for (int i = 0; i < arr.length; i++) {
      maxCurrent = maxCurrent + arr[i];
      
      if(maxCurrent > maxGlobal) {
        maxGlobal = maxCurrent;
      }
      
      if(maxCurrent < 0) {
        maxCurrent = 0;
      }
    }
    
    if(maxCurrent > maxGlobal) {
      maxGlobal = maxCurrent;
    }
    return maxGlobal;
  }
  
  

}
