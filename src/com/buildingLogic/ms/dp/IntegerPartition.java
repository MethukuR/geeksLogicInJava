/**
 * Ways to write n as sum of two or more positive integers:
 * 
 * For a given number n > 0, find the number of different ways in which n can be written as a sum of
 * at two or more positive integers.
 * 
 * Examples:
 * 
 * Input : n = 5 
 * Output : 6 
 * Explanation : 
 * All possible six ways are : 
 * 4 + 1 
 * 3 + 2 
 * 3 + 1 + 1 
 * 2 + 2 +1 
 * 2 + 1 + 1 + 1 
 * 1 + 1 + 1 + 1 + 1
 * 
 * Input : 4 
 * Output : 4 
 * Explanation : 
 * All possible four ways are : 
 * 3 + 1 
 * 2 + 2 
 * 2 + 1 + 1 
 * 1 + 1 + 1 + 1
 */
package com.buildingLogic.ms.dp;

public class IntegerPartition {

  public static void main(String[] args) {
    System.out.println(countWays(5));
  }

  public static int countWays(int n) {

    int[][] table = new int[n + 1][n + 1];
    table[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      table[0][i] = 0;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i > j) {
          table[i][j] = table[i - 1][j];
        } else {
          table[i][j] = table[i - 1][j] + table[i][j - i];
        }
      }
    }

    return table[n][n];
  }

}

