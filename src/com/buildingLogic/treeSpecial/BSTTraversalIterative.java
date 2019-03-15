package com.buildingLogic.treeSpecial;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class BSTTraversalIterative {

	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		List<Integer> inorder= inOrderTraversalIterative(head);
		System.out.println(inorder);
	}

	private static List<Integer> inOrderTraversalIterative(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		// create an empty stack
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> inorder = new ArrayList<Integer>();
		
		// start from root node (set current node to root node)
		TreeNode cur = root;
		
		// if current node is null and stack is also empty, we're done
		while( cur != null && !s.isEmpty()) {
			
			// if current node is not null, push it to the stack (defer it)
			// and move to its left child
			while(cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			
			// else we pop an element from stack,
			// add to output and finally set current node to its right child
			cur = s.pop();
			inorder.add(cur.val);
			
			cur = cur.right;
		}
		return inorder;
	}
	
	private static List<Integer> postOrderTraversalIterative(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		// create an empty stack and push root node
		Stack<TreeNode> temp = new Stack<TreeNode>();
		temp.push(root);
		
		List<Integer> postOrder = new ArrayList<Integer>();

		// run till stack is not empty
		while(!temp.isEmpty()) {
			TreeNode cur = temp.pop();
			postOrder.add(0,cur.val);
			
			// push left and right child of popped node to the stack
			if(cur.left != null) {
				temp.push(cur.left);
			}
			
			if(cur.right != null) {
				temp.push(cur.right);
			}
		}
		
		return postOrder;
	}
	
	private static List<Integer> preOrderTraversalIterative(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		// create an empty stack and push root node
		Stack<TreeNode> temp = new Stack<TreeNode>();
		temp.push(root);
		
		List<Integer> preOrder = new ArrayList<Integer>();

		// run till stack is not empty
		while(!temp.isEmpty()) {
			TreeNode cur = temp.pop();
			preOrder.add(cur.val);
			
			// push right and left child of popped node to the stack
			if(cur.right != null) {
				temp.push(cur.right);
			}
			
			if(cur.left != null) {
				temp.push(cur.left);
			}
		}
		
		return preOrder;
	}
	
	private static int checkBalance(TreeNode node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = checkBalance(node.left);
		
		if(leftHeight == -1) {
			return -1;
		}
		
        int rightHeight = checkBalance(node.right);
		
		if(rightHeight == -1) {
			return -1;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return (1 + Math.max(leftHeight , rightHeight));
	}

}
