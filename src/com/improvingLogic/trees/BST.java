package com.improvingLogic.trees;

class TNode{
	private int data;
	private TNode left;
	private TNode right;
	private TNode parent;
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
public class BST {
	
	static TNode createNewNode(int data){
		TNode node = new TNode();
		node.setData(data);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(null);
		
		return node;
	}
	
	static TNode insertNode(TNode root,int data){
		if(root == null){
			return createNewNode(data);
		}
		else{
			TNode temp;
			if(data <= root.getData()){
				temp= insertNode(root.getLeft(), data);
				root.setLeft(temp);
				temp.setParent(root);
				
			}else{
				temp= insertNode(root.getRight(), data);
				root.setRight(temp);
				temp.setParent(root);
			}
		}
		
		return root;
	}
	
	static TNode inorderSuccessor(TNode node){
		if(node == null){
			return null;
		}else{
			if(node.getRight()!=null){
				return minValue(node.getRight());
			}else{
				TNode parent= node.getParent();
				while(parent != null && node == parent.getRight() ){
					node=parent;
					parent=parent.getParent();
				}
				
				return parent;
			}
		}
	}
	
	static TNode minValue(TNode node) {
		TNode curr = node;
		while(curr.getLeft() != null){
			curr=curr.getLeft();
		}
		return curr;
	}

	public static void main(String[] args) {
		TNode root = new TNode();
		root=insertNode(root,20);
		root=insertNode(root,8);
		root=insertNode(root,22);
		root=insertNode(root,4);
		root=insertNode(root,12);
		root=insertNode(root,10);
		root=insertNode(root,14);
		System.out.println(root.getData());
		TNode temp=root.getLeft().getRight().getRight();
		TNode succ = inorderSuccessor(temp);
		if(temp != null){
			System.out.println(succ.getData());
		}
		
	}

}
