package com.example.leet;
/**
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop
 * 
 * Algorithm:
 * 1. Create two pointers, FastPointer and SlowPointer
 * 2. Move FastPointer at a rate of 2 steps and Slowpointer at a rate of 1 step
 * 3. When they collide, move SlowPOinter to LinkedListHead. Keep FastPointer where it is
 * 4. Move SlowPointer and FastPointer at a rate of one step. Return the new collison point.
 * @author bin zhou
 * @since 2016-01-30
 */
public class LinkedListCycleII {

	public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        //ListNode five = new ListNode(5);
        one.next = two;
        two.next = null;
        /*two.next = three;
        three.next = four;
        four.next = two;
        */
        ListNode head = detectCycle(one);
        System.out.print("detectCycle is : " + head.val);
/*        while (head.next != null)
        {
            System.out.print("->" + head.next.val);
            head = head.next;
        }*/
	}
	
   /**
    * Definition for singly-linked list.
    * 
    */
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }	
	
    /**
     * detect linkedlist cycle
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        /*
         * find meeting point, this will be LOOP_SIZE-k steps into the linked list
         */
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow)
                break;
        }
        
        /*
         * Error check - no meeting point, and therefore no loop
         */
        if (fast == null || fast.next == null)
            return null;
        
        /*
         * move slow to head. Keep fast at meeting point. Each are k steps from the loop start. 
         * If they move at the same pace, they must meet at loop start.
         */
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        if (slow == null)
            return null;
        else
            return slow;
    }	

}



