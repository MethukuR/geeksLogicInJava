package com.buildingLogic.numberSpecial;
/**
 *  Problem: Given a decimal number n, in the form of a string. You need to find minimum 
 *  multiple of this number n, which completes it ie. the smallest number to which 
 *  multiplying n, it will become an integer
	Input: Input contains a decimal number n.
	Output: Print the smallest positive number to which multiplying n gives an integer.
	Constraints: 1≤n≤1000
	Sample Input: 699.25
	Sample Output: 
	4
 * 
 * @author Raju :)
 *
 */
public class OnlyYouCanCompleteMe {

	public static void main(String[] args) {
		double inpNumber=699;
		
		int requiredNumber=findSmallestNumber(inpNumber);
		System.out.println(requiredNumber);

	}

	private static int findSmallestNumber(double inpNumber) {
		if(inpNumber == Math.floor(inpNumber)){
			return 1;
		}
		else{
			double temp=inpNumber;
			int requiredNumber=0;
			while(temp != Math.floor(temp)){
				requiredNumber+=2;
				temp*=requiredNumber;
			}
			return requiredNumber;
		}
	}

}
