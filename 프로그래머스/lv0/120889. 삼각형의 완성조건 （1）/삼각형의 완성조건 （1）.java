class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = 0;
        int sidesSum = 0;
        for(int i=0; i<sides.length; i++){
            sidesSum += sides[i];
            if(max < sides[i]) max = sides[i];
        }
        if(max < sidesSum-max){
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}