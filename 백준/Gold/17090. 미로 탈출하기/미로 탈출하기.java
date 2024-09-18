import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1}; // U, R, D, L 순서
    static char[][] map;
    static int[][] memo;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                memo[i][j] = -1; // -1: 미방문, 0: 탈출 불가, 1: 탈출 가능
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j] == -1) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean dfs(int i, int j) {
        if (memo[i][j] != -1) return memo[i][j] == 1;

        int dir = getDirection(map[i][j]);
        int ni = i + di[dir];
        int nj = j + dj[dir];

        if (isEscape(ni, nj)) {
            memo[i][j] = 1;
            cnt++;
            return true;
        }

        memo[i][j] = 0; // 임시로 탈출 불가능으로 표시 (사이클 방지)
        boolean escape = dfs(ni, nj);

        if (escape) {
            memo[i][j] = 1;
            cnt++;
        }

        return escape;
    }

    public static boolean isEscape(int ni, int nj) {
        return ni < 0 || ni >= n || nj < 0 || nj >= m;
    }

    public static int getDirection(char c) {
        switch (c) {
            case 'U': return 0;
            case 'R': return 1;
            case 'D': return 2;
            case 'L': return 3;
        }
        return -1;
    }
}