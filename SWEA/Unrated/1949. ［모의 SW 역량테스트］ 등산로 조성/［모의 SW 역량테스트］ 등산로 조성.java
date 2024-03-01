import java.util.*;
import java.io.*;

public class Solution {
	static int n, k;
	static int[][] map;
	static boolean[][] v;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int maxPath;

	// 잘못 접근한 방식
//	public static void dfs(int[] start, int depth) {
//		int tmp = 0;
//		v[start[0]][start[1]] = true; 
//		int[] next = new int[] { -1, -1 };
//		for (int d = 0; d < 4; d++) {
//			int ni = di[d] + start[0];
//			int nj = dj[d] + start[1];
//			// 가장 큰 값을 찾아서, 다음행선지로 선택한다.
//			if (ni >= 0 && nj >= 0 && ni < n && nj < n && tmp < map[ni][nj] && !v[ni][nj]) {
//				tmp = map[ni][nj];
//				next = new int[] { ni, nj };
//			}
//		}
//		if (next[0] == -1) {
//			max = Math.max(max, depth);
//			return;
//		} else {
//			// next에 담긴 값은 제일 큰 값임
//			v[next[0]][next[1]] = true;
//			dfs(next, depth + 1);
//			v[next[0]][next[1]] = false;
//		}
//	}
	public static void dfs(int[] cur, int depth, boolean used) {
		maxPath = Math.max(maxPath, depth);
		v[cur[0]][cur[1]] = true; // 진입했으니까 true 넣고 시작
		for (int d = 0; d < 4; d++) {
			int ni = di[d] + cur[0];
			int nj = dj[d] + cur[1];

			if (ni < n && nj < n && ni >= 0 && nj >= 0 && !v[ni][nj]) {
				if (map[ni][nj] < map[cur[0]][cur[1]]) {
					dfs(new int[] { ni, nj }, depth + 1, used);
					// #1 틀린이유. used에 false를 넣으면 이전 케이스에서 공사한지 알 수 없다
				} else {
					if (!used && map[ni][nj] - k < map[cur[0]][cur[1]]) {
						// 차이가 k이상 벌어지면 못 깎으니까
						int tmp = map[ni][nj];
						map[ni][nj] = map[cur[0]][cur[1]] - 1; // 최대한 작게 깎는게 맞다.
						dfs(new int[] { ni, nj }, depth + 1, true); // 깎은거 flag 넣기
						map[ni][nj] = tmp; // 원복
					}
				}
			}
		}
		v[cur[0]][cur[1]] = false;
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine()); // 처음에 27이 들어올것.

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			// 입력 받으면서 최댓값을 가진 좌표들을 기록해서 그 세 개를 기준으로 DFS를 돌리자.
			List<int[]> maxPos = new ArrayList(); // 배열처럼 접근하려면 이게 편함.
			int max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					// max 값 찾으면 maxPos에 넣기.
					// max값이 바뀔경우 maxPos를 싹 비우고 새로 추가.
					int h = Integer.parseInt(st.nextToken());
					map[i][j] = h;
					if (max < h) {
						max = h;
						maxPos.clear();
						maxPos.add(new int[] { i, j });
					} else if (max == h) {
						maxPos.add(new int[] { i, j });
					}
				}
			}
			v = new boolean[n][n];

			// 입력 끝 -> 시작 지점은 maxPos에 있는 지점들이다.
			// DFS를 돌면서 다음 값이 작은 곳으로만 갈 수 있고, 갈 수 있는 후보 중에 다음길이 막혀있으면 공사
			// 일단 최장거리를 찾는 로직짜기
			maxPath = 0;
			for (int t = 0; t < maxPos.size(); t++) {
				int[] node = maxPos.get(t);
				dfs(node, 1, false);
			}

			sb.append("#").append(test_case).append(" ").append(maxPath).append("\n");
		}
		System.out.println(sb);
	}

}