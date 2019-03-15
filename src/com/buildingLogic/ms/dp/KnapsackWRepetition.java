package com.buildingLogic.ms.dp;

public class KnapsackWRepetition {

  public static void main(String[] args) {
    int sum = 100; 
    int values[] = {10, 30, 20}; 
    int weights[] = {5, 10, 15};

    
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
          table[i][j] = Math.max(table[i - 1][j], values[i - 1] + table[i][j - weights[i - 1]]);
        }
      }
    }
    
    printMatrix(table, n + 1, sum + 1);

    return table[n][sum];
  }

}
