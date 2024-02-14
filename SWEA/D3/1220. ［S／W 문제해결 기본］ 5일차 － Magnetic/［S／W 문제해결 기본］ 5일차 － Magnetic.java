import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			// 상단이 1, 하단이 2
			int n = sc.nextInt();
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int res = 0;
			// 각 열 조사하면서 상단이 1로 가려지지않은 2, 하단이 2로 가려지지않은 1은 싹 제거.
			for (int i = 0; i < 100; i++) {
				int[] tmp = new int[100];
				int idx = 0;
				for (int j = 0; j < 100; j++) {
					if (idx == 0 && map[j][i] != 0)
						tmp[idx++] = map[j][i];
					if (idx > 0 && map[j][i] != 0 && tmp[idx - 1] != map[j][i]) { // 다른게 올때만 추가하기.
						tmp[idx++] = map[j][i];
					}
				}
				for (int j = 0; j < idx; j++) {
					if (j == 0 && tmp[j] == 2) {
						continue;
					} else if (tmp[j] == 1 && tmp[j + 1] == 0 ) { // 이건 비어있는 거
						break;
					} else {
						j++;
						res += 1;
					}
				}
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}