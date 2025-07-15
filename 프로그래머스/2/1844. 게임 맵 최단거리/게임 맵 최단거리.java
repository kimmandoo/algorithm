import java.util.*;

class Solution {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static boolean[][] v; // 방문한 최단 거리;
    
    public int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        v = new boolean[n][m];
        // 0,0 -> n-1, m-1;
        
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, 0, 0});
        int res = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n-1 && cur[1] == m-1) res = cur[2]+1;
            for(int d=0; d<4; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(ni < n && nj < m && ni >= 0 && nj >= 0 && !v[ni][nj] && maps[ni][nj] == 1){
                    q.offer(new int[]{ni, nj, cur[2] + 1});
                    v[ni][nj] = true;
                }
            }
        }
        
        return res;
    }
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}