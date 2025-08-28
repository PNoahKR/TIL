import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_이진수표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String result = "";
			if(M % 2 == 0) {
				result = "OFF";
			} else {
				int mask = (1 << N) - 1;
				
				if((M & mask) == mask) {
					result = "ON";			
				} else {				
					result = "OFF";		
				}
				
			}
			
			System.out.println("#" + test_case + " " + result);
			
			
		}
	}
}
