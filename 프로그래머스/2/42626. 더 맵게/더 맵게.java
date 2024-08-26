import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i: scoville){
            pq.add(i);
        } // 기본이 min heap
        while(pq.peek()<K){
            if(pq.size()>=2){
                int easy = pq.poll();
                int eeasy = pq.poll();
                pq.add(easy + (2*eeasy)); // 새 음식 만들어서 추가
                answer++;
            }else{
                answer = -1;
                break;
            }
            if(pq.peek() >= K) break;
        }
        
        return answer;
    }
}