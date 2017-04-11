package 栈与队列;
import java.util.Stack;

class Tower {
	private Stack<Integer> disks;
	private int index;
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if(!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("error placing disk " + d);
		} else {
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("move disk " + top + " from " + index() + " to " + t.index());
	}
	
	public void moveDisks(int n, Tower des, Tower buff) {
		if(n > 0) {
			moveDisks(n - 1, buff, des);
			moveTopTo(des);
			buff.moveDisks(n - 1, des, this);
		}
	}
	
}

public class MoveDisk {

	public static void main(String[] args) {
		int n = 10;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++)
			towers[i] = new Tower(i);
		
		for (int i = n - 1; i >= 0; i--)
			towers[0].add(i);
		
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
