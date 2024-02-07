import java.util.*;

class Main {
	// https://www.acmicpc.net/problem/1012

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 }; // 사방 돌기
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int baechu = sc.nextInt();
			// nxm 이 자연스럽다.
			map = new int[n][m];
			v = new boolean[n][m];

			int sum = 0;

			for (int i = 0; i < baechu; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!v[i][j] && map[i][j] == 1) {
						sum++;
						bfs(i, j);
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

		sc.close();
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		v[x][y] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && map[nx][ny] == 1) {
					q.offer(new int[] { nx, ny });
					v[nx][ny] = true;
				}
			}
		}
	}
}