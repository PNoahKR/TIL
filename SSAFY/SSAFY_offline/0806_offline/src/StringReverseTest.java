public class StringReverseTest {

//	/**
//	 * text 문자열을 역으로 뒤집어서 반환하겠다!
//	 * @param text 원본 문자열
//	 * @return 뒤집은 문자열
//	 */
//	private static String reverse1(String text) {
//		// 문자열의 길이
//		int length = text.length();
//		
//		// 문자 배열 전화
//		char[] chArr = text.toCharArray();
//		
//		// 문자열을 뒤집는다..!
//		// 1. 문자열의 절반만 순회
//		for (int i = 0; i < length / 2; i++) {
//			// 2. 문자를 서로 교환(swap)
//			// chArr[i] <-> chArr[N - 1 - i]
//			char tmp = chArr[i];
//			chArr[i] = chArr[length - 1 - i];
//			chArr[length - 1 - i] = tmp;
//		}
//		
//		return new String(chArr);
//	}

	/**
	 * text 문자열을 역으로 뒤집어서 반환하겠다! (StringBuilder 객체)
	 * @param text 원본 문자열
	 * @return 뒤집은 문자열
	 */
	private static String reverse2(String text) {
		StringBuilder sb = new StringBuilder(text);
		String reversed = sb.reverse().toString();
	
		return reversed;
	}

	public static void main(String[] args) {
		String text = "algorithm";

		String reversed = reverse2(text);

		System.out.println(reversed);
	}

}
