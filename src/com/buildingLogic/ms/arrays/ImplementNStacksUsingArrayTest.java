package com.buildingLogic.ms.arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImplementNStacksUsingArrayTest {
  private Stacks stacks;
  @BeforeEach
  void setUp() throws Exception {
    stacks = new Stacks(3, 6);
  }

  @Test
  void testForInvalidStackNumberAsInput() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.push(4, 56);
    });
  }
  
  @Test
  void testForPoppingWhenDataisEmpty() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.pop(2);
    });
  }
  
  @Test
  void testForInsertingBeyondCapacity() {
    stacks.push(0, 5);
    stacks.push(1, 7);
    stacks.push(2, 8);
    stacks.push(0, 5);
    stacks.push(1, 7);
    stacks.push(2, 8);
    
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.push(2, 8);
    });
  }
  
  @Test
  void testForSimultaneousPushAndPopInOneStack() {
    stacks.push(0, 5);
    stacks.push(0, 7);
    
    assertEquals(7, stacks.pop(0));
    assertEquals(5, stacks.pop(0));
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.pop(0);
    });
  }
  
  @Test
  void testForSimultaneousPushAndPopInMultipleStacks() {
    stacks.push(0, 5);
    stacks.push(1, 7);
    stacks.push(2, 8);

    
    assertEquals(5, stacks.pop(0));
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.pop(0);
    });
    
    assertEquals(7, stacks.pop(1));
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.pop(1);
    });
    
    assertEquals(8, stacks.pop(2));
    assertThrows(IndexOutOfBoundsException.class, () -> {
      stacks.pop(2);
    });
  }

}
