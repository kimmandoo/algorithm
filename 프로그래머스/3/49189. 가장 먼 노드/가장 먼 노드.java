import java.util.*;

class Solution {
    static ArrayList<Integer>[] g;
    static int[] dist;

    public int solution(int n, int[][] edge) {
        g = new ArrayList[n + 1];
        dist = new int[n + 1]; 

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            int s = e[0];
            int d = e[1];
            g[s].add(d);
            g[d].add(s); // 무방향
        }

        return bfs(1, n);
    }

    public int bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];

        q.offer(start);
        v[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : g[cur]) {
                if (!v[next]) {
                    v[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        int mx = 0;
        for (int i = 1; i <= n; i++) {
            mx = Math.max(mx, dist[i]);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == mx) count++;
        }

        return count;
    }
}
