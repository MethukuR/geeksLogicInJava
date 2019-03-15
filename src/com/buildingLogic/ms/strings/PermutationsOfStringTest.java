package com.buildingLogic.ms.strings;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PermutationsOfStringTest {
  
  private PermutationsOfString permutationsOfString;

  @Before
  public void setUp() throws Exception {
    permutationsOfString = new PermutationsOfString();
  }

  @Test
  public void test() {
    assertEquals(null, permutationsOfString.permutationsFinder(null));
    assertTrue(permutationsOfString.permutationsFinder("a").contains("a"));
    assertEquals(6, permutationsOfString.permutationsFinder("abc").size());
    assertEquals(1, permutationsOfString.permutationsFinder("").size());
  }

}
