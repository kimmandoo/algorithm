import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/boj.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; // new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(br.readLine());
		int[][] in = new int[n+1][3];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
			in[i][2] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		int[][] dp = new int[n+1][3];
		dp[1][0] = in[1][0];
		dp[1][1] = in[1][1];
		dp[1][2] = in[1][2];

		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + in[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + in[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + in[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			min = Math.min(min, dp[n][i]);
		}
		System.out.println(min);

	}

}