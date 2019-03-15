/**
 * Median of two sorted arrays of same size: ========================================= There are 2
 * sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained
 * after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)).
 * 
 * Note : Since size of the set for which we are looking for median is even (2n), we need take
 * average of middle two numbers and return floor of the average.
 * 
 * Method 1 (Simply count while Merging): ===================================== Use merge procedure
 * of merge sort. Keep track of count while comparing elements of two arrays. If count becomes n(For
 * 2n elements), we have reached the median. Take the average of the elements at indexes n-1 and n
 * in the merged array.
 * 
 * Time Complexity : O(n)
 * 
 * Method 2 (By comparing the medians of two arrays) :
 * =================================================== This method works by first getting medians of
 * the two sorted arrays and then comparing them.
 * 
 * Let ar1 and ar2 be the input arrays.
 * 
 * Algorithm :
 * 
 * 1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively. 2) If m1 and
 * m2 both are equal then we are done. return m1 (or m2) 3) If m1 is greater than m2, then median is
 * present in one of the below two subarrays. a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
 * b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1]) 4) If m2 is greater than m1, then median
 * is present in one of the below two subarrays. a) From m1 to last element of ar1
 * (ar1[|_n/2_|...n-1]) b) From first element of ar2 to m2 (ar2[0...|_n/2_|]) 5) Repeat the above
 * process until size of both the subarrays becomes 2. 6) If size of the two arrays is 2 then use
 * below formula to get the median. Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
 * 
 * Examples:
 * 
 * ar1[] = {1, 12, 15, 26, 38} ar2[] = {2, 13, 17, 30, 45}
 * 
 * For above two arrays m1 = 15 and m2 = 17
 * 
 * For the above ar1[] and ar2[], m1 is smaller than m2. So median is present in one of the
 * following two sub-arrays.
 * 
 * [15, 26, 38] and [2, 13, 17]
 * 
 * Let us repeat the process for above two sub-arrays:
 * 
 * m1 = 26 m2 = 13. m1 is greater than m2. So the subarrays become
 * 
 * [15, 26] and [13, 17] Now size is 2, so median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2 =
 * (max(15, 13) + min(26, 17))/2 = (15 + 17)/2 = 16
 * 
 */
package com.buildingLogic.des;

public class MedianInTwoSortedArrays {

  public static void main(String[] args) {
    int arr1[] = {1, 2, 3, 6};
    int arr2[] = {4, 6, 8, 10};
    int startA = 0, startB = 0;
    int endA = arr1.length - 1, endB = arr2.length - 1;
    System.out.println(findMedianUtil(arr1, arr2, startA, endA, startB, endB));
  }

  private static double findMedianUtil(int[] arrA, int[] arrB, int startA, int endA, int startB,
      int endB) {

    if ((endA - startA < 0) || ((endB - startB < 0))) {
      return -1;
    }
    
    // arrays has only one element  each
    if ((endA - startA == 0) && ((endB - startB == 0))) {
      return 1.0 * (arrA[0] + arrB[0]) / 2;
    }

    // arrays has only two elements each
    if ((endA - startA == 1) && (endB - startB == 1)) {
      return 1.0 * ((Math.max(arrA[startA], arrB[startB])) + Math.min(arrA[endA], arrB[endB])) / 2;
    }

    double medianA = getMedian(arrA, startA, endA);
    double medianB = getMedian(arrB, startB, endB);

    if (medianA == medianB) {
      return medianA;
    }

    if (medianA < medianB) {
      int diff = endA - startA;
      if ((diff & 1) == 0) {// odd number of elements
        startA = startA + (endA - startA) / 2;
        endB = startB + (endB - startB) / 2 ;
      } else { // even number of elements
        startA = startA + (endA - startA) / 2;
        endB = startB + (endB - startB) / 2 + 1;
      }
    } else {
      int diff = endB - startB;
      if ((diff & 1) == 0) {// odd number of elements
        startB = startB + (endB - startB) / 2;
        endA = startA + (endA - startA) / 2;
      } else { // even number of elements
        startB = startB + (endB - startB) / 2;
        endA = startA + (endA - startA) / 2 + 1;
      }
    }

    return findMedianUtil(arrA, arrB, startA, endA, startB, endB);
  }

  private static double getMedian(int[] arr, int start, int end) {
    int diff = (end - start);

    if ((diff & 1) == 0) {// odd number of elements
      return arr[start + (diff / 2)];
    } else { // even number of elements
      return (1.0) * (arr[start + diff / 2] + arr[start + diff / 2 + 1]) / 2;
    }
  }
}
