package com.improvingLogic;

import java.util.Arrays;
/*
 * Please note that, by default Arrays.sort method sorts the Strings
 * in case sensitive manner.
 *
 * To sort an array of Strings irrespective of case, use
 * Arrays.sort(String[] strArray, String.CASE_INSENSITIVE_ORDER) method instead.
 
	To sort partial int/String array use
	sort(int[] i, int startIndex, int endIndex) method where startIndex is
	inclusive and endIndex is exclusive
*/

/*
To sort java int array use Arrays.sort() method of java.util package.
Sort method sorts int array in ascending order and based on quicksort
algorithm.
There are two static sort methods available in java.util.Arrays class
to sort an int array.
*/

public class SortStrings {

	public static void main(String[] args) {
		String[] strNames = new String[]{"John", "alex", "Chris", "williams", "Mark", "Bob"};
		
		Arrays.sort(strNames);
		System.out.println("Case Sensitive Sorting");
		for(String strIndex: strNames){
			System.out.println(strIndex);
		}
		
		Arrays.sort(strNames,String.CASE_INSENSITIVE_ORDER);//case in sensitive sorting
		System.out.println("Case Insensitive Sorting");
		for(String strIndex: strNames){
			System.out.println(strIndex);
		}
		
		Arrays.sort(strNames,0,4,String.CASE_INSENSITIVE_ORDER);//Partial case insensitive sorting
		System.out.println("Case Insensitive Sorting");
		for(String strIndex: strNames){
			System.out.println(strIndex);
		}
		

	}

}
