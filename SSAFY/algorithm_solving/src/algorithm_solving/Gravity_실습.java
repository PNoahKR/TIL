package algorithm_solving;

import java.util.Scanner;

public class Gravity_실습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			int N = sc.nextInt();
			int[][] arr = new int[N][100];
			// 상자 최대 높이
			int high = 0;
			
			for (int i = 0; i < N; i++) {
				int box = sc.nextInt();
				high = Math.max(high, box);
				for(int j = 0; j < box; j++) {
					arr[i][j] = 1;
				}
			}
			
			// 로직
			// 미리 뒤집어진 2차원 배열 생성
			int[][] tArr = new int[high][N];
			// 바닥이 되는 [N-1]이 첫번째가 되도록
			for(int i = 0; i < high; i++) {
				for(int j = 0; j < N; j++) {
					tArr[i][j] = arr[N-1-j][i];
				}
			}
			
			// 최대 낙차
			int drop = 0;
			
			for (int i = 0; i < high; i++) {
				// 0 즉, 낙차 카운트
				int zeroCnt = 0;
				for (int j = 0; j < N; j++) {
					if(tArr[i][j] == 0) {
						zeroCnt++;
					} else if (zeroCnt > drop) {
						drop = zeroCnt;
					}
				}
			}
			

			// 출력
			System.out.println("#" + test_case + " " + drop);
		}
	}

}
