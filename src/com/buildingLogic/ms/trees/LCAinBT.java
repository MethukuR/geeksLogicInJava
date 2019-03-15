package com.buildingLogic.ms.trees;

public class LCAinBT {
  private boolean n1Present = false, n2Present = false;
  public static void main(String[] args) {

  }
  
  public TreeNode findLCAInBT(TreeNode root, int n1, int n2) {
    TreeNode node = findLCAInBTUtil(root, n1, n2);
    
    if(node == null) {
      return null;
    }
    
    return (n1Present && n2Present) ? node : null;
  }
  
  private  TreeNode findLCAInBTUtil(TreeNode root, int n1, int n2) {
    
    if(root == null) {
      return null;
    }
    
    TreeNode temp = null;
    
    if(root.getData() == n1) {
      n1Present = true;
      temp = root;
    }
    
    if(root.getData() == n2) {
      n2Present = true;
      temp = root;
    }
    
    TreeNode left = findLCAInBTUtil(root.getLeft(), n1, n2);
    TreeNode right = findLCAInBTUtil(root.getRight(), n1, n2);
    
    if(temp != null) {
      return temp;
    }
    
    if(left != null && right != null) {
      return root;
    }
    
    return (left == null) ? right : left;
  }

}
