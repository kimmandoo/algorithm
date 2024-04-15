import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][k + 1]; // n가지 동전으로 k원 만들기
		int[] money = new int[n + 1];

		Arrays.fill(dp[0], 1000000);

		for (int i = 1; i <= n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j < money[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - money[i]] + 1); // 개수가 하나 추가되는 것
				}
			}
		}

		System.out.println(dp[n][k] == 1000000 ? -1 : dp[n][k]);

	}
}