/**
 * Two nodes of a BST are swapped, correct the BST Two of the nodes of a Binary Search Tree (BST)
 * are swapped. Fix (or correct) the BST. Input Tree: 10 / \ 5 8 / \ 2 20
 * 
 * In the above tree, nodes 20 and 8 must be swapped to fix the tree. Following is the output tree
 * 10 / \ 5 20 / \ 2 8
 * 
 * 
 * The inorder traversal of a BST produces a sorted array. So a simple method is to store inorder
 * traversal of the input tree in an auxiliary array. Sort the auxiliary array. Finally, insert the
 * auxiilary array elements back to the BST, keeping the structure of the BST same. Time complexity
 * of this method is O(nLogn) and auxiliary space needed is O(n).
 * 
 * We can solve this in O(n) time and with a single traversal of the given BST. Since inorder
 * traversal of BST is always a sorted array, the problem can be reduced to a problem where two
 * elements of a sorted array are swapped. There are two cases that we need to handle:
 * 
 * 1. The swapped nodes are not adjacent in the inorder traversal of the BST.
 * 
 * For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}. The inorder traversal of the
 * given tree is 3 25 7 8 10 15 20 5 If we observe carefully, during inorder traversal, we find
 * TreeNode 7 is smaller than the previous visited TreeNode 25. Here save the context of TreeNode 25
 * (previous TreeNode). Again, we find that TreeNode 5 is smaller than the previous TreeNode 20.
 * This time, we save the context of TreeNode 5 ( current TreeNode ). Finally swap the two
 * TreeNode’s values.
 * 
 * 2. The swapped nodes are adjacent in the inorder traversal of BST.
 * 
 * For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20 25}. The inorder traversal of the
 * given tree is 3 5 8 7 10 15 20 25 Unlike case #1, here only one point exists where a TreeNode
 * value is smaller than previous TreeNode value. e.g. TreeNode 7 is smaller than TreeNode 8.
 */
package com.buildingLogic.treeSpecial;


public class CorrectBST {

  TreeNode prev = null, first = null, last = null;

  private void recoverBST(TreeNode root) {

    findSegments(root);

    int temp = first.val;
    first.val = last.val;
    last.val = temp;
  }

  private void findSegments(TreeNode node) {

    if (null == node) {
      return;
    }

    findSegments(node.left);

    if (null != prev) {
      if (prev.val > node.val) {
        if (null == first) {
          first = prev;
        }
        last = node;
      }
    }

    prev = node;

    findSegments(node.right);

  }

  private void printInorder(TreeNode node) {
    if (node == null) {
      return;
    }

    printInorder(node.left);
    System.out.print(" " + node.val);
    printInorder(node.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(10);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(12);
    root.right.left = new TreeNode(7);

    System.out.println("Inorder Traversal" + " of the original tree");
    CorrectBST tree = new CorrectBST();
    tree.printInorder(root);

    tree.recoverBST(root);

    System.out.println("\nInorder Traversal" + " of the fixed tree");
    tree.printInorder(root);
  }

}
