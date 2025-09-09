import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_탈주범검거 {
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	static int N, M, L, count;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 터널 세로 N 가로 M
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];

			// 맨홀 뚜껑 위치 R, C
			int R = sc.nextInt();
			int C = sc.nextInt();
			// 탈출후 소요 시간 L
			L = sc.nextInt();

			// 지하 터널 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 로직
			// bfs탐색을 맨홀부터 시작
			// visited 배열 초기화
			visited = new boolean[N][M];
			// 경우의 수 초기화
			count = 0;
			bfs(R, C);

			// 출력
			System.out.println("#" + test_case + " " + count);
		}
	}

	private static void bfs(int r, int c) {
		// 큐에 들어갈 값은 탈주범의 위치인 r, c 와 소요 시간
		Queue<int[]> q = new ArrayDeque<>();

		visited[r][c] = true;
		count++;
		// 맨홀에 위치에 있다면 소요시간 1시간 경과된 것
		q.add(new int[] { r, c, 1 });

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			int time = cur[2];
			if(time == L) {
				count++;
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != 0) {
					if(map[curR][curC] == 1) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
					else if (map[curR][curC] == 2 && (d == 0 || d == 1)) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
					else if (map[curR][curC] == 3 && (d == 2 || d == 3)) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
					else if (map[curR][curC] == 4 && (d == 0 || d == 3)) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
					else if (map[curR][curC] == 5 && (d == 1 || d == 3)) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
					else if (map[curR][curC] == 6 && (d == 1 || d == 2)) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
					else if (map[curR][curC] == 7 && (d == 0 || d == 2)) {
						visited[nr][nc] = true;
						count++;
						q.add(new int[] {nr, nc, time+1});
					}
				}
			}
			
				
		}

	}
}
