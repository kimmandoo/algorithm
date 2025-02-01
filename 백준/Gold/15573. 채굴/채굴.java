import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        max = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 각 칸의 강도
                max = Math.max(max, map[i][j]);
            }
        }

        go();
    }

    public static void go() {
        int l = 1;
        int r = max;
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (dig(mid)) {
                r = mid - 1;
                result = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static boolean dig(int d) {
        boolean[][] v = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            if (map[0][i] <= d) {
                q.offer(new Node(0, i));
                v[0][i] = true;
                cnt++;
            }
        }
        for (int i = 1; i < n; i++) {
            if (map[i][0] <= d) {
                q.offer(new Node(i, 0));
                v[i][0] = true;
                cnt++;
            }
            if (map[i][m - 1] <= d) {
                q.offer(new Node(i, m - 1));
                v[i][m - 1] = true;
                cnt++;
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int ci = cur.i;
            int cj = cur.j;

            if (cnt >= k) return true;

            for (int i = 0; i < 4; i++) {
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if (check(ni, nj) && !v[ni][nj] && map[ni][nj] <= d) {
                    q.offer(new Node(ni, nj));
                    v[ni][nj] = true;
                    cnt++;
                }
            }
        }

        return cnt >= k;
    }

    static boolean check(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}