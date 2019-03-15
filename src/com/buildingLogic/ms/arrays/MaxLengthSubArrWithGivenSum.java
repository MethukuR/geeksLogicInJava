package com.buildingLogic.ms.arrays;

import java.util.HashMap;

public class MaxLengthSubArrWithGivenSum {

  public static void main(String[] args) {
    int[] arr = { -2, 1, 6, -3 };
    int k = 15;
    System.out.println(maxLenSubArrSumEqualK(arr, k));
    System.out.println(minLenSubArrSumEqualK(arr, -1));
    System.out.println(minLenSubArrSumMoreThanK(arr, k));
    System.out.println(maxLenSubArrWithSumMoreThanK(arr, 5));
  }

  
  private static int minLenSubArrSumEqualK(int[] arr, int k) {

    int n = arr.length;
    if (n == 0) {
      return n+1;
    }

    int minLength = n + 1;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == k) {
        minLength = i + 1;
      }

      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }

      if (map.containsKey(sum - k)) {
        minLength = (minLength > i - map.get(sum - k)) ? i - map.get(sum - k) : minLength;
      }
    }

    return minLength;
  
  }

  private static int maxLenSubArrSumEqualK(int[] arr, int k) {

    int n = arr.length;
    if (n == 0) {
      return 0;
    }

    int maxLength = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == k) {
        maxLength = i + 1;
      }

      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }

      if (map.containsKey(sum - k)) {
        maxLength = (maxLength < i - map.get(sum - k)) ? i - map.get(sum - k) : maxLength;
      }
    }

    return maxLength;
  }

  private static int minLenSubArrSumMoreThanK(int[] arr, int k) {

    int n = arr.length;
    if (n == 0) {
      return n + 1;
    }

    int minLength = n + 1;
    int sum = 0;
    int start = 0, end = 0;
    
    while(end < n) {
      while( sum <= k && end < n) {
        sum += arr[end++];
      }
      
      while(sum > k) {
        if(end - start + 1 < minLength) {
          minLength = end - start +1;
        }
        sum -= arr[start++];
      }
    }
    return minLength;
  }

  //sum of whole array
  private static int maxLenSubArrWithSumMoreThanK(int[] arr, int k) {
    return 0;
  }

}
