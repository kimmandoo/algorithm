import java.util.*;

class Solution {
    
    int[][] maps, visited;
    int m, n;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    
    void bfs() {
        visited[0][0] = 1;
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{0,0});
        
        while (!queue.isEmpty()) {
            var curr = queue.remove();
            var r = curr[0];
            var c = curr[1];
            
            for (var i = 0; i < 4; i++) {
                var nr = r + dr[i];
                var nc = c + dc[i];
                
                if (nr >= m || nr < 0 || nc >= n || nc < 0) continue;
                if (visited[nr][nc] == 0 && maps[nr][nc] == 1) {
                    visited[nr][nc] = visited[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        this.maps = maps;
        
        bfs();
        answer = visited[m - 1][n - 1] == 0 ? - 1 : visited[m - 1][n - 1];
        return answer;
    }
}