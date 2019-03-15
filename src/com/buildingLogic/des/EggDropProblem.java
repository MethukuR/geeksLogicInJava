/**
 * Egg Dropping Puzzle | DP-11
The following is a description of the instance of this famous puzzle involving n=2 eggs and a building 
with k=36 floors.
Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which 
will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor 
do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be 
carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the 
second floor window. Continue upward until it breaks. In the worst case, this method may require 36 
droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to 
work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs 
should be dropped so that total number of trials are minimized.


In this post, we will discuss solution to a general problem with n eggs and k floors. The solution is to 
try dropping an egg from every floor (from 1 to k) and recursively calculate the minimum number of 
droppings needed in worst case. The floor which gives the minimum value in worst case is going to be 
part of the solution.
In the following solutions, we return the minimum number of trials in worst case; these solutions can be 
easily modified to print floor numbers of every trials also.

1) Optimal Substructure:
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x 
with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors 
higher than x; so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We 
consider the max of above two cases for every floor and choose the floor which yields minimum number of 
trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trials needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)): 
                 x in {1, 2, ..., k}}

 */
package com.buildingLogic.des;

public class EggDropProblem {

  public static void main(String[] args) {
    int n = 36;
    int e = 2;
    System.out.println(findMinTrials(n, e));
  }

  private static int findMinTrials(int n, int e) {
    if( n == 1) {
      return 1;
    }
    
    if(e == 1) {
      return n;
    }
    
    int[][] trials = new int[n+1][e+1];
    
    trials[0][0] = 0;
    
    for (int i = 1; i <= n; i++) {
      trials[i][1] = i;
      trials[i][0] = Integer.MAX_VALUE;
    }
    
    for (int i = 1; i <= e; i++) {
      trials[1][i] = 1;
      trials[0][i] = 0;
    }
    
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= e; j++) {
        trials[i][j] = Integer.MAX_VALUE;
       
        for (int x = 1; x <= i; x++) {
          int res = 1   +  Math.max(trials[x-1][ j-1], trials[i-x][j]);
          if(res < trials[i][j]) {
            trials[i][j] = res;
          }
        }
      }
    }
    return trials[n][e];
  }

}
