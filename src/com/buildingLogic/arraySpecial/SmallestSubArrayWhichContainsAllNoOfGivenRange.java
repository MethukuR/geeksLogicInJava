package com.buildingLogic.arraySpecial;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubArrayWhichContainsAllNoOfGivenRange {

  public static void main(String[] args) {
    int[] arr = {7, 3, 3, 3, 1, 3, 3, 4};
    System.out.println(solution(arr));
  }

  public static int solution(int[] arr) {
    int arrLen = arr.length;
    if (arrLen == 1) {
      return 1;
    }

    Map<Integer, Integer> unique = new HashMap<Integer, Integer>();
    Map<Integer, Boolean> uniqueLocs = new HashMap<Integer, Boolean>();

    for (int i = 0; i < arrLen; ++i) {
      if (unique.containsKey(arr[i])) {
        unique.put(arr[i], unique.get(arr[i]) + 1);
      } else {
        unique.put(arr[i], 1);
      }
      uniqueLocs.put(arr[i], false);
    }

    int start = 0;
    int minDays = arrLen;
    int locLen = unique.size();
    for (int i = 0; i < arrLen; ++i) {
      if (!uniqueLocs.get(arr[i])) {
        --locLen;
        uniqueLocs.put(arr[i], true);
      }

      while (i < arrLen && locLen == 0) {
        minDays = Math.min(i - start + 1, minDays);
        if(start < arrLen) {
          if (unique.get(arr[start]) > 1) {
            unique.put(arr[start], unique.get(arr[start]) - 1);
            ++start;
          }else {
            ++locLen;
            uniqueLocs.put(arr[start], false);
          }
        }
        
      }
    }
    return minDays;
  }
}


