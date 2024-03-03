import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int find;

    public static void dfs(int ci, int cj, int cs) {
        if (ci == n - 1 && cj == n - 1) {
            find++;
            return;
        }

        if (cs == 0) {
            if (cj < n - 1 && map[ci][cj + 1] == 0) {
                dfs(ci, cj + 1, 0);
            }
            if (cj < n - 1 && ci < n - 1 && map[ci + 1][cj + 1] == 0 && map[ci][cj + 1] == 0 && map[ci + 1][cj] == 0) {
                dfs(ci + 1, cj + 1, 1);
            }
        } else if (cs == 1) {
            if (cj < n - 1 && map[ci][cj + 1] == 0) {
                dfs(ci, cj + 1, 0);
            }
            if (cj < n - 1 && ci < n - 1 && map[ci + 1][cj + 1] == 0 && map[ci][cj + 1] == 0 && map[ci + 1][cj] == 0) {
                dfs(ci + 1, cj + 1, 1);
            }
            if (ci < n - 1 && map[ci + 1][cj] == 0) {
                dfs(ci + 1, cj, 2);
            }
        } else if (cs == 2) {
            if (cj < n - 1 && ci < n - 1 && map[ci + 1][cj + 1] == 0 && map[ci][cj + 1] == 0 && map[ci + 1][cj] == 0) {
                dfs(ci + 1, cj + 1, 1);
            }
            if (ci < n - 1 && map[ci + 1][cj] == 0) {
                dfs(ci + 1, cj, 2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        find = 0;
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0); // 시작 위치 설정
        System.out.println(find);
    }
}
