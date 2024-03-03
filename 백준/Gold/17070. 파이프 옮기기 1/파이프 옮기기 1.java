import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] v;
	static int find;
	static int state; // 0,1,2

	public static void dfs(int cs, int[] next) {
		int ci = next[0];
		int cj = next[1];
		if (ci == n - 1 && cj == n - 1) {
			find++;
			return;
		}
		if (cs == 0) {// 이전 상태가 가로. 다음길은 0,1 만 보면됨.
			// 0
			if (cj < n - 1 && map[ci][cj + 1] == 0) {
				dfs(0, new int[] { ci, cj + 1 });
			}
			// 1
			if (cj < n - 1 && ci < n - 1 && map[ci + 1][cj + 1] == 0 && map[ci][cj + 1] == 0 && map[ci + 1][cj] == 0) {
				dfs(1, new int[] { ci + 1, cj + 1 });
			}
		}
		if (cs == 1) {// 다음길은 0,1,2 보면됨.
			// 0
			if (cj < n - 1 && map[ci][cj + 1] == 0) {
				dfs(0, new int[] { ci, cj + 1 });
			}
			// 1
			if (cj < n - 1 && ci < n - 1 && map[ci + 1][cj + 1] == 0 && map[ci][cj + 1] == 0 && map[ci + 1][cj] == 0) {
				dfs(1, new int[] { ci + 1, cj + 1 });
			}
			// 2
			if (ci < n - 1 && map[ci + 1][cj] == 0) {
				dfs(2, new int[] { ci + 1, cj });
			}
		}
		if (cs == 2) {// 다음길은 1,2 보면됨.
			// 1
			if (cj < n - 1 && ci < n - 1 && map[ci + 1][cj + 1] == 0 && map[ci][cj + 1] == 0 && map[ci + 1][cj] == 0) {
				dfs(1, new int[] { ci + 1, cj + 1 });
			}
			// 2
			if (ci < n - 1 && map[ci + 1][cj] == 0) {
				dfs(2, new int[] { ci + 1, cj });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n][n];
		find = 0;
		state = 0; // 0,1,2 -> 가로 대각 세로
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0,0 이랑 0,1 은 이미 방문처리 된거고 시작지점이 0,1부터
		v[0][0] = true;
		v[0][1] = true;
		dfs(0, new int[] { 0, 1 });
		System.out.println(find);
	}
}