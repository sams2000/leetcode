package com.example.leet;

import algorithm.datastructure.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.
	You should preserve the original relative order of the nodes in each of the two partitions.
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.

 * @author bin zhou
 * @since 2014-03-12
 */
public class PartitionLinkedList {

	public static void main(String[] args) {
        // build the linkedlist
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
/*        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);*/
        one.next = two;
        two.next = null;
/*        three.next = four;
        four.next = five;
        five.next = six;*/
        
        ListNode head = partition(one, 1);
        System.out.print("Partition List is : " + head.val);
        while (head.next != null)
        {
            System.out.print("->" + head.next.val);
            head = head.next;
        }		
	}

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode frontHead = null, frontTail = null;
        ListNode backHead = null, backTail = null;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x){
                //attach to front node list
                if (frontHead == null){
                    frontHead = cur;
                    frontTail = cur;
                } else {
                    frontTail.next = cur;
                    frontTail = cur;
                }
            } else { //very trick to process >= here together
                //attach to back node list
                if (backHead == null){
                    backHead = cur;
                    backTail = cur;
                } else {
                    backTail.next = cur;
                    backTail = cur;
                }
                
            }            
            cur = cur.next;
        }
        
        if (frontTail != null) frontTail.next = backHead;
        if (backTail != null) backTail.next = null;
        if (frontHead == null) return backHead;
        return frontHead;    	      
    }
}


