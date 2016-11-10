package com.example.leet;

import algorithm.datastructure.ListNode;

/**
 * Write program that includes the partial class below to create singly-linked
 * lists of the ListNode defined in the class. Add a method to the main program
 * that returns whether or not the list contains a loop. Then create unit tests
 * that create 2 lists, one with a loop and one without. See picture for more
 * explanation.
 *
 * @author bzhou
 * @since 4/2/2013
 * @since 2016-08-08
 */

public class CheckLinkedListLoopApp {
    private static ListNode one, two, three, four;

    public static boolean hasLoop(ListNode head) {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return false;
        }

        ListNode slow = head.getNext(); //slow for 1 step
        ListNode fast = head.getNext().getNext(); //fast for 2 steps

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }

            if (slow.getNext() == null || fast.getNext() == null || fast.getNext().getNext() == null) {
                return false;
            }

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return false;
    }

    public static void main(String[] args) {
        
        one = new ListNode(1);
        two = new ListNode(2);
        three = new ListNode(3);
        four = new ListNode(4);
        
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(two);
        
        System.out.println("List with or without loop? " + hasLoop(one));
    }

}
