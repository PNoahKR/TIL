import java.util.Scanner;

public class BOJ_1330 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        //로직
        
        String output;
        
        if (A > B) {
        	//출력
        	output = ">";
            //System.out.print(">");
        } else if (A < B) {
        	output = "<";
            //System.out.print("<");
        } else {
        	output = "==";
            //System.out.print("==");
        }
        //삼항연사자 -> 마니아틱함;
        //output = (A > B) ? ">" : ((A < B) ? "<" : "==");
        System.out.println(output);
        sc.close();
	}
}
