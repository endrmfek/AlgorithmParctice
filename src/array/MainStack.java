package array;

public class MainStack {
	static class Stack<T> {
		int top;
		int capacity = -1;
		T[] stack;
		
		public Stack(int capacity) {
			this.capacity = capacity;
			stack = (T[]) new Object[capacity];
			System.out.println("size : " + capacity);
			top = -1;
		}
		
		public void push(T element) {
			if(isFull()) {
				System.out.println("stack이 가득 찼습니다.");
				return;
			}
			
			stack[++top] = element;
		}
		
		public T pop() {
			if(isEmpty()) {
				System.out.println("stack이 비어있습니다.");
				return null;
			}
			
			return stack[top--];
			
		}
		
		public T peek() {
			if(isEmpty()) {
				System.out.println("stack이 비었습니다.");
				return null;
			}
			
			return stack[top];
		}
		
		public void clear() {
			if(isEmpty()) {
				System.out.println("stack은 이미 비어있습니다.");
				return;
			}
			top = 0;
			stack = (T[]) new Object[capacity];
			System.out.println("stack 초기화 완료.");
			
		}
		
		public int size() {
			return top+1;
		}
		
		public boolean isEmpty() {return (this.top == -1); }
		public boolean isFull() {return (this.top == capacity-1); }
	}
}
