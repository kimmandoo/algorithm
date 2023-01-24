import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        
        ArrayList<Integer> arr = new ArrayList();
        int len = my_string.length();
        for(int i=0; i<len; i++){
            char c = my_string.charAt(i);
            if((int)c >= '0' && (int)c <= '9') arr.add(Character.getNumericValue(c));
        }
        int[] answer = new int[arr.size()];
        int idx = 0;
        for(Integer i: arr){
            answer[idx++] = i;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}