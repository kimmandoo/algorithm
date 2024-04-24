import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] indegree;
    static List<Integer>[] adj;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
    static int cnt = 0;

    static void topology() {
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                pq.add(i);
        }
        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append(node).append("\n");
            cnt++;
            for (int nxt : adj[node]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0)
                    pq.add(nxt);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        pq = new PriorityQueue<>();
        sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int prev = -1;
            for (int j = 0; j < size; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (prev != -1) {
                    adj[prev].add(cur);
                    indegree[cur]++;
                }
                prev = cur;
            }
        }
        topology();
        if (cnt == n) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }
}