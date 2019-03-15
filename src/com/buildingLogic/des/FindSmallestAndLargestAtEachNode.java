package com.buildingLogic.des;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestAndLargestAtEachNode {
  private static Map<Integer, MinMaxNode> map = new HashMap<Integer, MinMaxNode>();
  public static void main(String[] args) {
    TreeNode root= new TreeNode(1);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(3));
    root.getRight().setLeft(new TreeNode(7));
    root.getRight().setRight(new TreeNode(8));
    calculateMinMaxAtEachNode(root);
    System.out.println(map.get(1));
    System.out.println(map.get(2));
    System.out.println(map.get(3));
    System.out.println(map.get(7));
    System.out.println(map.get(8));
  }
  private static MinMaxNode calculateMinMaxAtEachNode(TreeNode node) {
    if(node == null) {
      return null;
    }
    
    MinMaxNode leftMinMax = calculateMinMaxAtEachNode(node.getLeft());
    MinMaxNode rightMinMax = calculateMinMaxAtEachNode(node.getRight());
    
    MinMaxNode cur = new MinMaxNode();
    if(leftMinMax == null && rightMinMax == null) {
      cur.setMin(node.getData());
      cur.setMax(node.getData());
      map.put(node.getData(), cur);
      return cur;
    }
    
    if(leftMinMax == null) {
      cur.setMin(node.getData());
      cur.setMax(Math.max(node.getData(), rightMinMax.getMax()));
      map.put(node.getData(), cur);
      return cur;
    }
    
    if(rightMinMax == null) {
      cur.setMin(Math.min(node.getData(), leftMinMax.getMin()));
      cur.setMax(node.getData());
      map.put(node.getData(), cur);
      return cur;
    }
    
    cur.setMax(Math.max(node.getData(), rightMinMax.getMax()));
    cur.setMin(Math.min(node.getData(), leftMinMax.getMin()));
    map.put(node.getData(), cur);
    return cur;
  }

}

class MinMaxNode{
  private int min;
  private int max;
  
  public MinMaxNode() {
    super();
    this.min = Integer.MAX_VALUE;
    this.max = Integer.MIN_VALUE;
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
  @Override
  public String toString() {
    return "MinMaxNode [min=" + min + ", max=" + max + "]";
  }
  
}
