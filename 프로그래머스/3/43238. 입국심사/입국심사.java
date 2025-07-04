import java.util.*;

class Solution {
    public boolean go(int n, long m, int[] t){
        // m 시간이면 다 돌 수 있는 지?
        long sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += m / t[i]; // i번째 심사관이 m 시간 동안 처리할 수 있는 인원
            if (sum >= n) return true; // 이미 n명 이상이면 더 계산할 필요 없음
        }
        return false;
    }
    public long solution(int n, int[] times) {
        // n 명이 줄 서 있음.
        Arrays.sort(times); // 심사관 오름차순 정렬
        long l = 1L;
        long r = (long) times[times.length - 1] * n;
        long answer = r;
        while(l<=r){
            long m = (l+r)/2;
            if(go(n, m, times)){
                answer = m;
                // 조건을 만족하면 더 작은 시간으로
                r = m - 1;
            }else{
                l = m + 1; 
            }
        }
        
        return answer;
    }
}