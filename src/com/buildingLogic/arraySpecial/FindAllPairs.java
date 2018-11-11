package com.buildingLogic.arraySpecial;

import java.util.HashMap;

/**
 *  Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array 
 *  whose sum is equal to ‘sum’.

	Examples:
	========
	Input  :  arr[] = {1, 5, 7, -1}, 
	          sum = 6
	Output :  2
	Pairs with sum 6 are (1, 5) and (7, -1)
	
	Input  :  arr[] = {1, 5, 7, -1, 5}, 
	          sum = 6
	Output :  3
	Pairs with sum 6 are (1, 5), (7, -1) &
	                     (1, 5)         
	
	Input  :  arr[] = {1, 1, 1, 1}, 
	          sum = 2
	Output :  6
	There are 3! pairs with sum 2.
	
	Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
	                   5, 4, 2, 1, 1, 1}, 
	          sum = 11
	
	Output :  9

	Expected time complexity O(n)
	
 * @author Raju Rockzz:P
 *
 */
public class FindAllPairs {

	public static void main(String[] args) {
		int[] inputArray={4, 5, 7, 11, 9, 13, 8, 12};
		int givenNumber=20;
		findAllPairs(inputArray,givenNumber);
		findAllPairsOptimized(inputArray,givenNumber);
	}
	
    private static void findAllPairsOptimized(int[] inputArray, int givenNumber) {
    	int inputArrayLength=inputArray.length;
		HashMap<Integer,Integer> hm= new HashMap<Integer, Integer>(inputArrayLength);
		
		for(int i : inputArray){
			if(hm.containsKey(i)){
				hm.put(i, hm.get(i)+1);
			}
			else{
				hm.put(i,1);
			}
		}
		
		
	}
	/*
     * A simple solution is be traverse each element and check if there’s another number in the array 
     * which can be added to it to give sum.
     * Time Complexity : O(n^2)
     * Auxiliary Space : O(1)
     */
	private static void findAllPairs(int[] inputArray, int givenNumber) {
		int inputArrayLength=inputArray.length;
		for (int i = 0; i < inputArrayLength-1; ++i) {
			for (int j = i+1; j < inputArrayLength; ++j) {
				if(inputArray[i]+inputArray[j] == givenNumber){
					System.out.println(inputArray[i]+" + "+inputArray[j]+" = "+givenNumber);
				}
			}
		}
	}

}
