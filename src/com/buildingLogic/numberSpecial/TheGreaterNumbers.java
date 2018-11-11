package com.buildingLogic.numberSpecial;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem: Given a number n, find number of numbers that are greater than n
 * using the same set of digits as n. Assume number n doesn't contain any
 * duplicate digits. Input: Input contains an integer n. Output: Print the
 * number of numbers greater than n. Constraints: 1 ≤ n ≤ 100000 Sample Input:
 * 123 Sample Output: 5
 * 
 * @author Raju Rockzz :P
 *
 */
public class TheGreaterNumbers {

	public static void main(String[] args) {
		int input = 534976;
		int count = methodOne(input);
		System.out.println("count " + count);

		count = methodTwo(input);
		System.out.println("count " + count);
	}

	/**
	 * link: http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
	 * 
	 * Find next greater number with same set of digits:
	 * ------------------------------------------------- Given a number n, find
	 * the smallest number that has same set of digits as n and is greater than
	 * n. If x is the greatest possible number with its set of digits, then
	 * print “not possible”.
	 * 
	 * Examples: -------- For simplicity of implementation, we have considered
	 * input number as a string.
	 * 
	 * Input: n = "218765" Output: "251678"
	 * 
	 * Input: n = "1234" Output: "1243"
	 * 
	 * Input: n = "4321" Output: "Not Possible"
	 * 
	 * Input: n = "534976" Output: "536479"
	 * 
	 * ALGORITHM: ---------
	 * 
	 * Following are few observations about the next greater number:
	 * -------------------------------------------------------------- 
	 * 1) If all
	 * digits sorted in descending order, then output is always “Not Possible”.
	 * For example, 4321. 2) If all digits are sorted in ascending order, then
	 * we need to swap last two digits. For example, 1234. 3) For other cases,
	 * we need to process the number from rightmost side (why? because we need
	 * to find the smallest of all greater numbers)
	 * 
	 * You can now try developing an algorithm yourself:
	 * -------------------------------------------------
	 * 
	 * Following is the algorithm for finding the next greater number. I)
	 * Traverse the given number from rightmost digit, keep traversing till you
	 * find a digit which is smaller than the previously traversed digit. For
	 * example, if the input number is “534976”, we stop at 4 because 4 is
	 * smaller than next digit 9. If we do not find such a digit, then output is
	 * “Not Possible”.
	 * 
	 * II) Now search the right side of above found digit ‘d’ for the smallest
	 * digit greater than ‘d’. For “534976″, the right side of 4 contains “976”.
	 * The smallest digit greater than 4 is 6.
	 * 
	 * III) Swap the above found two digits, we get 536974 in above example.
	 * 
	 * IV) Now sort all digits from position next to ‘d’ to the end of number.
	 * The number that we get after sorting is the output. For above example, we
	 * sort digits in bold 536974. We get “536479” which is the next greater
	 * number for input 534976.
	 */
	private static int methodTwo(int input) {
		String inputString = String.valueOf(input);
		String[] strArr = inputString.split("");
		Arrays.sort(strArr, Collections.reverseOrder());
		int strArrLength = strArr.length;
		String largest = "";
		for (int i = 0; i < strArrLength; i++) {
			largest += strArr[i];
		}
		int largestNumber = Integer.parseInt(largest);
		//System.out.println(largestNumber);
		if (largestNumber == input) {
			return 0;
		} else {
			int count = 0;
			while (input < largestNumber) {
				inputString = String.valueOf(input);
				char[] inputChar = inputString.toCharArray();
				int charLength = inputChar.length;

				// I) Start from the right most digit and find the first digit
				// that is
				// smaller than the digit next to it.
				int i = 0;
				for (i = charLength - 1; i > 0; --i) {
					if (inputChar[i] > inputChar[i - 1]) {
						break;
					}
				}
				// II) Find the smallest digit on right side of (i-1)'th digit
				// that is
				// greater than number[i-1]
				int currentIndex = i - 1;
				int x = inputChar[i - 1];
				int tempMin = inputChar[i - 1];
				int min = 111;
				int minIndex = i - 1;
				for (int j = currentIndex + 1; j < charLength; ++j) {

					if (inputChar[j] > x) {
						tempMin = inputChar[j];
					}
					if (tempMin < min) {
						min = tempMin;
						minIndex = j;
					}
				}

				char temp = inputChar[currentIndex];
				inputChar[currentIndex] = inputChar[minIndex];
				inputChar[minIndex] = temp;

				Arrays.sort(inputChar, currentIndex + 1, charLength);

				input = Integer.parseInt(String.valueOf(inputChar));
				++count;
			}
			return count;
		}
	}

	private static int methodOne(int input) {
		Set<String> possibleNumbers = findAllPossibleNumbers(String
				.valueOf(input));
		System.out.println("possibleNumbers : " + possibleNumbers.size());

		TreeSet<Integer> requiredNumbers = findRequiredNumbers(possibleNumbers,
				input);
		//System.out.println("requiredNumbers : " + requiredNumbers.size());
		return requiredNumbers.size();
	}

	private static TreeSet<Integer> findRequiredNumbers(
			Set<String> possibleNumbers, int inputNumber) {
		TreeSet<Integer> tempSet = new TreeSet<Integer>();

		Iterator<String> itr = possibleNumbers.iterator();

		while (itr.hasNext()) {
			tempSet.add(Integer.parseInt(itr.next()));
		}
		return (TreeSet<Integer>) tempSet.tailSet(inputNumber + 1);
	}

	private static Set<String> findAllPossibleNumbers(String str) {

		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = findAllPossibleNumbers(rem);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(formWord(strNew, initial, i));
			}
		}
		return perm;

	}

	private static String formWord(String numberStr, char firstChar, int i) {
		String start = numberStr.substring(0, i);
		String end = numberStr.substring(i);
		return start + firstChar + end;
	}

}

/*
 * Arrays.sort(strArr); 
 * String smallest=""; 
 * for (int i = 0; i < strArrLength;i++) { 
 * smallest+=strArr[i]; 
 * } 
 * int smallestNumber=Integer.parseInt(smallest);
 * System.out.println(smallestNumber); 
 * char[]
 * inputChar=inputString.toCharArray(); 
 * int charLength=inputChar.length;
 * if(smallestNumber == input){ 
 * char temp =inputChar[charLength-1];
 * inputChar[charLength-1]=inputChar[charLength-2];
 * inputChar[charLength-2]=temp;
 * System.out.println("ascending orsder :"+String.valueOf(inputChar)); 
 * } else{
 */