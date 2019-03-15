/**
 * Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the maximum difference between any two elements such that 
larger element appears after the smaller number.

Examples :

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.
Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
Method 1 (Simple)
Use two loops. In the outer loop, pick elements one by one and in the inner loop calculate the difference 
of the picked element with every other element in the array and compare the difference with the maximum 
difference calculated so far. 

Method 2 (Tricky and Efficient)
In this method, instead of taking difference of the picked element with every other element, we take 
the difference with the minimum element found so far. 
So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).



 */
package com.buildingLogic.des;

public class MaxDiffBetweenTwoNumbers {

  public static void main(String[] args) {
    int arr[] = {7, 9, 5, 6, 3, 2}; 
    System.out.println(findMaxDiff(arr));
  }

  private static int findMaxDiff(int[] arr) {
    if(arr.length < 2) {
      return -1;
    }
    int maxDiff = arr[1] - arr[0];
    int minElement = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
      maxDiff = (arr[i] - minElement > maxDiff) ? arr[i] - minElement : maxDiff;
      minElement = (arr[i] < minElement) ? arr[i] : minElement;
    }
    return maxDiff;
  }
}
