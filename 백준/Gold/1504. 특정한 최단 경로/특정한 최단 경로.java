import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, e;
    static List<Node>[] nodes;

    static class Node {
        int next;
        long weight;

        Node(int next, long weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    static PriorityQueue<Node> pq;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 초기화 부분은 동일
        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int mustA = Integer.parseInt(st.nextToken());
        int mustB = Integer.parseInt(st.nextToken());

        // 1에서 시작하는 최단거리
        long[] dist1 = go(1);
        // mustA에서 시작하는 최단거리
        long[] distA = go(mustA);
        // mustB에서 시작하는 최단거리
        long[] distB = go(mustB);

        boolean path1Possible = dist1[mustA] != Long.MAX_VALUE
                && distA[mustB] != Long.MAX_VALUE
                && distB[n] != Long.MAX_VALUE;
        boolean path2Possible = dist1[mustB] != Long.MAX_VALUE
                && distB[mustA] != Long.MAX_VALUE
                && distA[n] != Long.MAX_VALUE;

        long path1 = path1Possible ? dist1[mustA] + distA[mustB] + distB[n] : Long.MAX_VALUE;
        long path2 = path2Possible ? dist1[mustB] + distB[mustA] + distA[n] : Long.MAX_VALUE;

        if (!path1Possible && !path2Possible) {
            System.out.println(-1);
        } else {
            if (path1Possible && path1 < 0) path1 = Long.MAX_VALUE;
            if (path2Possible && path2 < 0) path2 = Long.MAX_VALUE;

            if (path1 == Long.MAX_VALUE && path2 == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(Math.min(path1, path2));
            }
        }
    }

    public static long[] go(int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->
                Long.compare(o1.weight, o2.weight));

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.next]) continue;

            visited[node.next] = true;
            for (Node child : nodes[node.next]) {
                long tmpDist = child.weight + dist[node.next];
                if (tmpDist < dist[child.next]) {
                    dist[child.next] = tmpDist;
                    pq.add(new Node(child.next, tmpDist));
                }
            }
        }
        return dist;
    }
}