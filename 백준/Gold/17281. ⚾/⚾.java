import java.util.*;
import java.io.*;

public class Main {
	static boolean[] v;
	static int[] output;
	static int max;
	static int n;
	static int[][] inning;

	static void perm(int d) {
		if (d == 9) {
			// 타순을 정했다.
			StringBuilder sb = new StringBuilder();
			int[] tasoon = new int[9];
			tasoon[0] = output[1];
			tasoon[1] = output[2];
			tasoon[2] = output[3];
			tasoon[3] = 0;
			tasoon[4] = output[4];
			tasoon[5] = output[5];
			tasoon[6] = output[6];
			tasoon[7] = output[7];
			tasoon[8] = output[8];
			// 타순 정하기 끝
			int lastBatter = 0;
			// 타순을 고정시켰기 때문에 첫 타자 부터 돌려도 된다.
			int tmp = 0;
			for (int i = 0; i < n; i++) {
				int outCount = 0;
				int jooja = 0;
				int sum = 0;
				boolean one = false;
				boolean two = false;
				boolean three = false;

				while (true) {
					int sunsoo = tasoon[lastBatter++];
					lastBatter = lastBatter % 9;
					if (inning[i][sunsoo] == 0) {
						outCount++;
						if (outCount == 3) {
							break;
						}
					}
					if (inning[i][sunsoo] == 1) {
						if (!one & !two & !three) { // 노 주자
							one = true;
							jooja++;
						} else if (!one & !two & three) { // 3
							three = false;
							sum++;
							one = true;
						} else if (!one & two & three) { // 2,3
							one = true;
							two = false;
							sum++;
						} else if (!one & two & !three) { // 2
							three = true;
							two = false;
							one = true;
							jooja++;
						} else if (one & !two & !three) { // 1
							two = true;
							jooja++;
						} else if (one & two & !three) { // 1,2
							three = true;
							jooja++;
						} else if (one & !two & three) { // 1,3
							sum++;
							three = false;
							two = true;
						} else if (one & two & three) { // 1,2,3
							sum++;
						}
					}
					if (inning[i][sunsoo] == 2) {
						if (!one & !two & !three) { // 노 주자
							two = true;
							jooja++;
						} else if (!one & !two & three) { // 3
							three = false;
							sum++;
							two = true;
						} else if (!one & two & three) { // 2,3
							three = false;
							sum += 2;
							jooja--;
						} else if (!one & two & !three) { // 2
							sum++;
						} else if (one & !two & !three) { // 1
							two = true;
							three = true;
							one = false;
							jooja++;
						} else if (one & two & !three) { // 1,2
							three = true;
							two = true;
							one = false;
							sum++;
						} else if (one & !two & three) { // 1,3
							sum++;
							two = true;
							one = false;
						} else if (one & two & three) { // 1,2,3
							sum += 2;
							one = false;
							jooja--;
						}
					}
					if (inning[i][sunsoo] == 3) {
						if (!one & !two & !three) { // 노 주자
							three = true;
							jooja++;
						} else if (!one & !two & three) { // 3
							three = false;
							sum++;
							three = true;
						} else if (!one & two & three) { // 2,3
							two = false;
							sum += 2;
							jooja--;
						} else if (!one & two & !three) { // 2
							three = true;
							two = false;
							sum++;
						} else if (one & !two & !three) { // 1
							three = true;
							one = false;
							sum++;
						} else if (one & two & !three) { // 1,2
							three = true;
							two = false;
							one = false;
							jooja--;
							sum += 2;
						} else if (one & !two & three) { // 1,3
							sum += 2;
							one = false;
							jooja--;
						} else if (one & two & three) { // 1,2,3
							sum += 3;
							one = false;
							two = false;
							jooja -= 2;
						}
					}
					if (inning[i][sunsoo] == 4) {
						// 홈런 치면 그 전에 쌓아둔 주자 클리어 하고 주자+현재 점수 +1
						one = false;
						two = false;
						three = false;
						sum += jooja + 1;
						jooja = 0;
					}
				}
				// 경기 종료
				tmp += sum;
			}
			max = Math.max(max, tmp);
		}

		for (int i = 1; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				output[d] = i;
				perm(d + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		// A1 부터 An 개 까지의 수 주어짐
		inning = new int[n][9];
		max = 0;
		output = new int[9];
		v = new boolean[9];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(1);
		System.out.println(max);
	}
}