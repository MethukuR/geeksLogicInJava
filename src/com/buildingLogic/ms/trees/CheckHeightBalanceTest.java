package com.buildingLogic.ms.trees;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CheckHeightBalanceTest {
  
  private CheckHeightBalance checkHeightBalance;

  @Before
  public void setUp() throws Exception {
    checkHeightBalance = new CheckHeightBalance();
  }

  @Test
  public void testOne() {
    
    TreeNode root = new TreeNode(1);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(3));
    
    assertEquals(true, checkHeightBalance.isHeightBalanced(root));
  }
  
  @Test
  public void testTwo() {
    assertEquals(true, checkHeightBalance.isHeightBalanced(null));
  }
  
  @Test
  public void testThree() {
    
    TreeNode root = new TreeNode(1);
    root.setLeft(new TreeNode(2));
    root.getLeft().setLeft(new TreeNode(3));
    assertEquals(false, checkHeightBalance.isHeightBalanced(root));
  }

}
