/**
 * 
 */
package com.improvingLogic;

import java.util.Arrays;

/**
 * @author Raju MLN
 *
 */
public class SortString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String originalStr="ÈDed,CBcbA‡,a";
		
		String commaRemovedString = originalStr.replace(",","");
		
		System.out.println("commaRemovedString: "+commaRemovedString);
		
		char[] charConvertedString=commaRemovedString.toCharArray();
		for(char charIndex:charConvertedString){
			System.out.print(charIndex);
		}
		System.out.println("\n");
		
		Arrays.sort(charConvertedString);
		String sortedString=String.valueOf(charConvertedString);
		System.out.println("sortedString:"+sortedString);

	}

}
