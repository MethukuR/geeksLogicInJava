package com.buildingLogic.ms.arrays;

import java.util.Arrays;

public class ImplementNStacksUsingArray {

  public static void main(String[] args) {

  }

}


class Stacks {

  private int[] topOfStacks;
  private int[] stackData;
  private int[] nextIndex;
  private int nextAvailableIndex;

  public Stacks(int noOfStacks, int capacity) {

    this.topOfStacks = new int[noOfStacks];
    Arrays.fill(topOfStacks, -1);

    this.stackData = new int[capacity];

    this.nextIndex = new int[capacity];
    for (int i = 0; i < capacity - 1; i++) {
      this.nextIndex[i] = i + 1;
    }
    this.nextIndex[capacity - 1] = -1;

    this.nextAvailableIndex = 0;
    System.out.println("Initial state:");
    print(topOfStacks, stackData, nextIndex, nextAvailableIndex);

  }

  public void push(int stackNumber, int data) {
    System.out.println("Inside push stackNumber: "+stackNumber+ " data: " + data);
    if (stackNumber < 0 || stackNumber >= topOfStacks.length) {
      throw new IndexOutOfBoundsException();
    }

    if (nextAvailableIndex < 0) {
      throw new IndexOutOfBoundsException();
    }

    int currentIndex = nextAvailableIndex;
    stackData[currentIndex] = data;
    nextAvailableIndex = nextIndex[currentIndex];
    nextIndex[currentIndex] = topOfStacks[stackNumber];
    topOfStacks[stackNumber] = currentIndex;
    //print(topOfStacks, stackData, nextIndex, nextAvailableIndex);
  }

  public int pop(int stackNumber) {
    System.out.println("Inside pop stackNumber :"+stackNumber);
    if (stackNumber < 0 || stackNumber >= topOfStacks.length || topOfStacks[stackNumber] < 0) {
      throw new IndexOutOfBoundsException();
    }

    int currentIndex = topOfStacks[stackNumber];
    int value = stackData[currentIndex];
    topOfStacks[stackNumber] = nextIndex[currentIndex];
    nextIndex[currentIndex] = nextAvailableIndex;
    nextAvailableIndex = currentIndex;
    //print(topOfStacks, stackData, nextIndex, nextAvailableIndex);

    return value;
  }
  
  private void print(int[] topOfStacks, int[] stackData, int[] nextIndex, int nextAvailableIndex) {
    System.out.println("topOfStacks");
    
    for (int i : topOfStacks) {
      System.out.print(i+"\t");
    }
    System.out.println();
    
    System.out.println("stackData");
    
    for (int i : stackData) {
      System.out.print(i+"\t");
    }
    System.out.println();
    
    System.out.println("nextIndex");
    
    for (int i : nextIndex) {
      System.out.print(i+"\t");
    }
    System.out.println();
    
    System.out.println("nextAvailableIndex: "+nextAvailableIndex);
  }

}
