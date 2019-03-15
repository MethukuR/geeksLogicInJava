/**
 Description:
 ============
 Find the nth to last element of a singly linked list. 

 The minimum number of nodes in list is n.

 Example:
 Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 */
package com.buildingLogic.linkedlist;

public class NthNodeFromLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
    	
    	if(head == null || n <= 0) {
    		return null;
    	}
    	
    	ListNode temp = head;
    	ListNode resultNode = head;
    	
    	while( n > 0 && temp != null) {
    		temp = temp.next;
    		--n;
    	}
    	
    	while(temp != null) {
    		temp = temp.next;
    		resultNode = resultNode.next;
    	}
		return resultNode;
    }

}
