import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] in = new int[n + 1]; // i개가 포함된 카드팩이 in[i] 원이다.
		for (int i = 1; i <= n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1000001);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], in[j] + dp[i - j]);
			}
		}	
		System.out.println(dp[n]);
	}
}