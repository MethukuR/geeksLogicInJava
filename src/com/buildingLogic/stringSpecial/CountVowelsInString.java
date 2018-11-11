package com.buildingLogic.stringSpecial;
/**
 *  Problem: You are given with a String, you have to output count of vowels in the String.
	Input: Input contains a String.
	Output: Print vowel count in the String.
	Constraints: 1≤ String lenght ≤1000
	Sample Input: Dcoder,A mobile coding platform
	Sample Output: 
	10
	
 * @author Raju Rockzz :P
 *
 */
public class CountVowelsInString {

	public static void main(String[] args) {
		String inputString="Dcoder,A mobile coding platform";
		
		int vowelCount=findTheVowelCountOne(inputString);
		System.out.println(vowelCount);
		
		vowelCount=findTheVowelCountTwo(inputString);
		System.out.println(vowelCount);
	}

	private static int findTheVowelCountTwo(String inputString) {
		int inputStringLength=inputString.length();
		int vowels=0;
		for (int i = 0; i < inputStringLength; ++i) {
			String j=inputString.substring(i,i+1);
			if (j.equalsIgnoreCase("a") == true)
			    vowels++;
			  else if (j.equalsIgnoreCase("e") == true)
			    vowels++;
			  else if (j.equalsIgnoreCase("i") == true)
			    vowels++;
			  else if (j.equalsIgnoreCase("o") == true)
			    vowels++;
			  else if (j.equalsIgnoreCase("u") == true)
			    vowels++;
		}
		return vowels;
	}

	private static int findTheVowelCountOne(String inputString) {
		int inputStringLength=inputString.length();
		int count=0;
		for (int i = 0; i < inputStringLength; ++i) {
			if(inputString.charAt(i) == 'a' 
			  || inputString.charAt(i) == 'A' 
			  || inputString.charAt(i) == 'e' 
			  || inputString.charAt(i) == 'E' 
			  || inputString.charAt(i) == 'i' 
			  || inputString.charAt(i) == 'I' 
			  || inputString.charAt(i) == 'o' 
			  || inputString.charAt(i) == 'O' 
			  || inputString.charAt(i) == 'u' 
			  || inputString.charAt(i) == 'U' 
			){
				++count;
			}
		}
		return count;
	}

}
