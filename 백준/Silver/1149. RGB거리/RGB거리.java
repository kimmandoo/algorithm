import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][3];
        // dp에 저장되는 값은 항상 최소값이어야함
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], 1001 * 1001);
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 맞닿은 집이랑 비교하면 안됨
            dp[i][0] = r + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = g + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = b + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n][i]);
        }
        System.out.println(min);
    }
}