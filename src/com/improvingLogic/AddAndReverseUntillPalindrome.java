package com.improvingLogic;

import java.util.Scanner;

public class AddAndReverseUntillPalindrome {
	public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
		 System.out.println("Enter the number");
		 int input=s.nextInt();
		 int result=findReverse(input);
		 System.out.println("The Addition :"+result);
		 String inputStr=Integer.toString(result);
		 boolean palindrom=isPalindrome(inputStr);
		 if(palindrom){
			 System.out.println("It is palindrome");
		 }
		 else{
			 System.out.println("Not");
		 }
		 s.close();
	}
	
	static int findReverse(int input){
		int temp=input;
		String inputStr="";
		int remainder=0;
		while(input!=0){
			remainder=input%10;
			inputStr=inputStr+remainder;
			input/=10;
		}
		int reverse=Integer.parseInt(inputStr);
		System.out.println("The reverse :"+reverse);
		temp=temp+reverse;
		return temp;
	}
	
	static boolean isPalindrome(String inputStr){
		boolean status=false;
		int i=0;
		int j=inputStr.length()-1;
		char[] inputCharArr=inputStr.toCharArray();
		while(i < j){
			char temp=inputCharArr[i];
			inputCharArr[i]=inputCharArr[j];
			inputCharArr[j]=temp;
			++i;
			--j;
		}
		String reverseString;
		reverseString=String.valueOf(inputCharArr);
		if(reverseString.equals(inputStr)){
			status=true;
		}
		 return status;
				
	}
}
