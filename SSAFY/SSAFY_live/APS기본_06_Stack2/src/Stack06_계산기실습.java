import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack06_계산기실습 {
	public static void main(String[] args) {
		// 문자열로 된 수식 -> 입력 받은 수식
		String infix = "2+3*4/5";
		
		// 연산자 우선순위 (Map을 이용해보자)
		// * / : 2
		// + - : 1
		// ( : 0
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
		
		StringBuilder postfix = new StringBuilder();
		// 연산자를 담는 스택
		Stack<Character> op = new Stack<>();
		
		// 글자를 하나씩 읽어오자! (피연산자는 한자리수 임을 보장)
		for (int i = 0; i < infix.length(); i++) {
			char tmp = infix.charAt(i);
			// 1. 피연산자 라면 출력
			if(tmp >= '0' && tmp <= '9') {
				postfix.append(tmp);
			} // 2. 연산자 라면 -> 고민 해보자
			// 2-1. '('라면.. 
			else if(tmp == '(') {
				// 겉바 -> 바로 추가
				op.push(tmp);
			} // 2-2. ')' 라면 -> 여는 소괄호 만날 때 까지 pop 
			else if(tmp == ')') {
				while(op.peek() != '(') {
					postfix.append(op.pop());
				}
				op.pop(); // 스택의 top은 '('를 가리키고 있기 때문에
			} // 2-3. 연산자라면
			else {
				// 공백 상태라면..
				if(op.isEmpty()) {
					op.push(tmp);
				} else {
					// 연산자 우선순위를 비교해 처리(마음의 숙제)
					if(priority.get(tmp) > priority.get(op.peek())) {
						op.push(tmp);
					} else {
						postfix.append(op.pop());
						op.push(tmp);
					}
					
				}
			}
		}
		while(op.size() != 0) {
			postfix.append(op.pop());
		}
		System.out.println(postfix);
		
		
		// 중위 -> 후위를 바꿔서 계산
	}
}
