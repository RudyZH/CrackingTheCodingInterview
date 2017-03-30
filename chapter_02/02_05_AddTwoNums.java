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

public class AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		ListNode head = new ListNode(0);
		ListNode temp = head;
		int flag = 0;
		
		while(l1 != null || l2 != null || flag != 0) {
			
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + flag;
			flag = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			
			l1 = (l1 != null ? l1.next : l1);
			l2 = (l2 != null ? l2.next : l2);
		}
		
        return head.next;
    }
	
	public void show(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.printf("%d", temp.val);
			System.out.print("->");
			temp = temp.next;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p1 = head;
		ListNode p2 = p1.next;
		while (p2 != null) {
			ListNode p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		head.next = null;
		return p1;
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
		//l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		
		AddTwoNums a = new AddTwoNums();
		a.show(l1);
		System.out.println();
		a.show(l5);
		System.out.println();
		a.show(a.addTwoNums(l1, l5));
		
	}

}
