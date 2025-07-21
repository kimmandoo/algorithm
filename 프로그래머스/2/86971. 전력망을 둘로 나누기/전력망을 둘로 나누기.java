import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        int answer = n*n;
        graph = new ArrayList[n + 1]; // 1~n

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        // 모든 전선을 하나씩 끊어보는 완전 탐색
        for (int[] w : wires) {
            int v1 = w[0]; // 간선 시작, 끝으로 해서 컨트롤
            int v2 = w[1];

            // v1을 시작으로 탐색하되, v2로는 가지 못하게 막는다 -> 전선이 끊긴 효과
            int cnt = bfs(v1, v2, n);

            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public int bfs(int start, int cut, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        int count = 0;

        q.offer(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++; // 방문한 노드 개수 증가

            for (int next : graph[cur]) { // 현재 노드에 연결된 노드들 순회
                // 방문한 적 없고, 끊어진 노드가 아니라면 큐에 추가
                if (!v[next] && next != cut) {
                    v[next] = true;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}