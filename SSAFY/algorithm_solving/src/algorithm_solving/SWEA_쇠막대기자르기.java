package algorithm_solving;

import java.util.Scanner;
import java.util.Stack;

/*
 * 제약조건
 * 1. 자기보다 긴 막대 위에만 놓일 수 있다. (괄호의 포함관계가 성립된다.)
 * 2. 완전 포함되게 놓으며, 끝점은 안겹침 (괄호 의 포함관계 성립된다.)
 * 3. 쇠막대를 자르는 레이저는 적어도 1개 이상
 * 4. 레이저는 막대기 끝점과 겹치치 않는다.
 */

public class SWEA_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 괄호
			String str = sc.next();
			// 괄호를 담을 스택
			Stack<Character> stack = new Stack<>();
			// 잘린 쇠막대기
			int cutStick = 0;
			// 레이저 생성 조건
			boolean raser = false;

			// 로직
			/*
			 * 1. 앞에서 부터 천천히 순회 
			 * 2. '(' 를 만나면 stack에 push(), raser = true 
			 * 3. ')'를 만나면 stack에 pop() 
			 * 3-1. raser가 true이면 stack.size() 만큼 cutStick에 더하기, raser = false
			 * 3-2. raser가 false이면 cutStick에 + 1
			 */
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(str.charAt(i));
					raser = true;
				} else {
					stack.pop();
					if (raser) {
						cutStick += stack.size();
						raser = false;
					} else {
						cutStick++;
					}
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + cutStick);
		}
	}
}
