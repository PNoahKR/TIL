import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			// 입력
			int T = sc.nextInt();

			// 배열 생성
			Queue<Integer> q = new LinkedList<>();

			// 데이터 넣기
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}

			// 로직
			// 0이 발견되면 while문 탈출
			boolean zero = false;
			while (!zero) {
				// 1~5까지 사이클을 돌면서 감소
				for (int i = 1; i <= 5; i++) {
					// 큐에서 숫자를 꺼내 사이클을 돌며 숫자 차감
					int num = q.poll();
					num -= i;
					// num 이 0이하가 되면 zero를 true 바꾸고 for 문 탈출 -> while문도 더이상 안돔
					if (num <= 0) {
						q.offer(0); // 0보다 작아지는 경우 0으로 유지
						zero = true;
						break;
					}
					q.offer(num);
				}
			}

			// 출력
			System.out.print("#" + T + " ");
			for (int p : q) {
				System.out.print(p + " ");
			}
			System.out.println();

		}
	}
}
