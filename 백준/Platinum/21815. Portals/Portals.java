import java.io.*;
import java.util.*;

public class Main {
    // 간선 클래스를 정의 (u: 시작 포털, v: 끝 포털, cost: 비용)
    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost); // 비용 기준으로 간선 정렬
        }
    }

    static int[] parent;

    //특정 정점 x가 속한 집합의 대표를 찾음
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // 경로 압축
        return parent[x];
    }

    //두 정점 x와 y를 같은 집합으로 병합
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) parent[rootX] = rootY; // 두 집합 병합
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정점의 개수

        int totalPortals = 4 * n; // 각 정점에 4개의 포털이 있으므로 총 포털 수
        List<Edge> edges = new ArrayList<>();
        parent = new int[totalPortals + 1];

        // make
        for (int i = 1; i <= totalPortals; i++) {
            parent[i] = i;
        }

        int[][] portals = new int[n][4]; // 각 정점의 포털 정보를 저장
        int[] costs = new int[n]; // 각 정점의 포털 재배열 비용

        // 입력 처리: 정점의 포털과 비용 정보
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken()); // 포털 재배열 비용
            for (int j = 0; j < 4; j++) {
                portals[i][j] = Integer.parseInt(st.nextToken());
            }

            // 같은 정점 내 포털 간 기본 연결 (0 비용)
            edges.add(new Edge(portals[i][0], portals[i][1], 0)); // 포털 1-2 연결
            edges.add(new Edge(portals[i][2], portals[i][3], 0)); // 포털 3-4 연결

            // 포털 재배열 비용 간선 추가
            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    edges.add(new Edge(portals[i][j], portals[i][k], costs[i]));
                }
            }
        }

        // 포털 번호로 연결된 정점들 간 비용 0 간선 추가
        Map<Integer, List<Integer>> portalMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                portalMap.computeIfAbsent(portals[i][j], k -> new ArrayList<>()).add(portals[i][j]);
            }
        }

        for (List<Integer> portalGroup : portalMap.values()) {
            for (int i = 0; i < portalGroup.size(); i++) {
                for (int j = i + 1; j < portalGroup.size(); j++) {
                    edges.add(new Edge(portalGroup.get(i), portalGroup.get(j), 0));
                }
            }
        }

        // 간선을 비용 기준으로 정렬
        Collections.sort(edges);

        // Kruskal 알고리즘으로 최소 스패닝 트리 계산
        int cost = 0;
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) { // 사이클이 생기지 않으면 간선 추가
                union(edge.u, edge.v); // 두 포털을 연결
                cost += edge.cost; // 비용 추가
            }
        }

        // 최소 비용 출력
        System.out.println(cost);
    }
}