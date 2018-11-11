package com.buildingLogic.numberSpecial;
/*
 * Write an iterative O(Log y) function for pow(x, y)
Given an integer x and a positive number y, write a function that computes x^y under 
following conditions.
a) Time complexity of the function should be O(Log y)
b) Extra Space is O(1)

Examples:

Input: x = 3, y = 5
Output: 243

Input: x = 2, y = 5
Output: 32
 */
public class FastExponentiation {

	public static void main(String[] args) {
		 int x = 1000;
		 int y = 5;
		 long  result=1;
		 result=pow(x,y,result);
		 System.out.println("Result :"+result);

	}
	
	static long pow(int x, int y,long result){
		
		while(y>0){
			// If y is odd, multiply x with result
			if((y&1)!=0){
				result*=x;
			}			
			y>>=1;//y=y/2
			x*=x;//x=x^2
		}
		return result;
	}

}
