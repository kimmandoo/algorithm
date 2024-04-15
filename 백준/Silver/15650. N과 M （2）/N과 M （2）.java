import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] num;
	static int[] result;
	static boolean[] v;

	public static void pmt(int depth, int start) {
		if (depth == m + 1) {
			// 오름차순 순열만 필터링
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= m; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		for (int i = start; i <= n; i++) {
			if (!v[i]) {
				v[i] = true;
				result[depth] = num[i];
				pmt(depth + 1, i + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n + 1];
		result = new int[m + 1];
		v = new boolean[n + 1];
		// n개 중 m개를 고른 수열, 수열의 출력은 사전순으로.
		for(int i=1; i<=n; i++){
            num[i] = i;
        }
		Arrays.sort(num);
		// 재귀
		// pmt(1);
		// DFS로 풀기(백트래킹)
//		dfs(1,1);
		pmt(1, 1);
	}
}