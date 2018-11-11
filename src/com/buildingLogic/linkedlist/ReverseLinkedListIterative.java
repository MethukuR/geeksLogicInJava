package com.buildingLogic.linkedlist;
public class ReverseLinkedListIterative {
	static Node head;
	
	static class Node{
		int data;
		Node link;
		
		Node(int value){
			data = value;
			link = null;
		}
	}
	
	static void printList(Node head){
		while( head != null ){
			System.out.print(head.data +"-->");
			head= head.link;
		}
		System.out.println("null");
	}
	
	static Node reverseList(Node head){
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null){
			next = current.link;
			current.link= prev;
			prev = current;
			current= next;
		}
		head= prev;
		return head;
	}
	
	public static void main(String[] args) {
		head=new Node(85);
		head.link=new Node(75);
		head.link.link= new Node(65);
		head.link.link.link= new Node(55);
		
		printList(head);
		
		Node headFinal=reverseList(head);
		
		printList(headFinal);
		
	}
}
