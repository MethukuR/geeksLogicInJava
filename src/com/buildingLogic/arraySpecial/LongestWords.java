package com.buildingLogic.arraySpecial;

import java.util.ArrayList;
import java.util.List;

public class LongestWords {

	public static void main(String[] args) {
		String[] dictionary = new String[] {"like",
				  "love",
				  "hate",
				  "yes"};
		List<String> words = longestWords(dictionary);
		System.out.println(words);

	}
	
	/*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public static List<String> longestWords(String[] dictionary) {
    	List<String> lWords = null;
     	int lengthOfLongestWord = 0;
     	
     	for (String word : dictionary) {
     		int wordLength = word.length();
     		if(wordLength > lengthOfLongestWord) {
     			lengthOfLongestWord = wordLength;
     			lWords = new ArrayList<String>();
     			lWords.add(word);
     		}else if(wordLength == lengthOfLongestWord) {
     			lWords.add(word);
     		}
 		}
     	return lWords;
    }

}
