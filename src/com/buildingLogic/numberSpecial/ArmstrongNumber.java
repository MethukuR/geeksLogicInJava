package com.buildingLogic.numberSpecial;
/**
 *  A number is called an Armstrong number if it is equal to sum of its digits each 
 *  raised to the power of number of digits in it. For example: 153, 371, 407, 9474, 
 *  54748 are some Armstrong numbers.
 
	153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
	
	371 = 3^3 + 7^3 + 1^3 = 27 + 343 + 1 = 371
	
	407 = 4^3 + 0^3 + 7^3 = 64 + 0 + 343 = 407
	
	9474 = 9^4 + 4^4 + 7^4 + 4^4 = 6561 + 256 + 2401 + 256 = 9474
	
	54748 = 5^5 + 4^5 + 7^5 + 4^5 + 8^5 = 3125 + 1024 + 16807 + 1024 + 32768 = 54748
	
	
	Logic Used To Find Out An Armstrong Number In Java :
	----------------------------------------------------
	First we create a copy of the given number as ‘copyOfNumber‘. We find out the 
	number of digits in a given number and store it into a variable called 
	‘noOfDigits‘. For this, we use String.valueOf(number).length() which gives the 
	number of digits in a given number. We also declare a variable ‘sum’ and 
	initialize it to 0.
	
	We extract each and every digit of a given number from last to first in a while 
	loop. For this we use ‘%’ – Modulus operator. You may know that, if we use 
	modulus operator like number%10, it will give last digit of the number. After 
	getting last digit of the number, we multiply it by itself equal to ‘noOfDigits’ 
	times, store it into ‘lastDigitToThePowerOfNoOfDigits’ and add it to ‘sum’. 
	
	After calculating ‘lastDigitToThePowerOfNoOfDigits’ and adding it to ‘sum’, we 
	divide the ‘copyOfNumber‘ by 10 i.e copyOfNumber/10. It will remove the last 
	digit from the number. We continue these steps until ‘copyOfNumber‘ becomes 0.

	At last, we check whether ‘sum’ is equal to given number. If it is equal, then 
	given number is an Armstrong number.
 
 * @author Raju :)
 *
 */
public class ArmstrongNumber {

	public static void main(String[] args) {
		int inputNumber=153;
		boolean status=isArmStrong(inputNumber);
		if(status){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}

	}

	private static boolean isArmStrong(int inputNumber) {
		int noOfDigits=String.valueOf(inputNumber).length();
		
		int copy=inputNumber;
		int sum=0;
		
		while(copy != 0){
			int rem=copy%10;
			sum+=Math.pow(rem, noOfDigits);
			copy/=10;
		}
		
		if(sum == inputNumber){
			return true;
		}
		return false;
	}

}
