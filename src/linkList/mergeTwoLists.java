package linkList;

import model.ListNode;

public class mergeTwoLists {
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if (l1==null) return l2;
         if (l2==null) return l1;
         ListNode l3=null;
         ListNode head=null;
         while(l1 !=null&&l2 !=null){
             if (l1.val<l2.val){
                 if (head==null){
                     head=l1;
                     l3=head;
                 }else{
                     l3.next=l1;
                     l3=l3.next;
                 }
                 l1=l1.next;
                 
             }else{
                 if (head==null){
                     head=l2;
                     l3=head;
                 }else{
                     l3.next=l2;
                     l3=l3.next;
                 }
                 
                 l2=l2.next;
             }
             l3.next=null;
              
         }
         if (l1==null){
             l3.next=l2;
         }
         if (l2==null) l3.next=l1;
         return head;
    }
	 
	 public static void main(String[] args){
		 ListNode l1=new ListNode(1);
		 ListNode temp=new ListNode(3);
		 l1.next=temp;
		 ListNode l2=new ListNode(2);
		 ListNode temp1=new ListNode(4);
		 l2.next=temp1;
		 System.out.println(mergeTwoLists(l1,l2));
	 }
}
