import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Long> arr;
	public static LinkedList<Long> st1;
	public static LinkedList<Long> st2; // idx
	public static int n;
	public static long max;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			arr = new ArrayList();
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			// idx 계산 1부터
			arr.add(0L);
			for (int i = 1; i <= n; i++) {
				arr.add(Long.parseLong(st.nextToken()));
			}
			// 입력 끝
			st1 = new LinkedList<>();
			st2 = new LinkedList<>();
			max = Long.MIN_VALUE;
			go();
			System.out.println(max);
		}
	}

	public static void go() {
		for (int i = 1; i <= n; i++) {
			while (!st1.isEmpty()) {
				if (st1.peek() > arr.get(i)) {
					long nowVal = st1.pop();
					long nowIdx = st2.pop();
					long leftIdx = -1L;
					long rightIdx = i - 1;
					if (st2.isEmpty())
						leftIdx = 1; // 2 1 4
					else
						leftIdx = st2.peek() + 1;
					long width = rightIdx - leftIdx + 1;
					long area = width * nowVal;
					max = Math.max(max, area);
				} else {
					break;
				}
			}
			st1.push(arr.get(i));
			st2.push((long) i);
		}
		// 남은 스택 정리
		while (!st1.isEmpty()) {
			Long nowVal = st1.pop();
			Long nowIdx = st2.pop();
			long rightIdx = n; // 오른쪽 끝
			long leftIdx = -1L;
			if (st2.isEmpty()) {
				leftIdx = 1;
			} else {
				leftIdx = st2.peek() + 1;
			}
			long width = rightIdx - leftIdx + 1;
			long area = width * nowVal;
			max = Math.max(max, area);
		}
	}
}