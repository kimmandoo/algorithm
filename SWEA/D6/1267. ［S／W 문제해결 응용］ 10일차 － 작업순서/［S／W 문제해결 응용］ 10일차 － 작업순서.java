import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int[] inbounds;
	static int[] outbounds;
	static int[][] map;
	static boolean[] visited;
	static int v, e;

	public static void dfs(int start) {
		if (!visited[start]) {
			visited[start] = true;
			System.out.print(start + " ");
		}
		for (int i = 1; i <= v; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				if (inbounds[i] > 1) {
					inbounds[i]--;
				} else if (inbounds[i] == 1) {
					inbounds[i]--;
					dfs(i);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			inbounds = new int[1001];
			outbounds = new int[1001];
			v = sc.nextInt(); // 정점 개수
			e = sc.nextInt(); // 간선 개수
			map = new int[v + 1][v + 1];
			visited = new boolean[v + 1];

			for (int i = 0; i < e; i++) {
				int st = sc.nextInt();
				int en = sc.nextInt();
				map[st][en] = 1;
				outbounds[st]++;
				inbounds[en]++;
			}
			// dfs를 돌건데, inbounds가 0인 정점을 찾아서 출력하고 outbounds인 간선 끊어 버리기. map[en][n] -> n개
			System.out.print("#" + test_case + " ");
			for (int i = 1; i <= v; i++) {
				if (!visited[i] && inbounds[i] == 0) {
					// dfs 시작점 - 진입차수가 0 인 것
					dfs(i);
				}
			}
			System.out.print("\n");

		}
	}
}