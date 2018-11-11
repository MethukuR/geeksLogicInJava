package com.buildingLogic.arraySpecial;
/**
 * Given an integer array, you have to find all the leader elements in this array. An element is said 
 * to be leader if all the elements on it’s right side are smaller than it. Rightmost element is always 
 * a leader. For example, if {14, 9, 11, 7, 8, 5, 3} is the given array then {14, 11, 8, 5, 3} are the 
 * leaders in this array.
 * 
 * Logic Used To Find All The Leaders In An Integer Array :

 * We go on traversing the given array from right to left. Initially, we assume the last element as 
 * highest and we store it in a variable called ‘max‘. We print the last element as it is always a 
 * leader. If we find any element greater than ‘max‘, we print that element and update the ‘max‘ 
 * variable. We continue this until we traverse all the elements in the given array.
 * 
 * @author Raju Rockzzz :P
 *
 */
public class LeadersInGivenArray {

	public static void main(String[] args) {
		int[] inputArr = {12, 9, 7, 14, 8, 6, 3};
		
		findLeadersInArray(inputArr);
		
	}
	
	static void findLeadersInArray(int[] inputArr){
		int inputArrLength=inputArr.length;
		
		int max=inputArr[inputArrLength-1];
		
		System.out.println("Leaders in given array are ");
		System.out.print(max+"\t");
		for (int i = inputArrLength-1; i >=0 ; --i) {
			if(inputArr[i] > max){
				max = inputArr[i];
				System.out.print(max +"\t");
			}
		}
	}

}
