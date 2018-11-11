package com.buildingLogic.stringSpecial;
import java.util.HashMap;

/*
 * Check if two given strings are isomorphic to each other:
 * --------------------------------------------------------
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every 
character of str1 to every character of str2. And all occurrences of every character in ‘str1′ map to 
same character in ‘str2′

Examples:

Input:  str1 = "aab", str2 = "xxy"
Output: True
'a' is mapped to 'x' and 'b' is mapped to 'y'.

Input:  str1 = "aab", str2 = "xyz"
Output: False
One occurrence of 'a' in str1 has 'x' in str2 and 
other occurrence of 'a' has 'y'.




A Simple Solution is to consider every character of ‘str1′ and check if all occurrences of 
it map to same character in ‘str2′. Time complexity of this solution is O(n*n).

An Efficient Solution can solve this problem in O(n) time. The idea is to create an array 
to store mappings of processed characters.

1) If lengths of str1 and str2 are not same, return false.
2) Do following for every character in str1 and str2
   a) If this character is seen first time in str1, 
      then current of str2 must have not appeared before.
      (i) If current character of str2 is seen, return false.
          Mark current character of str2 as visited.
      (ii) Store mapping of current characters.
   b) Else check if previous occurrence of str1[i] mapped
      to same character.
 */
public class IsomorphicStrings {
	static final int MAX_CHARS=256;
	public static void main(String[] args) {
		String strOne="xxy";
		String strTwo="aay";
		
		boolean status=isIsomorphic(strOne,strTwo);
		if(status)
			System.out.println("Two strings are Isomorphic");
		else
			System.out.println("Two strings are not Isomorphic");
	}
	
	static boolean isIsomorphic(String strOne, String strTwo){
		
		int strOneLength=strOne.length();
		int strTwoLength=strTwo.length();
		
		if(strOneLength != strTwoLength){
			return false;
		}
		else{
			boolean[] marked= new boolean[MAX_CHARS];
			char[] strOneChars=strOne.toCharArray();
			char[] strTwoChars=strTwo.toCharArray();
			HashMap<Character, Character> mapping=new HashMap<Character, Character>();
			for(int charIndex=0;charIndex<strOneLength;++charIndex){
				if(!marked[strOneChars[charIndex]]){
					if(!marked[strTwoChars[charIndex]]){
						mapping.put(strOneChars[charIndex],strTwoChars[charIndex]);
						marked[strOneChars[charIndex]]=true;
						marked[strTwoChars[charIndex]]=true;
					}
					else{
						return false;
					}
				}
				else{
					if(mapping.get(strOneChars[charIndex])!=strTwoChars[charIndex]){
						return false;
					}
				}
			}
			return true;
		}
		
	}
}
