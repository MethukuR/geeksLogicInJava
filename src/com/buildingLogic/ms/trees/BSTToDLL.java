package com.buildingLogic.ms.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BSTToDLL {
  private static TreeNode prev, head;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    
    BSTToDLL bstToDLL = new BSTToDLL();
    bstToDLL.convertBTToDLL(root);
    bstToDLL.printDLL(head);
    
    //bstToDLL.convertBTToDLLBFS(root);
    //bstToDLL.printDLL(bstToDLL.head);


  }
  
  private void convertBTToDLL(TreeNode root) {
    if(root == null) {
      return;
    }
    
    convertBTToDLL(root.getLeft());
    

    if(prev == null) {
      prev = head = root;
    }else {
      root.setLeft(prev);
      prev.setRight(root);
      prev = prev.getRight();
    }
    convertBTToDLL(root.getRight());
  }
  
  private void printDLL(TreeNode head) {
    if(head == null) {
      System.out.println("Empty");
    }
    
    TreeNode cur = head;
    while(cur != null) {
      System.out.print(cur.getData() + "\t");
      cur = cur.getRight();
    }
    System.out.println();
  }
  
  private void convertBTToDLLBFS(TreeNode root) {
    if(root == null) {
      return;
    }
    prev = head = null;
    Queue<TreeNode> q = new LinkedList<TreeNode> ();
    
    q.add(root);
    
    while(!q.isEmpty()) {
      
      TreeNode curNode = q.poll();
      
      if(prev == null) {
        prev = head = curNode;
      }else {
        prev.setRight(curNode);
        curNode.setLeft(prev);
        prev = prev.getRight();
      }
      
      if(curNode.getLeft() != null) {
        q.add(curNode.getLeft());
      }
      
      if(curNode.getRight() != null) {
        q.add(curNode.getRight());
      }
    }
  }


}
