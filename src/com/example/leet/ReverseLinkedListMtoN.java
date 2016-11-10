package com.example.leet;

import algorithm.datastructure.ListNode;

/**
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *  For example:
 *  Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *  return 1->4->3->2->5->NULL.
 *  Note:
 *  Given m, n satisfy the following condition:
 *  1 <= m <= n <= length of list.
 *
 * @author bin zhou
 * @since 2016-02-10
 */

public class ReverseLinkedListMtoN{
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
        
        ListNode head = reverseBetween(one, 2, 4);
        System.out.print("Reversed List is : " + head.val);
        while (head.next != null){
            System.out.print("->" + head.next.val);
            head = head.next;
        }
    }
    
    /**
     * accepted solution: using while loop to step through
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode preTail = null, midTail=null, pre=null, cur=head, next=null;
        
        int i=1;
            
        while(i<m){ //m inclusive
            preTail = cur;
            cur=cur.next;
            i++;
        }
        
        midTail = cur;
        
        while(i<=n){ //n inclusive
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        
        if (preTail == null){
            head = pre;
        } else {
            preTail.next = pre;
        }
        
        midTail.next = cur;
        
        
        return head;
    }
 
    /**
     * accepted solution: using for loop to step through
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null) return head;
        
        ListNode preTail = null, midTail = null;
        ListNode preNode = null, curNode = head;
        
        for (int i=1; i<=n; i++){
            if (i==m-1) preTail = curNode;
            if (i==m) midTail = curNode;
            if (i>=m){ //convert 1->2->3->4->5 to 1->2<-3<-4->5
                ListNode nextNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = nextNode;
            } else {
                curNode = curNode.next;
            }
            
        }
        //connect three parts together 1, 2<-3<-4, 5
        //e.g preTail is 1, preNode is 4, curNode is 5, curTail is 2
        if (preTail==null) {
            head = preNode;
        } else {
            preTail.next = preNode;
        }
        
        midTail.next = curNode;      
        
        return head;
    }
   

}
