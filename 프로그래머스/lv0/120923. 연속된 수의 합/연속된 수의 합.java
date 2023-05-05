class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int n = num; // 항 개수
        int a = 0; // 초항
        int d = 1; // 연속된 수니까 공차는 1 -> 고려할 필요없음
        
        a = ((total*2)/n - (n-1))/2;
        for(int i=0; i<num; i++){
            answer[i] = a++;
        }
        
        return answer;
    }
}