package com.buildingLogic.ms.linkedlists;


public class DetectLoop {

  public static void main(String[] args) {
    Node head = new Node(50); 
    head.setNext(new Node(20)); 
    head.getNext().setNext(new Node(15));  
    head.getNext().getNext().setNext(new Node(4)); 
    head.getNext().getNext().getNext().setNext(new Node(10)); 


    // Creating a loop for testing  
    head.getNext().getNext().getNext().getNext().setNext(head.getNext().getNext()); 
    System.out.println(hasLoop(head));
  }
  private static void printStack(Node node) {
    Node temp = node;
    while(temp != null) {
      System.out.print(temp.getData() + "\t");
      temp = temp.getNext();
    }
  }
  public static boolean  hasLoop(Node start) {
    Node slowPtr = start;
    Node fastPtr = start;
    
    while(fastPtr != null && fastPtr.getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
      
      if(slowPtr == fastPtr) {
        return true;
      }
    }
    
    return false;
  }
  
  public void detectLoopAndRemove(Node start) {
    
    if(start == null  || start.getNext() == null) {
      return ;
    }
    
    Node slowPointer = start;
    Node fastPointer = start;
    
    while(fastPointer != null  && fastPointer.getNext() != null) {
      slowPointer = slowPointer.getNext();
      fastPointer = fastPointer.getNext().getNext();
      if(slowPointer == fastPointer) {
        break;
      }
    }
    
    if(slowPointer == fastPointer) {
      slowPointer = start;
      
      while(slowPointer.getNext() != fastPointer.getNext()) {
        slowPointer = slowPointer.getNext();
        fastPointer = fastPointer.getNext();
      }
      
      fastPointer.setNext(null);
      
    }
  }

}
