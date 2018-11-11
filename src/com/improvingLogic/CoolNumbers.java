package com.improvingLogic;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Today Oz is busy with cool numbers. Cool numbers are positive integers whose
 * decimal representation contains only the cool digits 2 and 5. For example,
 * numbers 25, 522, 2 are cool and 7, 15, 265 are not. Let f(k) be the smallest
 * cool number greater than or equals k. Oz is interested what is the value of
 * the following expression for a given pair (l,r) : enter image description
 * here
 * 
 * Input : The first line of input contains an integer T - number of test cases.
 * Each test case consist of two integers l and r.
 * 
 * Output : For each test case output required answer.
 * 
 * Constraint : 
 * ------------
 * 1 ≤ T ≤ 50 
 * 1 ≤ l ≤ r ≤ 109
 * 
 * Sample Input 1 3 7 Sample Output 59
 * 
 * Explanation: 
 * ------------ 
 * In the first sample:
 * f(3)+f(4)+f(5)+f(6)+f(7)=5+5+5+22+22=59
 * 
 * @author Raju Rockzz :P
 * 
 *
 */
public class CoolNumbers {
	static TreeSet<Integer> ts = new TreeSet<Integer>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int r = s.nextInt();

		int sum = findCoolNumberSum(l, r);
		System.out.println(sum);
		
		s.close();

	}

	private static int findCoolNumberSum(int l, int r) {
		int sum = 0;
		int maxCoolNumberLength = String.valueOf(r).length();

		char[] coolSet = { '2', '5' };
		findAllKLengthRec(coolSet, "", 2, maxCoolNumberLength);
		findAllKLengthRec(coolSet, "", 2, maxCoolNumberLength + 1);

		System.out.println(ts);
		for (int i = l; i <= r; ++i) {
			sum += findNextCoolNumber(i);
		}
		return sum;
	}

	private static int findNextCoolNumber(int i) {
		int number = ts.tailSet(i).first();
		return number;
	}

	 
	// link: http://www.geeksforgeeks.org/print-all-combinations-of-given-length/
	// The main recursive method to print all possible strings of length k
	static void findAllKLengthRec(char set[], String prefix, int n, int k) {

		// Base case: k is 0, print prefix
		if (k == 0) {
			System.out.println(ts.add(Integer.parseInt(prefix)));
			return;
		}

		// One by one add all characters from set and recursively
		// call for k equals to k-1
		for (int i = 0; i < n; ++i) {

			// Next character of input added
			String newPrefix = prefix + set[i];

			// k is decreased, because we have added a new character
			findAllKLengthRec(set, newPrefix, n, k - 1);
		}
	}

}
