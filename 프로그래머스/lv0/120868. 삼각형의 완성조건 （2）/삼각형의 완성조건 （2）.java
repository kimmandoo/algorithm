class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int max = sides[0]+sides[1] - 1;
        if(sides[0]>=sides[1]){
            answer += max-sides[0] -1;
            answer += sides[0] - (sides[0] - sides[1] + 1) + 1;
        }
        else{
            answer += max-sides[1] -1;
            answer += sides[1] - (sides[1] - sides[0] + 1) + 1;
        }
        
        
        return answer+1;
    }
}