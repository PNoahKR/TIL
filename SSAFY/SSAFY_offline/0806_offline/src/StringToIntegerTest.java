
public class StringToIntegerTest {

	private static int atoi(String str) {
		// 숫자로 해당 문자를 하나씩 뜯어서 숫자화
		int result = 0; //결과 누적
		// 문자열에서 문자들을 순회
		for(char ch : str.toCharArray()) {
			//아스키 코드             -> 숫자
			// ch('7') - '0'; -> ch - '0'
			result = (result * 10) + (ch - '0');
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		String str = "1234";
		int num = atoi(str);
		System.out.println(num + 1); //1235
	}

}
