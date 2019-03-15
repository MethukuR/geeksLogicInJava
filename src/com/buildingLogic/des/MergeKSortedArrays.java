package com.buildingLogic.des;

import java.util.PriorityQueue;

public class MergeKSortedArrays {

  public static void main(String[] args) {
    int arr[][] =  {{2, 6, 12, 34}, 
        {1, 9, 20, 1000}, 
        {23, 34, 90, 2000}};
    
    int[] mergedArray = mergeArrays(arr);
    
    for (int i = 0; i < mergedArray.length; i++) {
      System.out.print(mergedArray[i]+"\t");
    }
  }

  private static int[] mergeArrays(int[][] arrays) {
    PriorityQueue<QueueNode> pq = new PriorityQueue<>();
    int size = 0;
    
    for (int i = 0; i < arrays.length; i++) {
      size += arrays[0].length;
      if(arrays[0].length > 0) {
        pq.add(new QueueNode(i, 0, arrays[i][0]));
      }
    }
    
    int[] mergedArrays = new int[size];
    
    for (int i = 0; !pq.isEmpty(); i++) {
      QueueNode cur = pq.poll();
      mergedArrays[i] = cur.getValue();
      if(cur.getIndex()+1 < arrays[cur.getArray()].length) {
        pq.add(new QueueNode(cur.getArray(), cur.getIndex()+1, arrays[cur.getArray()][cur.getIndex()+1]));
      }
    }
    return mergedArrays;
  }

}

class QueueNode implements Comparable<QueueNode>{
  private int array;
  private int index;
  private int value;
  
  public QueueNode(int array, int index, int value) {
    super();
    this.array = array;
    this.index = index;
    this.value = value;
  }

  public int getArray() {
    return array;
  }

  public void setArray(int array) {
    this.array = array;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(QueueNode node) {
    if(this.getValue() < node.getValue()) {
      return -1;
    }else if(this.getValue() > node.getValue()) {
      return 1;
    }
    return 0;
  }
  
}
