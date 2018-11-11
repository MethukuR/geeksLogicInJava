package com.buildingLogic.arraySpecial;


public class sumOfTwoElements {

	public static void main(String[] args) {
		int[] arr={3,1,2,4};
		int result=maxElement(arr);
		System.out.println(result);
	}
	
	static  int maxElement(int[] arr){
		int arrLength=arr.length;
		int maxSum=-1;
		 for( int i=0; i<arrLength; ++i){
			 for(int j=0; (j<arrLength) && (i!=j); ++j){
				 int tempSum=arr[i]+arr[j];
				 
				 if(tempSum > maxSum && containsArray(arr, tempSum, arrLength)){
					 maxSum=tempSum;
				 }
			 }
		 }
		 return maxSum;
	}
	static boolean containsArray(int[] arr, int value, int arrLength){
		boolean status=false;
		
		for(int index=0; index < arrLength; index++){
			if(arr[index]==value){
				status=true;
				
				break;
			}
		}
		return status;
	}

}
