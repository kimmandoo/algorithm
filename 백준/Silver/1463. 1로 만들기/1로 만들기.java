import java.util.*;
import java.io.*;

public class Main {
	static Integer[] dp;

	static int recur(int n) {
		if (dp[n] == null) { // 현재 값이 0이면 연산 안함 -> primitive라 0이 안됨
			if (n % 6 == 0) { // 최대공약수
				dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1; 
			} else if (n % 3 == 0) {
				dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1; // n-1과 의 위치를 바꾸면 재귀 도는 횟수가 매우 많아짐
			} else if (n % 2 == 0) {
				dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
			} else {
				dp[n] = recur(n - 1) + 1; 
			}
		}
		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		dp = new Integer[n + 1];
		dp[0]=dp[1]= 0; // 왜? -> 초기화 안하면 dp[-1]이 발생함. 또 0을 더하지는 않으므로 dp[0]일때도 봐야됨.
		bw.write(recur(n)+"");
		bw.flush();
	}
}