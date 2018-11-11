package com.improvingLogic;

import java.util.HashMap;
/**
 * String Queries:
 * ----------------
 Given a string consisting of lowercase English alphabets, you need to answer queries based 
 on the properties of this string.
 Note that we need to equalize the count of only characters that occur in the range, and not
 of characters that do not. It is allowed to delete all occurences of a character, so that 
 it no longer occurs in the range at all.

 Can you do it ?

 Sample Input
 8 2
 abcdabcd
 1 6
 2 7
 Sample Output
 2
 2
 
 2nd query, the substring required here is "bcdabc"

 "bcdabc" . We can delete from this substring one occurence one occurence of ′b′ and ′c′ to 
 achieve the desired result. Thus, the answer is 2.


 */
import java.util.Scanner;

class StringQueries {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		String inputString = s.next();

		int l = s.nextInt();

		int r = s.nextInt();

		int minDeletions = findMinDeletions(inputString, l, r);
		System.out.println(minDeletions);
		s.close();
	}

	private static int findMinDeletions(String inputString, int l, int r) {
		String s = inputString.substring(l - 1, r);
		;
		int minDeletions = 0;
		int sLength = s.length();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>(sLength);

		for (int i = 0; i < sLength; ++i) {
			char c = s.charAt(i);

			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			} else {
				hm.put(c, 1);
			}
		}

		int min = 11111;
		for (int value : hm.values()) {
			if (value < min) {
				min = value;
			}
		}

		for (int value : hm.values()) {
			minDeletions += (value - min);
		}

		return minDeletions;
	}
}
