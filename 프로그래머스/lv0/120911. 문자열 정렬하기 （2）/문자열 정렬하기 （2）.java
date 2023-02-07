import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        int[] ascii = new int[my_string.length()];
        
        // A는 65 a는 97. 32만큼 차이남
        for(int i=0; i<my_string.length(); i++){
            int n = my_string.charAt(i);
            if(n < 97) ascii[i] = n+32;
            else ascii[i] = n;
        }
        Arrays.sort(ascii);
        for(int n : ascii){
            answer += (char)n;
        }
        
        
        return answer;
    }
}