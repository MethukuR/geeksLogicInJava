package com.buildingLogic.arraySpecial;

import java.util.HashSet;

public class UniqueValuesInArray {
	public static int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10,4, 6, 10};
	public static void main(String[] args) {
		
		int arrLength=arr.length;
		printUniqueValues(arr,arrLength);
		printUniqueDuplicates(arr,arrLength);

		//printUniqueValuesSorting(arr);
		//printUniqueValuesHasing(arr);
	}
	
	static void printUniqueValues(int arr[],int arrLength){
		System.out.println("Unique elements Array is :");
		
		for(int outerLoopIndex=0;outerLoopIndex<arrLength-1;++outerLoopIndex){
			int innerLoopIndex;
			boolean isDistinct=true;
			for(innerLoopIndex=outerLoopIndex+1;innerLoopIndex<arrLength;++innerLoopIndex){
				if(arr[outerLoopIndex]==arr[innerLoopIndex]){
					isDistinct=false;
					break;
				}
			}
			if(isDistinct){
				System.out.print(arr[outerLoopIndex]+"\t");
			}
		}
	}
	
	static void printUniqueDuplicates(int arr[],int arrLength){
		System.out.println("\nDuplicate elements Array is :");
		int tempIndex=0;
		int[] tempArr= new int[arrLength];
		for(int outerLoopIndex=0;outerLoopIndex < arrLength-1; ++outerLoopIndex){
			int innerLoopIndex;
			for(innerLoopIndex=outerLoopIndex+1;innerLoopIndex < arrLength; ++innerLoopIndex){
				if(arr[outerLoopIndex] == arr[innerLoopIndex]){
					tempArr[tempIndex]=arr[outerLoopIndex];
					if(!alreadyExists(tempArr[tempIndex],tempArr,tempIndex)){
						System.out.print(tempArr[tempIndex]+"\t");
					}
					tempIndex++;
				}
			}
		}
	}
	
	static boolean alreadyExists(int tempValue, int[] tempArr,int tempIndex){
		boolean status = false;
		int tempArrLength=tempArr.length;
		for (int i = 0; i < tempArrLength && (i!=tempIndex); ++i) {
			if(tempArr[i] == tempValue){
				status=true;
				break;
			}
		}
		return status;
	}
	
	static void printUniqueValuesHasing(int[] arr){
		HashSet<Integer> set= new HashSet<Integer>();
		for(int arrIndex=0;arrIndex<arr.length;++arrIndex){
			if(!set.contains(arr[arrIndex])){
				set.add(arr[arrIndex]);
				System.out.print(arr[arrIndex]+"\t");
			}
			
		}
		
	}

}
