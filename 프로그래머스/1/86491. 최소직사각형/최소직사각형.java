import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0; // max가 될 것
        int h = 0; // min이 될 것
        for(int[] m: sizes){
            int tw = m[0];
            int th = m[1];
            // 가로 세로 해두고, 가로가 작다면 돌려서 가로가 더 크게 만든다
            if(tw < th){
                // 가로가 더 작아서 회전시킴
                w = Math.max(th, w);
                h = Math.max(tw, h);
            }else{
                w = Math.max(tw, w);
                h = Math.max(th, h); 
            }
        }
        return w*h;
    }
}