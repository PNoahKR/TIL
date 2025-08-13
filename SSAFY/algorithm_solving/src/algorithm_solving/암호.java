import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 암호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 초기 숫자 개수
			int M = sc.nextInt(); // M칸 뒤에 삽입 (문제의 M)
			int K = sc.nextInt(); // 삽입 반복 횟수

			// --- 리스트 처음 만들기 (head, tail) ---
			List<Integer> list = new LinkedList<>();

			for (int i = 1; i < N; i++) {
				list.add(sc.nextInt());
			}

			// 삽입 작업 시작
			// 현재 지정 위치 시작점을 0번째
			int currentIdx = 0;
			for (int i = 0; i < K; i++) {
				// M - 1 칸 뒤로 이동하여 삽입 직전 노드의 위치를 계산 (원형리스트처럼 순환)
				int beforeIdx = (currentIdx + M - 1) % list.size();
				int afterIdx = (beforeIdx + 1) % list.size();

				// 삽입할 계산 : 삽입 직전의 노드 + 삽입 직후의 노드
				int sum = list.get(beforeIdx) + list.get(afterIdx);

				// beforeIDx 다음 위치에 새 값을 삽입
				list.add(afterIdx, sum);

				// 삽입된 노드의 인덱스가 새로운 노드의 현재 위치가 되도록 만들기
				currentIdx = afterIdx;
			}

			// --- 출력 준비: 리스트를 ArrayList에 담아서 역순으로 편하게 출력 ---
			// 역순으로 최대 10개 출력
			System.out.print("#" + test_case + " ");
			int mx = Math.min(10, list.size()); // 10개 전까지, 0보다 작아지면 0

			// 뒤에서 앞으로 출력
			for (int i = 0; i < mx - 1; i++) {
				System.out.print(list.get(i));
				System.out.print(" ");
			}
			System.out.println(list.get(mx - 1));
		}
	}
}
