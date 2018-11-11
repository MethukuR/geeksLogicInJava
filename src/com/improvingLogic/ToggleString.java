package com.improvingLogic;
/**
 * You have been given a String S
consisting of uppercase and lowercase English alphabets. You need to change the case of each 
alphabet in this String. That is, all the uppercase letters should be converted to lowercase and 
all the lowercase letters should be converted to uppercase. You need to then print the resultant 
String to output.

Input Format
The first and only line of input contains the String S


Output Format
Print the resultant String on a single line.

Constraints:
===========
 1≤|S|≤100  where |S| denotes the length of string S.
 
SAMPLE INPUT:
============ 
abcdE

SAMPLE OUTPUT :
===============
ABCDe
 * 
 * @author Raju Rockzz :P
 *
 */
public class ToggleString {

	public static void main(String[] args) {
		String inpStr="abcdE";
		String outputStr=findToggledString(inpStr);
		
		System.out.println("outputStr : "+outputStr);

	}
	
	static String findToggledString(String inpStr){
		String outputStr="";
		int inpStrLength=inpStr.length();
		for (int i = 0; i < inpStrLength; i++) {
			int charValue=inpStr.charAt(i);
			if(charValue >= 65 && charValue <= 90){
				outputStr+=(char)(charValue+32);
			}
			else if(charValue >= 97 && charValue <= 122){
				outputStr+=(char)(charValue-32);
			}
		}
		return outputStr;
	}

}
