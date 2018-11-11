package com.buildingLogic.stringSpecial;

import java.util.regex.Pattern;

public class PatternMatching {

	public static void main(String[] args) {
		numberOrNot();
		sixDigitOrNot();
	}

	private static void sixDigitOrNot() {
		
	}

	private static void numberOrNot() {
		String [] inputs = {"123", "-123" , "123.12", "abcd123"};
		Pattern pattern= Pattern.compile("(([+]|[-])|[0-9]+).[0-9]+");
		for(String input: inputs){
	           System.out.println( "does " + input + " is number : "
	                                + pattern.matcher(input).matches());
	       }
	}

}
