package com.buildingLogic.ms.trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeNext {
  private int data;
  private TreeNodeNext left;
  private TreeNodeNext right;
  private TreeNodeNext next;
  public int getData() {
    return data;
  }
  public void setData(int data) {
    this.data = data;
  }
  public TreeNodeNext getLeft() {
    return left;
  }
  public void setLeft(TreeNodeNext left) {
    this.left = left;
  }
  public TreeNodeNext getRight() {
    return right;
  }
  public void setRight(TreeNodeNext right) {
    this.right = right;
  }
  public TreeNodeNext getNext() {
    return next;
  }
  public void setNext(TreeNodeNext next) {
    this.next = next;
  }
  @Override
  public String toString() {
    return "TreeNodeNext [data=" + data + ", left=" + left + ", right=" + right + ", next=" + next
        + "]";
  }
  public TreeNodeNext(int data) {
    super();
    this.data = data;
  }
  
  
}
public class ConnectNodesAtSameLevel {
  
  public void printPreOrder(TreeNodeNext root) {
    if(root == null) {
      return;
    }
    
    System.out.println(root.getData() + "---" + (root.getNext() != null ? root.getNext().getData() : null));
    printPreOrder(root.getLeft());
    printPreOrder(root.getRight());
  }
  
  public void connect(TreeNodeNext root) {
    if(root == null) {
      return;
    }
    
    Queue<TreeNodeNext> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    
    while(!q.isEmpty()) {
      TreeNodeNext cur = q.poll();
      
      if(cur != null) {
        cur.setNext(q.peek());
        
        if(cur.getLeft() != null) {
          q.add(cur.getLeft());
        }
        
        if(cur.getRight() != null) {
          q.add(cur.getRight());
        }
      }
      else if( !q.isEmpty()) {
        q.add(null);
      }
      
    }
  }
  
  public static void main(String[] args) {
    TreeNodeNext root= new TreeNodeNext(1);
    root.setLeft(new TreeNodeNext(2));
    root.setRight(new TreeNodeNext(3));
    root.getRight().setLeft(new TreeNodeNext(7));
    root.getRight().setRight(new TreeNodeNext(8));
    
    ConnectNodesAtSameLevel atSameLevel = new ConnectNodesAtSameLevel();
    atSameLevel.connect(root);
    
    atSameLevel.printPreOrder(root);
   
  }
}
