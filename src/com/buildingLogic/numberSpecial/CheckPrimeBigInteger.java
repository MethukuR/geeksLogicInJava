package com.buildingLogic.numberSpecial;
import java.math.BigInteger;

/**
 * Java provides two function under java.math.BigInteger to deal with Prime Numbers.

  isProbablePrime(int certainty):
  ------------------------------
  A method in BigInteger class to check if a given number is prime. 
  For certainty = 1, it return true if BigInteger is prime and false if BigInteger 
  is composite.
  
  nextProbablePrime() :
  ---------------------
   Another method present in BigInteger class. This functions returns the next 
   Prime Number greater than current BigInteger.
   
 * @author Raju Rockzz :P
 *
 */
public class CheckPrimeBigInteger {
	//Function to check and return prime numbers
    static boolean checkPrime(long n){
        // Converting long to BigInteger
        BigInteger b = new BigInteger(String.valueOf(n));
 
        return b.isProbablePrime(1);
    }
    
    // Function to get nextPrimeNumber
    static long nextPrime(long n){
        BigInteger b = new BigInteger(String.valueOf(n));
        System.out.println(b.nextProbablePrime());
        return Long.parseLong(b.nextProbablePrime().toString());
    }
 
    // Driver method
    public static void main (String[] args)throws java.lang.Exception{
       long n = 12;
       System.out.println(checkPrime(n));
       System.out.println(nextPrime(235689));
       int exp = (int) Math.pow(10, 7);
       BigInteger answer = BigInteger.valueOf(2).pow(exp);
       System.out.println(answer);
    }
}
