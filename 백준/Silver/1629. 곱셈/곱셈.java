import java.util.*;
import java.io.*;

class Main {
	static int A, B, C;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B));
	}

    public static long pow(long A, long exponent) {

        if (exponent == 1) {
			return A % C;
		}

        long temp = pow(A, exponent / 2);

		if (exponent % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}
}