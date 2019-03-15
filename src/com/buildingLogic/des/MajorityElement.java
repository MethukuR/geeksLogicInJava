package com.buildingLogic.des;

public class MajorityElement {

  public static void main(String[] args) {
    int arr[] = new int[]{1, 3, 3, 1, 2, 3};
    System.out.println(findMajorityElement(arr));
  }

  private static int findMajorityElement(int[] arr) {
    int n = arr.length;
    if( n == 1) {
      return -1;
    }
    
    int majorityIndex = 0;
    int count = 1;
    
    for (int i = 1; i < n; i++) {
      if(arr[majorityIndex] == arr[i]) {
        ++count;
      }else {
        --count;
      }
      
      if(count == 0) {
        majorityIndex = i;
        count = 1;
      }
    }
    return arr[majorityIndex];
  }

}
