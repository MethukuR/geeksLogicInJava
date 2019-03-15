package com.buildingLogic.des;

import com.buildingLogic.ms.trees.TreeNode;

public class MirrorOrNot {

  public static void main(String[] args) {
    TreeNode rootOne = new TreeNode(6);
    rootOne.setLeft(new TreeNode(10));
    rootOne.setRight(new TreeNode(2));
    rootOne.getLeft().setLeft(new TreeNode(1));
    rootOne.getLeft().setRight(new TreeNode(3));
    rootOne.getRight().setRight(new TreeNode(12));
    rootOne.getRight().setLeft(new TreeNode(7));

    TreeNode rootTwo = new TreeNode(6);
    rootTwo.setLeft(new TreeNode(10));
    rootTwo.setRight(new TreeNode(2));
    rootTwo.getLeft().setLeft(new TreeNode(1));
    rootTwo.getLeft().setRight(new TreeNode(3));
    rootTwo.getRight().setRight(new TreeNode(12));
    rootTwo.getRight().setLeft(new TreeNode(7));


    System.out.println(areMirror(rootOne, rootTwo));
  }

  private static boolean areMirror(TreeNode rootOne, TreeNode rootTwo) {
    if (rootOne == null && rootTwo == null) {
      return true;
    }

    if (rootOne == null || rootTwo == null) {
      return false;
    }

    return (rootOne.getData() == rootTwo.getData())
        && areMirror(rootOne.getLeft(), rootTwo.getRight())
        && areMirror(rootOne.getRight(), rootTwo.getLeft());
  }

}
