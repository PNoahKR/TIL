public class 부분집합_02_비트마스킹 {
	static int N = 4;
	static int[] sel = new int[N]; // 재료가 있다! 없다!
	static String[] element = {"단무지", "햄", "오이", "계란"};
	
	public static void main(String[] args) {
		// N개의 재료를 이용해서 만들 수 있는 부분 집합의 경우의 수는 2^N 가지
		for (int i = 0; i < (1 << N); i++) {
			// 김밥 속 재료 확인 반복문
			for (int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0) {
					// 해당 j번째 재료가 들어있어!
					System.out.print(element[j]);
				}
			}
			System.out.println("김밥");
		}
	}
}
