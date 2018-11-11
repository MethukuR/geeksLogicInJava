package com.buildingLogic.stringSpecial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *  Problem: This problem deals with compression.You need to compress a given string and the rule is 
 *  simple while reading string character by character if any character repeats, replace the repeated 
 *  part with number of its occurance.
	For example:  if a String has 'd' repeated 4 times, replace this "dddd" with "d4".
	PS: Your algorithm should make compress version of String only if after your compression algorithm 
	you get a string which is bigger/longer than the given, in that case output the given String.
	Input: Input contains a String s
	Output: Print the number of numbers greater than n.
	Constraints: 1≤s.length≤100
	Sample Input: dddccfgh
	Sample Output: 
	d3c2fgh
 * 
 * @author Raju Rockzz :P
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		String inputString="dddccfgh";
		String outputString="";
		outputString=findCompressedString(inputString);
		System.out.println("outputString : "+outputString);
	}
	
	static String findCompressedString(String inputString){
		String outputString="";
		int inputLength=inputString.length();
		LinkedHashMap<Character,Integer> hs= new LinkedHashMap<Character,Integer>(inputLength);
		for (int i = 0; i < inputLength; ++i) {
			char c=inputString.charAt(i);
			if(hs.containsKey(c)){
				hs.put(c,hs.get(c)+1);
			}
			else{
				hs.put(c,1);
			}
		}
		/*ArrayList<Integer> al=(ArrayList<Integer>) hs.values();
		Integer[] a=(Integer[]) al.toArray();*/
		Iterator<Entry<Character, Integer>> it = hs.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if((int)pair.getValue() > 1){
	        	outputString+=pair.getKey()+""+pair.getValue();
	        }
	        else{
	        	outputString+=(char)pair.getKey();
	        }
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
		 
		return outputString;
	}
}
