package com.buildingLogic.ms.strings;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PermutationsOfStringOfGivenLengthTest {
  private PermutationsOfStringOfGivenLength  permutationsOfString;
  @BeforeEach
  void setUp() throws Exception {
    permutationsOfString = new PermutationsOfStringOfGivenLength();
  }

  @Test
  void testAllBaseCases() {
    assertEquals(null, permutationsOfString.findPermutations(null));
    assertTrue(permutationsOfString.findPermutations("").contains(""));
    assertEquals(1, permutationsOfString.findPermutations("").size());
    assertTrue(permutationsOfString.findPermutations("a").contains("a"));
    assertEquals(1, permutationsOfString.findPermutations("a").size());
  }
  
  @Test
  void testForGivenString() {
    assertEquals(6, permutationsOfString.findPermutations("abc").size());
    assertTrue(permutationsOfString.findPermutations("abc").
        containsAll(Arrays.asList(new String[] {"abc", "acb", "bac", "bca", "cab", "cba"})));

  }

}
