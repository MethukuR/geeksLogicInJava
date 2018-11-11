package com.buildingLogic.numberSpecial;
/**
 * You have been given 3 integers l, r and k
Find how many numbers between 
l and r (both inclusive) are divisible by k. You do not need to print these numbers, you just have to 
find their count.

Input Format
The first and only line of input contains 3 space separated integers 
l, r and k.

Output Format
Print the required answer on a single line.

Constraints:
============
1 ≤ l ≤ r ≤ 1000 
 
1 ≤ k ≤ 1000

SAMPLE INPUT:
------------ 
1 10 1
SAMPLE OUTPUT :
-------------
10

There are multiple ways to solve this problem. The easiest one is to iterate over the entire range and 
check each number. This gives us a time complexity of O(N) where N is the size of the range. However, 
this problem can also be solved in O(1) time which might be helpful for larger constraints. The number 
of numbers divisible by a certain number k in the range from 1 to r is 
r/k Thus we can first find the number of numbers divisible by k in the range from 1 to r and then 
subtract from it the numbers divisible by k in the range from 1 to l−1 to obtain the answer.

 * @author Raju Rockzz :P
 *
 */
public class CountDivisors {

	public static void main(String[] args) {
		int l =347;
		int r=1000;
		int k=432;
		
		int count=findDivisorCount(l,r,k);
		
		System.out.println("DivisorCount : "+count);
	}

	static int findDivisorCount(int l, int r, int k) {
		int count=(r/k)-((l-1)/k);
		return count;
	}

}
