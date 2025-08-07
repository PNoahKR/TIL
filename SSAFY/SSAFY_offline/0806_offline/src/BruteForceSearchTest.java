
public class BruteForceSearchTest {

	private static int bruteForce(String p, String text) {
		// 패턴의 길이랑 텍스트의 길이
		int M = p.length(); // 패턴의 길이
		int N = text.length(); // 텍스트의 길이
		
		// for문으로 브루트포스 로직 구현
		for (int i = 0; i < N - M + 1; i++) {
			int j = 0;
			for (; j < M; j++) {
				// 문자 비교 text[i] <-> p[j]
				// 해당 패턴 매칭 실패! -> 다음 매칭으로~
				if(text.charAt(i + j) != p.charAt(j)) {
					break;
				}
			}
			if(j == M) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// 찾을 패턴
		String p = "is";

		// 전체 문자열
		String text = "cat is animal";

		// 무식한 조회 방법 : bruteForceSearch 메서드 만들어보기
		int idx = bruteForce(p, text);
		int idx2 = text.indexOf(p);
		
		System.out.println("인덱스 위치 : " + idx);
		System.out.println("인덱스 위치 : " + idx2);
	}

}
