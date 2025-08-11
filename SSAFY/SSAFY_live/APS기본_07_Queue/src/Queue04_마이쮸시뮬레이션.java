import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue04_마이쮸시뮬레이션 {
	static class Person {
		static int pNumber = 1;
		int num; // 사람의 번호
		int cnt; // 가져갈 수 있느 마이쮸 개수

		public Person() {
			this.num = pNumber++;
			this.cnt = 1;
		}
		

		public Person(int num) {
			this.num = num;
			this.cnt = 1;
		}

		public Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Person [num=" + num + ", cnt=" + cnt + "]";
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			int N = sc.nextInt(); // 이번에 나누어줄 마이쮸 양
			int pNum = 1;
			
			// Q를 통해서 관리하겠다.
			// 1. 사람의 번호 관린
			// 2. 이사람이 가져갈 수 있는 마이쮸 개수
			// 두개의 정보는 정수(int 형)
//			Queue<int[]> q = new LinkedList<>();
			Queue<Person> q = new LinkedList<>();
			
//			q.offer(new Person());
			q.offer(new Person(pNum++));
//			q.offer(new Person(pNum++, 1));
			
			while(N > 0) {
				Person p = q.poll();
				
				N -= p.cnt;
				if(N < 0) {
					// 마지막 마이쮸 까지 탈탈털어서 다 줘버렸다!
					ans = p.num;
					break;
				}
				// 줄 다시 서야되니까!
//				p.cnt++;
//				q.offer(p); // p는 새로 생성한게 아님. 
				q.offer(new Person(p.num, p.cnt+1)); // 이건 다른 객체임
				////////////////////////////////////////////
				// 새로운 사람이 줄을 선다
				q.offer(new Person(pNum++));
				
			}
			
			System.out.println("#" + test_case + " " + ans);
			
			
			
		} // tc
	}
}
