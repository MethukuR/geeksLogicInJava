package com.buildingLogic.stringSpecial;

import java.util.Arrays;

/**
 * Write a java program or function to find the longest substring without repeating characters in a 
 * given string. For example, if “javaconceptoftheday” is the input string, then the longest substring 
 * without repeating or duplicate characters is “oftheday” and its length is 8.


 
How To Find Longest Substring Without Repeating Characters In Java?(using collections)

Step 1 : Convert the given inputString to an array of characters called charArray.

char[] charArray = inputString.toCharArray();

Step 2 : Initialize longestSubstring to null and longestSubstringLength to 0.

String longestSubstring = null;

int longestSubstringLength = 0;

Step 3 : Define one LinkedHashMap called charPosMap. It will hold characters of inputString as keys and their position as values. Here, we have used LinkedHashMap instead of HashMap because it maintains the insertion order of elements.

LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>();

Step 4 : For every char ch in charArray, check whether it is already present in charPosMap. If it is not present, add this char to charPosMap along with its position.

if(!charPosMap.containsKey(ch))
{
        charPosMap.put(ch, i);
}

Step 5 : If char ch is present in charPosMap, reposition the cursor i to the position of ch and clear the charPosMap. 

i = charPosMap.get(ch);

charPosMap.clear();

Step 6 : Check whether the size of charPosMap is greater than longestSubstringLength. If it is greater than longestSubstringLength, assign the size of charPosMap to longestSubstringLength and its keySet to longestSubstring.

if(charPosMap.size() > longestSubstringLength)
{
        longestSubstringLength = charPosMap.size();

        longestSubstring = charPosMap.keySet().toString();
}

Step 7 : Print longestSubstring and longestSubstringLength.
 * @author Raju Rockzzz :P
 *
 */
public class LongestSubStringWithOutRepeatingCharacters {

	public static void main(String[] args) {
		String inputStr="javaconceptoftheday";
		findSubString(inputStr);
	}
	
	static String findSubString(String inputStr){
		String longestSubString="";
		String tempLongestSubString="";

		int longestSubStringLength=0;
		int tempLongestSubStringLength=0;
		
		char[] inpCharArr=inputStr.toCharArray();
		int inpCharArrLength=inpCharArr.length;
		char[] tempArr=new char[inpCharArrLength];
		int tempIndex=0;
		
		for (int i = 0; i < inpCharArrLength; ++i) {
			tempArr[tempIndex]=inpCharArr[i];
			if(!alreadyExists(tempArr[tempIndex], tempArr, tempIndex)){
				tempLongestSubString+=tempArr[tempIndex];
				++tempLongestSubStringLength;
				++tempIndex;
			}
			else{
				if(tempLongestSubStringLength>longestSubStringLength){
					longestSubStringLength=tempLongestSubStringLength;
					longestSubString=tempLongestSubString;
				}
				int repeatedCharIndex=tempLongestSubString.indexOf(tempArr[tempIndex]);
				tempLongestSubString=tempLongestSubString.substring(repeatedCharIndex,tempLongestSubStringLength-1);
				tempLongestSubStringLength=tempLongestSubString.length();
				tempArr=Arrays.copyOf(tempLongestSubString.toCharArray(), inpCharArrLength);
				tempIndex=tempLongestSubStringLength;
			}
		}
		if(tempLongestSubStringLength>longestSubStringLength){
			longestSubStringLength=tempLongestSubStringLength;
			longestSubString=tempLongestSubString;
		}
		System.out.println("longestSubStringLength::"+longestSubStringLength);
		System.out.println("longestSubString:::"+longestSubString);
		return longestSubString;
	}
	
	static boolean alreadyExists(char tempValue, char[] tempArr,int tempIndex){
		boolean status = false;
		int tempArrLength=tempArr.length;
		for (int i = 0; i < tempArrLength && (i!=tempIndex); ++i) {
			if(tempArr[i] == tempValue){
				status=true;
				break;
			}
		}
		return status;
	}
	
	static void findLongSubString(String inputStr){
		
	}

}
