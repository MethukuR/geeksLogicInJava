package com.buildingLogic.arraySpecial;
/**
 * Description:
 * 
Given a sorted array, remove the duplicates in place such that each element appear only 
once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant 
memory.

Example
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]
 * @author methukuraju
 *
 */
public class RemoveDuplicatesInSortedArray {
	
	 /*
     * @param nums: An integer array
     * @return: An integer
     */
    public static int removeDuplicates(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
    	
    	int count = 1;
    	for(int i = 1; i < nums.length; ++i) {
    		if(nums[i] != nums[i-1]) {
    			nums[count] = nums[i];
    			++count;
    			
    		}
    	}
		return count;
    }

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {1,1,2}));

	}

}
