import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int [] abc = new int[26]; // 0이 a 25가 z
        char[] c = s.toCharArray();
        // a는 97
        for(char i: c){
            abc[i-97]++;
        }
        
        for(int i=0; i<26; i++){
            if(abc[i]==1) answer += (char)(i+97);
        }
        char[] t = answer.toCharArray();
        Arrays.sort(t);
        answer = new String(t);
        
        
        
        return answer;
    }
}