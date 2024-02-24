import java.util.*;
import java.io.*;

public class Main {
	static int[] p;
	static int n;

	public static void make() {
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
	}

	public static int find(int a) {
		if (p[a] == a)
			return a;

		return p[a] = find(p[a]);
	}

	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa == pb)
			return false;
		p[pb] = pa;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		make();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int target = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (target == 0) {
				// union
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}