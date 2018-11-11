package com.buildingLogic.arraySpecial;
/**
 * @author  Ranger Raju :P
 */

import java.util.Arrays;
//import java.util.stream.IntStream;

public class SecondMaxInArray {

	public static void main(String[] args) {
		int[] inputArr={6,2,1,3,0,4};
		
		/*int sum=IntStream.of(inputArr).sum();
		System.out.println("Sum : "+sum);*/
		int secondLargestNumberOne=findSecondLargestOne(inputArr);
		int secondLargestNumberTwo=findSecondLargestTwo(inputArr);  

		System.out.println("Second Largest numberOne :"+secondLargestNumberOne);
		System.out.println("Second Largest numberTwo :"+secondLargestNumberTwo);

	}
    
	public static int findSecondLargestOne(int[] inputArr){
		
		int arrLength=inputArr.length;
		Arrays.sort(inputArr);
		int secMax=inputArr[arrLength-2];
		return secMax;
	}
	
	static int findSecondLargestTwo(int[] inputArr){
			int arrLength=inputArr.length;
			int firstMax=0,secondMax=0;
			if(inputArr[0]>inputArr[1]){
				firstMax=inputArr[0];
				secondMax=inputArr[1];
			}
			else{
				firstMax=inputArr[1];
				secondMax=inputArr[0];
			}
			for (int i = 2; i <arrLength ; i++) {
				if(inputArr[i] > firstMax){
					secondMax=firstMax;
					firstMax=inputArr[i];
				}
				else if(inputArr[i] < firstMax && inputArr[i] > secondMax){
					secondMax=inputArr[i];  
				}	
			}
			return secondMax;
		}
	}
