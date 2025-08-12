import java.util.Arrays;

public class LinkedList07_삽입정렬 {
	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 17, 73, 444 };

		// 삽입정렬 할겅미

		for (int i = 1; i < data.length; i++) {
			int key = data[i];
			int j;
			for (j = i - 1; j >= 0 && key < data[j]; j--) {
				data[j+1] = data[j];
			}
			data[j+1] = key;
		}
		System.out.println(Arrays.toString(data));
	}
}
