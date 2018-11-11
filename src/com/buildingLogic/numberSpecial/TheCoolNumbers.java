package com.buildingLogic.numberSpecial;
/**
 * Problem: For a number X, let its "Coolness" be defined as the number of
 * "101"s occurring in its binary representation. For example, the number 21 has
 * Coolness 2, since its binary representation is 10101, and the string "101"
 * occurs twice in this representation.
 * 
 * A number is defined as Very Cool if its Coolness is greater than or equal to
 * K. Please, output the number of Very Cool integers between 1 and R. Input:
 * The first line contains an integer T, the number of test cases. The next T
 * lines contains two space-separated integers, R and K. Output: Output T lines,
 * the answer for each test case.
 *  
 * Constraints: 
 * 1<=T<=100 
 * 1<=R<=105 
 * 1<=K<=100
 * 
 * Sample Input: 
 * 1 
 * 5 1 
 * 
 * Sample Output: 
 * 1
 * 
 * @author Raju Rockzz :P
 *
 */
public class TheCoolNumbers {

	public static void main(String[] args) {
		int n=5;
		int k=2;
		
		boolean isCool=isGivenNumberCool(n,k);
		
		if(isCool){
			System.out.println("Cool");
		}
		else{
			System.out.println("Not Cool");
		}
	}

	private static boolean isGivenNumberCool(int n, int k) {

		String binaryInput=Integer.toBinaryString(n);
		String coolNumber="101";
		int index=0;
		int coolness=0;
		while(index != -1){
			index=binaryInput.indexOf(coolNumber,index);
			if(index != -1){
				++coolness;
				index+=2;
			}
		}
		
		if(coolness >= k){
			return true;
		}
		return false;
	}

}
