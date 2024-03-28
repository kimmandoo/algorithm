import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int x; // 경사로 길이 -> 경사로는 가로 x, 세로 1 이다.
	static int[][] map;
	static boolean[][] v;

	public static boolean checkRow(int[] row) {
		boolean[] visited = new boolean[n]; // 방문 여부를 나타내는 배열

		for (int i = 0; i < n - 1; i++) {
			if (row[i] == row[i + 1]) // 현재 위치와 다음 위치의 높이가 같은 경우
				continue;

			if (Math.abs(row[i] - row[i + 1]) > 1) // 높이 차이가 1보다 큰 경우
				return false;

			if (row[i] > row[i + 1]) { // 내리막길인 경우
				for (int j = i + 1; j <= i + x; j++) { // 경사로의 길이만큼 확인
					if (j >= n || row[j] != row[i + 1] || visited[j]) // 범위를 벗어나거나 높이가 다르거나 이미 방문한 경우
						return false;
					visited[j] = true; // 방문 체크
				}
			} else { // 오르막길인 경우
				for (int j = i; j > i - x; j--) { // 경사로의 길이만큼 확인
					if (j < 0 || row[j] != row[i] || visited[j]) // 범위를 벗어나거나 높이가 다르거나 이미 방문한 경우
						return false;
					visited[j] = true; // 방문 체크
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// row 검사
			int res = 0;
			for (int i = 0; i < n; i++) {
				if (checkRow(map[i]))
					res++;
			}
			for (int i = 0; i < n; i++) {
				int[] column = new int[n];
				for (int j = 0; j < n; j++) {
					column[j] = map[j][i];
				}
				if (checkRow(column))
					res++;
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}
