package com.buildingLogic.ms.arrays;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KthMostFrequentTest {
  
  KthMostFrequent kthMostFrequent;
  
  @Before
  public void setUp() throws Exception {
    kthMostFrequent = new KthMostFrequent();
  }

  @Test
  public void testforEmptyInput() {
    String[] arr = {};
    assertEquals("should return null, if input array is empty",null, kthMostFrequent.findKthMostFrequentElement(arr, 1));
  }
  
  @Test
  public void testforInvalidK() {
    String[] arr = {"abc", "def"};
    assertEquals("should return null, if k is greater than number of distinct elements",null, kthMostFrequent.findKthMostFrequentElement(arr, 2));
  }
  
  @Test
  public void testforValidK() {
    String[] arr = {"abc", "abc"};
    assertEquals("should return kth frequent, if k is less than or equal to number of distinct elements","abc", kthMostFrequent.findKthMostFrequentElement(arr, 1));
  }

}
