package 链表;

import javax.xml.stream.events.EndDocument;

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


public class DivideList {
	
	/*
	 *  method 
	 *  myself
	 *  基于快排
	 */
	public ListNode divideList(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode i = new ListNode();
		i.next = head;
		ListNode j = head;
		for (; j.next != null; j = j.next) {
			if (j.val < k) {
				i = i.next;
				int temp = i.val;
				i.val = j.val;
				j.val = temp;
			}
		}
		i = i.next;
		int temp = i.val;
		i.val = j.val;
		j.val = temp;
		return head;
	}
	
	/*
	 *  method 2
	 *  使用两个链表保存结果
	 *  每次插入到链表的尾端
	 */

	public ListNode partition2(ListNode head, int x) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		
		while (head != null) {
			ListNode next = head.next;
			head.next = null;
			if (head.val < x) {
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = head;
					beforeEnd = head;
				}
			} else {
				if (afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				} else {
					afterEnd.next = head;
					afterEnd = head;
				}
			}
			head = next;
		}
		
		if (beforeStart == null)
			return afterStart;
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	/*
	 *  method 3
	 *  每次插入到链表的头部
	 */
	public ListNode partition3(ListNode head, int x) {
		ListNode beforeStart = null;
		ListNode afterStart = null;
		
		while (head != null) {
			ListNode next = head.next;
			if (head.val < x) {
				head.next = beforeStart;
				beforeStart = head;
			} else {
				head.next = afterStart;
				afterStart = head;
			}
			head = next;
		}
		
		if (beforeStart == null)
			return afterStart;
		
		ListNode temp = beforeStart;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = afterStart;
		return beforeStart;	
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
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(8);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(7);
		ListNode l7 = new ListNode(6);
		ListNode l8 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		DivideList d = new DivideList();
		d.show(l1);
		System.out.println();
		ListNode res = d.partition3(l1, 4);
		d.show(res);
//		System.out.println();
//		d.show(d.divideList(l1, 4));
		
		
		
	}

}
