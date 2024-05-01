import java.util.*;
import java.io.*;

class Main {
	static int mod;
	static int[][] map;
	static int[] res;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = new int[3]; // -1, 0, 1 개수 넣기
		go(0, 0, n);
		for(int i: res) {
			System.out.println(i);
		}
	}

	public static void go(int ci, int cj, int n) {
		if (n == 1) {
			if (map[ci][cj] == -1) {
				res[0]++;
			} else if (map[ci][cj] == 0) {
				res[1]++;
			} else {
				res[2]++;
			}
			return;
		}
		boolean check = true;
		int base = map[ci][cj];
		a: for (int i = ci; i < ci + n; i++) {
			for (int j = cj; j < cj + n; j++) {
				if (base != map[i][j]) {
					check = false;
					break a;
				}
			}
		}
		if (check) {
			if (map[ci][cj] == -1) {
				res[0]++;
			} else if (map[ci][cj] == 0) {
				res[1]++;
			} else {
				res[2]++;
			}
			return;
		}
		go(ci, cj, n / 3);
		go(ci, cj + n / 3, n / 3);
		go(ci, cj + 2 * n / 3, n / 3); // 위에 세줄
		go(ci + n / 3, cj, n / 3);
		go(ci + n / 3, cj + n / 3, n / 3);
		go(ci + n / 3, cj + 2 * n / 3, n / 3); // 가운데 세줄
		go(ci + 2 * n / 3, cj, n / 3);
		go(ci + 2 * n / 3, cj + n / 3, n / 3);
		go(ci + 2 * n / 3, cj + 2 * n / 3, n / 3);
	}
}