package com.buildingLogic.des;

import java.util.Stack;

public class ImplementQueueUsingStack {
  private static Stack<Integer> sOne = new Stack<Integer>();
  private static Stack<Integer> sTwo = new Stack<Integer>();
  
  public static void main(String[] args) {
    ImplementQueueUsingStack q = new ImplementQueueUsingStack();  
    q.enQueue(1);  
    q.enQueue(2);  
    q.enQueue(3);  
  
    System.out.println(q.deQueue());  
    System.out.println(q.deQueue()); 
    System.out.println(q.deQueue());
  }

  private int deQueue() {
    return sOne.pop();
  }

  private void enQueue(int i) {
    if(!sOne.isEmpty()) {
      while(!sOne.isEmpty()) {
        sTwo.push(sOne.pop());
      }
      sOne.push(i);
      
      while(!sTwo.isEmpty()) {
        sOne.push(sTwo.pop());
      }
    }else {
      sOne.push(i);
    }
  }
  
  // Pop is costly
  /*private void enQueue(int i) {
    sOne.push(i);
  }

  private int deQueue() {
    if(sTwo.isEmpty()) {
      while(!sOne.isEmpty()) {
        sTwo.push(sOne.pop());
      }
      
      return sTwo.pop();
    }else {
      return sTwo.pop();
    }
  }*/

  

}
