import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        // int h = 0;
        // for(int i=1; i<=n; i++){
        //     // i번째 논문의 인용 수 체크 1-based
        //     int cit = citations[i-1];
        //     // 인용된 논문이 h편 이상인가?
        //     if(n-i+1 >= h){
        //         // 남은 논문 개수가 현재 인용 수 보다 크거나 같으면 성립
        //         h = cit;
        //     }
        // }
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 남은 논문 개수
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}