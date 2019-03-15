package com.buildingLogic.des;

public class CountNodesInRange {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.setLeft(new TreeNode(5));
    root.setRight(new TreeNode(50));
    root.getLeft().setLeft(new TreeNode(1));
    root.getRight().setLeft(new TreeNode(40)); 
    root.getRight().setRight(new TreeNode(100));
    System.out.println(getCount(root, 5, 45));
  }

  private static int getCount(TreeNode node, int low, int high) {
    if (node == null) {
      return 0;
    }

    if (node.getData() >= low && node.getData() <= high) {
      return 1 + getCount(node.getLeft(), low, high) + getCount(node.getRight(), low, high);
    }

    if (node.getData() < low) {
      return getCount(node.getRight(), low, high);
    }

    return getCount(node.getLeft(), low, high);
  }

}
