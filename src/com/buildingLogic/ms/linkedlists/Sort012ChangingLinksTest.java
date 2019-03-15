package com.buildingLogic.ms.linkedlists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sort012ChangingLinksTest {
  
  private Sort012ChangingLinks sort012ChangingLinks;
  
  @BeforeEach
  void setUp() throws Exception {
    sort012ChangingLinks = new Sort012ChangingLinks();
  }

  @Test
  void testForLengthZero() throws Exception {
    assertEquals(null, sort012ChangingLinks.sort(null));
  }
  
  @Test
  void testForLengthOne() throws Exception {
    Node head = new Node(0);
    assertEquals(head, sort012ChangingLinks.sort(head));
    assertTrue(compareLL(head, sort012ChangingLinks.sort(head)));
  }
  
  @Test
  void testForInvalidInput() throws Exception {
    Node head = new Node(0);
    head.setNext(new Node(5));
    assertThrows(Exception.class, () -> {
      sort012ChangingLinks.sort(head);
    });
  }
  
  @Test
  void testForValidInput() throws Exception {
    Node head = new Node(2);
    head.setNext(new Node(1));
    head.getNext().setNext(new Node(1));
    head.getNext().getNext().setNext(new Node(0));
    head.getNext().getNext().getNext().setNext(new Node(2));
    
    Node result = new Node(0);
    result.setNext(new Node(1));
    result.getNext().setNext(new Node(1));
    result.getNext().getNext().setNext(new Node(2));
    result.getNext().getNext().getNext().setNext(new Node(2));

    assertTrue(compareLL(result, sort012ChangingLinks.sort(head)));
    
  }
  
  @Test
  void testForOnlyOnes() throws Exception {
    Node head = new Node(1);
    head.setNext(new Node(1));
    head.getNext().setNext(new Node(1));
    head.getNext().getNext().setNext(new Node(1));
    head.getNext().getNext().getNext().setNext(new Node(1));
    
    Node result = new Node(1);
    result.setNext(new Node(1));
    result.getNext().setNext(new Node(1));
    result.getNext().getNext().setNext(new Node(1));
    result.getNext().getNext().getNext().setNext(new Node(1));

    assertTrue(compareLL(result, sort012ChangingLinks.sort(head)));
    
  }
  
  @Test
  void testForOnlyOnesAndTwo() throws Exception {
    Node head = new Node(2);
    head.setNext(new Node(1));
    head.getNext().setNext(new Node(1));
    head.getNext().getNext().setNext(new Node(2));
    head.getNext().getNext().getNext().setNext(new Node(1));
    
    Node result = new Node(1);
    result.setNext(new Node(1));
    result.getNext().setNext(new Node(1));
    result.getNext().getNext().setNext(new Node(2));
    result.getNext().getNext().getNext().setNext(new Node(2));

    assertTrue(compareLL(result, sort012ChangingLinks.sort(head)));
    
  }
  
  @Test
  void testForOnlyZeroesesAndTwo() throws Exception {
    Node head = new Node(2);
    head.setNext(new Node(0));
    head.getNext().setNext(new Node(2));
    head.getNext().getNext().setNext(new Node(0));
    head.getNext().getNext().getNext().setNext(new Node(0));
    
    Node result = new Node(0);
    result.setNext(new Node(0));
    result.getNext().setNext(new Node(0));
    result.getNext().getNext().setNext(new Node(2));
    result.getNext().getNext().getNext().setNext(new Node(2));

    assertTrue(compareLL(result, sort012ChangingLinks.sort(head)));
    
  }
  
  
  
  private static boolean compareLL(Node head1, Node head2) {
    if(head1 == null && head2 == null) {
      return true;
    }
    
    if(head1 == null || head2 == null) {
      return false;
    }
    
    boolean equal = true;
    
    while(head1 != null || head2 != null) {
      if(head1 == null || head2 == null || head1.getData() != head2.getData()) {
        equal = false;
        break;
      }
      
      head1 =head1.getNext();
      head2 = head2.getNext();
    }
    
    return equal ;
  }
  
}
