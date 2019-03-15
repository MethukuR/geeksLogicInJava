package com.buildingLogic.ms.linkedlists;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PalindromeCheckInLLTest {
  
  PalindromeCheckInLL palindromeCheckInLL;
  @Before
  public void setUp() throws Exception {
    palindromeCheckInLL = new PalindromeCheckInLL();
  }

  @Test
  public void testForNullHead() {
    Node head = null;

    assertEquals("should return true if head is null",true, palindromeCheckInLL.isPalindrome(head));
  }
  
  @Test
  public void testForSingleNode() {
    Node head = new Node(5);
    
    assertEquals("should return true if list has only one element",true, palindromeCheckInLL.isPalindrome(head));
  }
  
  @Test
  public void testForEvenElementsPalindrome() {
    Node head = new Node(5);
    head.setNext(new Node(3));
    head.getNext().setNext(new Node(3));
    head.getNext().getNext().setNext(new Node(5));
    
    assertEquals("should return true if list has even number of elements and it is palindrome",true, palindromeCheckInLL.isPalindrome(head));
  }
  
  @Test
  public void testForOddElementsPalindrome() {
    Node head = new Node(5);
    head.setNext(new Node(3));
    head.getNext().setNext(new Node(2));
    head.getNext().getNext().setNext(new Node(3));
    head.getNext().getNext().getNext().setNext(new Node(5));
    
    assertEquals("should return true if list has odd number of elements and it is palindrome",true, palindromeCheckInLL.isPalindrome(head));
  }
  
  @Test
  public void testForOddElementsNonPalindrome() {
    Node head = new Node(5);
    head.setNext(new Node(3));
    head.getNext().setNext(new Node(2));
    head.getNext().getNext().setNext(new Node(3));
    head.getNext().getNext().getNext().setNext(new Node(3));
    
    assertEquals("should return false if list has odd number of elements and it is not palindrome",false, palindromeCheckInLL.isPalindrome(head));
  }
  
  @Test
  public void testForEvenElementsNonPalindrome() {
    Node head = new Node(5);
    head.setNext(new Node(3));
    head.getNext().setNext(new Node(2));
    head.getNext().getNext().setNext(new Node(3));
    
    assertEquals("should return false if list has even number of elements and it is not palindrome",false, palindromeCheckInLL.isPalindrome(head));
  }

}
