import java.util.*;
import java.io.*;

public class Main {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int n;
	static int m;
	static int max;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		max = 0;
		List<int[]> blank = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 1은 벽, 0은 빈칸, 2는 바이러스, 경계선도 벽으로 간주함
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) { // 바이러스 기준 탐색
					blank.add(new int[] { i, j });
				}
			}
		}
		// 이제 blank에서 3개 뽑으면 됨
		int len = blank.size();
//		for(int[] i: blank) {
//			System.out.println(Arrays.toString(i));
//		}

		for (int i = 0; i < len; i++) {
			int[] one = blank.get(i);
			for (int j = i + 1; j < len; j++) {
				int[] two = blank.get(j);
				for (int k = j + 1; k < len; k++) {
					int[] three = blank.get(k);
					int[][] copyMap = new int[n][m];
					copy(copyMap, map);
					copyMap[one[0]][one[1]] = 1;
					copyMap[two[0]][two[1]] = 1;
					copyMap[three[0]][three[1]] = 1;
					// 세 개를 골라서, 복사한 map에 넣고, bfs를 돌린다.
					bfs(copyMap);
				}
			}
		}

		System.out.println(max);
	}

	private static void copy(int[][] copy, int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	private static void bfs(int[][] copy) {
		LinkedList<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ni = di[i] + cur[0];
				int nj = dj[i] + cur[1];
				if (ni < n && nj < m && ni >= 0 && nj >= 0 && copy[ni][nj] == 0) {
					q.add(new int[] { ni, nj });
					copy[ni][nj] = 2;
				}
			}
		}
		int safe = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 0) {
					safe++;
				}
			}
		}
		max = Math.max(max, safe);
	}
}