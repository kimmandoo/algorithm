import java.util.*;
import java.io.*;

public class Main {
	static boolean[] v;
	static int[] n;
	static int[] output;
	static boolean c;

	static void perm(int d) {
		if (d == 7) {
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += output[i];
			}
			if (!c && sum == 100) {
				c = true;
				List<Integer> l = new ArrayList<>();
				for (int i = 0; i < 7; i++) {
//					System.out.println(output[i]);
					l.add(output[i]);
				}
				l.sort(null);
				for (Integer i : l) {
					sb.append(i).append("\n");
				}
				System.out.println(sb);
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				output[d] = n[i];
				perm(d + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		n = new int[9];
		c = false;
		output = new int[7];
		v = new boolean[9];
		for (int i = 0; i < 9; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		perm(0);
	}
}