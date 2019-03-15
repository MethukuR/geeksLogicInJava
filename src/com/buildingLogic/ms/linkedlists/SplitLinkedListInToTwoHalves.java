package com.buildingLogic.ms.linkedlists;

public class SplitLinkedListInToTwoHalves {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  public Node split(Node head) {
    if(head == null || head.getNext() == null) {
      return null;
    }
    
    Node cur = head;
    Node runner = head;
    
    while(runner != null && runner.getNext() != null) {
      runner = runner.getNext().getNext();
      cur= cur.getNext();
    }
    return cur;
  }

}
