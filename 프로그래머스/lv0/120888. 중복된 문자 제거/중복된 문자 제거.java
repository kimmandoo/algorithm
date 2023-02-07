class Solution {
    public String solution(String my_string) {
        String answer = "";
        int len = my_string.length();
        for(int i=0; i<len; i++){
            char c = my_string.charAt(i);
            if(answer.contains(Character.toString(c))) continue;
            else answer += c;
        }
        return answer;
    }
}