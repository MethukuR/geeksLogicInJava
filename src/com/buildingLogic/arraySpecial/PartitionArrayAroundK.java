package com.buildingLogic.arraySpecial;

public class PartitionArrayAroundK {

  public static void main(String[] args) {
    int[] nums = {3,2,2,1};
    int k = 2;
    System.out.println(partionArray(nums, k));
  }

  private static int partionArray(int[] nums, int k) {
    int low = 0;
    int high = nums.length -1;
    
    while(low < high) {
      while(low < high && nums[low] < k) {
        ++low;
      }
      while(low < high && nums[high] >= k) {
        --high;
      }
      
      if(low < high) {
        swap(nums, low, high);
        ++low;
        --high;
      }
    }
    return low;
  }

  private static void swap(int[] nums, int low, int high) {
    int temp = nums[low];
    nums[low] = nums[high];
    nums[high] = temp;
  }

}
