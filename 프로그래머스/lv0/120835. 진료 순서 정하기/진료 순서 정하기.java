import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] cl = emergency.clone();
        
        Arrays.sort(cl);
        int idxM = 1;
        
        for(int i=emergency.length-1; i>=0; i--){
            for(int j=0; j<emergency.length; j++){
                if(cl[i] == emergency[j]){
                    answer[j] = idxM++;
                } 
            }
        }
        
        return answer;
    }
}