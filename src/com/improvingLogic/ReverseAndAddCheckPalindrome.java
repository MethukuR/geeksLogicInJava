package com.improvingLogic;

import java.util.Scanner;

/**
 * How To Reverse And Add A Number Until You Get A Palindrome?
 * Take number from the user, reverse it and add it to itself. If the sum is not a 
 * palindrome then repeat the procedure until you get a palindrome.

For example, If 7325 is input number, then

7325 (Input Number) + 5237 (Reverse Of Input Number) = 12562

12562 + 26521 = 39083

39083 + 38093 = 77176

77176 + 67177 = 144353

144353 + 353441 = 497794 (Palindrome)

In this particular case, we got a palindrome (497794) after 5th addition. This method gives
 palindrome in few steps for almost all of the integers.

Note : Palindrome number is a number which remains the same when its digits are reversed. 
For example, 121, 7227, 45654.

 * @author Raju Rockzz :P
 *
 */
public class ReverseAndAddCheckPalindrome {

	public static void main(String[] args) {
		System.out.print("Enter the number : ");
		Scanner scn = new Scanner(System.in);
		int inputNumber=scn.nextInt();
		reverseAndCheckPalindrome(inputNumber);
		scn.close();
	}
	
	static void reverseAndCheckPalindrome(int number){
		if(checkPalindrome(number)){
			System.out.println("Given number is already palindrome");
		}
		else{
			while(!checkPalindrome(number)){
				int reverse=reverseNumber(number);
				int sum=number+reverse;
	            System.out.println(number+" + "+reverse+" = "+sum);
				number =sum;
			}
		}
		
	}
	
	static int reverseNumber(int number){
		int reverse=0;
		//String reverseString="";
		int remainder =0;
		while(number != 0){
			remainder=number%10;
			reverse=(reverse*10)+remainder;
			number/=10;
		}
		/*while(number != 0){
			remainder=number%10;
			reverseString=reverseString+remainder;
			number/=10;
		}*/
		return reverse;
	}
	
	static boolean checkPalindrome(int number){
		boolean status=false;
		
		if(number == reverseNumber(number)){
			status=true;
		}
		
		return status;
	}

}
