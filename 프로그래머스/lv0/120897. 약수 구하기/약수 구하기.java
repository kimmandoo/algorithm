import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arr = new ArrayList();
        // n이 작으니 그냥 돌린다.
        for(int i=1; i<=n; i++){
            if(n%i==0){
                arr.add(i);
            }
        }
        int[] answer = new int[arr.size()];
        int idx=0;
        for(Integer i: arr){
            answer[idx++] = i;
        }
        
        return answer;
    }
}