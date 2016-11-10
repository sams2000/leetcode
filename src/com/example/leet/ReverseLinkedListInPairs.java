package com.example.leet;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author bin zhou
 * @since 2016-02-10
 */
import algorithm.datastructure.ListNode;

public class ReverseLinkedListInPairs{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        
        ListNode head = swapPairs(one);
        System.out.print("Reversed List is : " + head.val);
        while (head.next != null){
            System.out.print("->" + head.next.val);
            head = head.next;
        }
    }
 
    /**
     * accepted solution
     * @param head
     * @return head
     */
    private static ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) 
                return head;
                
            if (pre == null) //if first time to assign new head
                head = next;
            else
                pre.next = next;
            
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        
        return head;
    }
    
}


