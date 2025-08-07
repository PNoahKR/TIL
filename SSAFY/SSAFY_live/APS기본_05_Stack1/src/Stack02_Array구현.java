
public class Stack02_Array구현 {
	// 배열을 이용한 구현 -> 고민포인트... -> 10만~100만사이 값 ㅋㅋ
	static String[] stack = new String[10];
	static int top = -1; // -1은 인덱스 밖! 공백상태군!

	public static void main(String[] args) {

	}

	// push
	static boolean push(String item) {
		// 배열이므로 가득 차 있는지 체크
		if (isFull()) {
			System.out.println("가득이요");
			return false;
		}
		
		stack[++top] = item;

		return true;
	}

	// pop
	static String pop() {
		if(isEmpty()) {
			// 공백상태이므로 어떤 작업을 진행해라
			System.out.println("공허함요");
			return null;
		}
		// 꺼내자
		return stack[top--];
	}
	
	// peek
	static String peek() {
		return stack[top];
	}
	
	
	
	// isEmpty()
	static boolean isEmpty() {
		return top == -1;
	}
	
	
	
	
	
	
	
	// isFull()
//	static boolean isFull() {
//		if (top == stack.length - 1) {
//			return true;
//		} else {
//			return false;
//  	}
//	}
//	static boolean isFull() {
//		if (top == stack.length - 1) {
//			return true;
//		}
//		return false;
//	}
	static boolean isFull() {
		return top == stack.length - 1;
	}
}
