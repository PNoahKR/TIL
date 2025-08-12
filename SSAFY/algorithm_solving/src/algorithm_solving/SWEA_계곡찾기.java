import java.util.Scanner;

public class SWEA_계곡찾기 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int sum = 0;

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (isValley(map, i, j)) { 
						sum++;
					}
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}

	public static boolean isValley(int[][] map, int r, int c) {
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (map[r][c] >= map[nr][nc]) {
				return false;
			}
		}
		return true;
	}
}
