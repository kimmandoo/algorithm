import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main
{
    static int n, m, v;
    static int[][] map;
    static boolean[] visited; // 전역으로 쓰는 이유는 함수에서 다 갖다 쓰려고

    static void dfs(int node){
        visited[node] = true;
        System.out.print(node+" ");
        for(int i = 1; i <= n; i++){
            if (map[node][i]==1 & !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        map = new int[n+1][n+1]; // 정점 개수 만큼 map
        visited = new boolean[n+1];

        // 인접행렬에 값 넣기, 무방향 그래프임.
        for(int i=0; i<m; i++){
            int src = sc.nextInt();
            int dst = sc.nextInt();
            map[src][dst] = 1;
            map[dst][src] = 1;
        }
        // DFS
        dfs(v);
        System.out.println();
        visited = new boolean[n+1]; // 방문 배열초기화하기
        // BFS
        q.offer(v);
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;
            System.out.print(node+" ");
            for(int i=1; i<=n; i++){
                if(map[node][i] == 1 & !visited[i]){
                    q.offer(i);
                    visited[i] = true; // 넣으면서 방문처리를 해줘야 됨. 안하면 똑같은 정점이 중복으로 추가 됨
                }
            }
        }
    }
}