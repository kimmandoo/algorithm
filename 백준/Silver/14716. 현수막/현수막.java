import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];
        cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    go(i,j);
                }
            }
        }

        System.out.println(cnt);
    }

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void go(int si, int sj) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(si, sj));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (v[cur.i][cur.j]) continue;
            v[cur.i][cur.j] = true;
            for (int d = 0; d < 8; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                if (ni < n && ni >= 0 && nj >= 0 && nj < m && map[ni][nj] == 1 && !v[ni][nj]) {
                    q.add(new Node(ni, nj));
                    //v[ni][nj] = true;
                }
            }
        }
        cnt++;
    }
}
