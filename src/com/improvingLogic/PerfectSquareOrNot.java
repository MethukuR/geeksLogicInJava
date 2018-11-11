package com.improvingLogic;
/**
 * Square root of an integer:
 * --------------------------
Given an integer x, find square root of it. If x is not a perfect square, then return floor(√x).

Examples:

Input: x = 4
Output: 2

Input: x = 11
Output: 3

Algorithm:
1) Start with 'start' = 0, end = 'x',
2) Do following while 'start' is smaller than or equal to 'end'.
      a) Compute 'mid' as (start + end)/2
      b) compare mid*mid with x.
      c) If x is equal to mid*mid, return mid.
      d) If x is greater, do binary search between mid+1 and end. In this case, we also update 
      	ans (Note that we need floor).
      e) If x is smaller, do binary search between start and mid-1
 */
import java.util.Scanner;

public class PerfectSquareOrNot {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number :");
		int inputNumber=scn.nextInt();
		boolean status=isPerfectSquare(inputNumber);
		System.out.println(status);
		scn.close();
	}
	
	static boolean isPerfectSquare(int inputNumber){
		boolean status =false;
		for (int i = 0; i * i <= inputNumber; ++i) {
			if(inputNumber == i * i){
				status=true;
			}
		}
		return status;
	}
	
	static int floorSqrt(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;
 
        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
 
            // If x is a perfect square
            if (mid*mid == x)
                return mid;
 
            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }

}
