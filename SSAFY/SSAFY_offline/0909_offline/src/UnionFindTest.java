import java.util.Arrays;

public class UnionFindTest {
	// 서로소 집합을 표현할 대표자를 가리키는 parent 배열 선언
	protected int[] parent;

	// 초기화 make-set : 나 자신을 부모로 가리키도록 초기화 메서드 선언
	public void init(int N) { // 요소의 개수가 n개일 때 초기화
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	// find-set : 대표자를 반환하는 메서드 선언
	public int findSet(int x) {
		if(x == parent[x]) return x;
		// 재귀 호출로 부모를 통해 다시 대표자 탐색 진행
		return parent[x] = findSet(parent[x]);
	}
	
	// union : x 와 y 가 속해있는 그룹을 통합하는 메서드
	public void union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);
		parent[root_y] = root_x;
	}
	
	public static void main(String[] args) {
		UnionFindTest ut = new UnionFindTest();
		ut.init(5);
		
		System.out.println(Arrays.toString(ut.parent));
		
		ut.union(2, 1);
		System.out.println(Arrays.toString(ut.parent));
		ut.union(4, 3);
		System.out.println(Arrays.toString(ut.parent));
		ut.union(3, 1);
		System.out.println(Arrays.toString(ut.parent));
		
		System.out.println(ut.findSet(1));
		System.out.println(ut.findSet(3));
		
		
	}
}
