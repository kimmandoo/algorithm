class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        int size = my_string.length();
        for(int i=0; i<size; i++){
            char let = letter.charAt(0);
            if((my_string.charAt(i)) == let){
                continue;
            }else{
                answer += my_string.charAt(i);
            }
        }
        
        return answer;
    }
}