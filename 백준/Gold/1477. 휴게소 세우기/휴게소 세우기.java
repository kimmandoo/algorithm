import java.util.*;
import java.io.*;

class Main {
	static int n, m, l;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		// 이진탐색 준비 끝
		// 고속도로 양 끝에는 휴게소를 못세운다.
		System.out.println(binarySearch());
	}

	static boolean buildRestArea(int dist) { // 얘가 결정조건
		int cnt = 0; // M개 지으면 끝
		int last = 0;
		for (int i = 0; i < n; i++) {
			int idx = arr[i];
			cnt += (idx - last - 1) / dist;
//			while (idx - last > dist) { // 입력받은 거리보다 크면 휴게소 설치가 가능하다
//				last += dist; // 마지막 이동거리 기록
//			}
			if (cnt > m)
				return false;
			last = idx;
		}
		cnt += (l - last - 1) / dist;
		return cnt <= m;
	}

	static int binarySearch() {
		int left = 1;
		int right = l; // L, R은 고속도로 양끝
		int distMin = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (buildRestArea(mid)) {
				distMin = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return distMin;
	}
}
