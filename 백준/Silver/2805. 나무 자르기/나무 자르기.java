import java.io.*;
import java.util.*;

public class Main {
	static int[] namu;
	static int n;
	static int c;

	static long count(int m) { // 자른 나무 개수 세기
		long cnt = 0; 
//		int h = namu[0]; // 순회 돌 준비 

		for (int i = 0; i < n; i++) {
			long d = namu[i] - m; // 나무 자르기
			if (d > 0) {
				cnt+=d;
			}
		}
		return cnt;
	}

	static int parametric() {
		int l = 0;
		int r = namu[n-1];
		
		int ans = 0;

		while (l <= r) {
			int m = (l + r) / 2;
			long cnt = count(m); // 길이를 m만큼 자르면?
			if (cnt >= c) { // 나무가 c랑 딱 맞다.
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
		// 그래프 초기화
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			namu[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(namu);
//		System.out.println(Arrays.toString(namu));

		System.out.println(parametric());
	}
}