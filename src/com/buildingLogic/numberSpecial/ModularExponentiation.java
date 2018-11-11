package com.buildingLogic.numberSpecial;
/*
 *  Modular Exponentiation (Power in Modular Arithmetic)
	Given three numbers x, y and p, compute (x^y) % p.
	
	Examples
	
	Input:  x = 2, y = 3, p = 5
	Output: 3
	Explanation: 2^3 % 5 = 8 % 5 = 3.
	
	Input:  x = 2, y = 5, p = 13
	Output: 6
	Explanation: 2^5 % 13 = 32 % 13 = 6.
	 
	 
	 Below is the fundamental modular property that is used for efficiently computing power under modular 
	 arithmetic.
	
	(a mod p) (b mod p) ≡  (ab) mod p
	
	or equivalently 
	
	( (a mod p) (b mod p) ) mod p  =  (ab) mod p
	
	For example a = 50,  b = 100, p = 13
	50  mod 13  = 11
	100 mod 13  = 9
	
	11*9 ≡ 1500 mod 13
	or 
	11*9 mod 13 = 1500 mod 13
 */
public class ModularExponentiation {

	public static void main(String[] args) {
		int x = 2;
		int y = 3;
		int p = 5;
		int result = 1;
		result = powModulo(x, y, p, result);
		System.out.println("Result :" + result);

	}

	static int powModulo(int x, int y, int p, int result) {
		x %= p; // Update x if it is more than or equal to p
		while (y > 0) {
			// If y is odd, multiply x with result
			if ((y & 1) != 0) {
				result = (result * x) % p;
			}
			y >>= 1; // y=y/2
			x = (x * x) % p; // x=(x^2)%p
		}
		return result;
	}

}
