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

public class DeleteSpecificNode {

	
	/*
	 *  不可刪除最后一個節點
   */
	public void deleteSpecificNode(ListNode node) {
		if (node == null || node.next == null) 
			return;
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
		return;
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
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		
		DeleteSpecificNode d = new DeleteSpecificNode();
		d.show(l1);
		System.out.println();
		d.deleteSpecificNode(l1);
		d.show(l1);
		
	}

}
