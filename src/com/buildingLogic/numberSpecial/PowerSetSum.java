package com.buildingLogic.numberSpecial;
/**
 * Problem: Cody hates Maths.He recently finished Set Theory in school. He was
 * solving a problem based on set, and found himself lost. The problem is like
 * you are given a Set, find its Power Set and compute sum of all elements of
 * all the subsets in power set.Now you need to help Cody in his assignment.
 * 
 * Input: First line has T, the total number of test cases. The next T lines
 * contains a number N in each line. Output: T lines giving answer as defined in
 * the question for each N. 
 * 
 * For given Sample Input for N=3 S={1,2,3} P(S) =
 * {{1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}} 
 * answer =(1)+(2)+(3)+(1+2)+(1+3)+(2+3)+(1+2+3) = 24 
 * 
 * Constraints: 
 * 1<=T<=40 
 * 1<=N<=40
 * 
 * Power set of a set S is defined as set of all possible subsets of S. Set S
 * consist of all the number from 1 to N. 
 * 
 * Sample Input: 
 * 1 
 * 3 
 * 
 * Sample Output: 
 * 24
 * 
 * @author Raju Rockzz :P
 *
 */
public class PowerSetSum {

	public static void main(String[] args) {
		int inputNumber=4;
		int powerSetSum=findPowerSetSum(inputNumber);
		System.out.println(powerSetSum);
	}
	
	/**
	 * link: http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
	 * 
	 * @param inputNumber
	 * @return sum
	 */
	private static int findPowerSetSum(int inputNumber) {
		int sum=0;
		//System.out.println(1<<inputNumber);
		for (int i = 0; i < (1<<inputNumber); i++) {
			StringBuffer binaryString= new StringBuffer(Integer.toBinaryString(i));
			binaryString.reverse();
			//System.out.println(binaryString);
			int binaryLength=binaryString.length();
			for (int j = 0; j < binaryLength; ++j) {
				if(binaryString.charAt(j) == '1'){
					System.out.print(i+":"+(j+1)+"\t");
					sum+=j+1;
				}
			}
			System.out.println();
		}
		return sum;
	}

}
