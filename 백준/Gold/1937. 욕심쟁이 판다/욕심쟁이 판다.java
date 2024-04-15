import java.io.*;
import java.util.*;

class Main {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int n;
	static int[][] map;
	static int[][] dp;
	static int max = -1;

	public static int dfs(int ci, int cj) {
		if (dp[ci][cj] != -1)
			return dp[ci][cj]; // 방문했으니까 계산하지않고 반환한다.
		dp[ci][cj] = 1; // 방문처리
		for (int i = 0; i < 4; i++) {
	        int ni = di[i] + ci;
	        int nj = dj[i] + cj;
	        if (isValid(ci, cj, ni, nj)) {
	            dp[ci][cj] = Math.max(dp[ci][cj], 1 + dfs(ni, nj)); // 탐색을 진행하고 최댓값을 저장한다.
	        }
	    }
	    return dp[ci][cj];
	}

	public static boolean isValid(int ci, int cj, int ni, int nj) {
		return ni < n && nj < n && ni >= 0 && nj >= 0 && map[ci][cj] < map[ni][nj];
	}

	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(i, j);
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
}