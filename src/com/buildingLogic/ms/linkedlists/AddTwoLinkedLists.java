/**
 * Add two numbers represented by linked lists: 
 * ============================================ 
 * Given
 * two numbers represented by two linked lists, write a function that returns sum list. The sum list
 * is linked list representation of addition of two input numbers. It is not allowed to modify the
 * lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
 * 
 * Example
 * 
 * Input: First List: 5->6->3 // represents number 563 Second List: 8->4->2 // represents number 842
 * Output Resultant list: 1->4->0->5 // represents number 1405
 * 
 */
package com.buildingLogic.ms.linkedlists;




public class AddTwoLinkedLists {

  public static void main(String[] args) {
    Node head1, head2;

    // creating first list
    head1 = new Node(7);
    head1.setNext(new Node(5));
    head1.getNext().setNext(new Node(9));
    head1.getNext().getNext().setNext(new Node(4)); 
    head1.getNext().getNext().getNext().setNext(new Node(6));
    System.out.println("First List is ");
    printList(head1);

    // creating second list
    head2 = new Node(8);
    head2.setNext(new Node(4));
    System.out.println("Second List is ");
    printList(head2);

    // add the two lists and see the result
    Node rs = addTwoLists(head1, head2);
    System.out.println("Resultant List is ");
    printList(rs);
  }

  private static Node addTwoLists(Node head1, Node head2) {
    if(head1 == null && head2 == null) {
      return null;
    }
    
    if(head1 == null) {
      return head2;
    }
    
    if(head2 == null) {
      return head1;
    }
    
    Node rev1 = reverseList(head1);
    System.out.println("First List is ");
    printList(rev1);
    Node rev2 = reverseList(head2);
    System.out.println("Second List is ");
    printList(rev2);

    
    int sum = 0;
    int carry = 0;
    Node sumNode = null, temp = null;
    
    while(rev1 != null || rev2 != null) {
      sum += ((rev1 != null) ? rev1.getData() : 0) + ((rev2 != null) ? rev2.getData() : 0);
      carry = sum/10;
      sum = sum%10;
      
      if(sumNode == null) {
        sumNode = temp = new Node(sum);
      }else {
        temp.setNext(new Node(sum));
        temp = temp.getNext();
      }
      
      if(rev1 != null) {
        rev1 = rev1.getNext();
      }
      
      if(rev2 != null) {
        rev2 = rev2.getNext();
      }
    }
    
    if(carry > 0) {
      temp.setNext(new Node(carry));
    }
    
    sumNode = reverseList(sumNode);
    
    return sumNode;
  }

  private static Node reverseList(Node head) {
    if(head == null || head.getNext() == null) {
      return head;
    }
    
    Node prev = null, cur = head , next = null;
    
    while(cur != null) {
      next = cur.getNext();
      cur.setNext(prev);
      prev = cur;
      cur = next;
    }
    
    head = prev;
    
    return head;
  }

  private static void printList(Node head) {
    while (head != null) {
      System.out.print(head.getData() + "\t");
      head = head.getNext();
    }
    System.out.println();
  }

}

/*
 * 
    if(null == head1 && null == head2) {
      return null;
    }
    
    if(null == head1) {
      return head2;
    }
    
    if(null == head2) {
      return head1;
    }
    
    Node sumList = null, temp = null;
    Node rHead1 = reverseList(head1);
    System.out.print("First List reverse ");
    printList(rHead1);

    Node rHead2 = reverseList(head2);
    System.out.print("Second List reverse ");
    printList(rHead2);

    
    int carry = 0, sum = 0;
    
    while(null != rHead1 || null != rHead2) {
      sum = carry + ( null != rHead1 ? rHead1.data : 0 ) + ( null != rHead2 ? rHead2.data : 0 );
      carry = sum / 10;
      sum = sum % 10;
      
      if(null == sumList) {
        sumList = temp = new Node(sum);
      }else {
        temp.next = new Node(sum);
        temp = temp.next;
      }
      
      if( null != rHead1) {
        rHead1 = rHead1.next;
      }
      if( null != rHead2) {
        rHead2 = rHead2.next;
      }
    }
    
    if(carry > 0) {
      temp.next = new Node(carry);
    }
    
    sumList = reverseList(sumList);

    return sumList;
  
 */


