import java.io.*;
import java.util.*;

public class Main {
    static int n, t, p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            if (i == 4) dp[i] = -1;
            if (i == 5) dp[i] = 1;
            if (i > 5) {
                if (dp[i - 3] > 0 && dp[i - 5] > 0) {
                    dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
                    continue;
                }
                if (dp[i - 3] > 0 && dp[i - 5] < 0) {
                    dp[i] = dp[i - 3] + 1;
                    continue;
                }
                if (dp[i - 3] < 0 && dp[i - 5] > 0) {
                    dp[i] = dp[i - 5] + 1;
                    continue;
                }
            }
        }
        System.out.println(dp[n]);
//        go();
    }

    public static void go() {

    }
}