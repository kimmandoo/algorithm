import java.util.*;
import java.io.*;

class Main {
	static int mod;
	static int[][] map;
	static int white, blue;

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
		white = blue = 0;
		go(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void go(int ci, int cj, int n) {
		if (n == 1) {
			if (map[ci][cj] == 1)
				blue++;
			else
				white++;
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
			if (base == 1)
				blue++;
			else
				white++;
			return;
		}
		go(ci, cj, n / 2);
		go(ci, cj + n / 2, n / 2);
		go(ci + n / 2, cj, n / 2);
		go(ci + n / 2, cj + n / 2, n / 2);
	}
}