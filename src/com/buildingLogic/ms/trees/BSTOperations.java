package com.buildingLogic.ms.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class TNode {
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

  @Override
  public String toString() {
    return "TNode [data=" + data + ", left=" + left + ", right=" + right + ", parent=" + parent
        + "]";
  }
}


public class BSTOperations {
  TNode root = null;
  HashMap<Integer, List<Integer>> mapVerticalDistance = null;

  private void insert(int data) {
    root = insertData(root, data);
  }

  // recursive approach
  private TNode insertData(TNode node, int data) {
    // base case
    if (node == null) {
      node = new TNode(data);
      return node;
    }

    TNode temp;
    if (node.getData() >= data) {
      temp = insertData(node.getLeft(), data);
      node.setLeft(temp);
      temp.setParent(node);
      return temp;
    } else {
      temp = insertData(node.getRight(), data);
      node.setRight(temp);
      temp.setParent(node);
      return temp;
    }
  }

  // iterative approach
  public TNode insertNode(TNode root, TNode node) {
    if (root == null) {
      return node;
    }

    if (node == null) {
      return root;
    }

    TNode cur = root;
    TNode parent = null;

    while (cur != null) {
      parent = cur;
      if (cur.getData() >= node.getData()) {
        cur = cur.getLeft();
      } else {
        cur = cur.getRight();
      }
    }

    if (parent.getData() >= node.getData()) {
      parent.setLeft(node);
    } else {
      parent.setRight(node);
    }

    return root;
  }

  private void inorder() {
    inorderTraversal(root);
  }

  private void inorderTraversal(TNode root) {
    if (root == null) {
      return;
    }

    inorderTraversal(root.getLeft());
    System.out.print(root.getData() + " ");
    inorderTraversal(root.getRight());
  }

  private void preorder() {
    preorderTraversal(root);
  }

  private void preorderTraversal(TNode root) {
    if (root == null) {
      return;
    }

    System.out.print(root.getData() + " ");
    preorderTraversal(root.getLeft());
    preorderTraversal(root.getRight());
  }

  private void postorder() {
    postorderTraversal(root);
  }

  private void postorderTraversal(TNode root) {
    if (root == null) {
      return;
    }

    postorderTraversal(root.getLeft());
    postorderTraversal(root.getRight());
    System.out.print(root.getData() + " ");

  }

  private void levelorder() {
    levelorderTraversal(root);
  }

  private void levelorderTraversal(TNode root) {
    if (root == null) {
      return;
    }
    Queue<TNode> q = new LinkedList<TNode>();
    q.add(root);

    while (!q.isEmpty()) {
   
      TNode cur = q.poll();
      System.out.print(cur.getData() + " ");

      if (cur.getLeft() != null) {
        q.add(cur.getLeft());
      }

      if (cur.getRight() != null) {
        q.add(cur.getRight());
      }

    }
  }

  private void verticalorder() {
    verticalorderTraversal(root, 1);
  }

  private void verticalorderTraversal(TNode root, int hd) {

  }

  private TNode searchNode(int data) {
    return search(root, data);
  }

  private TNode search(TNode root, int data) {
    if (root == null) {
      return null;
    }

    if (root.getData() == data) {
      return root;
    } else if (root.getData() >= data) {
      return search(root.getLeft(), data);
    } else {
      return search(root.getRight(), data);
    }
  }

  private TNode inorderSuccessor(int data) {
    TNode node = search(root, data);
    if (node == null) {
      return null;
    }

    return inorderSuccessor(node);
  }

  private TNode inorderSuccessor(TNode node) {
    if (node.getRight() != null) {
      return minValueNode(node.getRight());
    }

    TNode parent = node.getParent();

    while (parent != null && parent.getRight() == node) {
      parent = parent.getParent();
      node = parent;
    }

    return parent;

  }

  private TNode minValueNode(TNode node) {
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node;
  }

  private TNode deleteNode(int data) {
    root = search(root, data);
    return root;
  }


  private TNode delete(TNode node, int data) {
    if (node.getData() >= data) {
      node.setLeft(delete(node.getLeft(), data));
    } else if (node.getData() < data) {
      node.setRight(delete(node.getRight(), data));
    } else {
      if (node.getLeft() == null && node.getRight() == null) {
        node = null;
      } else if (node.getLeft() == null) {
        node = node.getRight();
      } else if (node.getRight() == null) {
        node = node.getLeft();
      } else {
        TNode minNode = minValueNode(node.getRight());
        node.setData(minNode.getData());
        node.setRight(delete(node.getRight(), minNode.getData()));
      }
    }

    return node;
  }

  public static void main(String[] args) {

    BSTOperations operations = new BSTOperations();

    operations.insert(50);
    operations.insert(30);
    operations.insert(20);
    operations.insert(40);
    operations.insert(70);
    operations.insert(60);
    operations.insert(80);

    System.out.println("Inorder : ");
    operations.inorder();

    System.out.println("\nPreorder : ");
    operations.preorder();

    System.out.println("\nPostorder : ");
    operations.postorder();

    System.out.println("\nLevelorder : ");
    operations.levelorder();

    System.out.println("\nVerticalorder : ");
    operations.verticalorder();

    System.out.println("\nNode with data 20 ? " + operations.searchNode(20).getData());

    System.out.println("Inorder Successor of 50 :" + operations.inorderSuccessor(50).getData());

    System.out.println("Deletion of node :");
    operations.deleteNode(50);
    System.out.println("Inorder : ");
    operations.inorder();

  }

}
