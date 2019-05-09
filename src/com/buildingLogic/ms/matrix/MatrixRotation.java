package com.buildingLogic.ms.matrix;

/**
 * O(n^2) time and O(1) space algorithm ( without any workarounds and hanky-panky stuff! )
 * 
 * Rotate by +90: -------------- 1.Transpose 2.Reverse each row
 * 
 * Rotate by -90: -------------- Method 1 :
 * 
 * 1.Transpose 2.Reverse each column
 * 
 * Method 2 :
 * 
 * 1.Reverse each row 2.Transpose
 * 
 * Rotate by +180: ---------------
 * 
 * Method 1: Rotate by +90 twice
 * 
 * Method 2: Reverse each row and then reverse each column (Transpose)
 * 
 * Rotate by -180: ---------------
 * 
 * Method 1: Rotate by -90 twice
 * 
 * Method 2: Reverse each column and then reverse each row
 * 
 * Method 3: Rotate by +180 as they are same
 * 
 * @author Raju Rockzz :P
 *
 */
public class MatrixRotation {

  public static void main(String[] args) {
    int[][] inputMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int n = inputMatrix.length;
    System.out.println("Initial Matrix");
    printMatrix(inputMatrix, n);

    int[][] rotatedMatrix = rotateClockWise90(inputMatrix, n);
    System.out.println("Matrix after rotating it by 90 degree clockwise");
    printMatrix(rotatedMatrix, n);

    rotatedMatrix = rotateClockWise90InPlace(inputMatrix, n);
    System.out.println("Matrix after rotating it by 90 degree clockwise in place");
    printMatrix(rotatedMatrix, n);

    rotatedMatrix = rotateAntiClockWise90(inputMatrix, n);
    System.out.println("Matrix after rotating it by 90 degree anti clockwise");
    printMatrix(rotatedMatrix, n);

    rotatedMatrix = rotateBy180(inputMatrix, n);
    System.out.println("Matrix after rotating it by 180 degree");
    printMatrix(rotatedMatrix, n);
  }

  private static int[][] rotateClockWise90InPlace(int[][] inputMatrix, int n) {
    int level = 0;
    int last = n - 1;
    int noOfLevels = n / 2;

    while (level < noOfLevels) {

      for (int i = level; i < last; ++i) {

        int temp = inputMatrix[level][i];
        inputMatrix[level][i] = inputMatrix[i][last];
        inputMatrix[i][last] = temp;

        temp = inputMatrix[level][i];
        inputMatrix[level][i] = inputMatrix[last][last - i + level];
        inputMatrix[last][last - i + level] = temp;

        temp = inputMatrix[level][i];
        inputMatrix[level][i] = inputMatrix[last - i + level][level];
        inputMatrix[last - i + level][level] = temp;

      }
      ++level;
      --last;
    }
    return inputMatrix;
  }

  private static int[][] rotateBy180(int[][] inputMatrix, int n) {
    int[][] rotatedMatrix = rotateClockWise90(rotateClockWise90(inputMatrix, n), n);

    return rotatedMatrix;
  }

  private static int[][] rotateAntiClockWise90(int[][] inputMatrix, int n) {
    int[][] reversedMatrix = reverseEachRowOfMatrix(inputMatrix, n);
    int[][] rotatedMatrix = findTranspose(reversedMatrix, n);

    return rotatedMatrix;
  }

  private static int[][] rotateClockWise90(int[][] inputMatrix, int n) {
    int[][] transposedMatrix = findTranspose(inputMatrix, n);
    int[][] rotatedMatrix = reverseEachRowOfMatrix(transposedMatrix, n);

    return rotatedMatrix;

  }

  private static int[][] reverseEachRowOfMatrix(int[][] transposedMatrix, int n) {
    for (int i = 0; i < n; ++i) {
      int start = 0;
      int end = n - 1;
      while (start <= end) {
        int temp = transposedMatrix[i][start];
        transposedMatrix[i][start] = transposedMatrix[i][end];
        transposedMatrix[i][end] = temp;
        ++start;
        --end;
      }
    }
    return transposedMatrix;
  }

  private static int[][] reverseEachColumnOfMatrix(int[][] transposedMatrix, int n) {
    for (int i = 0; i < n; ++i) {
      int start = 0;
      int end = n - 1;
      while (start <= end) {
        int temp = transposedMatrix[start][i];
        transposedMatrix[start][i] = transposedMatrix[end][i];
        transposedMatrix[end][i] = temp;
        ++start;
        --end;
      }
    }
    return transposedMatrix;
  }

  private static int[][] findTranspose(int[][] inputMatrix, int n) {
    int[][] transposedMatrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        transposedMatrix[i][j] = inputMatrix[j][i];
      }
    }

    return transposedMatrix;

  }

  private static void printMatrix(int[][] matrix, int n) {
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }

}
