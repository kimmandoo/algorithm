import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> p = new HashSet();
        for(int i: nums){
            p.add(i);
        }
        int pick = nums.length / 2;
        if(pick >= p.size()) return p.size();
        
        return pick;
    }
}