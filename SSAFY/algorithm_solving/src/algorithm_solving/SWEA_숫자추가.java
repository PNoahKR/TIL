import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_숫자추가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			int L = sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			// 로직
			// M개의 숫자를 지정된 위치에 추가하기 위한 로직
			// 1. 인덱스를 받고, 2. 추가할 값을 받는다
			// list.add(index, value)
			for (int i = 0; i < M; i++) {
				list.add(sc.nextInt(), sc.nextInt());
			}
			
			
			// 출력
			// list.get() 메서드를 통해서 원하는 인덱스의 값을 뽑아낸다.
			System.out.println("#" + test_case + " " + list.get(L));
		}
		sc.close();
	}
}
