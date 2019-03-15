package com.buildingLogic.ms.trees;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BSTOrNotTest {
  BSTOrNot bstOrNot ;
  
  @Before
  public void setUp() {
    bstOrNot = new BSTOrNot();
  }
  
  @Test
  public void testForNullRoot() {
    assertEquals("should return true if root is null", true, bstOrNot.isBST(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }
  
  @Test
  public void testForValidBST() {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    assertEquals("should return true, if input is valid bst", true, bstOrNot.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }
  
  @Test
  public void testForInValidBST() {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(10));
    root.setRight(new TreeNode(2));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    assertEquals("should return false, if input is not valid bst", false, bstOrNot.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

}
