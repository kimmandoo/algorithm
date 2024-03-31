import java.util.*;
import java.io.*;

class Main {

	static int[] sub;
	static int[] input;
	static int s;
	static int res;

	static void subset(int idx, int n) {
		if (idx == n) {
			int tmp = 0;
			boolean isOne = false;
			//StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (sub[i] == 1) {
					isOne = true;
					tmp += input[i];
				}
				//sb.append(sub[i]).append(" ");
			}
			//System.out.println(sb);
			if (tmp == s & isOne)
				res++;

			return;
		}
		
		sub[idx] = 0;
		subset(idx + 1, n);
		sub[idx] = 1;
		subset(idx + 1, n);
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		res = 0;
		sub = new int[n];
		input = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		subset(0, n);
		System.out.println(res);
	}
}