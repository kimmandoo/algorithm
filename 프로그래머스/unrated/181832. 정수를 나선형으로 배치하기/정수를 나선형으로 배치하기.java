class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        // u, r, d, l
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int dir = 1;
        int cnt = 1;
        int i=0;
        int j=0;
        while(cnt < n*n){
            // 90도 변경 -> 1, 2, 3, 0

            int ni = i + dr[dir];
            int nj = j + dc[dir];
            if (ni < n && ni >= 0 && nj < n && nj >= 0 && answer[ni][nj] == 0) {
                answer[i][j] = cnt++;
                i = ni;
                j = nj;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        answer[i][j] = cnt;
        
        return answer;
    }
}