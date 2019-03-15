package com.buildingLogic.ms.linkedlists;

public class Sort012ChangingLinks {

  public static void main(String[] args) {

  }
  
  public Node sort(Node head) throws Exception {
    if(head == null || head.getNext() == null) {
      return head;
    }
    Node zeroHead =null, zeroTail = null;
    Node oneHead =null, oneTail = null;
    Node twoHead =null, twoTail = null;
    
    Node cur = head;
    
    while(cur != null) {
      if(cur.getData() == 0) {
        if(zeroHead == null) {
          zeroHead = zeroTail = cur;
        }else {
          zeroTail.setNext(cur);
          zeroTail = zeroTail.getNext();
        }
      }else if(cur.getData() == 1) {
        if(oneHead == null) {
          oneHead = oneTail = cur;
        }else {
          oneTail.setNext(cur);
          oneTail = oneTail.getNext();
        }
      }else if(cur.getData() == 2){
        if(twoHead == null) {
          twoHead = twoTail = cur;
        }else {
          twoTail.setNext(cur);
          twoTail = twoTail.getNext();
        }
      }else {
        throw new Exception();
      }
      
      cur = cur.getNext();
    }
    
    if(twoHead != null) {
      twoTail.setNext(null);
    }
    
    if(zeroHead != null) {
      if(oneHead != null) {
        zeroTail.setNext(oneHead);
        oneTail.setNext(twoHead);
      }else {
        zeroTail.setNext(twoHead);
      }
    }else {
      if(oneHead != null) {
        oneTail.setNext(twoHead);
        zeroHead = oneHead;
      }else {
        zeroHead = twoHead;
      }
    }
    
    return zeroHead;
  }

}
