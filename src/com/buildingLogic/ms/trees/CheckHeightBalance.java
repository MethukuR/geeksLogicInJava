package com.buildingLogic.ms.trees;

public class CheckHeightBalance {
  
  public boolean isHeightBalanced(TreeNode root) {
    if(root == null) {
      return true;
    }
    System.out.println(heightBalancedUtil(root));
    return (heightBalancedUtil(root) != -1);
  }

  private static int heightBalancedUtil(TreeNode node) {
    if(node == null) {
      return 0;
    }
    
    int leftHeight = heightBalancedUtil(node.getLeft());
    if(leftHeight == -1) {
      return -1;
    }
    
    int rightHeight = heightBalancedUtil(node.getRight());
    if(rightHeight == -1) {
      return -1;
    }
    
    if(Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    
    return ( 1 + Math.max(leftHeight, rightHeight));
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.setLeft(new TreeNode(2));
    root.getLeft().setLeft(new TreeNode(3));
    
    CheckHeightBalance cs = new CheckHeightBalance();
    System.out.println(cs.isHeightBalanced(root));
  }
}
