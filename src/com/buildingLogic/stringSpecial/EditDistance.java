package com.buildingLogic.stringSpecial;

/*
 * Check if edit distance between two strings is one
An edit between two strings is one of the following changes.

Add a character
Delete a character
Change a character

Given two string s1 and s2, find if s1 can be converted to s2 
with exactly one edit. Expected time complexity is O(m+n) where
 m and n are lengths of two strings.

Examples:

Input:  s1 = "geeks", s2 = "geek"
Output: yes
Number of edits is 1

Input:  s1 = "geeks", s2 = "geeks"
Output: no
Number of edits is 0

Input:  s1 = "geaks", s2 = "geeks"
Output: yes
Number of edits is 1

Input:  s1 = "peaks", s2 = "geeks"
Output: no
Number of edits is 2


A Simple Solution is to find Edit Distance using Dynamic 
programming. If distance is 1, then return true, else return 
false. Time complexity of this solution is O(n^2)

An Efficient Solution is to simultaneously traverse both strings 
and keep track of count of different characters. Below is 
complete algorithm.

Let the input strings be s1 and s2 and lengths of input 
strings be m and n respectively.

1) If difference between m an n is more than 1, 
     return false.
2) Initialize count of edits as 0.
3) Start traversing both strings from first character.
    a) If current characters don't match, then
       (i)   Increment count of edits
       (ii)  If count becomes more than 1, return false
       (iii) If length of one string is more, then only
             possible  edit is to remove a character.
             Therefore, move ahead in larger string.
       (iv)  If length is same, then only possible edit
             is to  change a character. Therefore, move
             ahead in both strings. 
    b) Else, move ahead in both strings.
 */
public class EditDistance {

	public static void main(String[] args) {
		
		String stringOne="geeks";
		String stringTwo="geeks";
		
		if(isEditDistanceOne(stringOne ,stringTwo)){
			System.out.println("Yes");
		}else{  
			System.out.println("No");
		}						
	}
	
	static boolean isEditDistanceOne(String stringOne, String stringTwo){
		int stringOneLength=stringOne.length();
		int stringTwoLength=stringTwo.length();
		
		// If difference between lengths is more than
	    // 1, then strings can't be at one Edit distance
		if(Math.abs(stringOneLength-stringTwoLength)>1){
			return false;
		}
		int count=0;// Count of edits
		int stringOneIndex=0;
		int stringTwoIndex=0;
		char[] strOneArray=stringOne.toCharArray();
		char[] strTwoArray=stringTwo.toCharArray();
		
		while((stringOneIndex<stringOneLength) && (stringTwoIndex<stringTwoLength)){					
			 // If current characters don't match
			if(strOneArray[stringOneIndex]!= strTwoArray[stringTwoIndex]){
				if(count==1){
					return false;
				}
				// If length of one string is
	            // more, then only possible edit
	            // is to remove a character
				if(stringOneLength > stringTwoLength){
					++stringOneIndex;
				}else if(stringOneLength < stringTwoLength){
					++stringTwoIndex;
				}else{
					++stringOneIndex;
					++stringTwoIndex;
				}
				++count; // Increment count of edits
			}
			// If current characters match
			else{
				++stringOneIndex;
				++stringTwoIndex;
			}						
		}
		
		// If last character is extra in any string
		if((stringOneIndex < stringOneLength) || (stringTwoIndex < stringTwoLength)){				
			++count;
		}
		return count==1;
		
	}

}
