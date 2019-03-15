package com.buildingLogic.ms.arrays;

import java.util.Stack;

public class MinInSpecialStack {

  private Stack<Integer> specialStack;
  private Stack<Integer> auxillaryStack;
  
  public MinInSpecialStack() {
    specialStack = new Stack<>();
    auxillaryStack = new Stack<>();
  }
  
  public void push(int data) {
    if(specialStack.isEmpty()) {
      specialStack.push(data);
      auxillaryStack.push(data);
    }else {
      specialStack.push(data);
      
      int curMin = auxillaryStack.peek();
      if(data <= curMin) {
        auxillaryStack.push(data);
      }
    }
  }
  
  public int pop() {
    if(specialStack.isEmpty()) {
      throw new IndexOutOfBoundsException();
    }else {
      int poppedValue = specialStack.pop();
      
      int curMin = auxillaryStack.peek();
      if(poppedValue == curMin) {
        auxillaryStack.pop();
      }
      
      return poppedValue;
    }
  }
  
  public int getMin() {
    if(specialStack.isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    
    return auxillaryStack.peek();
  }

}
