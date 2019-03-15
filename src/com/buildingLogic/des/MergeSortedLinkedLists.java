package com.buildingLogic.des;

public class MergeSortedLinkedLists {
  
  public static void main(String[] args) {
    
    Node l1 = new Node(1);
    l1.setNext(new Node(3));
    l1.getNext().setNext(new Node(6));
    l1.getNext().getNext().setNext(new Node(9));
    
    Node l2 = new Node(4);
    l2.setNext(new Node(5));
    l2.getNext().setNext(new Node(6));
    l2.getNext().getNext().setNext(new Node(8));
    l2.getNext().getNext().getNext().setNext(new Node(90));
    
    Node mergedNode = merge(l1, l2);
    printList(mergedNode);
    
  }
  
  private static void printList(Node intersection) {
    if(intersection == null) {
      System.out.println("empty");
    }
    Node temp = intersection ;   
    while(temp != null) {
      System.out.print(temp.getData() + "\t");
      temp = temp.getNext();
    }
  }
  
  private static Node merge(Node l1, Node l2) {
    
    if(l1 == null && l2 == null) {
      return null;
    }
    
    if(l1 == null) {
      return l2;
    }
    
    if(l2 == null) {
      return l1;
    }
    
    Node newHead = null, temp = null;
    
    if(l1.getData() <= l2.getData()) {
      temp = l1;
      l1 = l1.getNext();
    }else {
      temp = l2;
      l2 = l2.getNext();
    }
    
    newHead = temp;
    
    while( l1 != null && l2 != null) {
      if(l1.getData() <= l2.getData()) {
        temp.setNext(l1);
        l1 = l1.getNext();
      }else {
        temp.setNext(l2);
        l2 = l2.getNext();
      }
      temp = temp.getNext();
    }
    
    if( l1 == null) {
      temp.setNext(l2);
    }
    
    if( l2 == null) {
      temp.setNext(l1);
    }
    return newHead;
  }
}
