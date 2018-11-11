package com.buildingLogic.numberSpecial;
/**
 *  Problem: Mark is from a very superstitious cult. He believes that number '6' and 
 *  its multiples are number of the Devil, and avoids writing it. So write a code 
 *  that will repalce each and every digit in the multiple of the number '6' with 
 *  an astrix '*'. eg. if input number is '6', output will be '*', or if input 
 *  number is '24', output will be '**', or if input number is '300', the output 
 *  will be '***'. You will be given an input in form of an array(non-zero array 
 *  DUH!).

	Input: First line of input will contains 'n', the number of elements in the array. 
	Second line of the input will contain the elements of the array.
	Output: The output will print the array by replacing the multiples of '6' with astrix '*'.
	Constraints: Number of elements in array = n and 0 < n < 100. 
	0 ≤ And the elements of array < 1000.
	ZERO (0) is not a multiple of '6'.
	Sample Input: 5
	5 15 26 18 0
	Sample Output: 
	5 15 26 ** 0
 * @author Dangal Raju Rockzz :P
 *
 */
public class NumberOfTheBeast {

	public static void main(String[] args) {
		int inputNumber=300;
		replaceBeastNumbersWithStarOne(inputNumber);
		replaceBeastNumbersWithStarTwo(inputNumber);
	}

	private static void replaceBeastNumbersWithStarOne(int inputNumber) {
		String outputString=String.valueOf(inputNumber);
		if(inputNumber % 6 == 0){
			char[] inputStringChar=String.valueOf(inputNumber).toCharArray();
			int inputStringCharLength=inputStringChar.length;
			for (int i = 0; i < inputStringCharLength; i++) {
				inputStringChar[i]='*';
			}
			outputString=String.valueOf(inputStringChar);
		}
		System.out.println("outputString : "+outputString);
	}
	
	private static void replaceBeastNumbersWithStarTwo(int inputNumber) {
		String outputString=String.valueOf(inputNumber);
		if(inputNumber % 6 == 0){
			outputString=outputString.replaceAll("[0-9]", "*");
		}
		System.out.println("outputString : "+outputString);
	}

}
