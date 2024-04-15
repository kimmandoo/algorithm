import java.util.*;
import java.io.*;

class Main {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		boolean[][] v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		// 입력받기 끝

		// 적록색약 아닌 사람이 볼때
		// 구역탐색이니까 DFS가 적절할듯
		int terr = 0;
		int rgTerr = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					LinkedList<int[]> s = new LinkedList<>();
					s.add(new int[] { i, j });
					v[i][j] = true;
					while (!s.isEmpty()) {
						int[] node = s.pollLast();
						for (int d = 0; d < 4; d++) {
							int ni = di[d] + node[0];
							int nj = dj[d] + node[1];
							if (ni >= 0 && ni < n && nj >= 0 && nj < n && !v[ni][nj]
									&& map[node[0]][node[1]] == map[ni][nj]) {
								// 같은 영역일때만 영역탐색도록
								s.add(new int[] { ni, nj });
								v[ni][nj] = true;
							}
						}
					}
					terr++;
				}
			}
		}
		v = new boolean[n][n];
		// 적록색약인 사람이 볼때 -> r이나 g하나를 붙여서 봐야됨.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					LinkedList<int[]> s = new LinkedList<>();
					s.add(new int[] { i, j });
					v[i][j] = true;
					while (!s.isEmpty()) {
						int[] node = s.pollLast();
						for (int d = 0; d < 4; d++) {
							int ni = di[d] + node[0];
							int nj = dj[d] + node[1];
							if (ni >= 0 && ni < n && nj >= 0 && nj < n && !v[ni][nj]) {
								// 같은 영역일때만 영역탐색도록
								if (map[node[0]][node[1]] == map[ni][nj]
										|| (map[node[0]][node[1]] == 'G' && map[ni][nj] == 'R')
										|| (map[node[0]][node[1]] == 'R' && map[ni][nj] == 'G')) {
									s.add(new int[] { ni, nj });
									v[ni][nj] = true;
								}

							}
						}
					}
					rgTerr++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(terr).append(" ").append(rgTerr);
		System.out.println(sb);
	}
}