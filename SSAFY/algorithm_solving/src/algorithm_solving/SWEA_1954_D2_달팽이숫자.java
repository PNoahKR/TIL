package algorithm_solving;

import java.util.Scanner;

public class SWEA_1954_D2_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // NxN크기의 배열
			int[][] arr = new int[N][N];

			int K = N; // 이동할 칸의 수
			int D = 1; // 증감 1 -> 1 -> 1

			// 현재좌표
			int r = 0;
			int c = -1;
			// 채울 숫자
			int num = 1;
			// 반복문 차례
			while (true) {
				// 수평->수직 : 이동거리가 준다
				for (int i = 0; i < K; i++) {
					c += D; // D 때로는 1 때로르 -1
					arr[r][c] = num++;
				}
				K--;
				// 종료 조건
				// 1. K == 0
				// 2. (r,c) 중앙 좌표일 때
				// 3. num == NxN;
				if (K == 0)
					break;

				// 수직->수평 : 증감의 방향이 바뀐다.
				for (int i = 0; i < K; i++) {
					r += D;
					arr[r][c] = num++;
				}
				D = -D;
			} // 달팽이 채우기

			System.out.println("#" + tc);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		} // tc for문
	}// main
}
