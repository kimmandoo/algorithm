import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n + 1][n + 1]; // 1~n 명
			boolean[] v = new boolean[n + 1]; // true가 되면 무리에 속했다는 말.
			int muri = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
				map[end][start] = 1;
			}

			for (int i = 1; i <= n; i++) {
				if (!v[i]) { // 무리 찾았다.
					LinkedList<Integer> s = new LinkedList();
					s.add(i);
					v[i] = true;
					while (!s.isEmpty()) {
						int node = s.pollLast();
						for (int k = 1; k <= n; k++) {
							if (map[node][k] == 1 && !v[k]) {
								s.add(k);
								v[k] = true;
							}
						}
					}
					muri++;
				}
			}

			sb.append("#").append(test_case).append(" ").append(muri).append("\n");
		}
		System.out.println(sb);
	}
}
