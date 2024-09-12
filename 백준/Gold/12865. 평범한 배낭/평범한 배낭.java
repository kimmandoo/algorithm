import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k; // 물품수 N과 가방에 들어갈 수 있는 최대 무게 K

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] input = new int[n + 1][2]; // 각 물건의 무게, 가치
        int[][] dp = new int[n + 1][k + 1]; // 최대 용량이 k인데, n개의 물건이 들어갈 지 말지 모름

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            input[i][0] = w;
            input[i][1] = v;
        }

        // 이제 배낭 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (input[i][0] > j) {
                    // 들어갈 물건의 무게갸 현재 j보다 크면 가방에 못넣음
                    dp[i][j] = dp[i - 1][j]; // 최대 가치 넣기
                } else { // 가방에 넣을 수 있으면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - input[i][0]] + input[i][1]);
                    // dp배열에는 가지가 들어가는데, 이전 가치랑, 현재 물건의 가치+ 이전 물건 가치
                }
            }
        }
        System.out.println(dp[n][k]);
    }

}
