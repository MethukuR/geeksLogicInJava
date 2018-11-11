package com.buildingLogic.stringSpecial;
/*
 * Reverse an array without affecting special characters
Given a string, that contains special character together with 
alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a 
way that special characters are not affected.

Examples:

Input:   str = "a,b$c"
Output:  str = "c,b$a"
Note that $ and , are not moved anywhere.  
Only subsequence "abc" is reversed

Input:   str = "Ab,c,de!$"
Output:  str = "ed,c,bA!$"


Simple Solution:
1) Create a temporary character array say temp[].
2) Copy alphabetic characters from given array to temp[].
3) Reverse temp[] using standard string reversal algorithm.
4) Now traverse input string and temp in a single loop. Wherever
 there is alphabetic character is input string, replace it with 
 current character of temp[].

Efficient Solution:
Time complexity of above solution is O(n), but it requires extra 
space and it does two traversals of input string.
We can reverse with one traversal and without extra space. Below 
is algorithm.

1) Let input string be 'str[]' and length of string be 'n'
2) l = 0, r = n-1
3) While l is smaller than r, do following
    a) If str[l] is not an alphabetic character, do l++
    b) Else If str[r] is not an alphabetic character, do r--
    c) Else swap str[l] and str[r]
 */
public class ReverseStrIgnoreSplChar {

	public static void main(String[] args) {
		String inputString="ab,c$d";
		reverseIgnoringSplChar(inputString);
	}
	
	static boolean isAlphabet(char value){
		if((value >='A' && value<='Z') || (value >='a' && value<='z')){
			return true;
		}else{
			return false;
		}
	}
	
	static void reverseIgnoringSplChar(String inputString){
		int inputStringLength=inputString.length();
		int firstIndex=0;
		int lastIndex=inputStringLength-1;
		
		char[] inputStringArray=inputString.toCharArray();
		while(firstIndex<lastIndex){
			if(!isAlphabet(inputStringArray[firstIndex])){
				++firstIndex;
			}else if(!isAlphabet(inputStringArray[lastIndex])){
				--lastIndex;
			}else{
				char tempChar=inputStringArray[firstIndex];
				inputStringArray[firstIndex]=inputStringArray[lastIndex];
				inputStringArray[lastIndex]=tempChar;
				++firstIndex;
				--lastIndex;
			}
		}
		
		System.out.println("Reversed String :"+String.valueOf(inputStringArray));
		
	}
}


