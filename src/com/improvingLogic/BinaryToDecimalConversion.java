package com.improvingLogic;

import java.util.Scanner;

public class BinaryToDecimalConversion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Binary String");
		String inputStr=s.nextLine();
		findDecimal(inputStr);
	}
    static void findDecimal(String inputStr){
    	int strLength=inputStr.length();
    	int power=0;
    	int sum=0;
    	char[] charStr=inputStr.toCharArray();
    	for (int i =strLength-1; i >= 0 ; i--) {
    		int charValue=charStr[i]-48;
    		sum+=charValue*Math.pow(2, power);
    		power++;
		}
    	System.out.println(sum);
    			
    }
}
