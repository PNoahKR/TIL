import java.util.Scanner;
import java.util.Stack;

public class Stack05_뒤로앞으로 {
	// Ctrl + z (실행취소)
	// Ctrl + y (실행취소 를 취소)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String page = "Google";

		Stack<String> 뒤로 = new Stack<>();
		Stack<String> 앞으로 = new Stack<>();

		// 일단 페이지를 입력받아서 거기부터 시작이야!
//		do {
//			
//		} while();

		while (true) {
			System.out.println("1. 새로운 페이지 방문");
			System.out.println("2. 뒤로 가기");
			System.out.println("3. 앞으로 가기");
			System.out.println("0. 종료버튼 (그 외 다른거 눌러도 종료됨)");

			int cmd = sc.nextInt();
			switch (cmd) {
			case 1:
				System.out.println("새로운 페이지 입력");
				//1. 현재 페이지를 뒤로 스택에 push
				뒤로.push(page);
				//2. 새로운 페이지 입력
				page = sc.next(); //공백은 없이 입력된다 가정
				//3. 앞으로 스택을 비워야 함
				//3.1 반복문 이용해서 죄다 꺼내기
				//3.2 새로운 스택 생성하기
				//3.3 clear() 활용하기
				앞으로.clear();
				//4. 현재 페이지 출력
				System.out.println("브라우저 : " + page);
				break;
			case 2:
				if (뒤로.isEmpty()) {
					System.out.println("뒤가 없다");
				} else {
					System.out.println("뒤로 갑니다.");
					//1. 현재 페이지를 앞으로 스택에 넣는다
					앞으로.push(page);
					//2. 현재 페이지는 뒤로 스택에서 꺼내온다.
					page = 뒤로.pop();
					//3. 현재 페이지 출력
					System.out.println("브라우저 : " + page);
				}
				break;
			case 3:
				if(앞으로.isEmpty()) {
					System.out.println("앞이 없다");
				} else {
					System.out.println("앞으로로 갑니다.");
					//1. 현재 페이지를 뒤로 스택에 넣는다
					뒤로.push(page);
					//2. 현재 페이지는 앞으로 스택에서 꺼내온다.
					page = 앞으로.pop();
					//3. 현재 페이지 출력
					System.out.println("브라우저 : " + page);
				}
				break;
			default:
				System.out.println("종료합니다");
				return;

			}
		}
	}
}
