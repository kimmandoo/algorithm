import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static class Node {
		int i;
		int j;
		int t;

		Node(int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.t = t;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + i + "," + j + ":" + t + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) { // 수영장 입력받기
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine(), " ");
			Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			Queue<Node> q = new LinkedList();
			q.add(start);
			int time = -1;
			boolean[][] v = new boolean[n][n];
			v[start.i][start.j] = true;
			a: while (!q.isEmpty()) {
				Node cur = q.poll();
//				System.out.println(cur.i + ", " + cur.j + "||" + cur.t);

				if (map[cur.i][cur.j] == 2 && (cur.t) % 3 != 0) {
					cur.t++;
//					System.out.println("conti" + cur.i + ", " + cur.j + "||" + cur.t);
					q.add(cur);
					continue;
				}
				// cur가 2면 분기 처리
				if (cur.i == end.i && cur.j == end.j) {
					time = cur.t;
					break a;
				}
				int curTime = cur.t;
				for (int i = 0; i < 4; i++) {
					int ni = cur.i + di[i];
					int nj = cur.j + dj[i];
					if (ni < n && nj < n && ni >= 0 && nj >= 0 && !v[ni][nj] && map[ni][nj] != 1) {
//						System.out.println(ni + ", " + nj);
						q.add(new Node(ni, nj, curTime + 1));
						v[ni][nj] = true;
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(time).append("\n");
		}

		System.out.println(sb);
	}
}