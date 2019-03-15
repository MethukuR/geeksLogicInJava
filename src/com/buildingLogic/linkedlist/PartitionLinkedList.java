/**
 * Partitioning a linked list around a given value and keeping the original order:
 * ===============================================================================
Given a linked list and a value x, partition it such that all nodes less than x come first, then all nodes 
with value equal to x and finally nodes with value greater than or equal to x. The original relative 
order of the nodes in each of the three partitions should be preserved. The partition must work in-place.

Examples:

Input : 1->4->3->2->5->2->3, 
        x = 3
Output: 1->2->2->3->3->4->5

Input : 1->4->2->10 
        x = 3
Output: 1->2->4->10

Input : 10->4->20->10->3 
        x = 3
Output: 3->10->4->20->10 


To solve this problem we can use partition method of Quick Sort but this would not preserve the original
relative order of the nodes in each of the two partitions.

Below is the algorithm to solve this problem :

> Initialize first and last nodes of below three linked lists as NULL.
> Linked list of values smaller than x.
> Linked list of values equal to x.
> Linked list of values greater than x.
>Now iterate through the original linked list. If a node’s value is less than x then append it at the end 
of smaller list. If the value is equal to x, then at the end of equal list. And if value is greater, then 
at the end of greater list.
>Now concatenate three lists.

 */
package com.buildingLogic.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class PartitionLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partitionOne(ListNode head, int x) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode smallerNodesHead = null;
    	ListNode equalNodesHead = null;
    	ListNode largerNodesHead = null;
    	
    	ListNode smallerNodesTail = null;
    	ListNode equalNodesTail = null;
    	ListNode largerNodesTail = null;
    	
    	ListNode temp = head;
    	
    	while(temp != null) {
    		if(temp.val == x) {
    			if(equalNodesHead == null) {
        			equalNodesHead = equalNodesTail = temp;
    			}else {
    				equalNodesTail.next = temp;
    				equalNodesTail = equalNodesTail.next;
    			}
    		}else if(temp.val < x) {
    			if(smallerNodesHead == null) {
    				smallerNodesHead = smallerNodesTail = temp;
    			}else {
    				smallerNodesTail.next = temp;
    				smallerNodesTail = smallerNodesTail.next;
    			}
    		}else {
    			if(largerNodesHead == null) {
    				largerNodesHead = largerNodesTail = temp;
    			}else {
    				largerNodesTail.next = temp;
    				largerNodesTail = largerNodesTail.next;
    			}
    		}
    		temp = temp.next;
    	}
    	
    	if(largerNodesHead != null) {
    		largerNodesTail.next = null;
    	}
    	
    	if(smallerNodesHead != null) {
    		if(equalNodesHead != null) {
    			smallerNodesTail.next = equalNodesHead;
    			equalNodesTail.next = largerNodesHead;
    		}else {
    			smallerNodesTail.next = largerNodesHead;
    		}
    		
    		return smallerNodesHead;
    	}else {
    		if(equalNodesHead != null) {
    			equalNodesTail.next = largerNodesHead;
    		}else {
    			equalNodesHead =  largerNodesHead;
    		}
    		return equalNodesHead;
    	}
    }
    
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes 
     * greater than or equal to x.

	 *You should preserve the original relative order of the nodes in each of the two partitions.

		Example:
	    ========
		Given 1->4->3->2->5->2->null and x = 3,
		return 1->2->2->4->3->5->null.
     */
    
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode smallerNodesHead = null;
    	ListNode remainingHead = null;
    	
    	ListNode smallerNodesTail = null;
    	ListNode remainingTail = null;
    	
    	while(head != null){
    		if(head.val < x) {
    			if(smallerNodesHead == null) {
    				smallerNodesHead = smallerNodesTail = head;
    			}else {
    				smallerNodesTail.next = head;
    				smallerNodesTail = smallerNodesTail.next;
    			}
    		}else {
    			if(remainingHead == null) {
    				remainingHead = remainingTail = head;
    			}else {
    				remainingTail.next = head;
    				remainingTail = remainingTail.next;
    			}
    		}
    		
    		head = head.next;
    	}
    	
    	if(remainingHead != null) {
    		remainingTail.next = null;
    	}
    	
    	if(smallerNodesHead == null) {
    		return remainingHead;
    	}else {
    		smallerNodesTail.next = remainingHead;
    		return smallerNodesHead;
    	}
    	
    }
}
