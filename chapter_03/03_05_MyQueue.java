package 栈与队列;
import java.util.Stack;

public class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;
	
	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {
		stackNewest.push(value);
	}
	
	private void shiftStacks() {
		if (stackOldest.isEmpty())
			while(!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
	
	public static void main(String[] args) {
		
		MyQueue<Integer> queue = new MyQueue<>();
		queue.add(2);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		while(queue.size() != 0) {
			System.out.println(queue.remove());
		}

	}

}
