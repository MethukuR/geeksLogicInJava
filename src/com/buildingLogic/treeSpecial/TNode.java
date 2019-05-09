package com.buildingLogic.treeSpecial;

public class TNode{
  private int data;
  private TNode left;
  private TNode right;
  private TNode parent;
  public TNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
      this.parent = null;
  }
  public int getData() {
      return data;
  }
  public void setData(int data) {
      this.data = data;
  }
  public TNode getLeft() {
      return left;
  }
  public void setLeft(TNode left) {
      this.left = left;
  }
  public TNode getRight() {
      return right;
  }
  public void setRight(TNode right) {
      this.right = right;
  }
  public TNode getParent() {
      return parent;
  }
  public void setParent(TNode parent) {
      this.parent = parent;
  }
  
}
