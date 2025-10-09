import java.util.*;

class Solution {
    static class Node {
        int nxt, cst;
        Node(int nxt, int cst){
            this.nxt = nxt;
            this.cst = cst;
        }
    }
    
    static ArrayList<Node>[] graph;
    static int INF = 100000001;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        graph = new ArrayList[n+1]; // 1-base 정점 세기
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            graph[fare[0]].add(new Node(fare[1], fare[2])); // 양방향 그래프 채우기
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        int[] distS = dijk(s, n); // s가 출발지
        int[] distA = dijk(a, n); // a가 출발지
        int[] distB = dijk(b, n); // b가 출발지
        
        int minFare = distS[a] + distS[b];

        // 1부터 n까지 모든 지점을 경유지(k)로 가정
        for (int k = 1; k <= n; k++) {
            // s->k (합승 요금) + k->a (A 개인 요금) + k->b (B 개인 요금)
            int sharedFare = distS[k] + distA[k] + distB[k];
            
            // 기존 최솟값과 비교하여 갱신
            minFare = Math.min(minFare, sharedFare);
        }

        return minFare;
    }
    
    public static int[] dijk(int s, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cst - o2.cst);
        pq.offer(new Node(s, 0));
        dist[s] = 0; // 시작 지는 0
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if (dist[cur.nxt] < cur.cst) {
                continue; 
            }
            for(Node next: graph[cur.nxt]){
                // 인접 노드 확인하기
                int cost = cur.cst + next.cst;
                if(cost < dist[next.nxt]){
                    dist[next.nxt] = cost;
                    pq.offer(new Node(next.nxt, cost));
                }
            }
        }
        return dist;
    }
}