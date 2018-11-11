/**
 *  Problem: The problem is simple, you are given a word. You need to remove the repeating characters.
	Input: Input contains a word w.
	Output: Print the output according to the problem explained.
	Constraints: 1 ≤ w.length ≤ 100
	Sample Input: AaabBbbc
	Sample Output: 
	AabBc

 * 	@author Raju Rockzz :P
 */
package com.buildingLogic.stringSpecial;

import java.util.LinkedHashSet;


public class IDontLikeRepetition {

	public static void main(String[] args) {
		String inputStr="AaabBbbc";
		String outputString=null;
		outputString=removeDuplicateCharacters(inputStr);
		System.out.println("outputString :: "+outputString);
	}
	
	static String removeDuplicateCharacters(String inputStr){
		int inputStrLength=inputStr.length();
		String outputString="";
		
		LinkedHashSet<Character> uniqueString= new LinkedHashSet<Character>(inputStrLength); 
		
		for (int i = 0; i < inputStrLength; ++i) {
			if(uniqueString.add(inputStr.charAt(i))){
				outputString+=inputStr.charAt(i);
			}
		}
		/*Iterator<Character> itr=uniqueString.iterator();
		while(itr.hasNext()){
			outputString+=itr.next();
		}*/
		return outputString;
	}

}
