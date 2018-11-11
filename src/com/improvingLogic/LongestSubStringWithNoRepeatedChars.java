package com.improvingLogic;

/**
 *  Length of the longest substring without repeating characters:
	Given a string, find the length of the longest substring without repeating characters. For example, 
	the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, 
	with length 6. For “BBBB” the longest substring is “B”, with length 1.

 * @author Raju Rockzz :P
 *
 */
public class LongestSubStringWithNoRepeatedChars {

	public static void main(String[] args) {
		String inputStr="GEEKSFORGEEKS";
		findRequiredSubString(inputStr);
	}
	
	static void findRequiredSubString(String inputStr){
		
		String tempString="";
		int tempStringLength=tempString.length();
		
		String finalString="";
		int finalStringLength=finalString.length();
		
		int startIndex=0;
		int endIndex=0;
		
		int inputStrLength=inputStr.length();
		
		for (int i = 0; i < inputStrLength; i++) {
			char value=inputStr.charAt(i);
			tempString+=value;
			if(alreadyExists(tempString)){
				int index=tempString.indexOf(value);
				tempString=tempString.substring(index+1,tempString.length());
			}
			
			tempStringLength=tempString.length();
			finalStringLength=finalString.length();
			if(finalStringLength <= tempStringLength){
				finalString=tempString;
				finalStringLength=tempStringLength;
				endIndex=i;
				startIndex=endIndex-finalStringLength+1;
				
			}
		}
		
		System.out.println("finalString : "+finalString);
		System.out.println("finalStringLength : "+finalStringLength);
		System.out.println("startIndex : "+ startIndex);
		System.out.println("endIndex : "+endIndex);
		
	}
	
	static boolean alreadyExists(String tempString){
		boolean status =false;
		char value = 0;
		int tempStringLength=tempString.length();
		if(tempStringLength > 0){
			value=tempString.charAt(tempStringLength-1);
		}
	 
		for (int i = 0;(tempStringLength > 0)&& i < tempStringLength-1; ++i) {
			if(tempString.charAt(i) == value){
				status=true;
			}
		}
		return status;
	}
	

}
