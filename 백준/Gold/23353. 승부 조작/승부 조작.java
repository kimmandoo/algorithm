import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] b;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        b = new int[n][n];
        dp = new int[8][n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go();
    }

    static void go() {
        gogo();
        int mx = 0;

        // 바꾸지 않는 경우
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == 1) {
                    mx = Math.max(mx, dp[0][i][j] + dp[4][i][j] - 1); // U+D
                    mx = Math.max(mx, dp[1][i][j] + dp[5][i][j] - 1); // UR+DL
                    mx = Math.max(mx, dp[2][i][j] + dp[6][i][j] - 1); // R+L
                    mx = Math.max(mx, dp[3][i][j] + dp[7][i][j] - 1); // DR+UL
                }
            }
        }

        // 바꾸는 경우
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == 2) {
                    // 세로
                    int u = (i > 0) ? dp[0][i - 1][j] : 0;
                    int d = (i < n - 1) ? dp[4][i + 1][j] : 0;
                    mx = Math.max(mx, 1 + u + d);

                    // 가로
                    int r = (j < n - 1) ? dp[2][i][j + 1] : 0;
                    int l = (j > 0) ? dp[6][i][j - 1] : 0;
                    mx = Math.max(mx, 1 + l + r);

                    // /
                    int ur = (i > 0 && j < n - 1) ? dp[1][i - 1][j + 1] : 0;
                    int dl = (i < n - 1 && j > 0) ? dp[5][i + 1][j - 1] : 0;
                    mx = Math.max(mx, 1 + ur + dl);

                    // \
                    int dr = (i < n - 1 && j < n - 1) ? dp[3][i + 1][j + 1] : 0;
                    int ul = (i > 0 && j > 0) ? dp[7][i - 1][j - 1] : 0;
                    mx = Math.max(mx, 1 + ul + dr);
                }
            }
        }
        System.out.println(mx);
    }

    static void gogo() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == 1) {
                    dp[0][i][j] = 1; // U
                    dp[1][i][j] = 1; // UR
                    dp[6][i][j] = 1; // L
                    dp[7][i][j] = 1; // UL

                    if (i > 0) dp[0][i][j] += dp[0][i - 1][j];
                    if (i > 0 && j < n - 1) dp[1][i][j] += dp[1][i - 1][j + 1];
                    if (j > 0) dp[6][i][j] += dp[6][i][j - 1];
                    if (i > 0 && j > 0) dp[7][i][j] += dp[7][i - 1][j - 1];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (b[i][j] == 1) {
                    dp[2][i][j] = 1; // R
                    dp[3][i][j] = 1; // DR
                    dp[4][i][j] = 1; // D
                    dp[5][i][j] = 1; // DL

                    if (j < n - 1) dp[2][i][j] += dp[2][i][j + 1];
                    if (i < n - 1 && j < n - 1) dp[3][i][j] += dp[3][i + 1][j + 1];
                    if (i < n - 1) dp[4][i][j] += dp[4][i + 1][j];
                    if (i < n - 1 && j > 0) dp[5][i][j] += dp[5][i + 1][j - 1];
                }
            }
        }
    }
}