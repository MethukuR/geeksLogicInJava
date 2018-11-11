/**
 * 	Problem: Consider an array A of n integers,where all but one of the integers occur in pairs.
	Every element in A occurs twice except for one.
	Find that unique element.
	Input: First line contains an integer n, represent number of elements of array.Next line contains n 
	space separated integers, the elements of array.
	Output: Print the unique element.
	Constraints: 0≤n≤100
	0≤ element of array ≤ 100
	Sample Input: 5
	2 2 4 5 4
	Sample Output: 
	5
	
	@author Raju Rockzz :P
 */
package com.buildingLogic.arraySpecial;

public class NonRepeatingNumberInArray {

	public static void main(String[] args) {
		int[] inputArr={2,2,3,3,5,7,7};
		int nonRepeatingNumber=findNonrepeatingNumber(inputArr);
		if(nonRepeatingNumber == 0){
			System.out.println("No such number exists");
		}
		else{
			System.out.println("nonRepeatingNumber : "+nonRepeatingNumber);
		}
		
	}
	
	static int findNonrepeatingNumber(int [] inputArr){
		int nonRepeatingNumber=inputArr[0];
		int inputArrLength=inputArr.length;
		
		for (int i = 1; i < inputArrLength; ++i) {
			nonRepeatingNumber^=inputArr[i];
		}
		return nonRepeatingNumber;
				
	}

}
