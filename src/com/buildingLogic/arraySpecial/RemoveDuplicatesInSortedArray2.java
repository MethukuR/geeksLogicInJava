/**
 * Description:
 * 
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */
package com.buildingLogic.arraySpecial;

public class RemoveDuplicatesInSortedArray2 {
	
	 /*
     * @param nums: An integer array
     * @return: An integer
     */
    public static int removeDuplicates(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
    	
    	int count = 1;
    	boolean flag = false;
    	for(int i = 1; i < nums.length; ++i) {
    		if(nums[i] != nums[i-1]) {
    			nums[count] = nums[i];
    			++count;
    			flag = false;
    			
    		}else {
    			if(!flag) {
    				flag = true;
    				nums[count] = nums[i];
        			++count;
    			}
    		}
    	}
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
