import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static Jewelry[] jewerly;
	static int[] bag;
	static int[][] dp;

	static class Jewelry {
		int w; // 무게
		int v; // 가격

		Jewelry(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// 보석 정보 받기
//		jewerly = new int[n + 1][2]; // 1번째 보석 ~ n번째 보석

		jewerly = new Jewelry[n];
		bag = new int[k]; // 1번째 가방
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " "); // i번째 보석의 정보
			jewerly[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//			jewerly[i].w = Integer.parseInt(st.nextToken()); // 무게
//			jewerly[i].v = Integer.parseInt(st.nextToken()); // 가치
		}

		Arrays.sort(jewerly, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				if (o1.w == o2.w) { // 무게가 같으면 가치 순으로 (그리디 접근)
					return o2.v - o1.v;
				}
				return o1.w - o2.w;
			}

		});
		for (int i = 0; i < k; i++) {
			// i번째 가방이 최대로 담을 수 있는 무게
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bag);

//		dp = new int[k + 1][bag[k] + 1];

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1; // 첫 요소가 항상 가장 큰 가격이 되도록 내림차순 maxHeap
		});

		long max = 0; // 가격*무게가 INT값 벗어남...
		for (int i = 0, j = 0; i < k; i++) { // 가방개수만큼
			// 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
			while (j < n && jewerly[j].w <= bag[i]) { // 보석 개수만큼
				pq.offer(jewerly[j++].v);
			}

			if (!pq.isEmpty()) {
				max += pq.poll();
			}
		}

//		int res = 0;
//		for (int i = 1; i <= n; i++) {
//			// N개의 배낭
//			for (int w = 1; w <= bag[k]; w++) { // 최대 k 무게를 담을 때까지 반복한다
//				if (jewerly[i][0] > w) {
//					// 물건을 담을 수 없는 경우다
//					// 이 경우 그냥 이전 물건을 담을 상태를 넣어준다(물건 안 담을 거니까)
//					dp[i][w] = dp[i - 1][w]; // 무게가 들어가는게 아니라 가치가 들어간다
//				} else {
//					// 물건을 담을 수 있는 경우다
//					// 이전 물건을 담은 상태가 지금 물건을 담을 경우와 비교했을 때 더 크면, 물건을 안담고 넘어간다
//					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - jewerly[i][0]] + jewerly[i][1]);
//				}
//				System.out.println(dp[i][w]);
//			}
//		}

		System.out.println(max);
		// 각 가방에는 보석을 하나만 넣을 수 있다.**
		// 각 가방이 항상 넣을수있는 무게 중에 가장 가치가 높은걸 담고있으면 될 것

	}
}