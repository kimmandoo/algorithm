import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> ans = new HashSet<Integer>();
        
        int k = 2;
        int a = n;
        
        while(a != 1){
            if(a%k == 0) {
                ans.add(k);
                a = a/k;
            }else{
                k++;
            }
        }
        
        int[] answer = new int[ans.size()];
        int idx = 0;
        for(Integer i: ans){
            answer[idx++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}