package com.buildingLogic.ms.numbers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmallestChangeTest {

  private SmallestChange smallestChange;
  
  @BeforeEach
  void setUp() throws Exception {
    smallestChange = new SmallestChange();
  }

  @Test
  void testBaseCases() {
    assertEquals(0, smallestChange.findMinCoins(0, new int[] {}));
  }
  
  @Test
  void testForAmount32() {
    assertEquals(4, smallestChange.findMinCoins(32, new int[] {1, 5, 10, 25}));
  }
  
  @Test
  void testForAmount25() {
    assertEquals(5, smallestChange.findMinCoins(25, new int[] {1, 2, 3, 4, 5}));
  }

}
