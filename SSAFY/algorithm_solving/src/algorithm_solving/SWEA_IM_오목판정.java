import java.util.Scanner;

public class SWEA_IM_오목판정 {
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			int N = sc.nextInt();
			char[][] arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 로직

			// 출력
			System.out.println("#" + test_case + " ");
		}
		sc.close();
	}
}
