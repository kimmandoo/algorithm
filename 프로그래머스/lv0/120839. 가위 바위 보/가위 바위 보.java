class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(int i=0; i<rsp.length(); i++){
            char c = rsp.charAt(i);
            if(c == '2') answer+= "0";
            if(c == '0') answer+= "5";
            if(c == '5') answer+= "2";
        }
        return answer;
    }
}