package com.example.leet;

/**
 * Implement a function to check if a linked list is a palindrome
 * @author bzhou
 * @since 2013-02-05
 */
import java.util.Stack;    

class Result{
    public ListNode node;
    public boolean result;
    
    Result(ListNode node, boolean result){
        this.node = node;
        this.result = result;
    }
}

public class PalindromeLinkedList {
	// Recursive Approach
	private static Result isPalindromeRecursive(ListNode head, int length) {
		if (head == null || length == 0)
			return new Result(null, true);
		else if (length == 1)
			return new Result(head.next, true);
		else if (length == 2)
			return new Result(head.next.next, head.val == head.next.val);

		Result res = isPalindromeRecursive(head.next, length - 2);
		if (!res.result || res.node == null)
			return res;
		else {
			res.result = head.val == res.node.val;
			res.node = res.node.next;
			return res;
		}

	}

	// Iterative Approach: to push the first half of the elements onto a stack
	private static boolean isPalindromeWithStack(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		Stack<Integer> stack = new Stack<Integer>();
		// push elements from first half of linked list onto stack. When fast
		// runner (which is moving at 2x speed)
		// reaches the end of the linked list, then we know we/re at the middle
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}

		// had odd number of elements , so skip the middle element
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();

			if (top != slow.val) {
				return false;
			} else {
				slow = slow.next;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		ListNode head = one;
		while (head != null) {
			System.out.print("->" + head.val);
			head = head.next;
		}

		System.out.print("This linked list is Palindrome ? \n");
		System.out.println("isPalindromeWithStack: "
				+ isPalindromeWithStack(one));
		System.out.println("isPalindromeRecursive: "
				+ isPalindromeRecursive(one, 6).result);
	}
}
