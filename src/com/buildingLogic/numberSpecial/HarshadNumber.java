package com.buildingLogic.numberSpecial;
/**
 *  Problem :
	--------
	Write a java program or function to check Harshad number (or Niven number). Your 
	program should take one positive integer from the user as input and check whether 
	this integer is Harshad number (Niven number) or not.
	
	 
	What Is Harshad Number Or Niven Number?
	
	Harshad number or Niven number is a number which is divisible by the sum of its digits. 
	For example,
	
	1) 21 is a Harshad number because it is divisible by the sum of its digits.
	
	21 –> sum of digits –> 2+1 = 3 and 21 is divisible by 3 –> 21/3 = 7.
	
	2) 111 is a Harshad number because it is divisible by the sum of its digits.
	
	111 –> sum of digits –> 1+1+1 = 3 and 111 is divisible by 3 –> 111/3 = 37
	
	3) 153 is a Harshad number. It is divisible by the sum of its digits.
	
	153 –> sum of its digits –> 1+5+3 = 9 and 153 is divisible by 9 –> 153/9 = 17
	
	
	How To Check Harshad Number Or Niven Number In Java?
	
	Step 1 : Let inputNumber be the input number and sum be the sum of its digits.
	
	Step 2 : First find the sum of digits of inputNumber and store it in sum.
	
	while (inputNumber != 0) 
	{
	        lastDigit = inputNumber % 10;
	        sum = sum + lastDigit;
	        inputNumber = inputNumber / 10;
	}
	
	Step 3 : If inputNumber is divisible by the sum, then inputNumber is a Harshad number.
 
 * @author Raju Rockzz :P
 *
 */
public class HarshadNumber {

	public static void main(String[] args) {
		int input=153;
		findHarshad(input);
		if(isHarshadNumber(input)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}

	private static boolean isHarshadNumber(int input) {
		int sumOfDigits=findSumOfDigits(input);
		if(input%sumOfDigits == 0){
			return true;
		}
		return false;
	}

	private static int findSumOfDigits(int input) {
		
		int sum=0;
		
		while(input != 0){
			int remainder=input%10;
			sum+=remainder;
			input/=10;
		}
		return sum;
	}
	
	// By Richa 
	private static void findHarshad(int a)
	{
		int sum=0;
		int dub=a;
		int div,rem;
		while(a!=0)
		{
		div=a/10;
		rem=a%10;
		sum=sum+rem;
		a=div;
		}
		if(dub%sum==0)
		{
			System.out.println("number is harshad");
			
		}
		else
			System.out.println("number is not harshad");
			
		}



}
