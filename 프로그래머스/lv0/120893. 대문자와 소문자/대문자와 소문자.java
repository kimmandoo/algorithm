class Solution {
    public String solution(String my_string) {
        String answer = "";
        int ascii = 32;
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if((int)c >= 97){
                answer+=(char)(c-32);
            }else{
                answer+=(char)(c+32);
            }
        }
        return answer;
    }
}