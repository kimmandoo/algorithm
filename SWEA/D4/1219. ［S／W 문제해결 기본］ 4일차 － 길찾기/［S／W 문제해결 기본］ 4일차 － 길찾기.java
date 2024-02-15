import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] v;
	static int[][] map;
	static int res = 0;

	static void dfs(int node) {
		v[node] = true;
		for (int i = 0; i < 100; i++) {
			if (map[node][i] == 1 & !v[i]) {
				dfs(i);
				if (i == 99)
					res = 1;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int pair = sc.nextInt();
			map = new int[100][100];
			v = new boolean[100];
			for (int i = 0; i < pair; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			res = 0;
			dfs(0);

			System.out.println("#" + tc + " " + res);
		}
	}
}