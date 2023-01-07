class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
        
        int de1 = denum1*num2;
        int de2 = denum2*num1;
        int sum = de1+de2;
        int gcd = getGcd(sum, num1*num2);
        
        answer[0]=sum/gcd;
        answer[1]=(num1*num2)/gcd;
        
        return answer;
    }
    public static int getGcd(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGcd(b, a%b);
	}
}