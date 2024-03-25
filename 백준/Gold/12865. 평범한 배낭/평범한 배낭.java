import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 물품의 수
		int k = Integer.parseInt(st.nextToken()); // 최대 무게

		int[][] dp = new int[n + 1][k + 1]; // 용량이 k인 배낭이고, 각 row의 인덱스에는 해당 용량일 때의 가치값이 들어가있다.
		int[][] input = new int[n + 1][2]; // 각 물건의 0-무게, 1-가치
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// i번째 물건의 무게, 가치
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			input[i][0] = weight;
			input[i][1] = value;
		}

		// 평범한 배낭
		for (int i = 1; i <= n; i++) {
			// N개의 배낭
			for (int w = 1; w <= k; w++) { // 최대 k 무게를 담을 때 때까지 반복한다
				if (input[i][0] > w) { // 물건을 담을 수 없는 경우다
					// 이 경우 그냥 이전 물건을 담을 상태를 넣어준다(물건 안 담을 거니까)
					dp[i][w] = dp[i - 1][w]; // 무게가 들어가는게 아니라 가치가 들어간다
				}
				else { // 물건을 담을 수 있는 경우다 
					// 이전 물건을 담은 상태가 지금 물건을 담을 경우와 비교했을 때 더 크면, 물건을 안담고 넘어간다 
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - input[i][0]] + input[i][1]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}