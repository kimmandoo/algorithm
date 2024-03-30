import java.util.*;
import java.io.*;

class Main {

	static int[][] map;

	// 인접리스트를 만들자
	static class Node {
		int s, e, w;

		Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}

//	static List<Node>[] adj; // 인접리스트를 만들어야 이제 관리가 가능함
	static int[][] dist;
	static int v;
	static int e;
	static PriorityQueue<Node> pq;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int INF = 100000000;
	static int n;

	static void dijk() { // 0,0에 위치하고 있음 -> 첫칸의 가중치는 피할수없기 때문에 고려하지않는다.
		pq.add(new Node(0, 0, dist[0][0]));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int ci = cur.s;
			int cj = cur.e;
			int w = cur.w;
			if (dist[ci][cj] < w)
				continue;
			for (int i = 0; i < 4; i++) {
				int ni = ci + di[i];
				int nj = cj + dj[i];
				if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
					if (dist[ni][nj] > dist[ci][cj] + map[ni][nj]) {
						dist[ni][nj] = dist[ci][cj] + map[ni][nj];
						pq.add(new Node(ni, nj, dist[ni][nj]));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			pq = new PriorityQueue<Node>((o1, o2) -> {
				return o1.w - o2.w;
			});
			map = new int[n][n];
//			v = n * n;// 정점 개수는 map 칸 개수
//			e = n * (n - 1) / 2; // 총 간선 개수
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = INF;
				}
			}
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist[0][0] = map[0][0];
			dijk();
			sb.append("Problem ").append(tc++).append(": ").append(dist[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}