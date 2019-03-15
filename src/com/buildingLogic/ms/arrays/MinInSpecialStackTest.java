package com.buildingLogic.ms.arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinInSpecialStackTest {

  private MinInSpecialStack minInSpecialStack;
  
  @BeforeEach
  void setUp() throws Exception {
    minInSpecialStack = new MinInSpecialStack();
  }

  @Test
  void testForInvalidOperation() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      minInSpecialStack.getMin();
    });
  }
  
  @Test
  void testForRandonOperations() {
    minInSpecialStack.push(5);
    assertEquals(5, minInSpecialStack.getMin());
    
    minInSpecialStack.push(5);
    minInSpecialStack.push(4);
    minInSpecialStack.push(4);

    assertEquals(4, minInSpecialStack.getMin());
    
    minInSpecialStack.pop();
    
    assertEquals(4, minInSpecialStack.getMin());
    
    minInSpecialStack.pop();
    
    assertEquals(5, minInSpecialStack.getMin());

  }

}
