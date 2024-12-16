import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] indegree;
    static List<Integer>[] adj;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 학생은 1번 부터 n번 까지 있고
        adj = new ArrayList[n + 1]; // 1 부터 N까지의 인접리스트
        indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList(); // N개의 정점 초기화
        }
        pq = new PriorityQueue<Integer>((o1, o2) -> {
            return o1 - o2;
        });
        // 키 비교횟수는 m번
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a가 b보다 앞에 있다 -> 순서를 이야기함. a 다음이 b
            adj[a].add(b);
            indegree[b]++;
        }
        go();
        System.out.println(sb);
    }

    public static void go() {
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                pq.add(i);
        }
        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append(node).append(" ");
            for (int nxt : adj[node]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0)
                    pq.add(nxt);
            }
        }
    }
}