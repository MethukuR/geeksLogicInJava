package com.buildingLogic.ms.trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LCAinBTTest {
  
  private LCAinBT lcaInBT;
  
  @BeforeEach
  void setUp() throws Exception {
    lcaInBT = new LCAinBT();
  }
  
  @Test
  void testForNullRoot() {
    assertEquals(null, lcaInBT.findLCAInBT(null, 1, 2));
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
    assertEquals(null, lcaInBT.findLCAInBT(root, 31, 32));
    assertEquals(null, lcaInBT.findLCAInBT(root, 2, 32));

    
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
    assertEquals(2, lcaInBT.findLCAInBT(root, 2, 3).getData());
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
    assertEquals(2, lcaInBT.findLCAInBT(root, 1, 3).getData());
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
    assertEquals(6, lcaInBT.findLCAInBT(root, 3, 12).getData());
  }

}
