import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		LinkedList<int[]> q = new LinkedList();
		int tomatos = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] { i, j, 0 });
				}
				if (map[i][j] == 0) {
					tomatos++;
				}
			}
		}
		int day = 0;
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			day = cur[2];
			for (int i = 0; i < 4; i++) {
				int ni = di[i] + cur[0];
				int nj = dj[i] + cur[1];
				if (ni < n && nj < m && ni >= 0 && nj >= 0) {
					if (map[ni][nj] == 0) {
						map[ni][nj] = 1;
						q.add(new int[] { ni, nj, day + 1 });
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]== 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(day);

	}
}
