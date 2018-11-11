package com.buildingLogic.XORSpecial;
/*
 * Euclid’s algorithm is used to find GCD of two numbers:
 * ------------------------------------------------------

There are mainly two versions of algorithm:

Version 1 (Using subtraction):
------------------------------

// Recursive function to return gcd of a and b
int gcd(int a, int b)
{
    if (a == b)  
       return a;
  
    return (a > b)? gcd(a-b, b): gcd(a, b-a);
}

Version 2 (Using modulo operator) :
-----------------------------------

// Function to return gcd of a and b
int gcd(int a, int b)
{
    if (a == 0) 
       return b;
     
    return gcd(b%a, a);
}
Which of the above two is more efficient?

Version 1 can take linear time to find the GCD, consider the situation when one of the given 
numbers is much bigger than the other. Version 2 is obviously more efficient as there are less 
recursive calls and takes logarithmic time.

Consider a situation where modulo operator is not allowed, can we optimize version 1 to work 
faster?

Below are some important observations. The idea is to use bitwise operators. We can find x/2 
using x>>1. We can check whether x is odd or even using x&1.

gcd(a, b) = 2*gcd(a/2, b/2) if both a and b are even.
gcd(a, b) = gcd(a/2, b) if a is even and b is odd.
gcd(a, b) = gcd(a, b/2) if a is odd and b is even.
 */
public class EuclidianGCD {

	public static void main(String[] args) {

		int firstNumber=3;
		int secondNumber=5;
		int gcd=0;
		gcd=calculateGCD(firstNumber,secondNumber);
		System.out.println("GCD of given numbers is "+gcd);
		gcd=calculateGCDModulo(firstNumber,secondNumber);
		System.out.println("GCD of given numbers is "+gcd);
		

	}
	private static int calculateGCDModulo(int firstNumber, int secondNumber) {
		if(firstNumber == 0){
			return secondNumber;
		}
		return calculateGCD(secondNumber%firstNumber, firstNumber);
	}
	//Efficient java program when % and / are not allowed
	static int calculateGCD(int firstNumber,int secondNumber){
		 if (secondNumber == 0 || firstNumber == secondNumber) 
			 return firstNumber;
		 if (firstNumber == 0) 
			 return secondNumber;
		// If both a and b are even, divide both a
		// and b by 2. And multiply the result with 2
		if((firstNumber & 1) == 0 && (secondNumber & 1) == 0){
			return (calculateGCD(firstNumber>>1, secondNumber>>1)<<1);
		}
		// If a is even and b is odd, divide a by 2
		if((firstNumber & 1)==0 && (secondNumber &1)!=0){
			return calculateGCD(firstNumber>>1, secondNumber);
		}
		// If a is odd and b is even, divide b by 2
		if((secondNumber & 1)==0 && (firstNumber & 1)!=0 ){
			return calculateGCD(firstNumber, secondNumber>>1);
		}
		// If both are odd, then apply normal subtraction 
		// algorithm. Note that odd-odd case always 
		// converts odd-even case after one recursion
		return (firstNumber>secondNumber) ? (calculateGCD(firstNumber-secondNumber, secondNumber)):(calculateGCD(firstNumber, secondNumber-firstNumber));
	}

}
