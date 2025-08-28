public class Quiz2 {
	public static void main(String[] args) {
		String input = "0000000111100000011000000111100110000110000111100111100111111001100111";
		
		// 입력 받은 문자열 내 7자리씩 끊어서 가져오기?
		int size = input.length() / 7;
		
		for (int i = 0; i < input.length(); i += size) {
			String temp = input.substring(i, i + size);
			// crack;
			int result = Integer.parseInt(temp, 2);
			System.out.print(result + " ");
		}
		
		
	}
}
