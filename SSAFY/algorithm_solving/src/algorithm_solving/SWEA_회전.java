import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA_회전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			// 로직
			// 맨 앞의 숫자를 꺼내(poll()) 맨 뒤로 보내는(offer()) 작업 M번 수행
			int rotations = M % N;
			for (int i = 0; i < rotations; i++) {
				int tmp = q.poll();
				q.offer(tmp);
			}
			
			
			// 출력
			System.out.println("#" + test_case + " " + q.poll());
		}
	}
}
