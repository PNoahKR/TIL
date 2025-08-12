import java.util.Scanner;

public class SWEA_IM_파리퇴치3 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] xr = { -1, -1, 1, 1 };
	static int[] xc = { -1, 1, -1, 1 };
	static int N, M;

	public static int spray(int[][] arr, int i, int j, int[] r, int[] c) {
		int sum = arr[i][j];
		for(int k = 0; k < 4; k++) {
			for (int l = 1; l < M; l++) {
				int nr = i+r[k]*l;
				int nc = j+c[k]*l;				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					sum += arr[nr][nc];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, spray(arr, i, j, dr, dc));
					max = Math.max(max, spray(arr, i, j, xr, xc));
				}
			}
			
			System.out.println("#" + test_case + " " + max);

		}
	}

}
