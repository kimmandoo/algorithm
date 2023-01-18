class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(int)Math.ceil(n/2.0)];
        int idx = 0;
        for(int i=0; i<=n;i++){
            if(i%2 != 0) answer[idx++] = i;
        }
        return answer;
    }
}