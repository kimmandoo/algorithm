import java.util.*;
import java.io.*;

public class Main {
	static int[] nums;
	static char[] ops;
	static boolean[] nv;
	static boolean[] ov;
	static char[] out;
	static int min;
	static int max;

	static void permOps(int d) {
		if (d == nums.length - 1) {
			// 다 뽑음
			StringBuilder sb = new StringBuilder();
			int sum = nums[0];
			int opIdx = 0;
			int numIdx = 1;

			for (int i = 0; i < out.length; i++) {
				if (out[opIdx] == '+') {
					sum += nums[numIdx++];
					opIdx++;
				} else if (out[opIdx] == '-') {
					sum -= nums[numIdx++];
					opIdx++;
				} else if (out[opIdx] == '*') {
					sum *= nums[numIdx++];
					opIdx++;
				} else if (out[opIdx] == '/') {
					sum /= nums[numIdx++];
					opIdx++;
				}
			}
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}

		char prevOp = ' '; // 이전 연산자를 기록하기 위한 변수 추가
		for (int i = 0; i < ops.length; i++) {
			if (!ov[i] && ops[i] != prevOp) { // 중복되지 않고 이전 연산자와 다른 경우에만 진행
				// 한번도 안썼다면
				ov[i] = true;
				out[d] = ops[i];
				permOps(d + 1);
				ov[i] = false; // 함수 호출 이후로는 다른 case도 사용해야되니까 check에 다시 false를 넣는다.
				prevOp = ops[i]; // 현재 연산자를 이전 연산자로 설정
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		// A1 부터 An 개 까지의 수 주어짐
		nums = new int[n];
		nv = new boolean[n];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		out = new char[n - 1];

		char[] oper = new char[] { '+', '-', '*', '/' };
		int p = 0;
		int idx = 0;
		List<Character> o = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			int op = Integer.parseInt(st.nextToken());
			if (op > 0) {
				for (int j = 0; j < op; j++) {
					o.add(oper[p]);
				}
			}
			p++;
		}

		ops = new char[o.size()];
		ov = new boolean[o.size()];
		idx = 0;
		for (char c : o) {
			ops[idx++] = c;
		}
		// 입력받기 끝
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		permOps(0);

		System.out.println(max);
		System.out.println(min);
	}
}