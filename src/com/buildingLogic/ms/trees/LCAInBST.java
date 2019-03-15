package com.buildingLogic.ms.trees;

public class LCAInBST {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  // recursive
  public TreeNode findLCA(TreeNode root, int n1, int n2) {
    if (root == null) {
      return null;
    }

    if (root.getData() > n1 && root.getData() > n2) {
      return findLCA(root.getLeft(), n1, n2);
    }

    if (root.getData() < n1 && root.getData() < n2) {
      return findLCA(root.getRight(), n1, n2);
    }

    return root;

  }

  //iterative
  public TreeNode findLCAIterative(TreeNode root, int n1, int n2) {
    if (root == null) {
      return null;
    }

    while (root != null) {
      if (root.getData() > n1 && root.getData() > n2) {
        root = root.getLeft();
      }
      else if (root.getData() < n1 && root.getData() < n2) {
        root = root.getRight();
      }
      else {
        break;
      }
    }

    return root;
  }

}
