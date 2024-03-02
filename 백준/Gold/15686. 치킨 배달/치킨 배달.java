import java.util.*;
import java.io.*;

public class Main {
	static int min;
	static List<int[]> hs;
	static List<int[]> cs;
	static int[] mChickhen;
	static boolean[] v;
	static int m;
	static List<int[]> selected;

	public static int dist(int[] home, int[] chickhen) {
		return Math.abs(home[0] - chickhen[0]) + Math.abs(home[1] - chickhen[1]);
	}

	public static int find(int[] home) {
		int tmp = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			// m개 중에 뽑아야됨.
			int tmpD = dist(home, selected.get(i));
			if (tmp > tmpD) {
				tmp = tmpD;
			}
		}
		return tmp;
	}

	public static int findAll() {
		int res = 0;
		for (int i = 0; i < hs.size(); i++) {
			res += find(hs.get(i));
		}
		return res;
	}

	// 이제 치킨집 M개로 줄일 차례
	public static void combi(int start, int target) {
		if (target == 0) {
			// 다 뽑았다.
			StringBuilder sb = new StringBuilder();
			selected = new ArrayList<>();
			for (int i = 0; i < cs.size(); i++) {
				if (v[i]) {
					selected.add(cs.get(i));
				}
			}
			min = Math.min(min, findAll());
		}
		for (int i = start; i < cs.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				combi(i + 1, target - 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mChickhen = new int[m];
		min = Integer.MAX_VALUE;
		hs = new ArrayList<>();
		cs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					// 집
					hs.add(new int[] { i, j });
				}
				if (tmp == 2) {
					// 치킨
					cs.add(new int[] { i, j });
				}
			}
		}
		v = new boolean[cs.size()];

		combi(0, m);
		// 이제 치킨 집을 M개로 줄여야되는데, 도시의 치킨거리가 최솟값이 되어야한다.
		System.out.println(min);
	}
}