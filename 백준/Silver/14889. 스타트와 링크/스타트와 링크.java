import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
	static int team;
	static int n;
	static int[] total;
	static boolean[] v;
	static int[][] map;
	static int min;

	public static void c(int start, int r) { // n개 중 team개 뽑기
		if (r == 0) {
			List<Integer> sTeam = new ArrayList<>();
			List<Integer> lTeam = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (v[i]) {
					sTeam.add(i);
				} else {
					lTeam.add(i);
				}
			}
			int sumS = 0;
			int sumL = 0;
//			System.out.println("L:" + lTeam.toString() + " S:" + sTeam.toString());
			for (int i = 0; i < sTeam.size(); i++) {
				int si = sTeam.get(i);
				int li = lTeam.get(i);
				for (int j = i+1; j < sTeam.size(); j++) {
					int sj = sTeam.get(j);
					int lj = lTeam.get(j);
					sumS += map[si][sj];
					sumS += map[sj][si];
					sumL += map[li][lj];
					sumL += map[lj][li];
				}
			}

//			System.out.println("L:" + sumL + " S:" + sumS);

			min = Math.min(min, Math.abs(sumL - sumS));

			return;
		} else {
			for (int i = start; i < n; i++) {
				v[i] = true;
				c(i + 1, r - 1);
				v[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		team = n / 2;
		total = new int[n];
		v = new boolean[n];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			total[i] = i;
		}
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		c(0, team);
		System.out.println(min);

		br.close();
	}
}