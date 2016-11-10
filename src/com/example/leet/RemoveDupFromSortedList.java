package com.example.leet;

import algorithm.datastructure.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
 * @author bin zhou
 * @since 2016-02-03
 */
public class RemoveDupFromSortedList{
    public static void main(String[] args){
        // build the linkedlist
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        
        ListNode head = deleteDuplicates(one);
        while (head != null) {
            System.out.print("->" + head.val);
            head = head.next;
        }
    }
    
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode cur = head;
        while (cur.next != null) {
            //if current node value is same as next node's value
            if (cur.val == cur.next.val){
                //remove next
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;        
    }
}



