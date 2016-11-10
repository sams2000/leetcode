package com.example.leet;

import algorithm.datastructure.ListNode;
/**
 * Given a linked list, return the Nth element from end
 * @author bin zhou
 * @since 2016-02-07
 */
public class RemoveNthNodeFromEnd{
    public static void main(String[] args){
        // build the linkedlist
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        
        ListNode head = removeNthFromEnd(one, 5);
        
        while (head != null){
            System.out.print("->" + head.val);
            head = head.next;
        }
    }
    
    /**
     * accepted
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n<=0 || head==null) return null;
        
        ListNode slow=head; //follow node to return and remove
        ListNode fast=head; //ahead node
        
        int count=1;
        while (count<=n){
            if (fast==null) return null;
            fast=fast.next;
            count++;            
        }
        
        //if n is the length of linkedlist
        if (fast == null) return slow.next;
        
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
           
        slow.next = slow.next.next;
        return head;    
    }
}




