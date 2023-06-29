class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        for(String[] input : db){
            if(input[0].equals(id_pw[0])){
                answer = "wrong pw";
                if(input[1].equals(id_pw[1])){
                    answer = "login";
                    break;
                }
            }
        }
        
        
        return answer;
    }
}