import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class BracketCheckTest {
	public static void main(String[] args) {
		String text = "(())()((()))";
		// 로직
		ArrayDeque<Character> stack = new ArrayDeque<>();
		// other <-> ch 쌍을 저장할 수 있는 자료 구조
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		boolean isValid = true; // 괄호 검사 성공 유무 (true이면 성공)

//		1. 문자열에 대해 왼쪽에서 오른쪽으로 순서대로 검사 (순회)
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
//		2. 왼쪽 괄호 `(`, `[`, `{` 를 만나면 스택에 삽입 (push)
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}
//		3. 오른쪽 괄호 `)`, `]`, `}` 를 만나면 (pop)
			else if (ch == ')' || ch == ']' || ch == '}') {
//		    1. 스택에 요소가 비어있으면
				if (stack.isEmpty()) {
//		        1. **괄호 검사 실패**(조건 1, 2 위배)
					isValid = false;
					break;
				}
//		    2. 스택에 요소가 있으면
				char other = stack.pop();
//		        1. pop 해서 괄호의 짝이 맞는지 확인 → **짝X 실패!** (조건 3 위배)
				if (map.get(ch) == other)
					continue;
				else {
					isValid = false;
					break;
				}
			}
//
		}
//		end. 괄호 검사가 완료 된 후 스택에 괄호가 남아있다면 **실패!** (조건 1 위배)
		if (stack.isEmpty() && isValid) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
}
