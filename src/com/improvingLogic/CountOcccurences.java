package com.improvingLogic;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Write a java program or function to count the occurrences of each element in an array. 
 * For example, if {12, 9, 12, 9, 10, 9, 10, 11} is the input array, then the count of 
 * occurrences of each element is {12:2, 9:3, 10:2, 11:1}.
 * @author Raju Rockzz :P
 *
 */
public class CountOcccurences {

	public static void main(String[] args) {
		int[] inputArr={12, 9, 12, 9, 10, 9, 10, 11,0,0,0,-1,-2,-1,-2,-3};
		calculateNumberCountOne(inputArr);
		calculateNumberCountTwo(inputArr);

	}
	
	static void calculateNumberCountOne(int[] inputArr){
		int inputArrLength=inputArr.length;
		int[] tempArr=new int[inputArrLength];
		int[] freq=new int[inputArrLength];
		int tempIndex=0;
		for (int i : inputArr) {
			int index=getIndex(i,tempArr,tempIndex);
			if(index != -1){
				++freq[index];
			}
			else{
				tempArr[tempIndex]=i;
				++freq[tempIndex];
				++tempIndex;
			}
		}
		
		for (int j = 0; j < inputArrLength; ++j) {
			if(freq[j] != 0){
				System.out.println(tempArr[j]+" repeated "+freq[j]+" times");
			}
		}

	}
	
	static int getIndex(int tempValue, int[] tempArr, int tempIndex){
		int index = -1;
		int tempArrLength=tempArr.length;
		for (int i = 0 ; i < tempArrLength && (i != tempIndex); ++i) {
			if(tempArr[i] == tempValue){
				index=i;
				break;
			}
		}
		return index;
	}
	/**
	 * How To Count Occurrences Of Each Element In An Array In Java?(Using collections)

		Step 1 : Create one HashMap object called elementCountMap with elements of inputArray as keys and their
		occurrences as values.
		
		Step 2 : Check every element of inputArray for its presence in elementCountMap.
		
		Step 3 : If an element is already present in elementCountMap, increment it’s count by 1.
		
		elementCountMap.put(i, elementCountMap.get(i)+1);
		
		Step 4 : If an element is not present in elementCountMap, add this element to elementCountMap with 1 as 
		it’s value.
		
		elementCountMap.put(i, 1);
		
		Step 5 : Print elementCountMap. This will contain all the elements of inputArray along with their 
		occurrences.
	 * 
	 */
	static void calculateNumberCountTwo(int[] inputArr){
		HashMap<Integer, Integer> elementCount=new HashMap<Integer, Integer>();
		
		for(int i : inputArr){
			if(elementCount.containsKey(i)){
				elementCount.put(i, elementCount.get(i)+1);
			}
			else{
				elementCount.put(i,1);
			}
		}
		System.out.println("Input Array : "+Arrays.toString(inputArr));
        
        System.out.println("Element Count : "+elementCount);
	}

}
