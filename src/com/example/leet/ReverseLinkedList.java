package com.example.leet;


/**
 * Given a linked list, reverse the whole list and return its head.
 * For example,
 * Given 1->2->3->4->5->6->null, you should return the list as 6->5->4->3->2->1->null.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author bin zhou
 * @since 2016-02-10
 */

public class ReverseLinkedList{
    public static void main(String[] args){
        // build the linkedlist 1->2->3->4->5->6->null
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
        
        ListNode head = reverseList(one);
        System.out.print("Reversed List is : " + head.val);

        while (head.next != null){
            System.out.print("->" + head.next.val);
            head = head.next;
        }
    }
  
    /**
     * accepted solution
     * revert the whole linked list from start to end
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode pre= null, cur = head, next = cur.next;
        
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;            
        }
        
        cur.next = pre;//connect last one
        
        return cur;

    }     
}


