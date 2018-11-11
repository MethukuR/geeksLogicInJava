package com.improvingLogic;

import java.util.HashMap;

public class SecondRepeatedCharacter {

	public static void main(String[] args) {
		String inputStr= "Bas";
		
		char secondRepeatedChar=findSecondRepeatedChar(inputStr);
		if(secondRepeatedChar != ' '){
			System.out.println("Second Repeated character is "+secondRepeatedChar);
		}
		else{
			System.out.println("No such char exists");
		}

	}
	
	static char findSecondRepeatedChar(String inputStr){
		char secondRepeatedChar=' ';
		int count=0;
		HashMap<Character,Integer> charsCount= new HashMap<Character,Integer>();
		char[] inputCharArr=inputStr.toCharArray();
		for(char charIndex:inputCharArr){
			if(charsCount.containsKey(charIndex)){
				charsCount.put(charIndex, charsCount.get(charIndex)+1);
				++count;
				if(count == 2){
					secondRepeatedChar=charIndex;
				}
			}
			else{
				charsCount.put(charIndex,1);
			}
		}
		return secondRepeatedChar;
	}

}
