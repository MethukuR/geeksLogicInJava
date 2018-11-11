package com.buildingLogic.stringSpecial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Title: Where am I!!
 *  ===================
	Problem: You are given 2 strings P and Q, you need to find out whether Q is a part 
	of P ie. Q is substring inside P, if yes output the starting index of the Q in P 
	else print "-1" without quotes.
	Input: First line contains P and next line contains Q.
	Output: Print index of Q in P if exist else print -1.
	Constraints: 1 ≤ String lenght ≤ 1000
	Sample Input: I Love Dcoder
	Dcoder
	Sample Output: 
	7
 * @author Ranger Raju :P
 *
 */
public class WhereAmI {

	public static void main(String[] args) {
		String p="I Love Dcoder";
		String q="Dcoder";
		
		int index=getIndexInGivenString(p,q);
		System.out.println(index);
	}

	private static int getIndexInGivenString(String p, String q) {

		Pattern pat=Pattern.compile(q);
		Matcher m= pat.matcher(p);
		
		if(m.find()){
			return m.start();
		}
		return -1;
	}

}
