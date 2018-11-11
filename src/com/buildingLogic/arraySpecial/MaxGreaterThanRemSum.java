package com.buildingLogic.arraySpecial;
/**
 *  You are given an array of elements. You need to find its max element say max and sum 
 *  of remaining elements say sum. if sum < max return true ...  else false. 
 *  
 *  @author Ranger Raju :)
 *
 */
public class MaxGreaterThanRemSum {

	public static void main(String[] args) {
		 int[] inputArray={1,2,3,4,5,6};
		 if(isMaxGreaterThanSumOfRem(inputArray)){
			 System.out.println("yes");
		 }
		 else{
			 System.out.println("No");
		 }
	}

	private static boolean isMaxGreaterThanSumOfRem(int[] inputArray) {
		int inpLength=inputArray.length;
		int max=Integer.MIN_VALUE;
		int sum =0;
		for (int i = 0; i < inpLength; ++i) {
			if(inputArray[i] > max){
				max=inputArray[i];
			}
			sum+=inputArray[i];
		}
		sum-=max;
		
		if(max > sum){
			return true;
		}
		else{
			return false;
		}
		
	}

}
