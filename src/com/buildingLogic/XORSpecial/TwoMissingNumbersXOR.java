package com.buildingLogic.XORSpecial;

/*
 * Find the two numbers with odd occurrences in an unsorted array.
 * Let x and y be the non-repeating elements we are looking for and arr[] 
 * be the input array. First calculate the XOR of all the array elements.
	xor = arr[0]^arr[1]^arr[2].....arr[n-1]
All the bits that are set in xor will be set in one non-repeating 
element (x or y) and not in other. So if we take any set bit of xor and 
divide the elements of the array in two sets – one set of elements with 
same bit set and other set with same bit not set. By doing so, we will 
get x in one set and y in another set. Now if we do XOR of all the elements 
in first set, we will get first non-repeating element, and by doing same in 
other set we will get the second non-repeating element.

Let us see an example.
   arr[] = {2, 4, 7, 9, 2, 4}
1) Get the XOR of all the elements.
     xor = 2^4^7^9^2^4 = 14 (1110)
2) Get a number which has only one set bit of the xor.   
   Since we can easily get the rightmost set bit, let us use it.
     set_bit_no = xor & ~(xor-1) = (1110) & ~(1101) = 0010
   Now set_bit_no will have only set as rightmost set bit of xor.
3) Now divide the elements in two sets and do xor of         
   elements in each set, and we get the non-repeating 
   elements 7 and 9. Please see implementation for this   
   step.
 */
public class TwoMissingNumbersXOR {

	public static void main(String[] args) {
		int[] inputArray={12, 23, 34, 12, 12, 23, 12, 45};
		int inputArrayLength=inputArray.length;
		int firstMissingNumber = 0;
		int secondMissingNumber = 0;
		if(inputArrayLength==1){
			System.out.println("Input Array size should be minimum 2");
		}
		else if(inputArrayLength==2){
			if(inputArray[0]!=inputArray[1]){
				firstMissingNumber=inputArray[0];
				secondMissingNumber=inputArray[1];
				System.out.println("First Missing Number :"+firstMissingNumber);
				System.out.println("First Missing Number :"+secondMissingNumber);
			}
			else{
				System.out.println("No such numbers exist in given input array of size 2");
			}
		}
		else if(inputArrayLength==3){
			System.out.println("No such numbers exist in given input array of size 3");
		}
		else{		
			getMissingNumbersUsingXOR(inputArray,firstMissingNumber,secondMissingNumber,inputArrayLength);
		}

	}
	
	static void getMissingNumbersUsingXOR(int[] inputArray, int firstMissingNumber,int secondMissingNumber, int inputArrayLength){
		int xorValue=inputArray[0];
		int setBit;
				
		//calculating xor of all numbers
		for(int arrayIndex=1; arrayIndex<inputArrayLength;++arrayIndex){
			xorValue=xorValue^inputArray[arrayIndex];
		}		
		System.out.println("XOR Value :"+xorValue);
		
		//Get the rightmost set bit in setBit
		setBit = xorValue & ~(xorValue-1);
		System.out.println("setBit : "+setBit);
		
		//dividing array in to two halves
		for(int arrayIndex=0; arrayIndex<inputArrayLength;++arrayIndex){
			
			if((inputArray[arrayIndex] & setBit)==0){								
				firstMissingNumber=firstMissingNumber^inputArray[arrayIndex];
			}
			else{				
				secondMissingNumber=secondMissingNumber^inputArray[arrayIndex];
			}
		}
		
		if(firstMissingNumber!=0 && secondMissingNumber !=0){
			System.out.println("First Missing Number :"+firstMissingNumber);
			System.out.println("Second Missing Number :"+secondMissingNumber);
		}
		else{
			System.out.println("No such numbers exist.Every number repeated twice");
		}
	}
}
