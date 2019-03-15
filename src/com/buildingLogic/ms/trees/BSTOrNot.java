package com.buildingLogic.ms.trees;

public class BSTOrNot {

  public static void main(String[] args) {
    
  }

  public boolean isBST(TreeNode node, int min, int max) {
    if(node == null) {
      return true;
    }
    
    
    if(node.getData() < min || node.getData() > max) {
      return false;
    }
    
    return (isBST(node.getLeft(), min, node.getData()) && 
        isBST(node.getRight(), node.getData()+1, max));
  }

}
