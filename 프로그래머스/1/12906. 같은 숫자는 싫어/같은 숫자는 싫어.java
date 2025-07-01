import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int k: arr){
            if(dq.isEmpty()){
                dq.addLast(k);
            }else{
                if(dq.peekLast() == k) continue;
                dq.addLast(k);
            }
        }
        
        int[] ans = new int[dq.size()];
        
        for(int i=0; i<ans.length; i++){
            ans[i] = dq.removeFirst();
        }
        
        return ans;
    }
}