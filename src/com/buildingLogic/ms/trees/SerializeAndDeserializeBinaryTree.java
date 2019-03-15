/**
 * Serialization is to store tree in a file(or string) so that it can be later restored. The structure of tree must 
 * be maintained. Deserialization is reading tree back from file(or string).

serialize-deserialize-binary-tree:
===================================


Following are some simpler versions of the problem:

If given Tree is Binary Search Tree?
If the given Binary Tree is Binary Search Tree, we can store it by either storing preorder or postorder 
traversal. In case of Binary Search Trees, only preorder or postorder traversal is sufficient to store 
structure information.

If given Binary Tree is Complete Tree?
A Binary Tree is complete if all levels are completely filled except possibly the last level and all 
nodes of last level are as left as possible (Binary Heaps are complete Binary Tree). For a complete 
Binary Tree, level order traversal is sufficient to store the  We know that the first TreeNode is root, 
next two nodes are nodes of next level, next four nodes are nodes of 2nd level and so on.

If given Binary Tree is Full Tree?
A full Binary is a Binary Tree where every TreeNode has either 0 or 2 children. It is easy to serialize such 
trees as every internal TreeNode has 2 children. We can simply store preorder traversal and store a bit with 
every TreeNode to indicate whether the TreeNode is an internal TreeNode or a leaf TreeNode.

How to store a general Binary Tree?
A simple solution is to store both Inorder and Preorder traversals. This solution requires requires space 
twice the size of Binary 
We can save space by storing Preorder traversal and a marker for NULL pointers.

Deserialization can be done by simply reading data from file one by one.
 */
package com.buildingLogic.ms.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(10));
    root.setRight(new TreeNode(2));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    
    String serializedTree = serialize(root);
    System.out.println("serializedTree: "+serializedTree);
    
    TreeNode deserializedTree = deserialize(serializedTree);
    System.out.println("deserializedTree: ");
    preorderTraversal(deserializedTree);

  }

  private static TreeNode deserialize(String serializedTree) {
    Queue<String> q = new LinkedList<>();
    q.addAll(Arrays.asList(serializedTree.split(",")));
    return deserialiseHelper(q);
  }

  
  private static TreeNode deserialiseHelper(Queue<String> q) {
    String val = q.poll();
    if(val.equals("null")) {
      return null;
    }else {
      TreeNode root = new TreeNode(Integer.parseInt(val));
      root.setLeft(deserialiseHelper(q));
      root.setRight(deserialiseHelper(q));
      return root;
    }
  }

  private static String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
  }

  private static void serializeHelper(TreeNode root, StringBuilder sb) {
      if( null == root) {
        sb.append("null").append(",");
      }else {
        sb.append(root.getData()).append(",");
        serializeHelper(root.getLeft(), sb);
        serializeHelper(root.getRight(), sb);
      }
  }
  
 

private static void preorderTraversal(TreeNode root) {
    if(root != null){
        System.out.print(root.getData() + " ");
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }
}

}
