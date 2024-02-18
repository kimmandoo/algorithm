import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			// 16*16
			int[][] map = new int[16][16];
			boolean[][] v = new boolean[16][16];
			int[] start = new int[2];
			for (int i = 0; i < 16; i++) {
				String row = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = row.charAt(j) - '0';
					if (map[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}

			LinkedList<int[]> q = new LinkedList<>();
			q.addLast(start);
			v[start[0]][start[1]] = true;
			int find = 0;
			while (!q.isEmpty()) {
				int[] node = q.pop(); // pollFirst();
				int x = node[0];
				int y = node[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx > 0 && nx < 16 && ny > 0 && ny < 16 && map[nx][ny] !=1 && !v[nx][ny]) {
						q.addLast(new int[] { nx, ny });
						v[nx][ny] = true;
						if (map[nx][ny] == 3) {
							find = 1;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + find);

		}
	}
}