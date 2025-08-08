import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class CalculatorUpgrade1 {

	public static void main(String[] args) {
		// 입력
		String infix = "2+3*4/5";

		// isp: 연산자 우선순위 (스택안에 우선순위
		Map<Character, Integer> isp = new HashMap<>();
		isp.put('(', 0);
		isp.put('*', 2);
		isp.put('/', 2);
		isp.put('+', 1);
		isp.put('-', 1);
		// icp: 연산자 우선순위 (새로 들어올 때의 우선순위
		Map<Character, Integer> icp = new HashMap<>();
		icp.put('(', 3);
		icp.put('*', 2);
		icp.put('/', 2);
		icp.put('+', 1);
		icp.put('-', 1);

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
			// 얘가 가장 높기 때문에.. 안에 뭐가 있든 상관X!
			else if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '(') {
				// 스택 안(isp)에 우선순위가 내가 들어갈(icp) 더 높다면 빼라...!
				while (!stack.isEmpty() && isp.get(stack.peek()) >= icp.get(ch)) {
					postfix += stack.pop();
				}
				stack.add(ch);
			}
			// 닫는 괄호 처리 ')'
			// = 여는 괄호를 만날 때까지 pop!
			else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop(); // 여는 괄호 버리기! '('
			}
		}
		// 스택의 남은 모든 연산자를 출력
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		// 후위표기식 출력
		System.out.println(postfix);
	}
}
