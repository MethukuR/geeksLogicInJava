package com.buildingLogic.ms.trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LCAInBSTTest {
  
  private LCAInBST lcaInBST;
  
  @BeforeEach
  void setUp() throws Exception {
    lcaInBST = new LCAInBST();
  }

  @Test
  void testForNullRoot() {
    assertEquals(null, lcaInBST.findLCA(null, 1, 2));
    assertEquals(null, lcaInBST.findLCAIterative(null, 1, 2));
  }
  
  @Test
  void testForInvalidInput() {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    assertEquals(null, lcaInBST.findLCA(root, 21, 31));
    assertEquals(null, lcaInBST.findLCAIterative(root, 21, 31));
    
    /*assertEquals(null, lcaInBST.findLCA(root, 2, 31));
    assertEquals(null, lcaInBST.findLCAIterative(root, 2, 31));*/
  }
  
  @Test
  void testForRandomInputOne() {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    assertEquals(2, lcaInBST.findLCA(root, 2, 3).getData());
    assertEquals(2, lcaInBST.findLCAIterative(root, 2, 3).getData());
  }
  
  @Test
  void testForRandomInputTwo() {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    assertEquals(2, lcaInBST.findLCA(root, 1, 3).getData());
    assertEquals(2, lcaInBST.findLCAIterative(root, 1, 3).getData());
  }
  
  @Test
  void testForRandomInputThree() {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    assertEquals(6, lcaInBST.findLCA(root, 3, 12).getData());
    assertEquals(6, lcaInBST.findLCAIterative(root, 12, 3).getData());
  }

}
