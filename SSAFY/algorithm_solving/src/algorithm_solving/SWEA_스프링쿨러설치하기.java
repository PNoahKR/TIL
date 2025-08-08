package algorithm_solving;

import java.util.Scanner;

public class SWEA_스프링쿨러설치하기 {
	// 상하좌우 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= 10; test_case++) {
			// 입력
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					farm[i][j] = sc.nextInt();
				}
			}
			
			// 로직
			// 작물의 최대 수를 잡기 위해... 테스트 케이스에 음수가 있기에 min_value 사용
			int harvest = Integer.MIN_VALUE;
			
			// 상하좌우 델타 탐색하며 최대 이익 실현 개수 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = farm[i][j];
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							sum += farm[nr][nc];
						}
					}
					if(harvest < sum) {
						harvest = sum;
					}
				}
			}
			
			
			// 출력
			System.out.println("#" + test_case + " " + harvest);
		}
	}
}
