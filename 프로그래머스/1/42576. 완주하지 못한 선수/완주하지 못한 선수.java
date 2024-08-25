import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        TreeMap<String, Integer> tm = new TreeMap();
        for(String name: participant){
            tm.put(name, tm.getOrDefault(name, 0)+1);
        } // 트리맵에 저장해두기 -> 굳이 TreeMap일 필요없음
        // 이제 completion을 돌면서 처리하자
        for(String name: completion){
            tm.put(name, tm.get(name)-1);
        } // 0이면 완주했다는 의미가 될 것
        
        Iterator<String> keys = tm.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            if(tm.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}