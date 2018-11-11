package com.buildingLogic.linkedlist;
/**
 * @author Raju MLN
 *
 */
public class LinkedListInJava {
	private Node start;
	private class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
	public static void main(String[] args) {
		LinkedListInJava llo= new LinkedListInJava();
		
		int[] inpArr= {99,9,999,0,777};
		
		for (int i : inpArr) {
			llo.sortWhileInserting(i);
		}
		
		llo.display();
		/*llo.appendNode(2);
		llo.appendNode(1);
		llo.appendNode(5);
		llo.appendNode(4);
		llo.addAtBeginning(29);
		llo.insertAt(2,35);*/
		
		/*int length=llo.listLength();
		System.out.println("Length of LinkedList:"+length);
		
		int nodeToSearch=5;
		int index=llo.searchNode(nodeToSearch);
		if(index == -1){
			System.out.println(nodeToSearch+" is not present in linked list");
		}
		else{
			System.out.println(nodeToSearch+" is  present in linked list at position "+index);
		}
		llo.display();
		
		int nodeTodelete=29;
		boolean isNodeDeleted=llo.deleteNode(nodeTodelete);
		if(isNodeDeleted){
			System.out.println("Node "+nodeTodelete+" is successfully deleted");
		}
		else{
			System.out.println("Node "+nodeTodelete+" could not be deleted as it is not present in list");
		}
		llo.display();
		
		System.out.println("Reverse List is :");
		llo.reverseList();
		llo.display();
		
		int deleteAt=1;
		boolean isDeleted=llo.deleteNodeAt(deleteAt);
		if(isDeleted){
			System.out.println("Node at position "+deleteAt+" is successfully deleted");
		}
		llo.display();
		
		System.out.println("List after sorting : ");
		llo.sortList();
		llo.display();
		*/
		/*llo.display();
		System.out.println("Copy List :");
		Node newList = null;
		llo.copyList(llo.start, newList);
		llo.display();*/
		
		
	}
	
	 private void sortWhileInserting(int i) {
		 Node newNode = new Node(i);
		 if(start == null){
			 start= newNode;
		 }else if(start.getNext() == null){
			 newNode.setNext(start);
			 start=newNode;
		 }else{
			 Node temp =start;
			 while(temp.getData() < i && temp.getNext() != null){
				 temp=temp.getNext();
			 }
			 if(temp.getNext() == null){
				 temp.setNext(newNode);
			 }
			 else if(temp.getNext() != null ){
				 Node nextNode= temp.getNext();
				 temp.setNext(newNode);
				 newNode.setNext(nextNode);
			 }
		 }
	}

	void appendNode(int data){
		 Node newNode=new Node(data);
		 if(start == null){
			 start=newNode;
		 }
		 else{
			 Node cur=start;
			 while(cur.getNext() != null){
				 cur=cur.getNext();
			 }
			 cur.setNext(newNode);
		 }
		 
	 }
	 
	 void addAtBeginning(int data){
		 Node newNode=new Node(data);
		 newNode.setNext(start);
		 start=newNode;
		 /*Node temp=start;
		 start=newNode;
		 newNode.setNext(temp);*///chintu's approach
	 }
	 
	 void insertAt(int position,int data){
		 if(position == 0){
			 addAtBeginning(data);
		 }else if(position==listLength()){
			 appendNode(data);
		 }
		 else if(position < 0 || position > listLength()){
			 System.out.println("Not possible");
		 }
		 else{
			 Node newNode= new Node(data);
			 Node cur=start;
			 for (int i = 1; i < position; ++i) {
				cur=cur.getNext();
			}
			Node nextNode=cur.getNext();
			cur.setNext(newNode);
			newNode.setNext(nextNode);
		 }
	 }
	 
	 int searchNode(int data){
		 int index=-1;
		 Node cur=start;
		 while(cur!=null){
			 if(cur.getData() == data){
				 break;
			 }
			 index+=1;
			 cur=cur.getNext();
		 }
		 if(index != -1){
			 index+=2;
		 }
		 return index;
		 
	 }
	 
	 boolean deleteNode(int data){
		 boolean isDeleted=false;
		 Node cur=start;
		 Node prev=start;
		 while(cur != null){
			 
			 if(cur.getData() == data){
				 if(prev == start){
					 start=cur.getNext();
				 }
				 else{
					 prev.setNext(cur.getNext());
				 }
				 cur=null;
				 isDeleted=true;
				 break;
			 }
			 prev=cur;
			 cur=cur.getNext();
		 }
		 return isDeleted;
	 }
	 
	 boolean deleteNodeAt(int position){
		 boolean isDeleted=false;
		 Node cur=start;
		 Node prev=start;
		 
		 if(position < 1 || position > listLength()){
			 System.out.println("Enter a valid position to delete");
		 }
		 else if(position == 1){
			 start=cur.getNext();
			 cur=null;
			 isDeleted=true;
		 }
		 else{
			 for (int i = 1; i < position; ++i) {
					prev=cur;
					cur=cur.getNext();
			 }
			 prev.setNext(cur.getNext());
			 cur=null;
			 isDeleted=true;
		 }
		 return isDeleted;
	 }
	 
	 void reverseList(){
		 Node prev=null;
		 Node cur=start;
		 Node next=null;
		 
		 while(cur != null){
			 next=cur.getNext();
			 cur.setNext(prev);
			 prev=cur;
			 cur=next;
		 }
		 start=prev;
	 }
	 
	 void sortList(){
		 Node temp=start;
		 while(temp != null){
			 Node index=temp.getNext();
			 while(index != null){
				 if(index.getData() < temp.getData()){
					 int tempData=index.getData();
					 index.setData(temp.getData());
					 temp.setData(tempData);
				 }
				 index=index.getNext();
			 }
			 temp=temp.getNext();
		 }
	 }
	 
	 void copyList(Node inputList, Node newList){
		 
		 while(inputList != null){
			 Node newNode= new Node(inputList.getData());
			 if(newList == null){
				 newList=newNode; 
			 }
			 else{
				 newList.setNext(newNode);
				 newList=newList.getNext();
			 }
			 inputList=inputList.getNext();
		 }
		 start=newList;
	 }
	 
	 int listLength(){
		 int length=0;
		 Node cur=start;
		 while(cur != null){
			 cur=cur.getNext();
			 length++;
		 }
		 return length;
	 }
	 
	 void display(){
		 Node cur=start;
		 while(cur != null){
			 System.out.print(cur.getData()+"-->");
			 cur=cur.getNext();
		 }
		 System.out.print("NULL\n");
	 }
	
	

}
