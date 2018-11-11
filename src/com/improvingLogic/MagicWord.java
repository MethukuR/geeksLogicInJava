package com.improvingLogic;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *  Dhananjay has recently learned about ASCII values.He is very fond of experimenting. With his 
 *  knowledge of ASCII values and character he has developed a special word and named it 
 *  Dhananjay's Magical word.

	A word which consist of alphabets whose ASCII values is a prime number is an Dhananjay's 
	Magical word. An alphabet is Dhananjay's Magical alphabet if its ASCII value is prime.
	
	Dhananjay's nature is to boast about the things he know or have learnt about. So just to 
	defame his friends he gives few string to his friends and ask them to convert it to 
	Dhananjay's Magical word. None of his friends would like to get insulted. Help them to 
	convert the given strings to Dhananjay's Magical Word.
	
	Rules for converting:
	
	1.Each character should be replaced by the nearest Dhananjay's Magical alphabet.
	
	2.If the character is equidistant with 2 Magical alphabets. The one with lower ASCII value 
	will be considered as its replacement.
	
	Input format:
	
	First line of input contains an integer T number of test cases. Each test case contains an 
	integer N (denoting the length of the string) and a string S.
	
	Output Format:
	
	For each test case, print Dhananjay's Magical Word in a new line.
	
	Constraints:
	
	1 <= T <= 100
	
	1 <= |S| <= 500
	
	SAMPLE INPUT :
	--------------
	1
	6
	AFREEN
	
	SAMPLE OUTPUT :
	--------------
	CGSCCO
	
	Explanation:
	------------
	ASCII values of alphabets in AFREEN are 65, 70, 82, 69 ,69 and 78 respectively which are 
	converted to CGSCCO with ASCII values 67, 71, 83, 67, 67, 79 respectively. All such ASCII 
	svalues are prime numbers.
	

 * 
 * @author Raju Rockzz :P
 *
 */
public class MagicWord {

	public static void main(String[] args) {
		String inputStr="AFREEN";
		ArrayList<Integer> primes=findPrimeNumbersBetweenAlphabets();
		System.out.println("primes : "+primes);
		
		findMagicWord(inputStr,primes);

	}

	private static String findMagicWord(String inputStr, ArrayList<Integer> primes) {
		String outputStr="";
		int inputStrLength=inputStr.length();
		
		for (int i = 0; i < inputStrLength; ++i) {
			outputStr+=findMagicChar(inputStr.charAt(i),primes);
		}
		System.out.println("outputStr : "+outputStr);
		
		return outputStr;
	}

	private static char findMagicChar(char c, ArrayList<Integer> primes) {
		char magicChar=' ';
		int tempMin=-1;
		int min=1111;
		
		Iterator<Integer> itr = primes.iterator();
		
		while(itr.hasNext()){
			int prime=itr.next();
			tempMin=Math.abs(c-prime);
			if(tempMin < min){
				min=tempMin;
				magicChar=(char)prime;
			}
		}
		return magicChar;
	}

	private static ArrayList<Integer> findPrimeNumbersBetweenAlphabets() {
		
		ArrayList<Integer> primesOne=sieveOfEratosthenes(90);
		ArrayList<Integer> primesTwo=sieveOfEratosthenes(64);
		primesOne.removeAll(primesTwo);
		
		ArrayList<Integer> primesOnes=sieveOfEratosthenes(122);
		ArrayList<Integer> primesTwos=sieveOfEratosthenes(96);
		primesOnes.removeAll(primesTwos);
		
		//System.out.println("primesOne :"+primesOne);
		//System.out.println("primesOnes :"+primesOnes);
		
		primesOne.addAll(primesOnes);
		return primesOne;
		
	}
	
	private static ArrayList<Integer> sieveOfEratosthenes(int n){
	    // Create a boolean array "prime[0..n]" and initialize
	    // all entries it as true. A value in prime[i] will
	    // finally be false if i is Not a prime, else true.
	    boolean prime[] = new boolean[n+1];
	    ArrayList<Integer> primes=new ArrayList<Integer>();
	    for(int i=0;i<n;i++)
	        prime[i] = true;
	 
	    for(int p = 2; p*p <=n; p++){
	        // If prime[p] is not changed, then it is a prime
	        if(prime[p] == true){
	            // Update all multiples of p
	            for(int i = p*2; i <= n; i += p)
	                prime[i] = false;
	        }
	    }
	 
	    // Print all prime numbers
	    for(int i = 2; i <= n; i++){
	        if(prime[i] == true)
	        	primes.add(i);
	            //System.out.print(i + " ");
	    }
	    return primes;
	}

}
