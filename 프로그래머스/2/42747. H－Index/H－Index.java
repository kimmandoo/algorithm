import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList();
        for(int c: citations){
            arr.add(c);
        }
        arr.sort(Collections.reverseOrder());

        int len = citations.length;
        for(int i=0; i<len; i++){
            int tmpH = arr.get(i);
            if (tmpH < i + 1) {
                break;
            } else {
                answer = i + 1;
            }
        }
            
        return answer;
    }
}