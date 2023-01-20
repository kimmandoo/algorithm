class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++)
        answer += n % i == 0 ? 1 : 0;
        //중복이 허용되므로 따로 고려할 필요없다.
        return answer;
    }
}