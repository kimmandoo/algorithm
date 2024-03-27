import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static List<Integer> a;
	static List<Integer> b;
	static int[][] map;
	static int min;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			a = new ArrayList();
			b = new ArrayList();
			min = Integer.MAX_VALUE;
			go(0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void go(int idx) {
		if (idx >= n) {
			if (a.size() == b.size()) {
				int aSum = 0;
				int bSum = 0;

				for (int i = 0; i < a.size(); i++) {
					for (int j = 0; j < a.size(); j++) {
						if (i == j)
							continue;
						aSum += map[a.get(i)][a.get(j)];
					}
				}

				for (int i = 0; i < b.size(); i++) {
					for (int j = 0; j < b.size(); j++) {
						if (i == j)
							continue;
						bSum += map[b.get(i)][b.get(j)];
					}
				}
				min = Math.min(min, Math.abs(aSum - bSum));
			}
			return;
		}

		a.add(idx);
		go(idx + 1);
		a.remove(a.size() - 1);

		b.add(idx);
		go(idx + 1);
		b.remove(b.size() - 1);

	}

}
