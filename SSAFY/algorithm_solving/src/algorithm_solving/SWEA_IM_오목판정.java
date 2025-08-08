package algorithm_solving;

import java.util.Iterator;
import java.util.Scanner;

public class SWEA_IM_오목판정 {
	static int N;
	static char[][] arr;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	private static boolean search5O(int r, int c) {

		for (int i = 0; i < 8; i++) {
			boolean omog = true;
			for (int j = 1; j <= 5; j++) {
				int nr = r + dr[i] * j;
				int nc = c + dc[i] * j;
				if (nr < 0 && nr >= N && nc < 0 && nc >= N && arr[nr][nc] != 'o') {
					omog = false;
					break;
				}
				
			} // 연속되는 4거리 탐색 
			if(omog) {
				return true;
			}
		}// 델타 탐색
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 오목판 크기
			N = sc.nextInt();
			arr = new char[N][N];

			// 돌 놓기
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 로직
			boolean isOk = false;
			// 배열을 순회하면서 o를 만나면 메서드를 통해서 델타탐색
			// 델타 탐색은 상,하,좌,우,대각선 8방향을 모두 탐색해 경계에 부딪히거나, o가 아니면
			// 탐색 중단
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o') {
						isOk = search5O(i, j);
					}
				}
			}

			// 출력
			if (isOk) {
				System.out.println("#" + test_case + " YES");
			} else {
				System.out.println("#" + test_case + " NO");
			}

		}
	}

}
