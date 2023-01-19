class Solution {
    public int solution(int n) {
        int answer = 0;
        int slice = 6;
        //n과 slice의 최소공배수를 구하면됨. -> 총 조각수이니까 피자 판수는 /6 해야됨
        answer = n/getGcd(slice, n);
        
        return answer;
    }
    public static int getGcd(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGcd(b, a%b);
	}
}