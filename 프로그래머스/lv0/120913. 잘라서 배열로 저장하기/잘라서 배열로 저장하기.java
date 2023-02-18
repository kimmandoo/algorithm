class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int a;
        if(len % n == 0){
            a = len/n;
        }else{
            a = len/n+1;
        }
        String[] answer = new String[a];
        String input = my_str;
        int idx = 0;
        
        while(input.length() > 0){
            if(input.length() <= n){
                answer[idx] = input;
                break;
            }else{
                answer[idx++] = input.substring(0,n);
                input = input.substring(n);
            }
        }
        
        return answer;
    }
}