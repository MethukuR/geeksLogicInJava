package com.buildingLogic.arraySpecial;

import java.util.HashMap;

/**
 * 
 *  Problem: Given an array of n elements containing duplicate elements, your task is to find the 
 *  majority element. An element is said to be majority if it occurs more than n/2 times.
	Input: First line of input contains n, no. of elements .
	Next line contains n space separated integers, elements of array.
	Output: Print the majority element if exist else -1
	Constraints: 0≤n≤1000
	Sample Input: 9
	3 3 4 2 4 4 2 4 4
	Sample Output: 
	4
	
 * @author Raju Rockzz :P
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] inputArr={3, 3 ,4, 2, 4, 4, 2, 4,4};
		int majorityElement=findMajorityElement(inputArr);
		System.out.println("majorityElement : "+majorityElement);

	}

	private static int findMajorityElement(int[] inputArr) {
		int majorityElement=-1;
		int inputArrLength=inputArr.length;
		HashMap<Integer,Integer> hm= new HashMap<Integer, Integer>(inputArrLength);
		for (int i = 0; i < inputArrLength; ++i) {
			int element=inputArr[i];
			if(hm.containsKey(element)){
				hm.put(element, hm.get(element)+1);
				if(hm.get(element) > (inputArrLength/2)){
					majorityElement=element;
					break;
				}
			}
			else{
				hm.put(element, 1);
			}
		}
		
		return majorityElement;
		
	}

}
