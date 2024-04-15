import java.util.*;

class Main {
	static int[][] v;
	static int garoSum;
	static int seroSum;
	static int crossSum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[5][5];
		v = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		garoSum = 0;
		seroSum = 0;
		crossSum = 0;
		int find = 0;
		for (int t = 0; t < 25; t++) {
			int tmp = sc.nextInt();
			int x = 0;
			int y = 0;
			a: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == tmp) {
						x = i;
						y = j;
						v[i][j] = 1;
						if (check(x, y)) {
							System.out.println(t + 1);
							find = 1;
						}
						break a;
					}
				}
			}
			if (find == 1)
				break;
			// check 메서드 하나 두고 true반환이면 break -> 값이 지워지는 곳에서 가로 세로 대각선(이때는 대각일때만)
		}

		sc.close();
	}

	public static boolean check(int x, int y) {
		boolean bingo = false;
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			int garo = 0;
			for (int j = 0; j < 5; j++) {
				if (v[i][j] == 1) {
					garo++;
				}
			}
			if (garo == 5)
				sum++;
		}
		for (int i = 0; i < 5; i++) {
			int sero = 0;
			for (int j = 0; j < 5; j++) {
				if (v[j][i] == 1) {
					sero++;
				}
			}
			if (sero == 5)
				sum++;
		}
		int cross1 = 0;
		int cross2 = 0;
		for (int i = 0; i < 5; i++) {
			cross1 += v[0 + i][0 + i];
		}
		for (int i = 0; i < 5; i++) {
			cross2 += v[0 + i][4 - i];
		}
		if (cross1 == 5)
			sum++;
		if (cross2 == 5)
			sum++;

		if (sum >= 3) {
			bingo = true;
		}

		return bingo;
	}
}