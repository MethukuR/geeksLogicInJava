package com.buildingLogic.ms.linkedlists;

public class MaxInStackLinkedList {

  public static void main(String[] args) {

  }
  
  class Node{
    private int data;
    private Node oldMax;
    private Node next;
    
    public Node(int data) {
      super();
      this.data = data;
    }
    public int getData() {
      return data;
    }
    public Node getOldMax() {
      return oldMax;
    }
    public Node getNext() {
      return next;
    }
    public void setNext(Node next) {
      this.next = next;
    }
    public void setOldMax(Node max) {
      this.oldMax = max;
    }
    @Override
    public String toString() {
      return "Node [data=" + data + ", oldMax=" + oldMax + ", next=" + next + "]";
    }
    
  }
  
  private Node stack;
  private Node max;
  
  public Node getStack() {
    return stack;
  }

  public void setStack(Node stack) {
    this.stack = stack;
  }

  public Node getMax() {
    return max;
  }

  public void setMax(Node max) {
    this.max = max;
  }

  public void push(int data) {

    Node newNode = new Node(data);
    
    if(stack == null) {
      stack = newNode;
    }else {
      newNode.setNext(stack);
      stack = newNode;
    }
    
    if(max == null || newNode.getData() > max.getData()) {
      newNode.setOldMax(max);
      max = newNode;
    }
    
  }
  
  public int pop() {
    if(stack == null) {
      throw new NullPointerException();
    }
    
    Node cur = stack;
    int value = cur.getData();
    
    if(cur.getOldMax() != null) {
      max = cur.getOldMax();
    }
    stack = stack.getNext();
    if(stack == null) {
      max = null;
    }
    return value;
  }
 
  public int findMax() {
    if(max == null) {
      throw new NullPointerException();
    }
    return max.getData();
  }
  
  private static void printStack(Node stack, Node max) {
    Node temp = stack;
    while(temp != null) {
      System.out.println(temp +".Max=> "+max);
      temp = temp.getNext();
    }
  }

}
