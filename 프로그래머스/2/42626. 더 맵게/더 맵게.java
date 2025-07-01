import java.util.*;

class Solution {
    public int solution(int[] sv, int k) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: sv){
            pq.offer(s);
        } // init
        
        int cnt = 0;
        if(pq.peek() >= k) return 0;
        while(pq.peek() < k && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b*2);
            cnt++;
        }
        
        if(pq.peek() < k) return -1;
        return cnt;
    }
}