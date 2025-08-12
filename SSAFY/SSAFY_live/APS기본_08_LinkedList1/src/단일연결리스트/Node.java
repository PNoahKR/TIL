package 단일연결리스트;

public class Node {
	// 데이터필드는 문자열로 고정! -> 제네릭하게 만들수 도 있다
	String data;
	// 링크 필드
	Node link;

	public Node() {
	}

	public Node(String data) {
		this.data = data;
//		this.link = null; // 참조자료형은 null값으로 초기화된다!
	}
	
	

}
