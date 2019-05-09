/**
 * Count numbers from 1 to n that have 4 as a digit Given a number n, find count of all numbers from
 * 1 to n that have 4 as a digit. Examples :
 * 
 * Input: n = 5 Output: 1 Only 4 has '4' as digit
 * 
 * Input: n = 50 Output: 14
 * 
 * Input: n = 328 Output: 60
 * 
 * Efficient Solution:

Above is a naive solution. We can do it more efficiently by finding a pattern.
Let us take few examples.

Count of numbers from 0 to 9   = 1
Count of numbers from 0 to 99  = 1*9 + 10 = 19
Count of numbers from 0 to 999 = 19*9 + 100 = 271 

In general, we can write 
   count(10d) =   9 * count(10d - 1) + 10d - 1
In below implementation, the above formula is implemented using dynamic programming as there are overlapping subproblems.
The above formula is one core step of the idea. Below is complete algorithm.

1) Find number of digits minus one in n. Let this value be 'd'.  
   For 328, d is 2.

2) Compute some of digits in numbers from 1 to 10d - 1.  
   Let this sum be w. For 328, we compute sum of digits from 1 to 
   99 using above formula.

3) Find Most significant digit (msd) in n. For 328, msd is 3.

4.a) If MSD is 4. For example if n = 428, then count of
     numbers is sum of following.
     1) Count of numbers from 1 to 399
     2) Count of numbers from 400 to 428 which is 29.

4.b) IF MSD > 4. For example if n is 728, then count of
     numbers is sum of following.
     1) Count of numbers from 1 to 399 and count of numbers
        from 500 to 699, i.e., "a[2] * 6"
     2) Count of numbers from 400 to 499, i.e. 100
     3) Count of numbers from 700 to 728, recur for 28
4.c) IF MSD < 4. For example if n is 328, then count of
     numbers is sum of following.
     1) Count of numbers from 1 to 299 a
     2) Count of numbers from 300 to 328, recur for 28 

 */
package com.buildingLogic.numberSpecial;

public class DigitSum {

  public static void main(String[] args) {
    int n = 428;
    int k =4;
    System.out.println(findDigitCount(328,4));
  }

  private static int findDigitCount(int n, int k) {
    // Base case 
    if (n < k) 
        return 0; 
      
    // d = number of digits minus 
    // one in n. For 328, d is 2 
    int d = (int)Math.log10(n);
    
    // computing count of numbers from 1 to 10^d-1, 
    // d=0 a[0] = 0; 
    // d=1 a[1] = count of numbers from  
    // 0 to 9 = 1 
    // d=2 a[2] = count of numbers from  
    // 0 to 99 = a[1]*9 + 10 = 19 
    // d=3 a[3] = count of numbers from 
    // 0 to 999 = a[2]*19 + 100 = 171 
    int[] a = new int[d + 2]; 
    a[0] = 0; 
    a[1] = 1; 
    
    for (int i = 2; i < a.length; i++) {
      a[i] = (int) (9*a[i-1] + (int)Math.ceil(Math.pow(10, i-1)));
    }
    
    // Computing 10^d 
    int p = (int)Math.ceil(Math.pow(10, d)); 
    
    // Most significant digit (msd) of n, 
    // For 328, msd is 3 which can be obtained using 328/100 
    int msd = n/p;
    
    // If MSD is k. For example if n = 428, and k = 4 then count of 
    // numbers is sum of following. 
    // 1) Count of numbers from 1 to 399 
    // 2) Count of numbers from 400 to 428 which is 29.
    
    if(msd == k) {
      return msd*a[d] + findDigitCount(n%p, k);
    }
    
    // IF MSD > k. For example if n  
    // is 728 and k = 4, then count of numbers 
    // is sum of following. 
    // 1) Count of numbers from 1 to  
    // 399 and count of numbers from 
    // 500 to 699, i.e., "a[2] * 6" 
    // 2) Count of numbers from 400  
    // to 499, i.e. 100 
    // 3) Count of number
    if(msd > k) {
      return (msd-1)*a[d] + p+ findDigitCount(n%p, k);
    }
    
    // IF MSD < 4. For example if n is 328, then count of 
    // numbers is sum of following. 
    // 1) Count of numbers from 1 to 299 a 
    // 2) Count of numbers from 300 to 328, recur for 28 
    return msd*a[d] + findDigitCount(n%p, k);
  }

}
