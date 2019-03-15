/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
 * For example, the below matrix contains 5 islands
 * 
 * Example:
 * 
 * Input : mat[][] = {
 *                      {1, 1, 0, 0, 0}, 
 *                      {0, 1, 0, 0, 1}, 
 *                      {1, 0, 0, 1, 1}, 
 *                      {0, 0, 0, 0, 0}, 
 *                      {1, 0, 1, 0, 1} 
 *                      
 *Output : 5 
 *This is a variation of the standard problem: “Counting the number of connected components in an 
 *undirected graph”.
 *
 * 
 * Before we go to the problem, let us understand what is a connected component. A connected
 * component of an undirected graph is a subgraph in which every two vertices are connected to each
 * other by a path(s), and which is connected to no other vertices outside the subgraph. For
 * example, the graph shown below has three connected components.
 * 
 * 
 * 
 * A graph where all vertices are connected with each other has exactly one connected component, 
 * consisting of the whole graph. Such graph with only one connected component is called as Strongly 
 * Connected Graph.
 * 
 * The problem can be easily solved by applying DFS() on each component. In each DFS() call, a
 * component or a sub-graph is visited. We will call DFS on the next un-visited component. The
 * number of calls to DFS() gives the number of connected components. BFS can also be used.
 * 
 * What is an island? 
 * A group of connected 1s forms an island. For example, the below matrix
 * contains 5 islands
 * 
 * {1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1} 
 * A cell in 2D matrix can be connected to 8 neighbours. So, unlike standard DFS(), where we recursively 
 * call for all adjacent vertices, here we can recursively call for 8 neighbours only. We keep track of 
 * the visited 1s so that they are not visited again.
 */
package com.buildingLogic.des;

public class NumberOfIslands {

  public static void main(String[] args) {
    int mat[][] =
        {
            {1, 1, 0, 0, 0}, 
            {0, 1, 0, 0, 1}, 
            {1, 0, 0, 1, 1}, 
            {0, 0, 0, 0, 0}, 
            {1, 0, 1, 0, 1}
         };
    System.out.println(findNumberOfIslands(mat));

  }

  private static int findNumberOfIslands(int[][] mat) {
    int rows = mat.length;
    int columns = mat[0].length;
    int islands = 0;
    
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if(mat[row][column] == 1) {
          ++islands;
          markNeighbourNodesAsVisited(mat, row, column);
        }
      }
    }
    return islands;
  }

  private static void markNeighbourNodesAsVisited(int[][] mat, int row, int column) {
    int rows = mat.length;
    int columns = mat[0].length;
    
    if(row < 0 || column < 0 || row >= rows || column >= columns) {
      return ;
    }
    
    if(mat[row][column] == 0) {
      return ;
    }
    
    mat[row][column] = 0;
    for (int r = row-1; r <= row+1; r++) {
      for (int c = column-1; c <= column+1; c++) {
        if(r != row || c != column) {
          markNeighbourNodesAsVisited(mat, r, c);
        }
      }
    }
  }
}
