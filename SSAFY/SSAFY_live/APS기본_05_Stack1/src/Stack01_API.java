import java.util.Stack;

public class Stack01_API {
	public static void main(String[] args) {
		
		// 숫자를 담을 수 있는 Stack
		Stack<Integer> stack = new Stack<>();
		// 문자를 담을 수 있는 Stack
//		Stack<String>
		
		// 주요 메서드
		// 1.push(item)
		int result = stack.push(10); // 반환 결과는 item이 반환된다.
		stack.push(20);
		stack.push(30);
		
		// 2. pop()
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop()); 없는 걸 꺼내려고 하면 예외 발생
		
		// 무작정 빼면 안될 것 같은디... 
		// 3. isEmpty() -> 비어있으면 true
		System.out.println(stack.isEmpty());
		// 안에 있는거 전부 빼라
		stack.clear(); // -> 스택을 초기화 해버리는 것
		// 조건을 확인해보자
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		System.out.println(stack.size());
		
		// 4. peek()
		stack.push(100);
		stack.push(200);
		System.out.println(stack.peek());
		System.out.println(stack.size());
	}

}
