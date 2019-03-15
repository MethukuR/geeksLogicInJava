package com.buildingLogic.ms.dp;

public class LongestCommonSubsequence {

  public static void main(String[] args) {
    System.out.println(calculateLongestCommonSubsequence("AGGTAB", "GXTXAYB"));
  }

  
  public static int calculateLongestCommonSubsequence(String s1, String s2) {

    if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
      return 0;
    }

    if (s1.equals(s2)) {
      return s1.length();
    }

    int max = -1;
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
          }
        } else {
          match[i][j] = Math.max(match[i - 1][j], match[i][j - 1]);
        }
      }
    }

    return match[s1Len][s2Len];

  }

}
