import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] p;

	static void make() {
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
	}

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb)
			return false;
		p[pb] = pa;
		return true;
	}

	static class Edge {
		int from, to, w;

		Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> {
			return o1.w - o2.w;
		});
//		int[][] graph = new int[n][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		int acc = 0;
		make();
		for (int i = 0; i < m; i++) {
			Edge item = pq.poll();
			if (union(item.from, item.to))
				acc += item.w;
		}
		System.out.println(acc);
	}
}