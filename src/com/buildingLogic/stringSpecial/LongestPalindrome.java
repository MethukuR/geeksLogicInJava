package com.buildingLogic.stringSpecial;
/**
 * Given a string, find the longest substring which is palindrome. For example, if the 
 * given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 * 
 * The time complexity can be reduced by storing results of subproblems. 
 * We maintain a boolean table[n][n] that is filled in bottom up 
 * manner. The value of table[i][j] is true, if the substring is palindrome, otherwise 
 * false. To calculate table[i][j], we first check the value of table[i+1][j-1], if the 
 * value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, 
 * the value of table[i][j] is made false.
 
 * @author Ranger Raju :P
 *
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		String inpString="forgeeksskeegfor";
		findMaxLenPalindrome(inpString);
	}
	
	// This function prints the longest palindrome substring
	// of str[].
	private static void findMaxLenPalindrome(String inpString) {
		int len=inpString.length();
		int maxLength=1;
		int start=0;
		
		// table[i][j] will be false if substring str[i..j]
	    // is not palindrome.
	    // Else table[i][j] will be true
		boolean[][] table= new boolean[len][len];
		
		// All substrings of length 1 are palindromes
		for (int i = 0; i < len; ++i) {
			table[i][i]=true;
		}
		
		// check for sub-string of length 2.
		for (int i = 0; i < len-1; ++i) {
			if(inpString.charAt(i) == inpString.charAt(i+1)){
				table[i][i+1]=true;
				start=i;
				maxLength=2;
			}
		}
		
		 // Check for lengths greater than 2. k is length
	    // of substring
		for (int k = 3; k <= len; ++k) {
			for (int i = 0; i < len-k+1; ++i) {
				int j= i+k-1;
				
				if(table[i+1][j-1] && (inpString.charAt(i) == inpString.charAt(j))){
					table[i][j]=true;
					
					if(k > maxLength){
						start=i;
						maxLength=k;
					}
					
				}
			}
		}
		
		System.out.println("maxLength : "+maxLength);
		System.out.println("start :"+start);
	}

}
