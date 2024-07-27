import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Node>> graph; // 각 노드는 노드를 가질 수 있다
    static int[] dist;


    static class Node {
        int end, time;

        Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // 컴 개수
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 처음 해킹당한 컴퓨터

            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) { // n개의 컴퓨터에 대한 노드 생성
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()); // a가 b에 의존하고 있다.
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Node(a, s)); // b에서 a로 전파 되려면 s초 필요함
            }

            dijk(c);

            int count = 0;
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            System.out.println(count + " " + maxTime);
        }
    }

    static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cur = current.end;

            if (dist[cur] < current.time) continue;

            for (Node next : graph.get(cur)) {
                if (dist[next.end] > dist[cur] + next.time) {
                    dist[next.end] = dist[cur] + next.time;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}