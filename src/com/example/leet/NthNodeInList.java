package com.example.leet;

public class NthNodeInList {

    public static void main(String[] args) {
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
        
        int n = 8;
        ListNode result = nthNode(one, n);
        System.out.print(n + "th Node is " + result.val);

    }

    /**
     * return nth node in linkedList, starting with 1
     * e.g 3rd node of 1->2->3->4->5->6->null, return 3
     * @param head
     * @param n
     * @return
     */
    private static ListNode nthNode(ListNode head, int n) {
       if (head == null || n<=1) return head;
       
       //validate n is less than linked list length
       int len = 0;
       ListNode curNode = head; 
       while (curNode != null){
           curNode=curNode.next;
           len++;
       }
       System.out.println("The linked list length is " + len);
       
       n = n%len;
       curNode = head;
       for (int i=1; i<n; i++){
           curNode = curNode.next;
       }
       return curNode;
    }   
}
