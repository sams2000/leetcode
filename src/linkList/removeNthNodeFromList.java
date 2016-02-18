package linkList;

import model.ListNode;

public class removeNthNodeFromList {
	  ListNode removeNthFromEnd(ListNode head, int n) {
	        int len=0;
	        if (head==null) return head;
	        ListNode slow=head;
	        ListNode fast=head;
	        for(int i=1;i<=n;i++){
	            fast=fast.next;
	        }
	        if(fast==null){
	            return head.next;
	        }
	        while(fast.next!=null){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        slow.next=slow.next.next;
	        return head;
	        
	    }
}
