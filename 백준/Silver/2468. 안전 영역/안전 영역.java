import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
//https://www.acmicpc.net/problem/2468
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] v;

		int max = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				max = Math.max(k, max);
			}
		}
		max--;
		int safe = 0;
		while (max >= 0) {	
			v = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > max && !v[i][j]) {
						LinkedList<int[]> q = new LinkedList();
						q.add(new int[] { i, j });
						v[i][j] = true;
						while (!q.isEmpty()) {
							int[] node = q.poll();
							for (int d = 0; d < 4; d++) {
								int nx = node[0] + dx[d];
								int ny = node[1] + dy[d];
								if (nx < n && nx >= 0 && ny < n && ny >= 0 && map[nx][ny] > max && !v[nx][ny]) {
									q.add(new int[] { nx, ny });
									v[nx][ny] = true;
								}
							}
						}
						cnt++;
					}
				}
			}
			max--;
			if (safe < cnt) {
				safe = cnt;
			}
		}

		System.out.println(safe);
		br.close();
	}
}