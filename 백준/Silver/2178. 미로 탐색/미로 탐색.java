import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
//https://www.acmicpc.net/problem/2589
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][k];
		int[][] order = new int[n][k];
		boolean[][] v = new boolean[n][k];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < k; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		int max = 0;
		v = new boolean[n][k];
		order = new int[n][k];
		LinkedList<int[]> q = new LinkedList();
		q.add(new int[] { 0, 0 });
		v[0][0] = true;
		order[0][0] = 1; // 시작점도 세니까
		while (!q.isEmpty()) {
			int[] node = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				if (nx < n && nx >= 0 && ny < k && ny >= 0 && map[nx][ny] == '1' && !v[nx][ny]) {
					q.add(new int[] { nx, ny });
					order[nx][ny] = order[node[0]][node[1]] + 1;
					v[nx][ny] = true;
				}
			}
//			System.out.println("x:" + node[0] + " y:" + node[1]);
		}
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < k; b++) {
				if (max < order[a][b]) {
					max = order[a][b];
				}
			}
		}

		System.out.println(order[n-1][k-1]);

		br.close();
	}
}