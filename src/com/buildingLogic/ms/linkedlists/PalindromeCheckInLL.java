package com.buildingLogic.ms.linkedlists;

import java.util.Stack;

public class PalindromeCheckInLL {
  public static void main(String[] args) {
    
  }

  public boolean isPalindrome(Node head) {
    if(head == null || head.getNext() == null) {
      return true;
    }
    
    Node cur = head;
    Node runner = head;
    Stack<Integer> s = new Stack<Integer>();
    
    while(runner != null && runner.getNext() != null) {
      s.push(cur.getData());
      cur = cur.getNext();
      runner = runner.getNext().getNext();
    }
    
    if(runner != null) { // LL has odd number of elements
      cur = cur.getNext();
    }
    boolean isPalindrome = true;
    
    while(!s.isEmpty()) {
      if(s.pop().intValue() != cur.getData()){
        isPalindrome = false;
        break;
      }
      cur = cur.getNext();
    }
    return isPalindrome;
  }
}
