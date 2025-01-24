import java.util.*;

class Solution {
    public static int solution(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // 임의의 노드(1번)에서 가장 먼 노드 A 찾기
        int[] distFrom1 = bfs(graph, 1, n);
        int fa = findMax(distFrom1, n);

        // 노드 A에서 가장 먼 노드 B 찾기 -> 트리의 지름 계산
        int[] distFromA = bfs(graph, fa, n);
        int fb = findMax(distFromA, n);
        int diameter = distFromA[fb];

        // Step 3: 노드 B 기준으로 지름의 특성 확인
        int[] distFromB = bfs(graph, fb, n);

        // Step 4: 중간값 계산
        // 지름 끝점이 둘 이상인지 확인
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (distFromA[i] == diameter) {
                cnt++;
            }
        }

        // 중간값 반환
        if (cnt >= 2) {
            return diameter; // 지름 끝점이 여러 개라면 지름 반환
        }

        // 노드 B에서 또 다른 탐색으로 확인
        cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (distFromB[i] == diameter) {
                cnt++;
            }
        }

        return cnt >= 2 ? diameter : diameter - 1;
    }

    // 시작 노드에서 모든 노드까지의 최단 거리 계산
    private static int[] bfs(List<Integer>[] graph, int start, int n) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dist, 0);
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    dist[nxt] = dist[cur] + 1;
                    queue.add(nxt);
                }
            }
        }
        return dist;
    }

    // 가장 먼 노드 찾기
    private static int findMax(int[] dist, int n) {
        int maxNode = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[maxNode]) {
                maxNode = i;
            }
        }
        return maxNode;
    }
}
