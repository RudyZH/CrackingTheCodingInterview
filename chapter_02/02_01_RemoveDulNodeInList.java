package 链表;

import java.util.HashSet;
import java.util.Set;

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

public class RemoveDulNodeInList {

	
	/*
	 * 	method 1 
	 * 	使用HashSet
	 *  space O(n)
	 *  time O(n)
	 */
	public ListNode removeDul(ListNode head) {
		if (head == null || head.next == null)
			return head;
		Set<Integer> set = new HashSet<>();
		ListNode pre = head;
		ListNode temp = pre.next;
		set.add(pre.val);
		while (temp != null) {
			if(set.contains(temp.val)) {
				pre.next = temp.next;
				temp = temp.next;
			} else {
				set.add(temp.val);
				pre = temp;
				temp = temp.next;
			}
		}
		return head;
	} 
	
	/*
	 *  method 2
	 *  不使用额外缓存
	 *  space O(1)
	 *  time O(n^2)
	 */
	
	public ListNode deleteDup(ListNode head) {
		if (head == null)
			return head;
		ListNode cur = head;
		while (cur != null) {
			ListNode runner = cur;
			while (runner.next != null) {
				if (runner.next.val == cur.val)
					runner.next = runner.next.next;
				else 
					runner = runner.next;
			}
			cur = cur.next;
		}
		return head;
	}
	
	
	public void show(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.printf("%d", temp.val);
			System.out.print("->");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(1);
		ListNode h3 = new ListNode(1);
		ListNode h4 = new ListNode(7);
		ListNode h5 = new ListNode(8);
		ListNode h6 = new ListNode(3);
		ListNode h7 = new ListNode(3);
		ListNode h8 = new ListNode(6);
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = h6;
		h6.next = h7;
		h7.next = h8;
		
		RemoveDulNodeInList r = new RemoveDulNodeInList();
		r.show(h1);
		System.out.println();
		ListNode res = r.deleteDup(h1);
		r.show(res);
		
	}

}
