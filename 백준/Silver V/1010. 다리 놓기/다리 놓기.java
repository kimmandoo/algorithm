import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

	static int a;
	static int b;
	static BigInteger mom;
	static BigInteger son;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int k = 0; k < n; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			mom = BigInteger.ONE;
			son = BigInteger.ONE;
			if (a >= b) {
				// aCb
				if (b > a / 2) {
					b = a - b;
				}
				for (int i = 1; i <= b; i++) {
					mom = mom.multiply(new BigInteger(String.valueOf(a-i+1)));
					son = son.multiply(new BigInteger(String.valueOf(i)));
				}
				mom = mom.divide(son);

			} else { // a<b
				if (a > b / 2) {
					a = b - a;
				}
				for (int i = 1; i <= a; i++) {
					mom = mom.multiply(new BigInteger(String.valueOf(b-i+1)));
					son = son.multiply(new BigInteger(String.valueOf(i)));
				}
				mom = mom.divide(son);
			}
			System.out.println(mom);
		}
		br.close();
	}
}