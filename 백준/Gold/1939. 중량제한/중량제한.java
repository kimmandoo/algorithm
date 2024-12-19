import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Node>> nodes;

    static class Node {
        int n;
        long w;

        Node(int next, long weight) {
            this.n = next;
            this.w = weight;
        }
    }

    static int start;
    static int end;
    static int load;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<List<Node>>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<Node>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c)); // 양방향
            load = Math.max(load, c); // 최대중량 기억해두기
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        go();
    }

    public static void go() {
        long l = 1;
        long r = load;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2; // 얘가 이제 타겟 중량
            // 다익 돌려서 갈 수 있으면
            if (gogo(mid)){ // 중량 좀 올리기
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean gogo(long mid) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Node next : nodes.get(current)) {
                if (!visited[next.n] && next.w >= mid) { // 중량 제한 만족 여부 확인
                    visited[next.n] = true;
                    queue.add(next.n);
                }
            }
        }

        return visited[end];
    }
}