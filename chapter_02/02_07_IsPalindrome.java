package 链表;

import java.util.Stack;

class ListNode {
	public ListNode next;
	public int val;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public ListNode() {
		this.val = 0;
		this.next = null;
	}
}

public class IsPalindrome {

	/*
	 *  method 1
	 *  翻转链表并比较
	 *  比较一半即可
	 */
	
	/*
	 *  method 2
	 *  利用栈保存前半部分
	 */
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) // 说明链表数为奇数，否则偶数
			slow = slow.next;
		
		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	public void show(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.printf("%d", temp.val);
			System.out.print("->");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
//		ListNode l2 = new ListNode(1);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(3);
//		ListNode l6 = new ListNode(2);
//		ListNode l7 = new ListNode(1);
		//ListNode l8 = new ListNode(1);

	//	l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
		//l7.next = l8;
		
		IsPalindrome i = new IsPalindrome();
		i.show(l1);
		System.out.println();
		System.out.println(i.isPalindrome(l1));
	}

}
