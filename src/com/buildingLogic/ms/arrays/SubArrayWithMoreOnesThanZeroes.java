package com.buildingLogic.ms.arrays;

import java.util.HashMap;

public class SubArrayWithMoreOnesThanZeroes {

  public static void main(String[] args) {
    int arr[] = { 0, 1, 1, 0, 0, 1 }; 
    System.out.println(maxLenSubArr(arr));
  }

  
private static int maxLenSubArr(int[] arr) {
    
    int n = arr.length;
    if(n == 0) {
      return 0;
    }
    
    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == 0) ? -1 : arr[i];
    }
    
    int maxLength = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      
      if(sum > 0) {
        maxLength = i+1;
      }
      
      if(!map.containsKey(sum)) {
        map.put(sum, i);
      }
      
      if(map.containsKey(sum-1)) {
        maxLength = (maxLength < i- map.get(sum-1)) ? i - map.get(sum-1) : maxLength;
      }
    }
    
    return maxLength;
  }

}
