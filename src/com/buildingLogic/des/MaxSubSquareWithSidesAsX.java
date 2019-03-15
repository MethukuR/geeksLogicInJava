/**
 * Given a matrix of ‘O’ and ‘X’, find the largest subsquare surrounded by ‘X’:
 * ============================================================================
Given a matrix where every element is either ‘O’ or ‘X’, find the largest subsquare surrounded by ‘X’.
In the below article, it is assumed that the given matrix is also square matrix. The code given below can 
be easily extended for rectangular matrices.

Examples:

Input: mat[N][N] = { {'X', 'O', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'O', 'X', 'O'},
                     {'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'O'},
                    };
Output: 3

The square submatrix starting at (1, 1) is the largest
submatrix surrounded by 'X'

Input: mat[M][N] = { {'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'X', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
                    };
Output: 4
The square submatrix starting at (0, 2) is the largest
submatrix surrounded by 'X'
 

A Simple Solution is to consider every square submatrix and check whether is has all corner edges filled 
with ‘X’. The time complexity of this solution is O(N^4).

We can solve this problem in O(N^3) time using extra space. The idea is to create two auxiliary arrays 
hor[N][N] and ver[N][N]. The value stored in hor[i][j] is the number of horizontal continuous ‘X’ characters 
till mat[i][j] in mat[][]. Similarly, the value stored in ver[i][j] is the number of vertical continuous 
‘X’ characters till mat[i][j] in mat[][]. Following is an example.


mat[6][6] =  X  O  X  X  X  X
             X  O  X  X  O  X
             X  X  X  O  O  X
             O  X  X  X  X  X
             X  X  X  O  X  O
             O  O  X  O  O  O

hor[6][6] = 1  0  1  2  3  4
            1  0  1  2  0  1
            1  2  3  0  0  1
            0  1  2  3  4  5
            1  2  3  0  1  0
            0  0  1  0  0  0

ver[6][6] = 1  0  1  1  1  1
            2  0  2  2  0  2
            3  1  3  0  0  3
            0  2  4  1  1  4
            1  3  5  0  2  0
            0  0  6  0  0  0
Once we have filled values in hor[][] and ver[][], we start from the bottommost-rightmost corner of 
matrix and move toward the leftmost-topmost in row by row manner. For every visited entry mat[i][j], we 
compare the values of hor[i][j] and ver[i][j], and pick the smaller of two as we need a square. Let the 
smaller of two be ‘small’. After picking smaller of two, we check if both ver[][] and hor[][] for left 
and up edges respectively. If they have entries for the same, then we found a subsquare. Otherwise we 
try for small-1
 */
package com.buildingLogic.des;

public class MaxSubSquareWithSidesAsX {

  public static void main(String[] args) {
    int mat[][] = {{'X', 'O', 'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X', 'O', 'X'}, 
        {'X', 'X', 'X', 'O', 'O', 'X'}, 
        {'O', 'X', 'X', 'X', 'X', 'X'}, 
        {'X', 'X', 'X', 'O', 'X', 'O'}, 
        {'O', 'O', 'X', 'O', 'O', 'O'}
       }; 
    
    System.out.println(findSubSquare(mat));
    
  }

  private static int findSubSquare(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    
    int max = 0;
    
    int[][] horizontal = new int[rows][columns];
    int[][] vertical = new int[rows][columns];
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        
        if(matrix[i][j] == 'O') {
          horizontal[i][j] = vertical[i][j] = 0;
        }
        else{
          horizontal[i][j] = (j == 0) ? 1 : horizontal[i][j-1] + 1;
          vertical[i][j] = (i == 0) ? 1 : vertical[i-1][j] + 1;
        }
      }
    }
    
    printMatrix(horizontal, rows);
    System.out.println();
    printMatrix(vertical, rows);
    
    for (int r = rows-1; r >= 0; --r) {
      for (int c = columns-1; c >= 0; --c) {
        int small = Math.min(horizontal[r][c], vertical[r][c]);
        while(small > max) {
          if(horizontal[r-small + 1][c] >= small && vertical[r][c-small+1] >= small) {
            max = small;
          }
          --small;
        }
      }
    }
    return max;
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
