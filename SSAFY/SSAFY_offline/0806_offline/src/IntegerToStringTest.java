
public class IntegerToStringTest {
	/**
	 * 
	 * @param num
	 * @return
	 */
	private static String itoa(int num) {
//		return String.valueOf(num);
//		return num + " ";
		
		// num값을 10으로 나누면서 한자리씩 문자열로 치환
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			// 한자리씩 자릿수 빼낸다
			int remain = num % 10;
			num /= 10;
			sb.append(remain);
		}
		return sb.reverse().toString();
	}

	
	public static void main(String[] args) {
		int num = 1234;
		String text = itoa(num);
		System.out.println(text + 1);
	}

}
