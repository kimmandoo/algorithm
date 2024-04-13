import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stair = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= N; i++)
            stair[i] = sc.nextInt();

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int n = 4; n <= N; n++) {
            dp[n] = Math.max(dp[n - 3] + stair[n - 1], dp[n - 2]) + stair[n];
        }

        System.out.println(dp[N]);
    }
}