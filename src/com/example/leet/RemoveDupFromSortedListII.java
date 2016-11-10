package com.example.leet;

import algorithm.datastructure.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author bin zhou
 * @since 2/7/2013
 */
public class RemoveDupFromSortedListII{
    public static void main(String[] args){
        // build the linkedlist
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;/*
        four.next = five;
        five.next = six;
        six.next = null;*/
        four.next = null;
        
        ListNode head = deleteDuplicates(one);
        while (head != null){
            System.out.print("->" + head.val);
            head = head.next;
        }
    }    
	
    /**
     * accepted soluiton: very tricky
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head){
        ListNode t = new ListNode(0);
        t.next = head;
     
        ListNode pre = t;
        while(pre.next!=null&&pre.next.next!=null){
            if(pre.next.val == pre.next.next.val){
                int dup = pre.next.val;
                while(pre.next!=null&&pre.next.val==dup){
                    pre.next = pre.next.next;
                }
            }else{
                pre=pre.next;
            }
     
        }
     
        return t.next;
    }   

}




