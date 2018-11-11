package com.improvingLogic;

import java.util.TreeSet;

/**
 *  Problem: Given a number n, find number of numbers that are greater than n using the same 
 *  set of digits as n.
	Assume number n doesn't contain any duplicate digits.
	Input: Input contains an integer n.
	Output: Print the number of numbers greater than n.
	Constraints: 1 ≤ n ≤ 100000
	Sample Input: 123
	Sample Output: 
	5
 * @author Raju Rockzz:P
 *
 */
public class TheGreaterNumbers {

	public static void main(String[] args) {
		int inputNumber=1234;
		TreeSet<Integer> ts=findAllPermutations(String.valueOf(inputNumber));
		System.out.println(ts);
	}

	private static TreeSet<Integer> findAllPermutations(String inputString) {
		TreeSet<Integer> permutations= new TreeSet<Integer>();
		if(null == inputString){
			return null;
		}
		else if(inputString.isEmpty()){
			permutations.add(-1);
			return permutations;
		}
		
		char firstChar=inputString.charAt(0);
		String remainder=inputString.substring(1);
		
		TreeSet<Integer> words=findAllPermutations(remainder);
		
		for (Integer word : words) {
			String curword=String.valueOf(word);
			int curwordLength=curword.length();
			for (int i = 0; i < curwordLength; ++i) {
				String newperm=charInsert(curword,firstChar,i);
				words.add(Integer.parseInt(newperm));
			}
		}
		
		return permutations;
		
	}

	private static String charInsert(String curword, char firstChar, int i) {
		    String begin = curword.substring(0, i);
	        String end = curword.substring(i);
	        return begin + firstChar + end;
	}

}
