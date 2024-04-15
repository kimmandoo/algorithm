import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[100001][3];
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1; // n-1의 2,3이 올수있다.
		dp[3][1] = 1; // n-2의 1, 3이 올 수 있다.
		dp[3][2] = 1; // n-3은 1,2가 올 수 있음.
		for(int i=4; i<100001; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2])%1_000_000_009;
			dp[i][1] = (dp[i-2][0] + dp[i-2][2])%1_000_000_009;
			dp[i][2] = (dp[i-3][0] + dp[i-3][1])%1_000_000_009;
		}
		for(int i=0; i<n; i++) {
			int s = sc.nextInt();
			System.out.println((dp[s][0]+dp[s][1]+dp[s][2])%1_000_000_009);
		}
	}
}
