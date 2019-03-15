package com.buildingLogic.ms.numbers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotateBitsTest {
  
  private RotateBits rotateBits;
  
  @BeforeEach
  void setUp() throws Exception {
    rotateBits = new RotateBits();
  }

  @Test
  void testRotateBy8Bits() {
    assertEquals(0, rotateBits.rotateBitsRight(0, 8));
    assertEquals(117440512, rotateBits.rotateBitsRight(7, 8));
  }

}
