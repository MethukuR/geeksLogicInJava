package com.buildingLogic.ms.trees;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    
   
    public TreeNode(int data) {
      super();
      this.data = data;
      this.left = this.right = this.parent = null;
    }
    
    public int getData() {
      return data;
    }
    public void setData(int data) {
      this.data = data;
    }
    public TreeNode getLeft() {
      return left;
    }
    public void setLeft(TreeNode left) {
      this.left = left;
    }
    public TreeNode getRight() {
      return right;
    }
    public void setRight(TreeNode right) {
      this.right = right;
    }
    public TreeNode getParent() {
      return parent;
    }
    public void setParent(TreeNode parent) {
      this.parent = parent;
    }
    @Override
    public String toString() {
      return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + ", parent=" + parent
          + "]";
    }
    
    
}
