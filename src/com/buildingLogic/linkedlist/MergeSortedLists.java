/**
 Description
 Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list 
 should be made by splicing together the nodes of the two lists and sorted in ascending order.

 Example:
 =======
 Given 1->3->8->11->15->null, 2->null , 
 return 1->2->3->8->11->15->null.
 */
package com.buildingLogic.linkedlist;

public class MergeSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param l1: ListNode l1 is the head of the linked list
	 * @param l2: ListNode l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

		ListNode mergedList = null;
		ListNode temp = null;

		if (l1.val < l2.val) {
			temp = l1;
			l1 = l1.next;
		} else {
			temp = l2;
			l2 = l2.next;
		}
		
		mergedList = temp;


		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;

			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}

		if (l1 != null) {
			temp.next = l1;
		}

		if (l2 != null) {
			temp.next = l2;
		}

		return mergedList;
	}

}
