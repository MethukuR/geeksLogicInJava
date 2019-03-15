package com.buildingLogic.des;

public class MergePointOfTwoLinkedLists {

  public static void main(String[] args) {
    Node l1 = new Node(1);
    l1.setNext(new Node(3));
    l1.getNext().setNext(new Node(7));
    l1.getNext().getNext().setNext(new Node(9));
    
    Node l2 = new Node(4);
    l2.setNext(new Node(5));
    l2.getNext().setNext(new Node(2));
    l2.getNext().getNext().setNext(new Node(8));
    l2.getNext().getNext().getNext().setNext(new Node(90));
    System.out.println(mergePoint(l1, l2));
  }

  private static int mergePoint(Node l1, Node l2) {
    if (l1 == null || l2 == null) {
      return -1;
    }

    int l1Len = length(l1);
    int l2Len = length(l2);

    int diff = Math.abs(l1Len - l2Len);

    Node p = l1;
    Node q = l2;
    if (l1Len > l2Len) {
      p = moveNodesForward(l1, diff);
    } else if (l1Len < l2Len) {
      q = moveNodesForward(l2, diff);
    }

    while (p != null  && q != null && p.getData() != q.getData()) {
      p = p.getNext();
      q = q.getNext();
    }

    if (p != null  && q != null && p.getData() == q.getData()) {
      return p.getData();
    }
    return -1;
  }

  private static Node moveNodesForward(Node l, int diff) {
    while (diff > 0) {
      if (l == null) {
        return null;
      }
      l = l.getNext();
      --diff;
    }
    return l;
  }

  private static int length(Node l) {
    int count = 0;
    while (l != null) {
      count++;
      l = l.getNext();
    }
    return count;
  }

}
