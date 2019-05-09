package com.buildingLogic.treeSpecial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeViews {

  public static void main(String[] args) {
    BSTOperations operations = new BSTOperations();

    operations.insert(50);
    operations.insert(30);
    operations.insert(20);
    operations.insert(40);
    operations.insert(70);
    operations.insert(60);
    operations.insert(80);
    operations.insert(10);
    operations.insert(59);
    operations.insert(58);
    operations.insert(57);
    
    System.out.println("Top View"); 
    topView(operations.root);
    System.out.println("\nBottom View"); 
    bottomView(operations.root);
     
    System.out.println("Left side View"); 

    leftSideView(operations.root);
    
    System.out.println("Right side View"); 

    rightSideView(operations.root);
  }

  private static void rightSideView(TNode root) {
    Map<Integer, List<TNode>> levelMap = levelOrderTraversal(root);

    for (List<TNode> nodes : levelMap.values()) {
      int size = nodes.size();
      System.out.print(nodes.get(size-1).getData() + "\t");
    }
    System.out.println();
  }

  private static void leftSideView(TNode root) {
    Map<Integer, List<TNode>> levelMap = levelOrderTraversal(root);

    for (List<TNode> nodes : levelMap.values()) {
      System.out.print(nodes.get(0).getData() + "\t");
    }
    System.out.println();

  }

  private static Map<Integer, List<TNode>> levelOrderTraversal(TNode root) {
    Map<Integer, List<TNode>> levelMap = new TreeMap<>();
    levelOrderTraversal(root, levelMap);
    return levelMap;
  }

  private static void levelOrderTraversal(TNode root, Map<Integer, List<TNode>> levelMap) {
    if (root == null) {
      return;
    }

    Queue<TNode> q = new LinkedList<>();
    q.add(root);
    int currentLevel = 0;
    while (true) {
      int nodesSize = q.size();
      if (nodesSize == 0) {
        break;
      }

      while (nodesSize > 0) {
        TNode curNode = q.poll();
        if (levelMap.containsKey(currentLevel)) {
          List<TNode> nodes = levelMap.get(currentLevel);
          nodes.add(curNode);
          levelMap.put(currentLevel, nodes);
        } else {
          List<TNode> nodes = new ArrayList<>();
          nodes.add(curNode);
          levelMap.put(currentLevel, nodes);
        }
        if (curNode.getLeft() != null) {
          q.add(curNode.getLeft());
        }
        if (curNode.getRight() != null) {
          q.add(curNode.getRight());
        }
        --nodesSize;
      }
      ++currentLevel;
    }
  }

  private static void bottomView(TNode root) {
    Map<Integer, List<TNode>> hdMap = verticalOrderTraversal(root);

    Iterator<List<TNode>> iterator = hdMap.values().iterator();
    while (iterator.hasNext()) {
      List<TNode> nodes = iterator.next();
      int size = nodes.size();
      System.out.print(nodes.get(size - 1).getData() + "\t");
    }
    System.out.println();

  }

  private static void topView(TNode root) {
    Map<Integer, List<TNode>> hdMap = verticalOrderTraversal(root);

    Iterator<List<TNode>> iterator = hdMap.values().iterator();
    while (iterator.hasNext()) {
      List<TNode> nodes = iterator.next();
      System.out.print(nodes.get(0).getData() + "\t");
    }
    System.out.println();

  }

  private static Map<Integer, List<TNode>> verticalOrderTraversal(TNode root) {
    Map<Integer, List<TNode>> hdMap = new TreeMap<Integer, List<TNode>>();
    verticalOrderTraversal(root, 0, hdMap);

    /*
     * Iterator<Map.Entry<Integer, List<TNode>>> itr = hdMap.entrySet().iterator();
     * while(itr.hasNext()) { Map.Entry<Integer, List<TNode>> entry = itr.next(); for (TNode node :
     * entry.getValue()) { System.out.print(node.getData() + "\t"); } }
     */

    return hdMap;
  }

  private static void verticalOrderTraversal(TNode root, int hd, Map<Integer, List<TNode>> hdMap) {
    if (root == null) {
      return;
    }

    if (hdMap.containsKey(hd)) {
      List<TNode> nodes = hdMap.get(hd);
      nodes.add(root);
      hdMap.put(hd, nodes);
    } else {
      List<TNode> nodes = new ArrayList<TNode>();
      nodes.add(root);
      hdMap.put(hd, nodes);
    }
    verticalOrderTraversal(root.getLeft(), hd - 1, hdMap);
    verticalOrderTraversal(root.getRight(), hd + 1, hdMap);
  }

}
