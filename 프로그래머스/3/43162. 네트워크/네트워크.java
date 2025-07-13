import java.util.*;

class Solution {
    static boolean[] visited;
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                cnt++;
            }
        }

        return cnt;
    }

    public void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
