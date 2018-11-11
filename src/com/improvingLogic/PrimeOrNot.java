/**
 * Given a positive integer, check if the number is prime or not. A prime is a natural 
 * number greater than 1 that has no positive divisors other than 1 and itself. Examples of
 *  first few prime numbers are {2, 3, 5,.....

Examples:

Input:  n = 11
Output: true

Input:  n = 15
Output: false

Input:  n = 1
Output: false

Method one:
A simple solution is to iterate through all numbers from 2 to n-1 and for every number 
check if it divides n. If we find any number that divides, we return false.

Method Two:

We can do following optimizations:

Instead of checking till n, we can check till √n because a larger factor of n must be a 
multiple of smaller factor that has been already checked.
The algorithm can be improved further by observing that all primes are of the form 6k ± 1,
with the exception of 2 and 3. This is because all integers can be expressed as (6k + i) 
for some integer k and for i = ?1, 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), 
(6k + 4); and 3 divides (6k + 3). So a more efficient method is to test if n is divisible
by 2 or 3, then to check through all the numbers of form 6k ± 1
 
 * @author Raju Rockzz :P
 */
package com.improvingLogic;

import java.util.Scanner;

public class PrimeOrNot {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number :");
		int inputNumber=scn.nextInt();
		boolean status=isPrimeOne(inputNumber);
		System.out.println(status);
		scn.close();
	}
	
	static boolean isPrimeOne(int inputNumber){
		boolean status =true;
		for (int i = 2; i < inputNumber; i++) {
			if(inputNumber % i == 0){
				status=false;
				break;
			}
		}
		return status;
	}
	
	static boolean isPrimeTwo(int inputNumber){
		// Corner cases
	    if (inputNumber <= 1){
	    	return false;
	    }  
	    if (inputNumber <= 3) {
	    	return true;
	    } 
	 
	    // This is checked so that we can skip 
	    // middle five numbers in below loop
	    if (inputNumber % 2 == 0 || inputNumber % 3 == 0) return false;
	 
	    for (int i=5; i*i <= inputNumber; i=i+6){
	    	 if (inputNumber % i == 0 || inputNumber % (i+2) == 0)
		           return false;
	    }
	    return true;
		
	}

}
