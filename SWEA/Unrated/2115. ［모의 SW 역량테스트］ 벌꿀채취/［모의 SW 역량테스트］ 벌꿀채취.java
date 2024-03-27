import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static int m;
	static int c;

	static int[][] map;
	static int min;
	static boolean[][] v;
	static int[] worker;
	static List<Integer> ggultong;
	static int[] out;
	static int ggulMax;
	static int totalMax;
	static int totalSum;
	static int sumA, sumB;

//	static int ggul(int si, int sj) {
//		ggultong = new ArrayList<Integer>();
//		for (int i = 0; i < m && sj + i < n; i++) { // 현재 위치에서 m 범위를 벗어나지 않도록 함
//			ggultong.add(map[si][sj + i]);
//		}
//
//		ggulMax = -1;
//		for (int i = 1; i <= m && i <= ggultong.size(); i++) { // 벌통이 m보다 작을 수 있음에 대한 처리 추가
//			out = new int[i];
//			ggulCombi(i, 0);
//		}
//		return ggulMax;
//	}

	static int ggul(int a, int b) {
		// 최대 벌꿀양을 구하자
		sumA = 0;
		for (int r = 1; r <= m; r++) {
			// i 만큼 뽑아보자
			combination(a, a + m, r, 0, 0, 0, 1);
		}
		sumB = 0;
		for (int r = 1; r <= m; r++) {
			combination(b, b + m, r, 0, 0, 0, 2);
		}

		return sumA + sumB;
	}

	static void combination(int start, int end, int r, int depth, int sum, int rev, int type) {
		if (depth == r) {
			if (sum > c)
				return;
			if (type == 1)
				sumA = Math.max(sumA, rev);
			else
				sumB = Math.max(sumB, rev);
			return;
		}
		for (int i = start; i < end; i++) { // 연속 채취하면 그냥 뽑으면 됨
			int h = map[i / n][i % n]; // 현재 좌표의 꿀통 값
			combination(i + 1, end, r, depth + 1, sum + h, rev + h * h, type);
		}
	}

//	static void ggulCombi(int depth, int start) {
//		if (depth == 0) {
//			// output에는 ggultong의 idx값 보기
//			int sum = 0;
//			for (int i = 0; i < out.length; i++) {
//				int cur = ggultong.get(out[i]);
//				if (cur <= c) {
//					sum += cur * cur;
//				}
//			}
//			ggulMax = Math.max(ggulMax, sum);
//			return;
//		}
//		for (int i = start; i < m; i++) {
//			out[start] = i;
//			ggulCombi(depth - 1, start + 1);
//		}
//	}

	static void dfs(int depth, int idx) {
		// 도착 지점 2개 뽑기
		if (depth == 2) {
			// 벌통 겹치는 지 검사하기
			if (worker[0] >= worker[1] - (m - 1)) { // 같은 줄에 있을 때 겹친다면
				return;
			}
			// i 좌표에서 벌통크기 만큼 늘린 위치가 한 줄에 있어야 한다.
			if ((worker[0] + m - 1) / n != worker[0] / n || (worker[1] + m - 1) / n != worker[1] / n) {
				return;
			}

			// 벌통을 잘 찾았다는 의미
			// 이제 각 벌통 위치부터 m만큼 돌면서 보기.

			int honey = ggul(worker[0], worker[1]);
			totalMax = Math.max(honey, totalMax);
			return;
		}
		for (int i = idx; i < n * n; i++) {
			worker[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			totalMax = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			worker = new int[2];
			v = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);

			System.out.println("#" + tc + " " + totalMax);
		}
	}
}