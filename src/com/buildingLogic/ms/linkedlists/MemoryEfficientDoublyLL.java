package com.buildingLogic.ms.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class MemoryEfficientDoublyLL {

  private class Node {
    private int data;
    private int npx;
    
    public Node(int data) {
      super();
      this.data = data;
    }

    public int getData() {
      return data;
    }

    public int getNpx() {
      return npx;
    }

    public void setNpx(int npx) {
      this.npx = npx;
    }
  }

  private Node head;
  private Map<Integer, Node> addressMap = new HashMap<Integer, Node>();

  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      addressMap.put(newNode.hashCode(), newNode);
      head = newNode;
      return;
    }

    Node cur = head;
    int curNpx = cur.getNpx();
    cur.setNpx(newNode.hashCode() ^ curNpx);
    newNode.setNpx(cur.hashCode());
    addressMap.put(newNode.hashCode(), newNode);
    head = newNode;
  }


  public void printList() {
    if (head == null) {
      System.out.println("empty");
    }

    Node cur = head;
    int previous = 0;
    System.out.println();
    while (cur != null) {
      System.out.print(cur.getData() + "\t");
      int curNpx = cur.getNpx();
      int curHashCode = cur.hashCode();
      Node next  = addressMap.get(previous ^ curNpx);
      previous = curHashCode;
      cur = next;
    }
  }

  public static void main(String[] args) {
    MemoryEfficientDoublyLL doublyLL = new MemoryEfficientDoublyLL();
    doublyLL.insertAtBeginning(5);
    doublyLL.insertAtBeginning(4);

    doublyLL.insertAtBeginning(3);

    doublyLL.insertAtBeginning(2);

    doublyLL.insertAtBeginning(5);

    doublyLL.printList();


  }

}
