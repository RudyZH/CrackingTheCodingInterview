package 链表;

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

public class FindBeginning {

	public ListNode findBeginning(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		
		if (fast == null || fast.next == null)
			return null;
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
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
		l8.next = l4;
		
		FindBeginning f = new FindBeginning();
		System.out.println(f.findBeginning(l1).val);
	}

}
