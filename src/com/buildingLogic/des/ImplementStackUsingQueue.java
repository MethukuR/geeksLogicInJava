package com.buildingLogic.des;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
  static Queue<Integer> q1 = new LinkedList<Integer>(); 
  static Queue<Integer> q2 = new LinkedList<Integer>();
  
  public static void main(String[] args) {
    ImplementStackUsingQueue s = new ImplementStackUsingQueue();  
    s.push(1);  
    s.push(2);  
    s.push(3);  
  
    System.out.println(s.pop());  
    System.out.println(s.pop());  
    System.out.println(s.pop());  
  }

  private int pop() {
    return q1.poll();
  }

  private void push(int i) {
    q2.add(i);
    while(!q1.isEmpty()) {
      q2.add(q1.poll());
    }
    
    Queue<Integer> temp =  q1;
    q1 = q2;
    q2 = temp;
  }

}
