package algorithm_solving;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1210 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			int t = sc.nextInt();
			int[][] arr = new int[100][100];
			
			
			int goal = 0;
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 2) {
						goal = j;
					}
				}
			}
			
			// 로직
			//제약사항
			//1. arr[N-1][j] 의 값이 2에서 출발
			//2. 위 좌 우 방향만 이동 가능
			//3. 좌 우에 1을 만났을 때 그쪽 방향으로 이동
			//4. 좌 우 이동중 위로가는 1을 만났을 때 위로 이동
			//경계값 지켜!
			
			for(int i = arr.length - 1; i >= 0; i--) {
				arr[i][goal] = 0;
				if(goal-1 >= 0) {
					while(goal-1 >= 0 && arr[i][goal-1] == 1) {
						goal -= 1;
						arr[i][goal] = 0;
					}
				}
				
				if(goal+1 < arr.length) {
					while(goal+1 < arr.length && arr[i][goal+1] == 1) {
						goal += 1;
						arr[i][goal] = 0;
					}
				}
			}

			// 출력
			System.out.println("#"+ t + " " + goal);
		}
	}

}