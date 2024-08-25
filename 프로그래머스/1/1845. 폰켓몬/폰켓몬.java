import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        TreeSet<Integer> ts = new TreeSet();
        for(int i: nums){
            ts.add(i); // 일단 이러면 중복제거가 된다
        }
        if(ts.size() >= nums.length/2){
            answer = nums.length/2;
        }else{
            answer = ts.size();
        }
        
        return answer;
    }
}