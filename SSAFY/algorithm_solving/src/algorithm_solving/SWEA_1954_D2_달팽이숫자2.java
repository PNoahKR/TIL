package algorithm_solving;

import java.util.Scanner;

public class SWEA_1954_D2_달팽이숫자2 {
	// 델타 배열 선언
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			// N*N 배열의 길이 N
			int N = sc.nextInt();

			// 로직
			// 달팽이의 정보
			// 달팽이의 좌표위치, 달팽이의 방향, 달팽이의 칸 수
			int r = 0, c = 0;
			int dir = 0;
			int step = 0;

			// 2차원 배열 N * N 선언 및 초기화
			int[][] arr = new int[N][N];

			// 실제로 달팽이 이동.. 배열 값 넣기
			// 반복문 step이 N의 제곱이 될때까지 반복
			while (step < N * N) {
				// 현재의 방향으로 한 칸 이동
				// 다음 방향에 대한 좌표값 nr, nc
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				// 이동이 불가능한 경우 방향 전환
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 0) {
					dir = (dir + 1) % 4;
					// 방향 전환 위치로 한칸 이동
					nr = r + dr[dir];
					nc = c + dc[dir];
				}
				// 배열에 발자취 남기기 (숫자 남기기)
				arr[r][c] = ++step;
				r = nr;
				c = nc;

			}

			// 출력
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println(arr[i][N - 1]);
			}
		} // tc for문
	}// main
}
