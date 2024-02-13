import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
	
		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int[][] map = new int[100][100];
			int x = 0;
			int y = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					int tmp = sc.nextInt();
					if (tmp == 2) {
						x = i;
						y = j;
					}
					map[i][j] = tmp;
				}
			}

// 시작점은 target이다. -> 올라오면서 x == 0이고 [x][y+1] [x][y-1] 인 x,y를 찾으면 완료.
			while (x > 0) {
// 기본동작은 위로 올라가는 것(양 옆이 비어있다면(0이라면))
				if (y + 1 < 100 && map[x][y + 1] == 1) { // 오른쪽일 때
					while (true) {
						if (y + 1 < 100 && map[x][y + 1] == 1) {
							y++;
						} else {
							break;
						}
					}
				} else if (y - 1 >= 0 && map[x][y - 1] == 1) {
					while (true) {
						if (y - 1 >= 0 && map[x][y - 1] == 1) {
							y--;
						} else {
							break;
						}
					}
				}

				if (y < 100 && map[x - 1][y] == 1) {
					x--;
				}
			}
			System.out.println("#" + tc + " " + y);
		}
	}
}