import java.util.ArrayDeque;

public class Calculator2 {
	public static void main(String[] args) {
		// 입력
		String postfix = "234*5/+"; // 후위표현식

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
				if(ch == '+') {
					int temp = b + a;
					stack.push(temp);
				} else if(ch == '-') {
					int temp = b - a;
					stack.push(temp);
				} else if(ch == '*') {
					int temp = b * a;
					stack.push(temp);
				} else if(ch == '/') {
					int temp = b / a;
					stack.push(temp);
				}
			}
		}
		
		//출력
		System.out.println(stack.pop());
	}
}
