/**
 * CASE 1: Given an array of n elements which contains elements from 0 to n-1, with any of these
 * numbers appearing any number of times. Find these repeating numbers in O(n) and using only
 * constant memory space.
 * 
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 * 
 * Algorithm: 
 * ========== 
 * traverse the list 
 * for i= 0 to n-1 elements 
 * { 
 *  check for sign of A[abs(A[i])]
 *      if positive then make it negative by A[abs(A[i])]=-A[abs(A[i])]; 
 *      else 
 *      // i.e., A[abs(A[i])] is
 *  negative this element (ith element of list) is a repetition }
 * 
 * CASE: 2
 * 
 * No restrictions on range of elements. Print Duplicates only once
 */
package com.buildingLogic.arraySpecial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int noOfElements = scn.nextInt();

        int[] elements = new int[noOfElements];

        for (int i = 0; i < noOfElements; ++i) {
            elements[i] = scn.nextInt();
        }

        int noOfDuplicates = calculateDuplicateCountt(elements, noOfElements);
        System.out.print(noOfDuplicates);

    }

    private void printRepeatingCaseTwo(int[] arr, int arrSize) {
        Arrays.sort(arr);

        System.out.println("The repeating elements are : ");
        int lastDuplicateIndex = -1;
        for (int i = 1; i < arrSize; ++i) {
            if (arr[i - 1] == arr[i]) {
                if (lastDuplicateIndex < 0
                        || (lastDuplicateIndex >= 0 && arr[lastDuplicateIndex] != arr[i - 1])) {
                    lastDuplicateIndex = i - 1;
                    System.out.print(arr[i - 1] + "\t");
                }
            }
        }
    }

    private void printRepeatingCaseOne(int[] arr, int arrSize) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < arrSize; i++) {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    private static int calculateDuplicateCount(int[] arr, int arrSize) {
        int count = 0;
        for (int i = 0; i < arrSize; i++) {
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                ++count;
            }
        }
        return count;
    }

    private static int calculateDuplicateCountt(int[] arr, int arrSize) {
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(arrSize);

        for (int i = 0; i < arrSize; ++i) {
            if (countMap.containsKey(arr[i])) {
                if (countMap.get(arr[i]) == 1) {
                    ++count;
                }
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        return count;
    }

}
