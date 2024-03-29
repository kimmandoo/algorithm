import java.util.*;
import java.io.*;

public class Solution {
	static int d, w, k;
	static int[][] map;
	static boolean[][] v;

	static boolean check(int[][] cp) {
		// 세로로 연속한 k가 존재하면 그 col은 통과
		for (int c = 0; c < w; c++) {
			int cntA = 0;
			int cntB = 0;
			for (int r = 0; r < d - 1; r++) {
				// k이상 연속한게 있는 지 체크
				int tmpA = 1;
				int tmpB = 1;
				for (int i = r; i < d - 1; i++) {
					if (cp[i][c] == cp[i + 1][c]) {
						if (cp[i][c] == 0)
							tmpA++;
						else
							tmpB++;
					} else {
						break;
					}
				}

				cntA = Math.max(tmpA, cntA);
				cntB = Math.max(tmpB, cntB);
				if (cntA >= k || cntB >= k) {
					// 한번 있으면 탈출 -> 좀 빨라지게
					break;
				}
			}
			if (cntA < k && cntB < k) {
				return false;
			}
		}
		return true;
	}

	static int[] subset;
	static int min;

	// 부분집합 생성
	static void generateSubsets(int index, int n, int[] pickedRow) {
		if (index == n) {
			// pickedRow에 subset을 모두 해보기
			int[][] cpMap = new int[d][w];
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					cpMap[i][j] = map[i][j];
				}
			}

			for (int i = 0; i < n; i++) {
				// pickRow의 값에 있는 idx번째 row를 subset의 값으로 넣어주자
				for (int r = 0; r < w; r++) {
					cpMap[pickedRow[i]][r] = subset[i];
				}
			}
			// subset값으로 cpMap이 됨
			if(check(cpMap)) {
				min = Math.min(min, n);
			}
			return;
		}
		subset[index] = 0;
		generateSubsets(index + 1, n, pickedRow);
		subset[index] = 1;
		generateSubsets(index + 1, n, pickedRow);
	}

	static int[] pick;

	static void rowpick(int depth, int r, int start) {
		if (depth == r) {
			// r개의 row idx 뽑기
			int[] rowIdx = new int[r];
			for (int i = 0; i < r; i++) {
				rowIdx[i] = pick[i];
			}
			generateSubsets(0, r, rowIdx);
			return;
		}
		for (int i = start; i < d; i++) {
			pick[depth] = i;
			rowpick(depth + 1, r, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[d][w]; // dxw = nxm
			subset = new int[d];
			pick = new int[d];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<=k; i++) {
				rowpick(0, i, 0);
				if(min != Integer.MAX_VALUE) break;
			}
//			check();
			System.out.println("#" + tc + " " + min);
		}
	}
}