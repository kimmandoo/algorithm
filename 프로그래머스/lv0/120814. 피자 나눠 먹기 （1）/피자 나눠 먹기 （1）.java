class Solution {
    public int solution(int n) {
        int answer = 0;
        final int slice = 7;
        
        if(n<=slice) answer = 1;
        else{
            answer = (int)Math.ceil(n/(double)slice);
        }
        return answer;
    }
}