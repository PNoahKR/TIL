import java.util.ArrayDeque;

public class Calculator1 {

	public static void main(String[] args) {
		// 입력
		String infix = "2+3*4/5";

		// 로직
		String postfix = ""; // 누적할 후위 표기식
		ArrayDeque<Character> stack = new ArrayDeque<>();
		// 중위표현식을 문자열 순서대로 순회!
		for (int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);

			// 피연산자 숫자 처리 (Character.isDigit(ch))
			if ('0' <= ch && ch <= '9') {
				postfix += ch;
			}
			// 여는 괄호 처리 '('
			else if (ch == '(') {
				// 얘가 가장 높기 때문에 안에 뭐가 있든 상관 X
				stack.push(ch);
			}
			// '*' '/' 처리
			// 실질적으로 가장 높은 우선순위를 가지는 연산자!
			// - 같은 우선순위인 */는 스택에서 먼저 빼줘라!
			else if (ch == '*' || ch == '/') {
				if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					postfix += stack.pop();
				}
				stack.push(ch);
			}
			// '+' '-' 처리
			else if (ch == '+' || ch == '-') {
				while (!stack.isEmpty()
						&& (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
					postfix += stack.pop();
				}
				stack.push(ch);
			}
			// 닫는 괄호 처리 ')'
			else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix += stack.pop();
				}
				if (!stack.isEmpty())
					stack.pop(); // 여는 괄호 버리기
			}
		}
		// 스택의 남은 모든 연산자를 출력
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		// 후위표기식 출력
		System.out.println(postfix);
	}
}
