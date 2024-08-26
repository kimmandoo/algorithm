import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap();
        for(String[] p: clothes){
            hm.put(p[1], hm.getOrDefault(p[1],0)+1);
        } // 없으면 0넣고 1더하기 -> NPE 방지
        
        for(Map.Entry<String, Integer> entry: hm.entrySet()){
            answer *= (entry.getValue()+1);
        }
        
        return answer-1;
    }
}