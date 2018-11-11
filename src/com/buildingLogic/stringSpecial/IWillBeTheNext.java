/**
 *  Problem: You are given a string, you have to convert each letter in the string with the next one.For 
 *  example a becomes b and C becomes D.
	Input: Input contains a string s.
	Output: Print the manipulated string according to the problem.
	Constraints: 1≤length of string≤100
	Sample Input: Dcoder
	Sample Output: 
	Edpefs
	
 * @author Raju Rockzz :P
 */
package com.buildingLogic.stringSpecial;

public class IWillBeTheNext {

	public static void main(String[] args) {
		String inputString="DeCodeR";
		String outputString=replaceWithNextChar(inputString);
		System.out.println("outputString : "+outputString);
		
	}
	static String replaceWithNextChar(String inputString){
		int inputStringLength=inputString.length();
		String outputString="";
		for (int i = 0; i < inputStringLength; i++) {
			int charValue=inputString.charAt(i)+1;
			outputString+=(char)charValue;
		}
		return outputString;
	}
}
