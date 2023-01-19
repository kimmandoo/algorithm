import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Arrays.sort(array);
        int[] freq = new int[array[array.length-1]+1];
        int cur = array[0];
        
        for(int i=0; i<array.length; i++){
            if(cur != array[i]){
                cur = array[i];
                freq[cur] += 1;
            }else{
                freq[cur] += 1;
            }
        }
        int max = 0;
        for(int i=0; i<freq.length; i++){
            if(max < freq[i]) {
                answer = i;
                max = freq[i];
            }
        }
        
        Arrays.sort(freq);
        if(freq.length > 1 && freq[freq.length-1] == freq[freq.length-2])
            answer = -1;
    
        return answer;
    }
}