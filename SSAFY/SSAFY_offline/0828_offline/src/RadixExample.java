
public class RadixExample {

	public static int NtoDecimal(String num, int radix) {
		return Integer.parseInt(num, radix);
	}

	public static void main(String[] args) {
		// N -> 10
		String input = "A";
		int decimal = NtoDecimal(input, 16);

		// 10 -> N
		int num = 13;

		String binary = Integer.toBinaryString(num);
//		System.out.println(binary);
		
		String output = Integer.toString(num, 16);
//		System.out.println(output);
		// N -> N
		String hex = "47FE";
		int temp = Integer.parseInt(hex, 16);
		String bina = Integer.toString(temp, 2);
		
		System.out.println(bina);
	}
}
