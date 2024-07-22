import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<int[]>> graph; // 각 노드는 노드를 가질 수 있다. 그 노드는 다음노드, 그 노드 까지 거리을 갖고 있음
    static int[][] d; // 순회하면서 노드 간 거리를 계산 - 경유해서 가는 거리도 같이
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = new int[n + 1][n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, dist});
            graph.get(end).add(new int[]{start, dist});
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1]; // 매 노두 순회할때마다 필요한 방문배열
            dfs(i, i, 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(d[start][end]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int current, int dist) {
        visited[current] = true;
        d[start][current] = dist;
        d[current][start] = dist;  // 양방향 그래프이므로 양쪽 모두 설정

        for (int[] next : graph.get(current)) {
            int nextNode = next[0];
            int nextDist = next[1];
            if (!visited[nextNode]) {
                dfs(start, nextNode, dist + nextDist);
            }
        }
    }
}
