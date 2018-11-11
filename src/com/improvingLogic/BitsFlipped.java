package com.improvingLogic;
/**
 *  Flipping a Bit:
 *  --------------
	Flipping a Bit (binary digit) means changing from 0 to 1 and from 1 to 0. An operation OP(i) of bit flipping is defined on a 
	binary number as follows:Performing OP(i) would result into flipping of each ith bit from the starting (i>0). 
	
	An n-bit number is given as input and two operations OP(j) and OP(k) are applied on it one after the other. Objective is to tell 
	how many bits will remain the same after applying these two operations.
	
	
	Input Format
	You will be given a function which contains three arguments. Argument 1 will represent the Binary number as String, argument 2 
	will represent the integer j and argument 3 will represent the integer k.
	
	Output Format
	You need to return the Number of bits(in the form of integer) will remain the same after applying these two operations {Integer}
	Or 
	-1 in  case of invalid values of j, k or both 
	
	
	Sample Test Case 1: 
	Sample Input: 
	10110101101
	3
	4
	
	Sample Output: 
	6
	
	Sample Test Case 2: 
	Sample Input: 
	10110101101
	3
	0
	
	Sample Output: 
	-1

 * @author Ranger Raju :P
 *
 */
public class BitsFlipped {

	public static void main(String[] args) {
		//System.out.println(nochange_bits("10110101101",3,4));
		System.out.println((char)(48+17));

	}
	
	public static int nochange_bits(String input1,int input2,int input3){   
        int inpLen=input1.length();
	    if((input2 < 1) || (input3 < 1)){
	        return -1;
	    }
	    return inpLen - (findCount(1,inpLen,input2) + findCount(1,inpLen,input3) - findCount(1,inpLen,lcm(input2,input3)));
    }
    
    
    static int findCount(int l , int r, int k){
        return (r/k)-(l-1)/k;
    }
    
    static int gcd(int a, int b)
    {
    	if (a == 0)
            return b;
        return gcd(b%a, a);
    }
     
    // method to return LCM of two numbers
    static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
}
