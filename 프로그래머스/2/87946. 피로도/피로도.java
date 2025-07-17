import java.util.*;

class Solution {
    static int mx = -1;
    static boolean[] v;
    
    public int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        // go(k, 0, 0, dungeons);
        dfs(k, 0, dungeons);
        
        return mx;
    }
    
    public void dfs(int k, int cnt, int[][] dungeons) {
        mx = Math.max(mx, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (v[i]) continue;
            if (k < dungeons[i][0]) continue;

            v[i] = true;
            dfs(k - dungeons[i][1], cnt + 1, dungeons);
            v[i] = false;
        }
    }
    
    public void go(int k, int cnt, int idx, int[][] dg){
        if(idx == dg.length || k < dg[idx][0]){
            mx = Math.max(cnt, mx);
            return;
        }
        // idx번째 던전을 갈지, 안갈지
        go(k-dg[idx][1],cnt+1, idx+1, dg); // 가
        go(k,cnt, idx+1, dg); // 안가
    }
}