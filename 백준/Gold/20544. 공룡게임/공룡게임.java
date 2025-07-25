import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MOD = 1000000007;
    static int n;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long result = (go() - nogo() + MOD) % MOD;
        System.out.println(result);
    }

    private static long go() {
        // dp[i][k]: i위치에서 k상태인
        // 0
        // 0, 1
        // 0, 2
        // 0, 1, 1
        // 0, 1, 2
        // 0, 2, 1
        // 0, 2, 2 <- 이건 안됨
        long[][] dp = new long[n + 1][6];

        dp[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            // 0
            long prev = 0;
            for(int j=0; j<6; j++) {
                prev = (prev + dp[i-1][j]) % MOD;
            }
            dp[i][0] = prev;

            // 1
            // 이전 상태가 0
            dp[i][1] = dp[i-1][0];
            // 이전 상태가 1
            dp[i][3] = dp[i-1][1];
            // 이전 상태가 2
            dp[i][5] = dp[i-1][2];

            // 2
            // 이전 상태가 0
            dp[i][2] = dp[i-1][0];
            // 이전 1
            dp[i][4] = dp[i-1][1];
            // 이전 2 -> 이건 안됨
        }

        long cnt = 0;
        for (int j = 0; j < 6; j++) {
            // 상태 별로 몇개 인지 세기
            cnt = (cnt + dp[n][j]) % MOD;
        }
        return cnt;
    }

    private static long nogo() {
        long[][] dp = new long[n + 1][3]; // 키가 2인 건 안쓰니가 0, 0 1, 0 1 1 상태가 3개

        dp[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            // i번째가 0
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            // i번째에 키가 1
            // 직전이 0
            dp[i][1] = dp[i-1][0];
            // 직전이 0, 1
            dp[i][2] = dp[i-1][1];
        }

        return (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
    }
}