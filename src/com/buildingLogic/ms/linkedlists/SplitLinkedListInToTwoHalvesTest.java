package com.buildingLogic.ms.linkedlists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplitLinkedListInToTwoHalvesTest {
  
  private SplitLinkedListInToTwoHalves splitLinkedListInToTwoHalves;
  
  @BeforeEach
  void setUp() throws Exception {
    splitLinkedListInToTwoHalves = new SplitLinkedListInToTwoHalves();
  }

  @Test
  void testBaseCases() {
    assertEquals(null, splitLinkedListInToTwoHalves.split(null));
    assertEquals(null, splitLinkedListInToTwoHalves.split(new Node(5)));
  }
  
  @Test
  void testForEvenLengthLinkedList() {
    Node head = new Node(5);
    head.setNext(new Node(3));
    head.getNext().setNext(new Node(2));
    head.getNext().getNext().setNext(new Node(3));
    
    assertEquals(2, splitLinkedListInToTwoHalves.split(head).getData());
  }
  
  @Test
  void testForOddLengthLinkedList() {
    Node head = new Node(5);
    head.setNext(new Node(3));
    head.getNext().setNext(new Node(2));
    head.getNext().getNext().setNext(new Node(3));
    head.getNext().getNext().getNext().setNext(new Node(3));
    
    assertEquals(2, splitLinkedListInToTwoHalves.split(head).getData());
  }

}
