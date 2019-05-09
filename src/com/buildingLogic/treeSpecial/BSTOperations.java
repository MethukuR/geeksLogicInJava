package com.buildingLogic.treeSpecial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class BSTOperations {
	TNode root = null;
	HashMap<Integer,List<Integer>> mapVerticalDistance =null;
	
	public void insert(int data){
		root=insertData(root,data);
	}
	
	//recursive approach
	public TNode insertData(TNode root, int data){
		if(root == null){
			root= new TNode(data);
		}else{
			TNode temp=null;
			if(root.getData() >= data){
				temp=insertData(root.getLeft(),data);
				root.setLeft(temp);
				temp.setParent(root);
			}else{
				temp=insertData(root.getRight(),data);
				root.setRight(temp);
				temp.setParent(root);
			}
		}
		return root;
	}
	
	//iterative
	public TNode insertNode(TNode root, TNode node) {
		if(root == null) {
			return node;
		}
		
		if(node == null) {
			return root;
		}
		
		TNode cur = root;
		TNode parent = null;
		
		while(cur != null) {
			parent = cur;
			
			if(cur.getData() > node.getData()) {
				cur = cur.getLeft();
			}else {
				cur = cur.getRight();
			}
		}
		
		if(parent != null) {
			if(parent.getData() > node.getData()) {
				parent.setLeft(node);
			}else {
				parent.setRight(node);
			}
		}
		return root;
    }
	
	private void inorder() {
		inorderTraversal(root);
	}

	private void inorderTraversal(TNode root) {
		if(root != null){
			inorderTraversal(root.getLeft());
			System.out.print(root.getData()+" ");
			inorderTraversal(root.getRight());
		}
	}
	
	private void preorder() {
		preorderTraversal(root);
	}

	private void preorderTraversal(TNode root) {
		if(root != null){
			System.out.print(root.getData() + " ");
			preorderTraversal(root.getLeft());
			preorderTraversal(root.getRight());
		}
	}
	
	private void postorder() {
		postorderTraversal(root);
	}

	private void postorderTraversal(TNode root) {
		if(root != null){
			postorderTraversal(root.getLeft());
			postorderTraversal(root.getRight());
			System.out.print(root.getData() + " ");

		}
	}
	
	private void levelorder() {
		levelorderTraversal(root);
	}
	
	private void levelorderTraversal(TNode root) {
		if(root != null){
			Queue<TNode> q =new LinkedList<TNode>();
			q.add(root);
			
			while(! q.isEmpty()){
				TNode temp=q.poll();
				System.out.print(temp.getData() + " ");
				
				if(temp.getLeft() != null){
					q.add(temp.getLeft());
				}
				
				if(temp.getRight() != null){
					q.add(temp.getRight());
				}
			}
		}
	}
	
	private void verticalorder() {
		
		mapVerticalDistance= new HashMap<Integer,List<Integer>>();
		verticalorderTraversal(root,0);
		Iterator<Map.Entry<Integer, List<Integer>>> it = mapVerticalDistance.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer, List<Integer>> pair = it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}

	private void verticalorderTraversal(TNode root, int hd) {
		if(null != mapVerticalDistance && null != root){
			if(mapVerticalDistance.containsKey(hd)){
				List<Integer> node=mapVerticalDistance.get(hd);
				node.add(root.getData());
				mapVerticalDistance.put(hd, node);
			}else{
				List<Integer> node=new ArrayList<Integer>();
				node.add(root.getData());
				mapVerticalDistance.put(hd, node);
			}
			verticalorderTraversal(root.getLeft(), hd-1);
			verticalorderTraversal(root.getRight(), hd+1);
		}
	}

	private TNode searchNode(int data) {
		return search(root,data);
	}
	private TNode search(TNode root,int data) {
		if(root == null){
			return null;
		}else if(root.getData() == data){
			return root;
		}else{
			if(root.getData() >= data){
				return search(root.getLeft(),data);
			}else{
				return search(root.getRight(),data);
			}
		}
	}
	
	private TNode inorderSuccessor(int data){
		TNode node=searchNode(data);
		if(node != null){
			return inorderSuccessor(node);
		}
		return null;
	}
	
	private TNode inorderSuccessor(TNode root) {
		
		if(root.getRight() != null){
			return minValueNode(root.getRight());
		}
		
		TNode parent=root.getParent();
		
		while(parent != null && root == parent.getRight()){
			root=parent;
			parent=parent.getParent();
		}
		return parent;
	}

	private TNode minValueNode(TNode node) {
		while(node.getLeft() != null){
			node=node.getLeft();
		}
		return node;
	}
	
	private TNode deleteNode(int data) {
		
		if(root != null){
			return delete(root,data);
		}
		return root;
	}
	

	private TNode delete(TNode node,int data) {
		if(data < node.getData()){
			node.setLeft(delete(node.getLeft(),data));
		}else if(data > node.getData()){
			node.setRight(delete(node.getRight(),data)); 
		}else{
			if(node.getLeft() == null && node.getRight() == null){
				node=null;
			}else if(node.getLeft() == null){
				node=node.getRight();
			}else if(node.getRight() == null){
				node=node.getLeft();
			}else{
				TNode minNode=minValueNode(node.getRight());
				node.setData(minNode.getData());
				node=delete(node.getRight(),minNode.getData());
			}
		}
		return node;
	}

	public static void main(String[] args) {
		
		BSTOperations operations= new BSTOperations();
		
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
        
        System.out.println("\nNode with data 20 ? "+operations.searchNode(20).getData());
        
        System.out.println("Inorder Successor of 50 :"+operations.inorderSuccessor(50).getData());
        
        System.out.println("Deletion of node :");
        operations.deleteNode(50);
        System.out.println("Inorder : ");
        operations.inorder();
        
	}

	

	
}