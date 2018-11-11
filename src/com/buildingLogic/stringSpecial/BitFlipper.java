package com.buildingLogic.stringSpecial;
/**
 * 	Problem: You are given a binary number, you just need to flip each and every bit of it ie. 1 turns to 
 *  0 and 0 turns to 1.
	Input: Input contains a binary number.
	Output: Print the flipped binary number.
	Constraints: The binary number can be any binary number of 0 bit to 32 bit.
	Sample Input: 11100110101
	Sample Output: 
	00011001010
 
 * @author Raju Rockzz :P
 *
 */
public class BitFlipper {

	public static void main(String[] args) {
		String inputNumber="1100101011";
		int inputLength=inputNumber.length();
		String outputString="";
		for (int i = 0; i < inputLength; ++i) {
			outputString+=flipBit(inputNumber.charAt(i));
		}
		System.out.println("outputString :: "+outputString);

	}
	static char flipBit(char value){
		if(value == '0'){
			return '1';
		}
		else{
			return '0';
		}
	}

}
