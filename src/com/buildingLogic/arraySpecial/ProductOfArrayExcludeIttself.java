/**
 * A Product Array Puzzle
Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of all the 
elements of arr[] except arr[i]. Solve it without division operator and in O(n).
Example :
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}

Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
Algorithm:
1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i] excluding arr[i].
2) Construct another temporary array right[] such that right[i] contains product of all elements on on right of arr[i] excluding arr[i].
3) To get prod[], multiply left[] and right[].

The above method can be optimized to work in space complexity O(1).

 */
package com.buildingLogic.arraySpecial;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExcludeIttself {
	
	/*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public static List<Long> productExcludeItself(List<Integer> nums) {
    	
    	int numsLength = nums.size();
    	
    	if(numsLength == 0 ) {
    		return null;
    	}
    	
    	List<Long> product = new ArrayList<>(numsLength);
    	
    	Long temp = 1L;
    	
    	for(int i = 0 ; i < numsLength; ++i) {
    		product.add(i, temp);
    		temp *= nums.get(i);
    	}
    	
    	temp = 1L;
    	
    	for(int i = numsLength-1 ; i >= 0; --i) {
    		product.set(i, product.get(i)*temp);
    		temp *= nums.get(i);
    	}

		return product;
    }

	public static void main(String[] args) {
		List<Integer> ar = new ArrayList<>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(10);
				add(3);
				add(5);
				add(6);
				add(2);
				
			}
		};
		productExcludeItself(ar);
	}

}
