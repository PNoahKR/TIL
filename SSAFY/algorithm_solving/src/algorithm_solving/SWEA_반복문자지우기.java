package algorithm_solving;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SWEA_반복문자지우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			String str = sc.next();
			
			// 로직
			// 문자를 넣을 스택
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			// 스택이 비어있거나 || top 데이터와 입력 받은 데이터가 다르면 입력받은 문자를 스택에 넣고
			// 스택이 차있는데 top 데이터와 입력받은 문자를 비교해 같으면 문자 push
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(!stack.isEmpty() && stack.peek() == ch){
					stack.pop();
					continue;
				}
				stack.push(ch);
			}
			if(stack.size() == 1) {
				stack.pop();
			}
			
			// 출력
			System.out.println("#" + test_case + " " + stack.size());
		}
	}
}
