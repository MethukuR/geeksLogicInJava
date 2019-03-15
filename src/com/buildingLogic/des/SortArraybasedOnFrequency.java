package com.buildingLogic.des;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortArraybasedOnFrequency {

  public static void main(String[] args) {
    int arr[] = {2, 5, 2, 6, -1, 99999, 5, 8, 8, 8};
    int[] sortedArr = sortOnFrequency(arr);
    for (int i : sortedArr) {
      System.out.print(i + "\t");
    }
  }
  

  private static int[] sortOnFrequency(int[] arr) {
    if(arr.length <= 2) {
      return arr;
    }
    Map<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();

    for (int i : arr) {
      if (hm.containsKey(i)) {
        hm.put(i, hm.get(i) + 1);
      } else {
        hm.put(i, 1);
      }
    }
    
    Map<Integer, Integer> sortedMap = sortByValues(hm);
    Iterator<Entry<Integer, Integer>> itr = sortedMap.entrySet().iterator();
    int[] sortedArr = new int[arr.length];
    int index = 0;
    
    while (itr.hasNext()) {
      Entry<Integer, Integer> entry = itr.next();
      for (int i = 0; i < entry.getValue(); i++) {
        sortedArr[index++] = entry.getKey();
      }
    }
    return sortedArr;

  }

  private static Map<Integer, Integer> sortByValues(Map<Integer, Integer> hm) {
    Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new ValueComparator(hm));
    sortedMap.putAll(hm);
    return sortedMap;
  }
}


class ValueComparator implements Comparator<Integer> {

  Map<Integer, Integer> map;

  public ValueComparator(Map<Integer, Integer> map) {
    this.map = map;
  }

  @Override
  public int compare(Integer o1, Integer o2) {
    Integer val1 = map.get(o1);
    Integer val2 = map.get(o2);
    if (val1 <= val2) {
      return 1;
    } else {
      return -1;
    }
  }
}
