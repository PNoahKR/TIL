import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalTest {

	static class Edge implements Comparable<Edge> {
		int u;
		int v;
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
		public int compareTo(KruskalTest.Edge o) {
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

		// 인접리스트 -> 간선배열
		List<Edge> edges = new ArrayList<>();
		for (int u = 0; u < V; u++) { // 0~6
			for (Edge edge : graph.get(u)) {
				int v = edge.v;
				int w = edge.w;
				edges.add(new Edge(u, v, w));
			}
		}

		int[] parent = makeSet(V);
		
		List<Edge> MST = new ArrayList<>();

		// 크루스칼 알고리즘 구현
		// 모든 간선 정보를 가중치대로 정렬 (오름차순)
		Collections.sort(edges);

		// 순차적으로 간선 하나 뽑기
		for (Edge edge : edges) { // 가중치가 적은 순서대로 뽑힘
			
			// 사이클이 발생되지 않은 간선만
			if(findSet(parent, edge.u) != findSet(parent, edge.v)) {
				// 해당 간선을 MST에 추가
				MST.add(new Edge(edge.u, edge.v, edge.w));
				union(parent, edge.u, edge.v);
			}
		}

		System.out.println(MST);
	}

	private static int[] makeSet(int v) {
		int[] result = new int[v];
		for (int i = 0; i < v; i++) {
			result[i] = i;
		}
		return result;
	}

	private static int findSet(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent, parent[x]);
	}

	private static void union(int[] parent, int x, int y) {
		int root_x = findSet(parent, x);
		int root_y = findSet(parent, y);
		if(root_x != root_y) {
			parent[root_y] = root_x;
		}
	}
}
