import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int[][] map;
	static int min;
	static int max;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n + 1];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 1;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n][n + 1];
		dp[0][1] = map[0][1];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + map[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[n - 1][i]);
		}

		System.out.println(max);
	}
}