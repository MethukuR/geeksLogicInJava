package com.buildingLogic.arraySpecial;
/**
 * 
 * @author Ranger Raju :P
 *
 */
public class CorrectBucketForNumber {

	public static void main(String[] args) {
		int noOfarrays=3;
		
		int[] sizeOfArrays={1,2,3};
		
		int number=3;
		int bucketNumber=findBucketToFill(noOfarrays,sizeOfArrays,number);
		System.out.println("bucketNumber : "+bucketNumber);
	}

	private static int findBucketToFill(int noOfarrays, int[] sizeOfArrays,int number) {
		
		/*int totalSize=0;
		
		for (int i = 0; i < noOfarrays; ++i) {
			totalSize+=sizeOfArrays[i];
		}
		
		if(number > totalSize){
			return -1;
		}*/
		
		int temp=1;
		for (int i = 0; i < noOfarrays; i++) {
			if(number >= temp && number < (temp+sizeOfArrays[i])){
				return i+1;
			}
			else{
				temp+=sizeOfArrays[i];
			}
		}
		return -1;
	}

}
