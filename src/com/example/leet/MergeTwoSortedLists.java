package com.example.leet;

import algorithm.datastructure.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 * 
 * @author bin zhou
 * @since 3/4/2013
 * @since 2016-01-29
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        one.next = three;
        three.next = five;
        five.next = seven;

        two.next = four;
        four.next = six;

        ListNode head = mergeTwoLists(one, two);

        while (head != null) {
            System.out.print("->" + head.val);
            head = head.next;
        }
    }    
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // if one of them is nul, just return another list head
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = null, curNode = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (head == null) {
                    head = l1;
                    curNode = head;
                } else {
                    curNode.next = l1;
                    curNode = l1;

                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    curNode = head;
                } else {
                    curNode.next = l2;
                    curNode = l2;
                }
                l2 = l2.next;
            }
        }

        // if l1 still has elements, then append remaining l1 to combined list head
        if (l1 != null) {
            curNode.next = l1;
        }
        // if l2 still has elements, then append remaining l2 to combined list head
        if (l2 != null) {
            curNode.next = l2;
        }

        return head;
    }
}
