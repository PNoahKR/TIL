import java.util.HashMap;
import java.util.Map;

public class Quiz4 {
	public static void main(String[] args) {
		String input = "0269FAC9A0";

		Map<String, String> mapping = new HashMap<>();
		mapping.put("0", "0000");
		mapping.put("1", "0001");
		mapping.put("2", "0010");
		mapping.put("3", "0011");
		mapping.put("4", "0100");
		mapping.put("5", "0101");
		mapping.put("6", "0110");
		mapping.put("7", "0111");
		mapping.put("8", "1000");
		mapping.put("9", "1001");
		mapping.put("A", "1010");
		mapping.put("B", "1011");
		mapping.put("C", "1100");
		mapping.put("D", "1101");
		mapping.put("E", "1110");
		mapping.put("F", "1111");

		String binary = "";
		for (char ch : input.toCharArray()) {
			String hex = String.valueOf(ch);
			binary += mapping.get(hex);
		}

		// 암호 비트 패넡 -> 숫자 한자지로 바꿔줘야 한다
		Map<String, String> hashToDigit = new HashMap<>();
		hashToDigit.put("001101", "0");
		hashToDigit.put("010011", "1");
		hashToDigit.put("111011", "2");
		hashToDigit.put("110001", "3");
		hashToDigit.put("100011", "4");
		hashToDigit.put("110111", "5");
		hashToDigit.put("001011", "6");
		hashToDigit.put("111101", "7");
		hashToDigit.put("011001", "8");
		hashToDigit.put("101111", "9");

		// 이진수 해당하는 문자열을 역순순회하며 암호를 찾아내자
		int i = binary.length() - 1;
		while (i >= 0) {
			// i번째의 인덱스에 있는 문자가 '1'인가 아닌가..!
			if (binary.charAt(i) == '1') {
				break;
			}
			i--;
		}

		// i 값이 이진수 배열의 '1' 문자가 존재하는 마지막 인덱스
		// 역순으로 i에서부터 6자리의 문자를 읽어들여서 암호패턴 해석
		String output = "";
		for (int j = i + 1; j >= 0; j -= 6) {
			if(binary.charAt(j - 1) == '0') {
				break;
			}
			String password = binary.substring(j - 6, j);
			output = hashToDigit.get(password) + output;
		}
		System.out.println(output);
	}
}
