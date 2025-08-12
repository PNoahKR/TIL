import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_수열편집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 수열의 길이
			int N = sc.nextInt();
			// 편집 횟수
			int M = sc.nextInt();
			// 출력할 인덱스
			int L = sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();
			// 수열 입력
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			// 로직
			// 편집 횟수만큼의 반복문을 진행
			for (int i = 0; i < M; i++) {
				char c = sc.next().charAt(0);
				// 'I'일 경우 입력받는 idx에 value 값을 삽입
				if(c == 'I') {
					list.add(sc.nextInt(), sc.nextInt());
				} // 'D'일 경우 입력받는 idx의 값을 삭제
				else if (c == 'D') {
					list.remove(sc.nextInt());
				} // 'C'일 경우 idx에 있는 값을 value로 바꿈
				else if (c == 'C') {
					list.set(sc.nextInt(), sc.nextInt());
				} else {
					System.out.println("잘못된 입력입니다.");
					return;
				}
			}
			
			// 출력
			// L인덱스가 존재하면 값 출력, 아니라면 -1 출력
			if(list.size() > L) {
				System.out.println("#" + test_case + " " + list.get(L));				
			} else {
				System.out.println("#" + test_case + " -1");				
			}
		}
		sc.close();
	}
}
