import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int pay = Integer.parseInt(st.nextToken());
            // n개의 카드를 가장 비싼 가격에 사는 방법
            for (int j = 1; j <= n; j++) {
                // i개수를 사는 가격이 pay만큼인데,
                // 이전에 i개수를 산 가격 vs 지금 가격에 i개수를 사는 가격 비교해서 최댓값 넣기
                // dp에는 j개수를 살 때의 최대 비용이 들어갈 것
                if (j>=i){
                    dp[i][j] = Math.max(dp[i][j - i] + pay, dp[i - 1][j]); // 현재값이랑
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
//        for (int[] r: dp){
//            System.out.println(Arrays.toString(r));
//        }
        System.out.println(dp[n][n]);
    }

    public static void go() {

    }
}
