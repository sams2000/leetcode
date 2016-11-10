package com.example.leet;

import java.util.ArrayList;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author bzhou3
 * @since 2016-01-29
 */
public class ConvertSortedListToBST {
    static ListNode h;
    
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next=B;
        B.next=C;
        C.next=D;
        D.next=E;
        E.next=null;
        ConvertSortedListToBST coverter = new ConvertSortedListToBST();
        TreeNode root = coverter.sortedListToBST(A);
        System.out.println(coverter.inOrderTravel(root));
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
 
        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    // get list length
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
    
    public ArrayList<Integer> inOrderTravel(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        helper(root, result);
        
        return result;
    }
    
    private void helper(TreeNode root, ArrayList<Integer> result){
        if (root == null) {
            return;
        } else {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
}
