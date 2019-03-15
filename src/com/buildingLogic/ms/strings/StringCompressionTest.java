package com.buildingLogic.ms.strings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCompressionTest {

  private StringCompression stringCompression;
  
  @BeforeEach
  void setUp() throws Exception {
    stringCompression = new StringCompression();
  }

  @Test
  void testBaseCases() {
    assertEquals("", stringCompression.compressString(""));
    assertEquals("a1", stringCompression.compressString("a"));
  }
  
  @Test
  void testForDifferentLastTwoCharacters() {
    assertEquals("a3b5c1", stringCompression.compressString("aaabbbbbc"));
  }
  
  @Test
  void testForSameLastTwoCharacters() {
    assertEquals("a3b2c6", stringCompression.compressString("aaabbcccccc"));
  }
  
  @Test
  void testForCompressedStringLengthGreateThanOrEqualsInput() {
    assertEquals("aaabbc", stringCompression.compressString("aaabbc"));
  }

}
