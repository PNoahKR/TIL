

//// 스택의 기본 구조
//class Stack {
//	// 스택 배경
//	private int[] stack;
//	// top 위치
//	private int top;
//	// 스택의 최대 크기
//	private int size;
//
//	// 생성자
//	public Stack(int size) {
//		this.stack = new int[size];
//		this.top = -1;
//		this.size = size;
//	}
//
//	// isEmpty 스택에 요소가 하나도 없으면 true 반환 (아니라면 false 반환)
//	public boolean isEmpty() {
//		return this.top == -1;
//	}
//
//	// isFull : 스택에 요소가 꽉 차 있다면 true 반환
//	public boolean isFull() {
//		return this.top == this.size - 1;
//	}
//
//	// peek : 스택 최상단에 있는 원소를 반환(삭제X)
//	public int peek() {
//		return this.stack[this.top];
//	}
//
//	// push : 스택에 원소를 삽입
//	public boolean push(int item) {
//		if (isFull()) {
//			System.out.print("스택이 꽉차있음");
//			return false;
//		}
//		stack[++top] = item;
//		return true;
//	}
//	
//	// pop : 스택에서 원소를 제거하고 반환
//	public int pop() {
//		if(isEmpty()) {
//			System.out.print("스택이 비어있음");
//			return -1;
//		}
//		return stack[top--];
//	}
//}

public class StackTest {
	public static void main(String[] args) {
//		Stack stack = new Stack(5);
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		
		// 스택에 1, 2, 3, 4, 5, 6 삽입
		for (int i = 1; i <=6; i++) {
			stack.push(i);
			System.out.print(i + " -> ");
		}
		System.out.println();

		System.out.println("===========================");
		for (int i = 1; i <=6; i++) {
			int result = stack.pop();
			System.out.print(result + " -> ");
		}
		System.out.println();
	}
}
