package com.buildingLogic.ms.linkedlists;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Before;
import org.junit.Test;


public class MaxInStackLinkedListTest {
  
  MaxInStackLinkedList  maxInStackLinkedList;
  @Before
  public void setUp() throws Exception {
    maxInStackLinkedList = new MaxInStackLinkedList();
  }

  @Test
  public void testForEmptyLinkedList() {
    assertThrows(NullPointerException.class, () -> maxInStackLinkedList.findMax());
  }
  
  @Test
  public void testForElementsFilledInDescendingOrder() {
    
    maxInStackLinkedList.push(5); 
    maxInStackLinkedList.push(4);
    maxInStackLinkedList.push(3);
    
    assertEquals(5, maxInStackLinkedList.getMax().getData());

    maxInStackLinkedList.pop();
    assertEquals(5, maxInStackLinkedList.getMax().getData());
    
    maxInStackLinkedList.pop();
    assertEquals(5, maxInStackLinkedList.getMax().getData());
    
    maxInStackLinkedList.pop();
    assertThrows(NullPointerException.class, () -> maxInStackLinkedList.findMax());
    
  }
  
  @Test
  public void testForElementsFilledInAscendingOrder() {
    maxInStackLinkedList.push(3); 
    maxInStackLinkedList.push(4);
    maxInStackLinkedList.push(5);
    
    assertEquals(5, maxInStackLinkedList.getMax().getData());

    maxInStackLinkedList.pop();
    assertEquals(4, maxInStackLinkedList.getMax().getData());
    
    maxInStackLinkedList.pop();
    assertEquals(3, maxInStackLinkedList.getMax().getData());
    
    maxInStackLinkedList.pop();
    assertThrows(NullPointerException.class, () -> maxInStackLinkedList.findMax());

  }


}
