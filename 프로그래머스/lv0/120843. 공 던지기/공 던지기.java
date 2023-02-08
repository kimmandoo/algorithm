class Solution {
    public int solution(int[] numbers, int k) {
        // numbers는 동그랗게 말려있음 %len 유지
        int len = numbers.length;
        int answer = 0;
        int idx = 0;
        
        for(int i=0; i<k; i++){
            idx+=2;
            if(idx >= len){idx = idx%len;}
        } // idx는 맞는 사람임.
        
        idx-=2;
        if(idx < 0){
            idx = len + idx;
        }
        
        answer = numbers[idx];
        
        return answer;
    }
}