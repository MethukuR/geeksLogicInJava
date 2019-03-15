/**
 * Given two lists sorted in increasing order, create and return a new list representing the
 * intersection of the two lists. The new list should be made with its own memory — the original
 * lists should not be changed. For example, let the first linked list be 1->2->3->4->6 and second
 * linked list be 2->4->6->8, then your function should create and return a third list as 2->4->6.
 */
package com.buildingLogic.des;

public class IntersectionSortedLinkedLists {

  public static void main(String[] args) {
    Node l1 = new Node(1);
    l1.setNext(new Node(3));
    l1.getNext().setNext(new Node(7));
    l1.getNext().getNext().setNext(new Node(9));
    Node l2 = new Node(3);
    l2.setNext(new Node(5));
    l2.getNext().setNext(new Node(7));
    l2.getNext().getNext().setNext(new Node(9));
    Node intersection = findIntersection(l1, l2);
    printList(intersection);
  }

  private static void printList(Node intersection) {
    if(intersection == null) {
      System.out.println("empty");
    }
    Node temp = intersection ;   
    while(temp != null) {
      System.out.print(temp.getData() + "\t");
      temp = temp.getNext();
    }
  }

  private static Node findIntersection(Node l1, Node l2) {
    
    if(l1 == null || l2 == null) {
      return null;
    }
    Node newHead = null, temp = null;
    
    while(l1 != null && l2 != null) {
      if(l1.getData() == l2.getData()) {
        Node newNode = new Node(l1.getData());
        if(newHead == null) {
          newHead = temp = newNode;
        }else {
          temp.setNext(newNode);
          temp = temp.getNext();
        }
        l1 = l1.getNext();
        l2 = l2.getNext();
      }else if(l1.getData() < l2.getData()) {
        l1 = l1.getNext();
      }else {
        l2 = l2.getNext();
      }
    }
    
    return newHead;
  }

}
