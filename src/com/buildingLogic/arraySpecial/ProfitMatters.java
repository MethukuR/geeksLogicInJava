package com.buildingLogic.arraySpecial;

import java.util.Arrays;

/**
 *  Problem: Romeo started to open up a small shop to help his earning, he buys in a range of goods. In 
 *  order to earn profit help Romeo to keep a tab on the minimum and maximum price of goods purchased by
 *  writing a code which returns an array having minimum and maximum values of the values from the 
 *  input array. 
	NOTE: There will atleast one input value and all inputs are non-zero and non-negative.
	Input: Let's consider two examples where the price of products purchased are arranged in an array as
	[1,598,4,36,52] and [15].
	Output: The output in case of first example will be an array having minimum and maximum values from
	the input as [1,598] and output in second case will contain only single value as input had only one 
	value. ie [15].
	
	Constraints: size of array < 1000
	
	input is non-zero non-negative and < 1000000
	
	Sample Input: [1,15,236,854]
	
	Sample Output: 
	[1,854]
	
 * @author Raju Rockzz :P
 *
 */
public class ProfitMatters {

	public static void main(String[] args) {
			int[] inputArr={1};
			int[] minMaxArray=findMinMax(inputArr);
			System.out.println(Arrays.toString(minMaxArray));
	}

	private static int[] findMinMax(int[] inputArr) {
		int[] minMaxArray= new int[2];
		minMaxArray[0]=inputArr[0];
		minMaxArray[1]=inputArr[0];
		
		int inputArrLength=inputArr.length;
		
		for (int i = 1; i < inputArrLength; ++i) {
			if(inputArr[i] < minMaxArray[0]){
				minMaxArray[0]=inputArr[i];
			}
			
			if(inputArr[i] > minMaxArray[1]){
				minMaxArray[1]=inputArr[i];
			}
		}
		return minMaxArray;
	}

}
