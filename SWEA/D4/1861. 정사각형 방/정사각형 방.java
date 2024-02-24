import java.util.*;
import java.io.*;

public class Solution {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine()); // 처음에 27이 들어올것.

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			boolean[][] v;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 시작 지점을 넣고 그 시작지점을 기준으로 최대 길이를 계속 갱신하면서 들어가야됨.
			int max = 0;
			int mI = 0;
			int mJ = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int[] node = new int[] { i, j };
					LinkedList<int[]> s = new LinkedList();
					v = new boolean[n][n]; // 매번 초기화 해줘야됨.
					v[i][j] = true;
					s.add(node);
					int tmpMax = 0;
					while (!s.isEmpty()) {
						int[] tmp = s.pollLast();
						for (int d = 0; d < 4; d++) {
							int ni = di[d] + tmp[0];
							int nj = dj[d] + tmp[1];
							if (ni >= 0 && ni < n && nj >= 0 && nj < n && !v[ni][nj]
									&& map[ni][nj] == map[tmp[0]][tmp[1]] + 1) {
								s.add(new int[] { ni, nj });
								v[ni][nj] = true;
								tmpMax++;
							}
						}
					}
					if (max <= tmpMax) {
						if (max == tmpMax) {
							if (map[mI][mJ] > map[i][j]) {
								mI = i;
								mJ = j;
							}
						} else {
							max = tmpMax;
							mI = i;
							mJ = j;
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(map[mI][mJ]).append(" ").append(max+1).append("\n");
		}
		System.out.println(sb);
	}
}
