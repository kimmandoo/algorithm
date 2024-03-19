import java.util.*;
import java.io.*;

public class Solution {
	static int[] target;
	static int n;
	static int max;

	static void swap(int l, int r) {
		int tmp = target[l];
		target[l] = target[r];
		target[r] = tmp;
	}

	static void findDFS(int left, int depth, int rep) { // 조합
		if (depth == rep) {
			StringBuilder res = new StringBuilder();
			for (int i : target) {
				res.append(i);
			}
			int tmp = Integer.parseInt(res.toString());
			max = Math.max(max, tmp);
			return;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					swap(i, j);
					findDFS(i, depth + 1, rep);
					swap(i, j);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;

		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			char[] input = st.nextToken().toCharArray();
			target = new int[input.length];
			int idx = 0;
			for (int i : input) {
				target[idx++] = i - '0';
			}
			n = target.length;
			max = 0;
			int rep = Integer.parseInt(st.nextToken());
			// 입력끝
			if (rep > n) {
				findDFS(0, 0, n);
				findDFS(0, 0, rep - n);
			} else {
				findDFS(0, 0, rep);
			}

			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}