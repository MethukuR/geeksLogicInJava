/**
 * 0-1 Knapsack Problem: Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. In other words, given two integer
 * arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
 * respectively. Also given an integer W which represents knapsack capacity, find out the maximum
 * value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 * A simple solution is to consider all subsets of items and calculate the total weight and value of
 * all subsets. Consider the only subsets whose total weight is smaller than W. From all such
 * subsets, pick the maximum value subset.
 * 
 * 1) Optimal Substructure: 
 * To consider all subsets of items, there can be two cases for every item:
 * (1) the item is included in the optimal subset, (2) not included in the optimal set. Therefore,
 * the maximum value that can be obtained from n items is max of following two values. 
 * 1) Maximum
 * value obtained by n-1 items and W weight (excluding nth item). 
 * 2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth 
 * item (including nth item).
 * 
 * If weight of nth item is greater than W, then the nth item cannot be included and case 1 is the
 * only possibility.
 */
package com.buildingLogic.ms.dp;

public class KnapSackWORepetition {

  public static void main(String[] args) {
    /*int sum = 100; 
    int values[] = {10, 30, 20}; 
    int weights[] = {5, 10, 15};*/
    
    
    int values[] = {60, 100, 120}; 
    int weights[] = {10, 20, 30}; 
    int sum = 50; 

    System.out.println(knapsack(values, weights, sum));
  }

  private static void printMatrix(int[][] matrix, int rows, int columns) {
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
  }

  private static int knapsack(int[] values, int[] weights, int sum) {
    if (sum == 0) {
      return 0;
    }

    int n = weights.length;
    //Arrays.sort(weights);

    int[][] table = new int[n + 1][sum + 1];

    printMatrix(table, n + 1, sum + 1);

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        if(i ==0 || j == 0) {
          table[i][j] = 0;
        }
        else if (weights[i - 1] > j) {
          table[i][j] = table[i - 1][j];
        } else {
          table[i][j] = Math.max(table[i - 1][j], values[i - 1] + table[i - 1][j - weights[i - 1]]);
        }
      }
    }
    
    printMatrix(table, n + 1, sum + 1);

    return table[n][sum];
  }

}
