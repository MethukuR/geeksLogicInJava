package com.buildingLogic.arraySpecial;
/**
 * If ‘n’ is the positive number and ‘a’ is an array of integers of length n-1 containing elements from 
 * 1 to n. Then find the missing number in ‘a’ in the range from 1 to n. Occurrence of each element is 
 * only once. i.e ‘a’ does not contain duplicates. 
 * 
 * example:
 * If n = 8, then array ‘a’ will have 7 elements in the range from 1 to 8. 
 * For example {1, 4, 5, 3, 7, 8, 6}. One number will be missing in ‘a’ (2 in this case). You have to 
 * find out that missing number.

Solution :

Step 1 : First we find out sum of ‘n’ numbers by using formula n*(n+1)/2.

Step 2 : Then we will find sum of all elements of array ‘a’.

Step 3 : Missing_Number = (Sum of 1 to ‘n’ numbers) – (Sum of elements of array ‘a’)

 * @author Raju Rockzzz :P
 *
 */
public class MissingNumberInArray {

	public static void main(String[] args) {
		int noOfElements = 8;
		 
        int[] inputArr = {1, 4, 5, 3, 7, 8, 6};
        
        int expectedSum=calculateExpectedSum(noOfElements);
        
        int actualSum=calculateActualSum(inputArr,noOfElements);
        
        int missingNumber=expectedSum - actualSum;
        
        System.out.println("Missing Number is "+missingNumber);

	}
	
	static int  calculateExpectedSum(int noOfElements){
		int expectedSum=(noOfElements*(noOfElements+1))/2;
		
		return expectedSum;
	}
	
	static int calculateActualSum(int[] inputArr , int noOfElements){
		int actualSum=0;
		int inputArrLength=inputArr.length;
		
		for (int i = 0; i < inputArrLength; ++i) {
			actualSum=actualSum+inputArr[i];
		}
		return actualSum;
	}

}
