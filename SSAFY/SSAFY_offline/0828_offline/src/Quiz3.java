import java.util.HashMap;
import java.util.Map;

public class Quiz3 {
	public static void main(String[] args) {
		String input = "01D06079861D79F99F";
		
		// Map을 사용해서 아래의 변환을 저장 및 처리 하자
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
		// 16 -> 2
		// "0" -> "0000"
		// "1" -> "0001"
		// "2" -> "0010"
		// "3" -> "0011"
		// "4" -> "0100"
		// "5" -> "0101"
		// "6" -> "0110"
		// "7" -> "0111"
		// "8" -> "1000"
		// "9" -> "1001"
		// "A" -> "1010"
		// "B" -> "1011"
		// "C" -> "1100"
		// "D" -> "1101"
		// "E" -> "1110"
		// "F" -> "1111"
	}
}
