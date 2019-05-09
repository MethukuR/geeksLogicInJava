/**
 * Search a Word in a 2D Grid of characters Given a 2D grid of characters and a word, find all
 * occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word
 * is said be found in a direction if all characters match in this direction (not in zig-zag form).
 * 
 * The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal
 * directions.
 * 
 * Example:
 * 
 * Input: grid[][] = {"GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE"}; word = "GEEKS"
 * 
 * Output: pattern found at 0, 0 pattern found at 0, 8 pattern found at 1, 0
 * 
 * Input: grid[][] = {"GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE"}; word = "EEE"
 * 
 * Output: pattern found at 0, 2 pattern found at 0, 10 pattern found at 2, 2 pattern found at 2, 12
 * 
 */
package com.buildingLogic.ms.matrix;

import java.util.ArrayList;
import java.util.List;

public class SearchWordIn2DMatrix {
  class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point [x=" + x + ", y=" + y + "]";
    }
  }

  public static void main(String[] args) {
    char grid[][] =
        {{'a', 'g', 'm', 'y'}, {'b', 'g', 'd', 'f'}, {'x', 'e', 'e', 't'}, {'r', 'a', 'k', 's'}};
    
    SearchWordIn2DMatrix s =  new SearchWordIn2DMatrix();
    List<Point> results = s.search(grid, "geeks");
    System.out.println(results);
  }

  private List<Point> search(char[][] grid, String searchWord) {
    List<Point> results = new ArrayList<Point>();
    if (searchWord.length() == 0) {
      return results;
    }

    int rows = grid.length;
    if (rows == 0) {
      return results;
    }
    int columns = grid[0].length;

    if (searchWord.length() > rows * columns) {
      return results;
    }
    boolean[][] visited = new boolean[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        searchUtil(grid, searchWord, i, j, 0, results, visited);
        if (results.size() == searchWord.length()) {
          break;
        }else {
          results = new ArrayList<Point>();
          visited = new boolean[rows][columns];
        }
      }
    }
    return results;
  }

  private void searchUtil(char[][] grid, String searchWord, int r, int c, int searchIndex,
      List<Point> results, boolean[][] visited) {
    
    int rows = grid.length;
    int columns = grid[0].length;

    if (r >= rows || r < 0 || c >= columns || c < 0) {
      return;
    }
    
    if(visited[r][c]) {
      return;
    }
    
    visited[r][c] = true;

    if (grid[r][c] != searchWord.charAt(searchIndex)) {
      return;
    }else {
      results.add(new Point(r, c));
    }
    
    if(searchIndex == searchWord.length() -1) {
      return;
    }

    for (int i = r - 1; i <= r + 1; i++) {
      for (int j = c - 1; j <= c + 1; j++) {
        searchUtil(grid, searchWord, i, j, searchIndex+1, results, visited);
      }
    }

  }
}
