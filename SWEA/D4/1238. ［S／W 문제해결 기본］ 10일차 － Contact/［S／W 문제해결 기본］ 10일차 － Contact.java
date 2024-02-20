import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			int start = sc.nextInt();
			int[][] map = new int[101][101];
			boolean[] v = new boolean[101];
			int[] order = new int[101];
			for (int i = 0; i < len / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}
			LinkedList<Integer> q = new LinkedList();
			q.add(start);
			v[start] = true;
			while (!q.isEmpty()) {
				int parent = q.pollFirst();
				boolean childExist = false;

				for (int i = 1; i <= 100; i++) {
					if (!v[i] && map[parent][i] == 1) {
						q.add(i);
						order[i] = order[parent] + 1;
						childExist = true;
						v[i] = true;
					}
				}

				a: for (int i = 0; i < q.size(); i++) {
					for (int j = 1; j <= 100; j++) {
						if (map[q.get(i)][j] == 1 && !v[j]) {
							childExist = true;
							break a;
						}
					}
				}

				if (!childExist) {
					q.add(parent);
					break;
				}
			}
//			System.out.println(Arrays.toString(order));
//			System.out.println(q.toString());

			int max = 0;
			int idx = 0;
			for (int i = 1; i < order.length; i++) {
				if (order[i] >= max) {
					max = order[i];
					idx = i;
				}
			}
//			for (int i = 0; i < q.size(); i++) {
//				max = Math.max(max, q.get(i));
//			}
			System.out.println("#" + test_case + " " + idx);
		}
	}
}