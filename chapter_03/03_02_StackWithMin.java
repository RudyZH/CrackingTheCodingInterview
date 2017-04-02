package 栈与队列;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {

	Stack<Integer> s;
	
	public StackWithMin() {
		s = new Stack<Integer>();
	}
	
	public void push(int val) {
		if (val <= min()) 
			s.push(val);
		super.push(val);
	}
	
	public Integer pop() {
		int val = super.pop();
		if (val == min())
			s.pop();
		return val;
	}
	
	public int min() {
		if (s.isEmpty())
			return Integer.MAX_VALUE;
		else 
			return s.peek();
	}
	
	
	public static void main(String[] args) {
		StackWithMin s = new StackWithMin();
		s.push(5);
		//System.out.println(s.min());
		s.push(6);
		s.push(3);
		s.push(7);
		s.push(1);
		s.push(9);
		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
	}

}
