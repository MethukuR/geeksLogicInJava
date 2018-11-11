package com.improvingLogic;

/*Extended Euclidean Algorithm: 
	Extended Euclidean algorithm also finds integer coefficients x and y such that:
 *   ax + by = gcd(a, b) 
Examples:

Input: a = 30, b = 20
Output: gcd = 10
        x = 1, y = -1
(Note that 30*1 + 20*(-1) = 10)

Input: a = 35, b = 15
Output: gcd = 5
        x = 1, y = -2
(Note that 10*0 + 5*1 = 5)
The extended Euclidean algorithm updates results of gcd(a, b) using the results calculated by 
recursive call gcd(b%a, a). Let values of x and y calculated by the recursive call be x1 and y1. 
x and y are updated using below expressions.


x = y1 - ⌊b/a⌋ * x1
y = x1
 */

public class ExtendedEuclidian {
	
	
	public static void main(String[] args) {
		int a=35;
		int b=15;
		int x=0;
		int y=0;				
		gcdExtended(a,b,x,y);
	}
	
	static void gcdExtended(int a, int b,int x, int y){
		//Base Case
		if(a==0){
			x=0;
			y=1;
			System.out.println("x:"+x);
			System.out.println("y:"+y);
			System.out.println("GCD :"+b);
			
		}
		
		int x1 = 0,y1 = 0;// To store results of recursive call
		while(a!=0){
			a=b%a;
			b=a;
		
			// Update x and y using results of recursive
		    // call
		    x = y1 - (b/a) * x1;
		    y = x1;
	    }
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("GCD :"+b);
		
	}

}
