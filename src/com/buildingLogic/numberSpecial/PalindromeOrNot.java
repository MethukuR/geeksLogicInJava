package com.buildingLogic.numberSpecial;

public class PalindromeOrNot {

	public static void main(String[] args) {
		int inputNumber=152;
		
		if(isPalindrome(inputNumber)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}

	}
	
	private static Boolean isPalindrome(int inputNumber){
		int rem;
		int copy=inputNumber;
		int rev=0;
		while(copy!=0)
		{
			rem=copy % 10;
			rev=rev*10 + rem;
			copy=copy / 10;
		}
		//System.out.println(rev);
		if(rev == inputNumber)
		{
			return true;
		}
		else{
			return false;
		}
			
	}

}
