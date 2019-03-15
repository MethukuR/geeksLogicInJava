package com.improvingLogic.trees;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class DepthInBinaryTree {

	public static void main(String[] args) {

	}
	
	/**
	   Maximum Depth of Binary Tree:
	   ============================
	   Given a binary tree, find its maximum depth.

	  The maximum depth is the number of nodes along the longest path from the root node down to the 
	  farthest leaf node.
	 */

	/**
	 * @param root: The root of binary tree.
	 * @return: An integer
	 */
	public int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	/**
	 * @param root: The root of binary tree.
	 * @return: An integer
	 */
	public int minDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		if(root.left == null) {
			return 1+ minDepth(root.right);
		}
		
		if(root.right == null) {
			return 1+ minDepth(root.left);
		}
		
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

}
