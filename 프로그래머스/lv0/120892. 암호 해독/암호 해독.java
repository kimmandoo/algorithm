class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        for(int i=code; i<=cipher.length(); i+=code){
            answer += Character.toString(cipher.charAt(i-1));
        }
        return answer;
    }
}