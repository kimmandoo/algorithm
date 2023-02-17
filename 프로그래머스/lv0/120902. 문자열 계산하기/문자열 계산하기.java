import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int temp = 0;
        StringTokenizer st = new StringTokenizer(my_string, " ");
        while(st.hasMoreTokens()){
            String input = st.nextToken();
            if(input.equals("+")){
                answer += Integer.parseInt(st.nextToken());
            }else if(input.equals("-")){
                answer -= Integer.parseInt(st.nextToken());
            }else{
                answer = Integer.parseInt(input);
            }
        }
    
        return answer;
    }
}