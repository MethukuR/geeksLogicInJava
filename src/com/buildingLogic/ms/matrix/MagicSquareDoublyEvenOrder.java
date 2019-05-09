/**
 * Magic squares are divided into three major categories depending upon order of square.
1) Odd order Magic Square. Example: 3,5,7,… (2*n +1)
2) Doubly-even order Magic Square. Example : 4,8,12,16,.. (4*n)
3) Singly-even order Magic Square. Example : 6,10,14,18,..(4*n +2)
 */
package com.buildingLogic.ms.matrix;

public class MagicSquareDoublyEvenOrder {

  public static void main(String[] args) {
    int n=4;
    int[][] magicSquare = formMagicSquare(n);
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(magicSquare[i][j] + "\t");
      }
      System.out.println();
    }
  }

  private static int[][] formMagicSquare(int n) {
    int[][] magicSquare = new int[n][n];
    
    // filling array with its count value 
    // starting from 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        magicSquare[i][j] = (n*i) + j +1;
      }
    }
    
    // Top left corner
    for (int i = 0; i < n/4; i++) {
      for (int j = 0; j < n/4; j++) {
        magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];
      }
    }
    
   // Top right corner
    for (int i = 0; i < n/4; i++) {
      for (int j = 3*(n/4); j < n; j++) {
        magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];
      }
    }
    
    // Bottom left corner
    for (int i = 3*(n/4); i < n; i++) {
      for (int j = 0; j < n/4; j++) {
        magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];
      }
    }
    
    // Bottom right corner
    for (int i = 3*(n/4); i < n; i++) {
      for (int j = 3*(n/4); j < n; j++) {
        magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];
      }
    }
    
    // center
    for (int i = n/4; i < 3*(n/4); i++) {
      for (int j = n/4; j < 3*(n/4); j++) {
        magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];
      }
    }
    
    return magicSquare;
  }

}
