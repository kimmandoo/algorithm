import java.util.*;

class Solution {
    public String solution(String[] p, String[] c) {
        // 참가자 수는 10만 이하
        // p보다 c가 작음
        // 한 명 빼고는 모두 완주했음
        Arrays.sort(p);
        Arrays.sort(c);
        
        for(int i=0; i<c.length; i++){
            if(!p[i].equals(c[i])){
                return p[i];
            }
        }
        
        return p[c.length];
    }
}