/**
 * Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 
 * 5, 6, 8, 9, 10, 12, 15, … because every number can only be divided by 2, 3, 5, one way to look at 
 * the sequence is to split the sequence to three groups as below:
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 
     3, 5. Then we use similar merge method as merge sort, to get every ugly number from the three 
     subsequence. Every step we choose the smallest one, and move one step after.

    1 Declare an array for ugly numbers:  ugly[n]
    2 Initialize first ugly no:  ugly[0] = 1
    3 Initialize three array index variables i2, i3, i5 to point to 
       1st element of the ugly array: 
            i2 = i3 = i5 =0; 
    4 Initialize 3 choices for the next ugly no:
             next_mulitple_of_2 = ugly[i2]*2;
             next_mulitple_of_3 = ugly[i3]*3
             next_mulitple_of_5 = ugly[i5]*5;
    5 Now go in a loop to fill all ugly numbers till 150:
    For (i = 1; i < 150; i++ ) 
    {
         These small steps are not optimized for good 
          readability. Will optimize them in C program 
        next_ugly_no  = Min(next_mulitple_of_2,
                            next_mulitple_of_3,
                            next_mulitple_of_5); 
    
        ugly[i] =  next_ugly_no       
    
        if (next_ugly_no  == next_mulitple_of_2) 
        {             
            i2 = i2 + 1;        
            next_mulitple_of_2 = ugly[i2]*2;
        } 
        if (next_ugly_no  == next_mulitple_of_3) 
        {             
            i3 = i3 + 1;        
            next_mulitple_of_3 = ugly[i3]*3;
         }            
         if (next_ugly_no  == next_mulitple_of_5)
         {    
            i5 = i5 + 1;        
            next_mulitple_of_5 = ugly[i5]*5;
         } 
         
    }//end of for loop  
    6.return next_ugly_no
    
    Example:
    Let us see how it works
    
    initialize
       ugly[] =  | 1 |
       i2 =  i3 = i5 = 0;
    
    First iteration
       ugly[1] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                = Min(2, 3, 5)
                = 2
       ugly[] =  | 1 | 2 |
       i2 = 1,  i3 = i5 = 0  (i2 got incremented ) 
    
    Second iteration
        ugly[2] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                 = Min(4, 3, 5)
                 = 3
        ugly[] =  | 1 | 2 | 3 |
        i2 = 1,  i3 =  1, i5 = 0  (i3 got incremented ) 
    
    Third iteration
        ugly[3] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                 = Min(4, 6, 5)
                 = 4
        ugly[] =  | 1 | 2 | 3 |  4 |
        i2 = 2,  i3 =  1, i5 = 0  (i2 got incremented )
    
    Fourth iteration
        ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                  = Min(6, 6, 5)
                  = 5
        ugly[] =  | 1 | 2 | 3 |  4 | 5 |
        i2 = 2,  i3 =  1, i5 = 1  (i5 got incremented )
    
    Fifth iteration
        ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                  = Min(6, 6, 10)
                  = 6
        ugly[] =  | 1 | 2 | 3 |  4 | 5 | 6 |
        i2 = 3,  i3 =  2, i5 = 1  (i2 and i3 got incremented )
    
    Will continue same way till I < 150
 */
package com.buildingLogic.numberSpecial;

public class UglyNumbers {

  public static void main(String[] args) {
    int n = 150;
    System.out.println(findNthUglyNumber(n));
  }

  private static int findNthUglyNumber(int n) {
    
    int[] uglyNumbers =  new int[n];
    uglyNumbers[0] = 1;
    int a = 0, b = 0, c = 0;
    int nextUglyNumber = 0; 
    for (int i = 1; i < n; i++) {
      nextUglyNumber = Math.min(uglyNumbers[a]*2, Math.min(uglyNumbers[b]*3, uglyNumbers[c]*5));
      uglyNumbers[i] = nextUglyNumber;
      
      if(uglyNumbers[a]*2 == nextUglyNumber) {
        ++a;
      }
      if(uglyNumbers[b]*3 == nextUglyNumber) {
        ++b;
      }
      if(uglyNumbers[c]*5 == nextUglyNumber) {
        ++c;
      }
    }
    return uglyNumbers[n-1];
  }

}
