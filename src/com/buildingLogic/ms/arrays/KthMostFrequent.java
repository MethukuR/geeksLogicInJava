package com.buildingLogic.ms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KthMostFrequent {

  public static void main(String[] args) {

    /*String[] arr = {};

    String frequentElement = findKthMostFrequentElement(arr, 3);*/

  }

  public String findKthMostFrequentElement(String[] arr, int k) {
    if (arr.length == 0) {
      return null;
    }
    
    if(arr.length == 1) {
      if(k == 1) {
        return arr[0];
      }else {
        return null;
      }
    }

    Map<String, Integer> hm = new HashMap<>();

    for (String element : arr) {
      if (hm.containsKey(element)) {
        hm.put(element, hm.get(element) + 1);
      } else {
        hm.put(element, 1);
      }
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    
    if(k <= list.size()) {
      return list.get(k-1).getKey();
    }
    return null;
  }

}
