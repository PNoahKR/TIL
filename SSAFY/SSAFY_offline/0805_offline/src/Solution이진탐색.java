import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution이진탐색 {

	/**
	 * 우리가 페이지를 찾기 위한 이진 탐색 메서드
	 * 
	 * @param p    페이지 전체 쪽 수
	 * @param page 찾아야할 페이지 쪽
	 * @return 탐색횟수
	 */
	private static int binarySearch(int p, int page) {
		// 왼쪽 범위, 오른쪽 범위 변수 초기화
		int left = 1, right = p;
		// 탐색 횟수를 카운트 변수
		int count = 0;

		while (left <= right) {
			count++; // 탐색횟수 증가

			// 우리가 찾고자 하는 값 (중간값 계산)
			int c = (left + right) / 2;

			// 내가 찾고자 하는 페이지가 해당되는 page 와 같다면 종료!
			if (c == page) {
				return count;
			}

			// UP/DOWN 게임
			if (c < page) {
				left = c;
			} else { // c > page
				right = c;
			}

		}
		return -1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// 사용자의 입력으로 파일로 읽어서 입력 처리...!
		// System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 수 TC
		int TC = sc.nextInt();

		// 테이스케이스 수 만큼 순회
		for (int test_case = 1; test_case <= TC; test_case++) {

			// 입력
			// 전체 페이지 쪽수 P
			int P = sc.nextInt();
			// A와 B가 각각 찾을 쪽 번호 Pa, Pb
			int Pa = sc.nextInt(), Pb = sc.nextInt();

			// 로직: 해당 쪽번호를 탐색을 수행하게 된 횟수...! (바이너리 서치)
			int countA = binarySearch(P, Pa); // A사람이 페이지를 탐색하게 된 횟수
			int countB = binarySearch(P, Pb); // B사람이 페이지를 탐색하게 된 횟수

			// 출력 (탐색 횟수에 따라 횟수가 적은 쪽이 승리!)
			if (countA < countB) {
				// A가 승리!
				System.out.println("#" + test_case + " A");
			} else if (countA > countB) {
				// B가 승리!
				System.out.println("#" + test_case + " B");
			} else {
				// 무승부
				System.out.println("#" + test_case + " 0");
			}
		}
	}
}