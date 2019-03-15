package com.buildingLogic.des;

import com.buildingLogic.ms.trees.TreeNode;

public class PrintSingleNodes {

  public static void main(String[] args) {
    TreeNode rootOne = new TreeNode(6);
    rootOne.setLeft(new TreeNode(10));
    rootOne.setRight(new TreeNode(2));
    rootOne.getLeft().setLeft(new TreeNode(1));
    rootOne.getRight().setRight(new TreeNode(12));
    
    printSingleNodes(rootOne);

  }

  private static void printSingleNodes(TreeNode root) {
    if(root == null) {
      return;
    }
    
    if(root.getLeft() != null && root.getRight() != null) {
      printSingleNodes(root.getLeft());
      printSingleNodes(root.getRight());
    }
    
    else if(root.getLeft() != null) {
      System.out.print(root.getLeft().getData() + "\t");
      printSingleNodes(root.getLeft());
    }
    
    else if(root.getRight() != null) {
      System.out.print(root.getRight().getData() + "\t");
      printSingleNodes(root.getRight());
    }
  }

}
