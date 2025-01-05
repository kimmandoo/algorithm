import java.io.*;
import java.util.*;

public class Main {
    static int k, n, m;
    static int[][] map;
    static boolean[][][] v;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[] ki = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] kj = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Node {
        int i, j, k, count;

        Node(int i, int j, int k, int count) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new boolean[k + 1][n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(go());
    }

    public static int go() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 0));
        v[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.i == n - 1 && cur.j == m - 1) {
                return cur.count; // 이동 한 만큼 -> 항상 최단거리
            }

            // 상하좌우 이동
            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (check(ni, nj, cur.k) && map[ni][nj] == 0) {
                    v[cur.k][ni][nj] = true;
                    q.offer(new Node(ni, nj, cur.k, cur.count + 1));
                }
            }

            // 말처럼 이동
            if (cur.k < k) {
                for (int d = 0; d < 8; d++) {
                    int ni = cur.i + ki[d];
                    int nj = cur.j + kj[d];

                    if (check(ni, nj, cur.k + 1) && map[ni][nj] == 0) {
                        v[cur.k + 1][ni][nj] = true;
                        q.offer(new Node(ni, nj, cur.k + 1, cur.count + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static boolean check(int i, int j, int k) {
        return i >= 0 && i < n && j >= 0 && j < m && !v[k][i][j];
    }
}