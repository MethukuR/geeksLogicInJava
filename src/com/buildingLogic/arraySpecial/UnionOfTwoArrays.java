package com.buildingLogic.arraySpecial;
/**
 * Given two unsorted arrays that represent two sets (elements in every array are distinct or may be repeated), 
 * find union and of two arrays.

For example, if the input arrays are:
arr1[] = {7, 1, 5, 2, 3, 6}
arr2[] = {3, 8, 6, 20, 7}
Then your program should print Union as {1, 2, 3, 5, 6, 7, 8, 20} and 
Intersection as {3, 6}. Note that the elements of union and intersection can be printed in any order.
 * @author Raju Roczzz :P
 *
 */

public class UnionOfTwoArrays
{

    public static void main(String[] args){
        int[] arrOne = {1, 2, 3, 3};
        int[] arrTwo = {2, 3, 1, 1};
        unionArrays(arrOne, arrTwo);
    }

    /* Union of multiple arrays */
    public static void unionArrays(int[] arrOne, int[] arrTwo){	
    	int arrOneLength=arrOne.length;
    	int arrTwoLength=arrTwo.length;
        int accSize = arrOneLength+arrTwoLength;
        int counter = 0;
        int[] accumulator = new int[accSize];
        
        
        for (int i = 0; i < arrOneLength; ++i) {
        	if(!isDuplicated(accumulator, counter, arrOne[i])){
       		 accumulator[counter] = arrOne[i];
       		 ++counter;
       	}
		}

        for (int i = 0; i < arrTwoLength; i++) {
        	if(!isDuplicated(accumulator, counter, arrTwo[i])){
        		 accumulator[counter] = arrTwo[i];
        		 ++counter;
        	}
		}
        
        System.out.println("Union Array is ");
        for(int i = 0; i < counter; i++){
        	System.out.print(accumulator[i]+"\t");

        } 
    }

    public static boolean isDuplicated(int[] array, int counter, int value){
    	boolean status=false;
    	
        for(int i = 0; i < counter; i++){
        	if(array[i] == value){
        		status= true;
        	} 
        } 
        return status;
    }
}