import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            // 무방향 그래프
            map[src][dst] = 1;
            map[dst][src] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int linked = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                linked++;
                q.offer(i);
                while (!q.isEmpty()){
                    int node = q.poll(); // 노드를 꺼내서 써야지 타고 타고 들어감...!
                    visited[node] = true;
                    for(int j=1; j<=n; j++){
                        if(map[node][j] == 1 && !visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(linked);
    }
}