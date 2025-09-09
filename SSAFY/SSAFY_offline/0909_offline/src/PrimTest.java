import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimTest {

	static class Edge implements Comparable<Edge>{
		// 시작 정점
		int u;
		// 가게될 정점 번호
		int v;
		// 가중치 값
		int w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(PrimTest.Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", w=" + w + "]";
		}
		
		

	}

	static List<List<Edge>> graph;

	public static void main(String[] args) {
		int V = 7;
		int E = 11;
		graph = new ArrayList<>();
		
		// 정점을 0~6 넣게 초기화
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		
		graph.get(0).add(new Edge(1, 32));
		graph.get(0).add(new Edge(2, 31));
		graph.get(0).add(new Edge(5, 60));
		graph.get(0).add(new Edge(6, 51));
		
		graph.get(1).add(new Edge(2, 21));
		graph.get(1).add(new Edge(0, 32));
		
		graph.get(2).add(new Edge(0, 31));
		graph.get(2).add(new Edge(1, 21));
		graph.get(2).add(new Edge(4, 46));
		graph.get(2).add(new Edge(6, 25));

		graph.get(3).add(new Edge(4, 34));
		graph.get(3).add(new Edge(5, 18));

		graph.get(4).add(new Edge(2, 46));
		graph.get(4).add(new Edge(3, 34));
		graph.get(4).add(new Edge(5, 40));
		graph.get(4).add(new Edge(6, 51));
		
		graph.get(5).add(new Edge(0, 60));
		graph.get(5).add(new Edge(3, 18));
		graph.get(5).add(new Edge(4, 40));

		graph.get(6).add(new Edge(0, 51));
		graph.get(6).add(new Edge(2, 25));
		graph.get(6).add(new Edge(4, 51));
		
		List<Edge> MST = new ArrayList<>();
		
		// 프림 알고리즘 구현
		// 시작 정점을 하나 골라서 -> 5번
		int start = 5;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(); // 최소 힙을 사용해 간선 가중치가 낮은 것을 뽑자.
		
		// 시작 정점으로 부터 로직을 수행하도록 임의의 간선 정보를 넣기
		minHeap.offer(new Edge(start, 0));
		
		// 연결되어 있는 간선 정보들 중에 가중치의 값이 가장 작은 간선을 계속 반복 선택..!
		while(!minHeap.isEmpty()) {
			// 최종적으로는 정점을 V개 모두 인접하게 된다면 종료
			Edge cur = minHeap.poll(); // 최소 비용을 가지고 있는 간선
			
			int next = cur.v; // 가게 될 정점
			int weight = cur.w; // 가중치
			
			// 이미 방문한 노드라면 제외
			if(visited[next]) {
				continue;
			}
			
			visited[next] = true; // 방문 표시
			MST.add(cur);
			
			// 다음 정점 next에 연결되어 있는 간선 정보를 다시 minHeap에
			for(Edge e : graph.get(next)) {
				int nnext = e.v;
				int wweight = e.w;
				
				
				if(!visited[nnext]) {
					minHeap.offer(new Edge(nnext, wweight));
				}
			}
		}
		
//		System.out.println(MST);
		for (Edge edge : MST) {
			System.out.println(edge);
		}
		
		
	}
}
