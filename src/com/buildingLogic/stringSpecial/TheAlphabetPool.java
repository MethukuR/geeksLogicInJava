package com.buildingLogic.stringSpecial;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *  Problem: You are given a string, you have to arrange its letters in alphabetical order.In case of 
 *  capital and small letter occurrence capital will be used first.
	Input: First line contains a number n, next n lines contain a string s each.
	Output: Print the alphabetical ordered string for each of n strings.
	Constraints: 1≤n≤100
	1≤length of string≤1000
	Sample Input:
	------------- 
	2
	Dcoder
	CompilEr
	
	Sample Output:
	-------------- 
	cDdeor
	CEilmopr
	
 * @author Raju Rockzz :P
 * 
 *
 */
public class TheAlphabetPool {

	public static void main(String[] args) {
			String inputStr="Dcoder";
			String orderedString="";
			orderedString=arrangeInAlphabeticalOrderOne(inputStr);
			System.out.println("orderedString : "+orderedString);
			
			orderedString=arrangeInAlphabeticalOrderTwo(inputStr);
			System.out.println("orderedString : "+orderedString);
	}

	private static String arrangeInAlphabeticalOrderTwo(String inputStr) {
		String orderedString="";
		int inputStrLength=inputStr.length();
		TreeSet<Character> ts = new TreeSet<Character>(new MyComparator());
		for (int i = 0; i <inputStrLength; ++i) {
			ts.add(inputStr.charAt(i));
		}
		
		Iterator<Character> itr= ts.iterator();
		
		while(itr.hasNext()){
			orderedString+=itr.next();
		}
		return orderedString;
	}

	private static String arrangeInAlphabeticalOrderOne(String inputStr) {
		String orderedString="";
		String orderedStringOne="";
		int inputStrLength=inputStr.length();
		
		
		String[] inpuStrArr=inputStr.split("");
		int inputStrArrLength=inpuStrArr.length;
		Arrays.sort(inpuStrArr,String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < inputStrArrLength; i++) {
			orderedString+=inpuStrArr[i];
		}
		
		// OR
		
		Character[] inputChars= new Character[inputStrLength];
		
		for (int i = 0; i < inputStrLength; ++i) {
			inputChars[i]=inputStr.charAt(i);
		}
		
		Arrays.sort(inputChars,new MyComparator());
		
		for (int i = 0; i < inputStrLength; i++) {
			orderedStringOne+=inputChars[i];
		}
		return orderedStringOne;
	}

}

class MyComparator implements Comparator<Character>{
	@Override
	public int compare(Character c1, Character c2) {
		
		int cmp=Character.compare(
				Character.toLowerCase(c1.charValue()),
				Character.toLowerCase(c2.charValue())
				);
		
		if(cmp != 0){
			return cmp;
		}
		else{
			 return Character.compare(c1.charValue(), c2.charValue());
		}
		
	}
	
	/*public int compare(Object obj1, Object obj2){
		String s1 = obj1.toString();
		String s2 = obj2.toString();
		
		return s1.compareTo(s2);
	}*/
}
