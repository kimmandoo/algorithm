import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static boolean[] c;
	static double max;
	static int[][] m;

	static void go(int row, double acc) {
		if (row == n) {
			max = Math.max(max, acc * 100);
			return;
		}
		
		if (max >= acc * 100) {
			// 가지치기를 여기서 해야됨........................................................
            return;
        }
		
		for (int col = 0; col < n; col++) {
			if (c[col]||m[row][col] == 0) // divide by zero 피하기
				continue;
			c[col] = true;
			acc *= (m[row][col] * 0.01);
			go(row + 1, acc);
			acc /= (m[row][col] * 0.01);
			c[col] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			m = new int[n][n];
			c = new boolean[n];
			max = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 초기화 끝
			go(0, 1.0);
			sb.append("#").append(test_case).append(" ").append(String.format("%.6f", max)).append("\n");
		}
		System.out.println(sb);
	}
}