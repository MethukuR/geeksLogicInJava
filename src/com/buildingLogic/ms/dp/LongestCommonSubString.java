package com.buildingLogic.ms.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubString {
 
  public static void main(String[] args) {
    calculateLongestCommonSubString("orgacdv", "orgbcdv");
  }

  public static void calculateLongestCommonSubString(String s1, String s2) {
    int max = -1;
    List<String> al = new ArrayList<>();
    
    if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()){
      max = 0;
      al.add("");
      return;
    }
    
    if (s1.equals(s2)) {
      max = s1.length();
      al.add(s1);
      return;
    }
    
    int s1Len = s1.length();
    int s2Len = s2.length();
    int[][] match = new int[s1Len + 1][s2Len + 1];
    
    for (int i = 0; i <= s1Len; i++) {
      for (int j = 0; j <= s2Len; j++) {
        if (i == 0 || j == 0) {
          match[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          match[i][j] = match[i - 1][j - 1] + 1;
          if (match[i][j] > max) {
            max = match[i][j];
            al.clear();
            al.add(s1.substring(i - max, i));
          } else if (match[i][j] == max) {
            al.add(s1.substring(i - max, i));
          }
        } else {
          match[i][j] = 0;
        }
      }
    }

    System.out.println(max);
    System.out.println(al);
  }

}
