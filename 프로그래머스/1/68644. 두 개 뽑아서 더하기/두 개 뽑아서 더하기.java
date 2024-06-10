import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> ts = new TreeSet();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1;j<numbers.length; j++){
                ts.add(numbers[i]+numbers[j]);
            }
        }
            int[] answer = new int[ts.size()];
        int idx=0;
        for(int i : ts){
            answer[idx++] = i;
        }
        return answer;
    }
}