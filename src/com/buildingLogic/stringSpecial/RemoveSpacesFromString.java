package com.buildingLogic.stringSpecial;
/**
 * 
 */

/**
 * @author laxminarasimha.m
 *Given a string, remove all spaces from the string and return it.

  Input:  "g  eeks   for ge  eeks  "
  Output: "geeksforgeeks"
  
  Below is a Simple Solution

1) Iterate through all characters of given string, do following
   a) If current character is a space, then move all subsequent
      characters one position back and decrease length of the 
      result string.
Time complexity of above solution is O(n2).

A Better Solution can solve it in O(n) time. The idea is to keep track of count of non-space 
character seen so far.

1) Initialize 'count' = 0 (Count of non-space character seen so far)
2) Iterate through all characters of given string, do following
     a) If current character is non-space, then put this character
        at index 'count' and increment 'count'
3) Finally, put '\0' at index 'count'
 */
public class RemoveSpacesFromString {

	
	public static void main(String[] args) {
		String inputStr="gee k   s fo r  ge e k s ";
		removeSpaces(inputStr);
		
	}
	
   static void  removeSpaces(String inputStr){
		int inputStrLength=inputStr.length();
		int noSpaceCount=0;
		char[] inputCharArray=inputStr.toCharArray();
		for(int charIndex=0; charIndex < inputStrLength;++charIndex){
			if(inputCharArray[charIndex] != ' '){
				inputCharArray[noSpaceCount++] = inputCharArray[charIndex];
			}
		}
		for(int index=noSpaceCount; index<inputStrLength ; ++index){
			inputCharArray[noSpaceCount++]=' ';
		}
		String finalStr1=String.valueOf(inputCharArray);
		System.out.println("Final Space Removed String ::"+finalStr1);
	
	 //Method 2   
	   String outStr = inputStr.replaceAll("\\s","");
	   System.out.println(outStr);
   
   
   }

}
