import java.util.ArrayDeque;

public class CalculatorUpgrade2 {
	
	
	
	private static int operator(ArrayDeque<Integer> stack, char ch, int a, int b) {
		if(ch == '+') {
			return b + a;
		} else if(ch == '-') {
			return b - a;
		} else if(ch == '*') {
			return b * a;
		} else {
			return b / a;
		}
	}

	public static void main(String[] args) {
		// 입력
		String postfix = "6528-*2/+"; // 후위표현식

		// 로직
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		// 순차적으로 문자를 스캔한다
		for (char ch : postfix.toCharArray()) {
			//피연산자 (숫자) -> 스택에 넣는다!
			if(Character.isDigit(ch)) {
				stack.push(ch - '0');
			}
			// 연산자 +=*/ -> 피연산자 2개 꺼내서 연산 후 다시 넣는다!
			else {
				// 피연산자 두개 꺼내기
				int a = stack.pop();
				int b = stack.pop();
				
				// 연산자(토큰 -> 연산함수 메서드)
				
				stack.push(operator(stack, ch, a, b));
			}
		}
		
		//출력
		System.out.println(stack.pop());
	}

}
