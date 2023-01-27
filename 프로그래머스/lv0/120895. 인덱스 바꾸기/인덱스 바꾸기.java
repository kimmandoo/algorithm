class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        int len = my_string.length();
        for(int i=0; i<len; i++){
            if(i==num1){
                answer+= my_string.charAt(num2);
            }else if(i==num2){
                answer+= my_string.charAt(num1);
            }else{
                answer+= my_string.charAt(i);
            }
        }
        
        return answer;
    }
}