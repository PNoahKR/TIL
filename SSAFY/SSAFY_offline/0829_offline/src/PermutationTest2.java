import java.util.Arrays;

public class PermutationTest2 {
	static int[] arr = { 1, 2, 3, 4 };
	static int[] perm;    // 순열의 경우의 수 하나를 담을 배열
	static boolean[] used; // 체크를 위한 used
	
	// 주어진 요소의 개수 n 개에서
	// r개 만큼의 요소를 선택하여
	// depth에는 현재까지 몇개 뽑았습니가?~
	// 순열 배열인 perm에 담겠다.
	public static void nPr(int n, int r, int depth) {
		
		// 유도 조건
		// 1. 매번 전체 배열을 처음부터 검사를 수행한다
		for (int i = 0; i < n; i++) {
			// 기저 조건
			if(r == depth) { // 이제 더 뽑을 카드 업승ㅁ
				// 여기에서 만든 경우의 수 perm 테스트!
				System.out.println(Arrays.toString(perm));
				return;
			}
			// 2. used배열에 이미 사용한 원소인지 체크한다!
			if(used[i] == true) {
				continue;
			}
			
			// used 그 카드를 사용하겠음! 표시!
			used[i] = true;
			perm[depth] = arr[i]; // 카드를 하장 뽑아~
			nPr(n, r, depth + 1);
			// 3. 재귀호출을 완료한 후에 다시 used배열을 원상복구한다.
			used[i] = false;
		}
	}
	// nPr -> 4P2
	// n개의 원소 중에서 r개를 선택 순열!
	public static void main(String[] args) {
		int n = 4; // 주어진 요소 개수
		int r = 3; // 고를 갯수
		
		// 배열 초기화
		perm = new int[r];
		used = new boolean[n]; 
		
		nPr(n, r, 0);
	}

}
