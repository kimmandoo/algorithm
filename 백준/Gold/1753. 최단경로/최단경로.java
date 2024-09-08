import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq;
    static ArrayList<Node>[] list;
    static int[] dist;
    static int v, e; // 정점 개수, 간선 개수
    static int INF = Integer.MAX_VALUE;

    static class Node {
        int endNode, weight;

        Node(int e, int w) {
            endNode = e;
            weight = w;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        dist = new int[v + 1]; // 정점 개수만큼 생성해야됨
        Arrays.fill(dist, INF);

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>(); // 각 노드(정점)에 연결된 리스트 생성
        }

        pq = new PriorityQueue<Node>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        int startNode = Integer.parseInt(br.readLine());


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight)); // 방향 그래프임
        }
        dijkstra(startNode);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<= v; i++){
            int distance = dist[i];
            if (distance == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dijkstra(int startNode) {
        // 시작 정점은 1
        // 그 전에 방문 배열 만들어두기
        boolean[] vis = new boolean[v + 1];
        pq.add(new Node(startNode, 0)); // 시작점을 넣어준다. 시작정점에서 시작으로 가는 w는 0이다.
        dist[startNode] = 0; // 0까지 가는 거리가 0이다
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nextNode = cur.endNode; // 사실상 간선
            if (vis[nextNode]) continue;

            vis[nextNode] = true;

            for (Node next : list[nextNode]) {
                int tmpWeight = dist[nextNode] + next.weight;
                // nextNode에서 next까지 가는 거리
                if (tmpWeight < dist[next.endNode]) {
                    dist[next.endNode] = tmpWeight;
                    pq.add(new Node(next.endNode, dist[next.endNode])); // 방문한 곳을 다시 큐에 넣는다.
                }
            }
        }
    }
}