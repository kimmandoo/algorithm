import java.util.*;
import java.io.*;

class Main {
	static int mod;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		mod = Integer.parseInt(st.nextToken());
		// a를 b번 곱한수를 구해야되는데, 매번 c로 나눈 나머지를 남기면서 가면 됨 (오버플로 주의)
		System.out.println(exp(a, b));
	}

	public static long exp(int x, int n) {
		if (n == 1)
			return x % mod;
		if (n % 2 == 0) {
			long y = exp(x, n / 2);
			return (y * y) % mod;
		}
		if (n % 2 == 1) {
			long y = exp(x, (n - 1) / 2);
			return ((y * y)% mod * x)% mod;
		}
		return x % mod;
	}
}