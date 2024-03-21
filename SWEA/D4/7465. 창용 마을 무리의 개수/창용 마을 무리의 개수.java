import java.util.*;
import java.io.*;

public class Solution {
	static int[] p;
	static int n;

	static void make() {
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
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
		if (pa == pb) {
			return false;
		}
		p[pb] = pa;
		return true;
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			make();
			int cnt = n;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(union(a, b)) cnt--;
			}
			
//			System.out.println(Arrays.toString(p));

			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}