package com.buildingLogic.numberSpecial;
/*
 * Modular multiplicative inverse
Given two integers ‘a’ and ‘m’, find modular multiplicative inverse of ‘a’
 under modulo ‘m’.

The modular multiplicative inverse is an integer ‘x’ such that.

 a x ≡ 1 (mod m) 
The value of x should be in {0, 1, 2, … m-1}, i.e., in the ring of integer 
modulo m.

The multiplicative inverse of “a modulo m” exists if and only if a and m 
are relatively prime (i.e., if gcd(a, m) = 1).

Examples:

Input:  a = 3, m = 11
Output: 4
Since (4*3) mod 11 = 1, 4 is modulo inverse of 3
One might think, 15 also as a valid output as "(15*3) mod 11" 
is also 1, but 15 is not in ring {0, 1, 2, ... 10}, so not 
valid.

Input:  a = 10, m = 17
Output: 12
Since (10*12) mod 17 = 1, 12 is modulo inverse of 3


Method 1 (Naive):
-----------------
A Naive method is to try all numbers from 1 to m. For every number x, 
check if (a*x)%m is 1. Below is C++ implementation of this method.
 
// A naive method to find modulor multiplicative inverse of
// 'a' under modulo 'm'
int modInverse(int a, int m)
{
    a = a%m;
    for (int x=1; x<m; x++)
       if ((a*x) % m == 1)
          return x;
}

Output:

4

Time Complexity of this method is O(m).
===========================================================================

Method 2 (Works when m and a are coprime)
-----------------------------------------
The idea is to use Extended Euclidean algorithms that takes two integers
 ‘a’ and ‘b’, finds their gcd and also find ‘x’ and ‘y’ such that

 ax + by = gcd(a, b) 
To find multiplicative inverse of ‘a’ under ‘m’, we put b = m in above 
formula. Since we know that a and m are relatively prime, we can put value 
of gcd as 1.

 ax + my = 1 
If we take modulo m on both sides, we get

 (ax + my)mod m ≡ 1 (mod m)
We can remove the second term on left side as ‘my (mod m)’ would always
 be 0 for an integer y.

 ax  ≡ 1 (mod m) 
So the ‘x’ that we can find using Extended Euclid Algorithm is 
multiplicative inverse of ‘a’
 */
public class ModularMultiplicativeInverse {
	int x=0,y=0;
	public static void main(String[] args) {
		int a=3,m=11;
		ModularMultiplicativeInverse inverse=new ModularMultiplicativeInverse();
		inverse.modMulInverse(a,m);

	}
	
	void modMulInverse(int a, int m){
		int gcd=0;
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		gcd=gcdExtended(a,m,x,y);
		System.out.println("x: "+x);
		System.out.println("gcd: "+gcd);
		if(gcd==1){
			int inverse=(x%m + m)%m;
			System.out.println("Inverse is "+inverse);
		}
		else{
			System.out.println("Inverse don't exist");
		}
	}
	
	int gcdExtended(int a, int b, int x, int y){
		
		if(a==0){
			x=0;
			y=1;
			return b;
		}
		
		int x1=0,y1=0;
		while(a<=0){
			a=b%a;
			b=a;
			x = y1 - (b/a) * x1;
			y = x1;
			 
		}
		return 0;
	}
	}
			

