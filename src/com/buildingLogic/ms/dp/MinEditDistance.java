package com.buildingLogic.ms.dp;

public class MinEditDistance {

  public static void main(String[] args) {
    System.out.println(calculateMinEditDistance("sunday", "saturday"));
  }
  
  private static void printMatrix(int[][] matrix, int rows, int columns) {
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }

  
  public static  int calculateMinEditDistance(String s1, String s2) {

    if ((s1 == null && s2 == null) || (s1.isEmpty() && s2.isEmpty())) {
      return 0;
    }
    if (s1 == null || s1.isEmpty()) {
      return s2.length();
    }

    if (s2 == null || s2.isEmpty()) {
      return s1.length();
    }
    int s1Len = s1.length();
    int s2Len = s2.length();

    int[][] table = new int[s1Len + 1][s2Len + 1];

    // base cases
    table[0][0] = 0;

    for (int i = 1; i <= s1Len; i++) {
      table[i][0] = i;
    }

    for (int i = 1; i <= s2Len; i++) {
      table[0][i] = i;
    }
    
    printMatrix(table, s1Len+1, s2Len+1);

    for (int i = 1; i <= s1Len; i++) {
      char curS1Char = s1.charAt(i-1);
      for (int j = 1; j <= s2Len; j++) {
        char curS2Char = s2.charAt(j-1);

        if (curS1Char == curS2Char) {
          table[i][j] = table[i - 1][j - 1];
        } else {
          table[i][j] =
              Math.min(table[i - 1][j - 1], Math.min(table[i][j - 1], table[i - 1][j])) + 1;
        }
      }
    }
    System.out.println();
    printMatrix(table, s1Len+1, s2Len+1);
    return table[s1Len][s2Len];
  }

}
