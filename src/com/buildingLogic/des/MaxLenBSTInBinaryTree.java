/**
 * Find the largest BST subtree in a given Binary Tree
 * 
 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a 
 * Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.
 */
package com.buildingLogic.des;

public class MaxLenBSTInBinaryTree {

  public static void main(String[] args) {
    MinMax len = findMaxBSTLen(null);
    System.out.println(len.getSize());
  }

  private static MinMax findMaxBSTLen(TreeNode node) {
    if(node == null) {
      return new MinMax();
    }
    
    MinMax leftTree = findMaxBSTLen(node.getLeft());
    MinMax rightTree = findMaxBSTLen(node.getRight());
    
    MinMax cur = new MinMax();
    if(!leftTree.isBST() || !rightTree.isBST() || leftTree.getMax() > node.getData() || rightTree.getMin() < node.getData()) {
      cur.setBST(false);
      cur.setSize(Math.max(leftTree.getSize(), rightTree.getSize()));
      return cur;
    }
    
    cur.setBST(true);
    cur.setSize(1 + leftTree.getSize() + rightTree.getSize());
    
    cur.setMin((node.getLeft() != null) ? leftTree.getMin() : node.getData());
    cur.setMax((node.getRight() != null) ? rightTree.getMax() : node.getData());

    return cur;
  }

}


class MinMax{
  private boolean isBST;
  private int size;
  private int min;
  private int max;
  
  public MinMax() {
    isBST = true;
    size = 0;
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
  }

  public boolean isBST() {
    return isBST;
  }

  public void setBST(boolean isBST) {
    this.isBST = isBST;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }
}
