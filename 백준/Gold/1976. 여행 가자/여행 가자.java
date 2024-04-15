import java.util.*;
import java.io.*;

public class Main {
	static int[] p;
	static int n;

	static void make() {
		p = new int[n + 1];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
	}

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb) {
			p[pb] = pa;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		make();
		int target = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					union(i, j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = find(Integer.parseInt(st.nextToken()));
		boolean flag = true;
		if (st.hasMoreTokens()) {
			for (int i = 0; i < target - 1; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (start != find(tmp)) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}