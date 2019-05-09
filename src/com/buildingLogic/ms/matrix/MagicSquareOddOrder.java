/**
 * Magic squares are divided into three major categories depending upon order of square.
1) Odd order Magic Square. Example: 3,5,7,… (2*n +1)
2) Doubly-even order Magic Square. Example : 4,8,12,16,.. (4*n)
3) Singly-even order Magic Square. Example : 6,10,14,18,..(4*n +2)
 */
package com.buildingLogic.ms.matrix;

public class MagicSquareOddOrder {

  public static void main(String[] args) {
    
    int n=5;
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
    
    int i = n/2;
    int j = n-1;
    magicSquare[i][j] = 1;
    int nextNumber = 2;
    
    while(nextNumber <= n*n) {
      i = i-1;
      j = j+1;
      
      
      if( i == -1 && j == n) {
        i = 0;
        j = j-2;
      }
      
      else if(i < 0) {
        i = n-1;
      }
      
      else if(j >= n) {
        j = 0;
      }
      
      if(magicSquare[i][j] > 0) {
        i = i+1;
        j = j-2;
      }
      magicSquare[i][j]= nextNumber;
      ++nextNumber;
    }
    return magicSquare;
  }

}
