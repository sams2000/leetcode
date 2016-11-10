package com.example.leet;


import algorithm.datastructure.ListNode;
/**
 * 
 * example linkedlist : ->1->2->3->4->5->null
 * 
 * @author bz250056
 * @since 2014-04-01	
 */
public class BasicOfLinkedList {

	public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        
        ListNode head = one;
        
        //step through linkedlist
        System.out.print("Original linked list : ");
        ListNode curNode = head;
        while (curNode != null){
            System.out.print("->" + curNode.val);
            curNode = curNode.next;
        } 
        
        //test 1 : list length
        System.out.println("\nList length is : " + listLength(head)); 

        int k = 3;
        //test 2: return k th node in the list
        ListNode kthNode = kthNode(head, k);
        System.out.println("\n"+ k + "th Node is : " + kthNode.val);
        
        //test 3: reverse first k nodes
        System.out.print("After reverse first " + k + " list nodes : ");
        curNode= reverseFirstKNodes(head, k);
        head = curNode;
        while (curNode != null){
            System.out.print("->" + curNode.val);
            curNode = curNode.next;
        }   
        
        //test 4: insertAtKth
        curNode= insertAtKth(head, k, 100);
        System.out.print("\ninsert new node at " + k + "th place in list : ");
        while (curNode != null){
            System.out.print("->" + curNode.val);
            curNode = curNode.next;
        }         
	}
	
    /////////////////////////listLength() - http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
    public static int listLength(ListNode node){
    	//if (head == null) return 0;
    	
    	int len = 0;
    	while (node != null){
    		len++;
    		node=node.next;
    	}
    	
    	return len;
    }
    
    /////////////////////////Get kth node in the link list
    public static ListNode kthNode(ListNode head, int k){
    	assert(k>=0);
    	//if (k<=1) return head;
 
    	//make sure k is less than the list length
    	/*int len = listLength(head);
    	k = k%len;*/
    	
    	//find kth and return
    	ListNode cur = head;
    	for (int i=1; i<k; i++){
    		cur=cur.next;
    	}
    	
    	return cur;
    }
    
    /////////////////////////reverse first k nodes in the linked list solution
    public static ListNode reverseFirstKNodes(ListNode head, int k){
    	assert(k>=0);
    	
    	if (k<=1) return head;
    	
    	//make sure k is less than the list length
    	int len = listLength(head);
    	k=k%len;
    	
    	//reverse first k nodes
    	ListNode curTail=head;
    	
    	ListNode pre=null, cur=head, next=null;
    	for (int i=0; i<k; i++){
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	
    	curTail.next = cur;
    	head = pre;
    	
    	return head;
    }    
    
    /////////////////////////insert a new node at kth place (starting counting index from 1)
    public static ListNode insertAtKth(ListNode head, int k, int val){
    	assert(k>=0);
    	
    	ListNode insertNode = new ListNode(val);
    	int len = listLength(head);
    	k=k%len;
    	if (k<=1){
    		insertNode.next = head;
    		return insertNode;
    	}
    	
    	ListNode pre=null, cur = head;
    	for (int i=0; i<k-1; i++){
    		pre=cur;
    		cur=cur.next;
    	}
    	
    	pre.next = insertNode;
    	insertNode.next = cur;
    	
    	return head;
    }
    
}



