import java.util.*;
import java.io.*;

class Main {

	static int[] map;
	static List<Node>[] adj;
	static int[] dist;
	static int INF = 10000000;
	static int v, e;
	static PriorityQueue<Node> pq;

	static class Node {
		int e, w;

		Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}

	public static void dijk(int start) {
		dist[start] = 0;
		boolean[] vis = new boolean[v + 1]; // 이거 또 빼먹었다1
		pq.add(new Node(start, 0)); // 나를 경유해서 도착하는 가중치는 0이니까
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int w = cur.w;
			int c = cur.e;
			if (vis[c]) // 이거 또 빼먹었다2
				continue;

			vis[c] = true;

			for (Node n : adj[c]) {
				int tmpW = dist[c] + n.w; // 이거 또 빼먹었다3 -> dist에 더해야지 이걸 인접한 w랑 더해서 뭐함
				if (dist[n.e] > tmpW) {
					dist[n.e] = tmpW;
					pq.add(new Node(n.e, dist[n.e])); // 갱신한 걸 pq에 넣어줘야 다익스트라가 잘 작동한다.
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		pq = new PriorityQueue<Node>((o1, o2) -> {
			return o1.w - o2.w;
		});
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// 가중치가 1임 하나 이동할 때 1만큼 이동함
		st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		dist = new int[v + 1]; // 1번정점부터 시작하니까
		Arrays.fill(dist, INF);
		adj = new ArrayList[v + 1]; // 도달할 수 없을 걸 예상해서 INF를 초기화 시킨다.
		for (int i = 0; i <= v; i++) {
			adj[i] = new ArrayList();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			adj[s].add(new Node(ed, 1)); // 양방향 연결 가는데 가중치가 1이니까
			adj[ed].add(new Node(s, 1));
		}
		dijk(start);

		System.out.println(dist[end] == INF ? -1 : dist[end]);
	}
}