import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i=0; i<len; i++){
            int tmpH = citations[i];
            // 현재 위치 포함해서 남은 논문 편 수
            int left = len - i;
            if(tmpH <= left){
                answer = tmpH;
            }
        }
        
        
            
        return answer;
    }
}