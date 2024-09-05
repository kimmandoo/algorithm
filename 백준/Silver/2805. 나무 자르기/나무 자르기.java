import java.io.*;
import java.util.*;

public class Main {
	static int[] namu;
	static int n;
	static int c;
	
	// 작은 범위로 쪼개서 생각하는 습관을 기르자
	static long count(int m) { // 자른 나무 개수 세기
		// m은 중간나무 크기다.
		long cnt = 0; // cnt가 int 범위를 넘어선다.
		for (int i = 0; i < n; i++) { // n개의 나무를 다 돌면서(100만까지라 무난하다)
		// 이분탐색 돌릴거라서 nlogn이다
			long d = namu[i] - m; // m 기준으로 나무를 다 잘라본다.
			if (d > 0) { // m 이상인거만 싹 자르는 것
				cnt+=d;
			}
		}
		return cnt; // m이상인 나무를 싹 잘라서 합친 수
	}

	static int parametric() {
		int l = 0;
		int r = namu[n-1]; // 끝 원소인데, 오름차순 정렬했으니까 제일 큰 나무가 될 것
		
		int ans = 0;

		while (l <= r) {
			int m = (l + r) / 2;
			long cnt = count(m); // 길이를 m만큼 자르면?
			if (cnt >= c) { // 나무가 c랑 딱 맞다
				// c보다 
				ans = m;
				l = m + 1;
			} else { // 작으니까 H를 좀 줄이자.
				r = m - 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken()); // 자른 나무 총 합

		namu = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			namu[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(namu); //이분탐색을 위해서 오름차순으로 정렬한다.
		System.out.println(parametric());
	}
}