import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int cache = 0;
        
        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            String input = st.nextToken();
            if(input.equals("Z")){
                answer -= cache;
            }else{
                cache = Integer.parseInt(input);
                answer += cache;
            }
        }
        return answer;
    }
}