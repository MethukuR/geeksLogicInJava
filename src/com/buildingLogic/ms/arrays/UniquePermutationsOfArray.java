package com.buildingLogic.ms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquePermutationsOfArray {

  public static void main(String[] args) {
    int[] nums = {2,1};
    System.out.println(permuteUnique(nums));
  }


  /*
   * @param nums: A list of integers.
   * 
   * @return: A list of permutations.
   */
  public static List<List<Integer>> permuteUnique(int[] nums) {

    if (nums.length == 0) {
      List<Integer> tempList = new ArrayList<>();
      List<List<Integer>> results = new ArrayList<List<Integer>>();
      results.add(tempList);
      return results;
    }

    if (nums.length == 1) {
      List<Integer> tempList = new ArrayList<>();
      tempList.add(nums[0]);
      List<List<Integer>> results = new ArrayList<List<Integer>>();
      results.add(tempList);
      return results;
    }

    List<Integer> numsList = new ArrayList<>();
    for (int element : nums) {
      numsList.add(element);
    }

    Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
    permuteUtil(numsList, 0, results);
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    for (List<Integer> list : results.values()) {
      res.add(list);
    }   
    return res;

  }

  private static void permuteUtil(List<Integer> numsList, int start, Map<String, List<Integer>> results) {
    int listSize = numsList.size();
    if (start >= listSize) {
      String numsKey = numsList.toString();
      if (!results.containsKey(numsKey)) {
        results.put(numsKey, new ArrayList<Integer>(numsList));
      }
      return;
    }

    for (int i = start; i < listSize; ++i) {
      swap(numsList, start, i);
      permuteUtil(numsList, start + 1, results);
      swap(numsList, start, i);
    }
  }

  private static void swap(List<Integer> numsList, int i, int j) {
    if (i == j) {
      return;
    }

    int temp = numsList.get(i);
    numsList.set(i, numsList.get(j));
    numsList.set(j, temp);
  }


}
