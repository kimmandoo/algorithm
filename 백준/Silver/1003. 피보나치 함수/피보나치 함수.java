import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[41][2];
		int tc = sc.nextInt();
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int target = sc.nextInt();
			sb.append(dp[target][0]).append(" ").append(dp[target][1]).append("\n");
		}
		System.out.println(sb);
	}

//	public static int fibonacci(int n) {
//	    if (n == 0) {
//	    	zero++;
//	        return 0;
//	    } else if (n == 1) {
//	    	one++;
//	        return 1;
//	    } else {
//	        return fibonacci(n-1) + fibonacci(n-2);
//	    }
//	}
}