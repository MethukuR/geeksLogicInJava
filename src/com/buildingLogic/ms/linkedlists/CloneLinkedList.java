/**
 * Below is the Algorithm:
 * 
 * 1. Create the copy of NodeR 1 and insert it between NodeR 1 & NodeR 2 in original Linked List,
 * create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N
 * after the Nth NodeR 
 * 2. Now copy the random link in this fashion 
 * original->next->random= original->random->next; 
 * //TRAVERSE TWO NODES This works because original->next is nothing but
 * copy of original and Original->random->next is nothing but copy of random.
 * 
 * 3.Now restore the original and copy linked lists in this fashion in a single loop. original->next
 * = original->next->next; copy->next = copy->next->next; 
 * 4.Ensure that original->next is NULL and
 * return the cloned list
 * 
 */
package com.buildingLogic.ms.linkedlists;

class NodeR {
  int data;// NodeR data
  NodeR next, random;// Next and random reference

  // NodeR constructor
  public NodeR(int data) {
    this.data = data;
    this.next = this.random = null;
  }
}


public class CloneLinkedList {

  NodeR head;// Linked list head reference

  // Linked list constructor
  public CloneLinkedList(NodeR head) {
    this.head = head;
  }

  // push method to put data always at the head
  // in the linked list.
  public void push(int data) {
    NodeR NodeR = new NodeR(data);
    NodeR.next = this.head;
    this.head = NodeR;
  }

  // Method to print the list.
  public void print(NodeR temp) {
    while (temp != null) {
      NodeR random = temp.random;
      int randomData = (random != null) ? random.data : -1;
      System.out.println("Data = " + temp.data + ", Random data = " + randomData);
      temp = temp.next;
    }
  }

  public NodeR clone() {
    NodeR originalList = head;
    NodeR clonedList = null;

    while (originalList != null) {
      NodeR temp = originalList.next;
      NodeR newNode = new NodeR(originalList.data);
      originalList.next = newNode;
      newNode.next = temp;
      newNode.random = originalList.random;

      originalList = temp;
    }

    originalList = head;

    while (originalList != null) {
      if (originalList.next != null) {
        originalList.next.random =
            (originalList.random != null) ? originalList.random.next : originalList.random;
      }
      originalList = (originalList.next != null) ? originalList.next.next : originalList.next;
    }

    originalList = head;
    clonedList = head.next;
    NodeR temp = clonedList;

    while (originalList != null && clonedList != null) {
      originalList.next = (originalList.next != null) ? originalList.next.next : originalList.next;
      clonedList.next = (clonedList.next != null) ? clonedList.next.next : clonedList.next;

      originalList = originalList.next;
      clonedList = clonedList.next;

    }
    return temp;
  }

  public static void main(String[] args) {

    // Pushing data in the linked list.
    NodeR start = new NodeR(1);
    start.next = new NodeR(2);
    start.next.next = new NodeR(3);
    start.next.next.next = new NodeR(4);
    start.next.next.next.next = new NodeR(5);

    // 1's random points to 3
    start.random = start.next.next;

    // 2's random points to 1
    start.next.random = start;

    // 3's and 4's random points to 5
    start.next.next.random = start.next.next.next.next;
    start.next.next.next.random = start.next.next.next.next;

    // 5's random points to 2
    start.next.next.next.next.random = start.next;

    CloneLinkedList cl1 = new CloneLinkedList(start);

    System.out.println("Original list : ");
    cl1.print(start);

    System.out.println("Cloned list : ");
    NodeR clonedList = cl1.clone();
    cl1.print(clonedList);

  }
}
