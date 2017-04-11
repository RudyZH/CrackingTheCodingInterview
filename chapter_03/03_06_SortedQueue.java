package 栈与队列;
import java.util.Stack;

public class SortedQueue {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(2);
		s.push(5);
		s.push(1);
		s.push(8);
		Stack<Integer> res = SortedQueue.sort(s);
		while (!res.isEmpty()) {
			System.out.println(res.pop());
		}
	}
}
