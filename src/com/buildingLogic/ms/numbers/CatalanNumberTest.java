package com.buildingLogic.ms.numbers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CatalanNumberTest {
  
  private CatalanNumber catalanNumber;

  @Before
  public void setUp() throws Exception {
    catalanNumber = new CatalanNumber();
  }

  @Test
  public void test() {
    assertEquals(1, catalanNumber.findCatalanNumber(1));
    assertEquals(2, catalanNumber.findCatalanNumber(2));
    assertEquals(5, catalanNumber.findCatalanNumber(3));
    assertEquals(14, catalanNumber.findCatalanNumber(4));
    assertEquals(42, catalanNumber.findCatalanNumber(5));
  }

}
