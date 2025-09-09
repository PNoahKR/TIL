import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_미로의거리 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int[] start = null;
			int[] end = null;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (map[i][j] == 2) {
						start = new int[] { i, j };
					} else if (map[i][j] == 3) {
						end = new int[] { i, j };
					}
				}
			}

			bfs(start[0], start[1], end[0], end[1], test_case);
		}
	}

	private static void bfs(int r, int c, int ex, int ey, int tc) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		q.add(new int[] { r, c , 0 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == ex && cur[1] == ey) {
				System.out.println("#" + tc + " " + (cur[2] - 1));
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != 1) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc , cur[2] + 1 });
				}
			}
		}
		System.out.println("#" + tc + " " + 0);

	}
}
