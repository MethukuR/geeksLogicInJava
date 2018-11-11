package com.buildingLogic.numberSpecial;
/**
 *  link: http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *  Program for Fibonacci numbers:
 *  ------------------------------
	The Fibonacci numbers are the numbers in the following integer sequence.
	
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
	
	In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the 
	recurrence relation
	
	Fn = Fn-1 + Fn-1
	
	with seed values

    F0 = 0 and F1 = 1.
    
    INTERESTING FACT :
    ------------------
    A number is Fibonacci if and only if one or both of (5*(n^2) + 4) or (5*(n^2) – 4) 
    is a perfect square .
 * 
 * @author Dangal Raju Rockzz :P
 *
 */
public class NthFibonacciNumber {

	public static void main(String[] args) {
		int n=9;
		int nthFibonacciNumber;
		
		nthFibonacciNumber=findNthFibonacciNumberOne(n);
		System.out.println("nthFibonacciNumberOne : "+nthFibonacciNumber);
		
		nthFibonacciNumber=findNthFibonacciNumberTwo(n);
		System.out.println("nthFibonacciNumberTwo : "+nthFibonacciNumber);
		
		nthFibonacciNumber=findNthFibonacciNumberThree(n);
		System.out.println("nthFibonacciNumberThree : "+nthFibonacciNumber);
		
		nthFibonacciNumber=findNthFibonacciNumberFour(n);
		System.out.println("nthFibonacciNumberFour : "+nthFibonacciNumber);
		
	}
	
	//This another O(n) which relies on the fact that if we n times multiply the matrix M = {{1,1},{1,0}} 
	//to itself (in other words calculate power(M, n )), then we get the (n+1)th Fibonacci number as the 
	//element at row and column (0, 0) in the resultant matrix.
	//Time Complexity: O(n)
	//Extra Space: O(1)
    //The matrix representation gives the following closed expression for the Fibonacci numbers:
	// Refer image in Questions folder
	private static int findNthFibonacciNumberFour(int n) {
		int[][] f= new int[][]{{1,1},{1,0}};
		if(n <= 1){
			return n;
		}
		else{
			findPower(f,n-1);
			return f[0][0];
		}
		
	}
	private static void findPower(int[][] f, int i) {
		int[][] m= new int[][]{{1,1},{1,0}};
		
		for (int j = 2; j <= i; ++j) {
			multiplyMatrices(f,m);
		}
		
	}

	private static void multiplyMatrices(int[][] f, int[][] m) {
		int x = f[0][0]*m[0][0] + f[0][1]*m[1][0];
		int y = f[0][0]*m[0][1] + f[0][1]*m[1][1];
		int z = f[1][0]*m[0][0] + f[1][1]*m[1][0];
		int w = f[1][0]*m[0][1] + f[1][1]*m[1][1];
		
		f[0][0]=x;
		f[0][1]=y;
		f[1][0]=z;
		f[1][1]=w;
		
	}

	//We can optimize the space used in method 2 by storing the previous two numbers only because that 
	//is all we need to get the next Fibonacci number in series.
	//Time Complexity: O(n)
	//Extra Space: O(1)
	private static int findNthFibonacciNumberThree(int n) {
		int a=0;
		int b=1;
		int c=0;
		if(n <= 0){
			return -1;
		}
		else if(n == 1){
			return a;
		}else if(n ==2){
			return b;
		}
		for (int i = 2; i <= n; ++i) {
			c=a+b;
			a=b;
			b=c;
		}
		return c;
	}
	
	//We can avoid the repeated work done is the method 1 by storing the Fibonacci numbers calculated 
	//so far.
	//Time Complexity: O(n)
	//Extra Space: O(n)
	private static int findNthFibonacciNumberTwo(int n) {
		int[] fib= new int[n+1];
		fib[0]=0;
		fib[1]=1;
		
		for (int i = 2; i <= n; ++i) {
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib[n];
	}
	
	//A simple method that is a direct recursive implementation mathematical recurrence 
	//relation given above.
	//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	//Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
	private static int findNthFibonacciNumberOne(int n) {
		if(n <= 1){
			return n;
		}
		else{
			return findNthFibonacciNumberOne(n-1)+findNthFibonacciNumberOne(n-2);
		}
	}

}
