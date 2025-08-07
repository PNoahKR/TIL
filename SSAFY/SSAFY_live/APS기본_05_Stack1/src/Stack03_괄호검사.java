import java.util.Stack;

public class Stack03_괄호검사 {

	// 소괄호만 있다! 간단한 문제로 만들어보자
	public static void main(String[] args) {
		// 괄호 검사
		// 1. 여는괄호와 닫는 괄호의 개수는 동일해야한다.
		// 2. 여는 괄호는 닫는 괄호보다 먼저 나와야 한다.
		// 3. 괄호는 포함관계여야 한다. (소괄호만 있으니 이번엔 굳이..)
		
		String str = "()()()(())";
		
		// 스택에는 상항 여는괄호만 들어간다.
		Stack<Character> stack = new Stack<>();
		boolean isOk = true; // 정상인지 아닌지를 체크하기 위함
		for (int i = 0; i < str.length(); i++) {
			// 1. 여는 괄호면 넣어!
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} 
			// 2. 닫는 괄호 확인 필수
			else {
				//공백쳌
				if(stack.isEmpty()) {
					isOk = false;
					break;
				} else {
					char c = stack.pop();
				}
			}
		} // for 검사문
		
		// 괄호 검사 끝
		
		if(isOk && stack.isEmpty()) {
			System.out.println("검사결과 이상 무!");
		} else {
			System.out.println("이슈 발생 ㅠ");
		}
		
		
	}

}
