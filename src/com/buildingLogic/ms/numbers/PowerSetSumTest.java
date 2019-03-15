package com.buildingLogic.ms.numbers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PowerSetSumTest {
  
  private PowerSetSum powerSetSum;

  @Before
  public void setUp() throws Exception {
    powerSetSum = new PowerSetSum();
  }

  @Test
  public void test() {
    assertEquals(80, powerSetSum.findPowerSetSum(4));
    assertEquals(0, powerSetSum.findPowerSetSum(0));
    assertEquals(1, powerSetSum.findPowerSetSum(1));
  }

}
