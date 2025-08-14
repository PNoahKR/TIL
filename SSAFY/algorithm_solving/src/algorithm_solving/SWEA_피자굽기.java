import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_피자굽기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 화덕 크기 N
			int N = sc.nextInt();
			// 피자의 총 개수 M
			int M = sc.nextInt();
			// 치즈를 올린 피자를 배열에 넣자
			int[] pizza = new int[M + 1];
			for (int i = 1; i <= M; i++) {
				pizza[i] = sc.nextInt();
			}

			// 로직
			// 피자 화덕의 입구와 출구가 하나라지만 결국 안에서 돌면서 나올 수 있기 때문에 Queue와 유사하다고 할 수 있겠다!
			// 먼저 pizza 배열에서 화덕큐에 N개만큼 넣어주고 한바퀴 돌때 마다 해당 값을 빼서 /2 한 값을 다시 넣어서 화덕에
			// 구우면 되는데
			// 사실상 넣고 한바퀴 돌린 상태가 바로 N개를 넣은 상태임으로 화덕큐의 사이즈가 N으로 꽉찬 상태에서 바로 poll() / 2를 넣어주면
			// 되겠다!
			Queue<Integer> firePit = new LinkedList<>();
			int idx = 1;
			do {
				// 화덕이 꽉차있지않고 넣은 피자가 아직 남아 잇으면 피자를 화덕에 넣어!
				while(firePit.size() < N && idx <= M) {
					firePit.offer(idx++);
				}
				// 빼낼 피자의 인덱스를 구해서 해당 인덱스의 피자 배열 값을 /2 하기!
				int pizzaIdx = firePit.poll();
				pizza[pizzaIdx] /= 2;
				// 피자의 치즈양이 0이 아니면 다시 해당 인덱스 집어넣기!
				if(pizza[pizzaIdx] != 0) {
					firePit.offer(pizzaIdx);
				}

				// 화덕의 피자가 1개가 될 때까지 반복!
			} while (firePit.size() != 1);

			// 출력
			// 마지막 남은 피자화덕 빼자~
			System.out.println("#" + test_case + " " + firePit.poll());
		}
		sc.close();
	}
}
