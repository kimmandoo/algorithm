import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int end, w;

		Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
	}

	static int v, e;
	static List<Node>[] list;
	static int[] dist;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/boj.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		int INF = 100000000;
		list = new ArrayList[v + 1];
		dist = new int[v + 1];

		Arrays.fill(dist, INF);
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>(); // 각 노드(정점)에 연결된 리스트 생성
		}

		pq = new PriorityQueue<Node>((o1, o2) -> {
			return o1.w - o2.w;
		});

		// 간선 개수
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// from에서 to로 가는 weight 가중치
			list[from].add(new Node(to, w));
		}
		dijkstra(s);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= v; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
		System.out.println(sb);
		
	}


	private static void dijkstra(int start) {
		boolean[] check = new boolean[v + 1]; // 확정된 노드를 표시함
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;

			if (check[cur] == true)
				continue;
			check[cur] = true;

			for (Node node : list[cur]) {
				if (dist[node.end] > dist[cur] + node.w) {
					dist[node.end] = dist[cur] + node.w;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}