package com.buildingLogic.ms.dp;

import java.util.Arrays;

public class LongestMonotonicallyIncreasingSubsequence {

  public static void main(String[] args) {
    int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
    System.out.println(lenOfLis(arr));
  }

  
  private static int lenOfLis(int[] arr) {
    
    if(arr.length == 0 || arr.length == 1) {
      return arr.length;
    }
    
    int[] lis = new int[arr.length];
    
    Arrays.fill(lis, 1);
    /*for (int i = 0; i < arr.length; i++) {
      lis[i] = 1;
    }*/
    
    for (int i = 1; i < lis.length; i++) {
      for (int j = 0; j < i; j++) {
        if(arr[i] > arr[j] && lis[i] < lis[j]+1) {
          lis[i] = lis[j]+1;
        }
      }
    }
    int max = 1;
    for (int i = 0; i < lis.length; i++) {
      if(lis[i] > max) {
        max = lis[i];
      }
    }
    return max;
  }

}
