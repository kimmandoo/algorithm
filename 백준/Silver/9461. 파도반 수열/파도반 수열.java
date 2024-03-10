import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4; i<101; i++) {
			dp[i] = dp[i-2]+dp[i-3];
		}
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(dp[tmp]).append("\n");
		}
		System.out.println(sb);
	}
}