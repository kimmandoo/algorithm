import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        for(int[] m: sizes){
            int tw = m[0];
            int th = m[1];
            if(tw < th){
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