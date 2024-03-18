import java.util.*;
import java.io.*;

public class Solution {
	static int[] code;
	// 0~9까지 패턴
	static int[][] pattern = { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 },
			{ 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2, }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };

	static int findPattern(String input) {
		int[] ratio = new int[4];
		int idx = 0;
		// 시작은 하나 추가하고 시작
		ratio[0] = 1;

		for (int i = 1; i < 7; i++) {
			if (input.charAt(i) != input.charAt(i - 1)) {
				ratio[++idx]++;
			} else {
				ratio[idx]++;
			}
		}

		int find = 0;
		for (int[] p : pattern) {
			if (p[0] == ratio[0] && p[1] == ratio[1] && p[2] == ratio[2] && p[3] == ratio[3]) {
				break;
			}
			find++;
		}

		return find;
	}

	static int findCode() {
		int odd = 0, even = 0;
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += code[i];
			if (i % 2 == 0) {
				odd += code[i];
			} else {
				even += code[i];
			}
		}
		sum += code[7];
		int tmpCode = odd * 3 + even + code[7];
		if (tmpCode % 10 == 0) {
			return sum;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				String row = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = row.charAt(j) - '0';
				}
			}
			code = new int[8];
			// 입력 다 받음
			// 탐색할건데, 맨 뒤에서 부터 한줄씩
			a:for (int i = 0; i < n; i++) {
				for (int j = m - 1; j > 0; j--) {
					if (map[i][j] == 1) {
						// 이제 56개 돌기
						int idx = 0;
						StringBuilder hex = new StringBuilder();
						int start = j - 56 + 1;
						for (int k = start; k < start+56; k++) {
							// 이제 7개씩 자르면서 패턴 넣어보면 됨
							hex.append(map[i][k]);
							if (hex.length() == 7) {
								code[idx++] = findPattern(hex.toString());
								hex = new StringBuilder();
							}
						}
						sb.append("#").append(test_case).append(" ").append(findCode()).append("\n");
						break a;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
