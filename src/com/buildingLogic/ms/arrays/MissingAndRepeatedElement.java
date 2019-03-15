package com.buildingLogic.ms.arrays;

import java.util.Arrays;

public class MissingAndRepeatedElement {

  public static void main(String[] args) {
    int arr[] = { 1, 3, 4, 5, 1, 6, 2 };
    //findMissingAndRepeatedElements(arr);
    findMissingAndRepeatedElementsTwo(arr);
  }
  
  public static void findMissingAndRepeatedElements(int[] inputArr) {
    if(inputArr.length == 0 || inputArr.length == 1) {
      return;
    }
    
    int xor = inputArr[0], x = 0, y = 0;
    
    for (int i = 1; i < inputArr.length; ++i) {
      xor ^= inputArr[i];
    }
    
    for (int i = 1; i <= inputArr.length; i++) {
      xor ^= i;
    }
    
    int setBit = xor & ~(xor - 1);
    
    for (int i = 0; i < inputArr.length; i++) {
      if((inputArr[i]&setBit) !=0) {
        x ^= inputArr[i];
      }else {
        y ^= inputArr[i];
      }
    }
    System.out.println(x);
    System.out.println(y);
  }
  
  public static void findMissingAndRepeatedElementsTwo(int[] inputArr) {
    if(inputArr.length == 0 || inputArr.length == 1) {
      return;
    }
    
    int arrLen = inputArr.length;
    int missingNumber = -1;
    int repeatedNumber = -1;

    //int[] temp = Arrays.copyOf(inputArr, arrLen);
    
    for (int i = 0; i < arrLen; i++) {
      int curVal = inputArr[i]%arrLen;
      inputArr[curVal-1]+= arrLen;
    }
    
    for (int i = 0; i < arrLen; i++) {
      if(inputArr[i]/arrLen == 2) {
        repeatedNumber = i + 1;
      }
      
      if(inputArr[i]/arrLen == 0) {
        missingNumber = i+1;
      }
    }
    
    System.out.println(missingNumber);
    System.out.println(repeatedNumber);
  }


}
