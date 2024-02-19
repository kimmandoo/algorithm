import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

	static boolean[] v;
	static int[] spooling;
	static long[] output;
	static int min;

//	public static void perm(int depth) {
//		// base case
//		if (depth == v.length) {
//			// 원하는 만큼 뽑았다
//			StringBuilder sb = new StringBuilder();
//			long sum = output[0];
//			for (int i = 1; i < v.length; i++) {
//				output[i] += output[i - 1];
//			}
//			System.out.println(Arrays.toString(output));
////			min = Math.min(min, sum);
//			return; // 이게 중요함. 더이상 안뽑아도 되니까 함수를 종료시켜야됨.
//		}
//		// recursive case
//		for (int i = 0; i < v.length; i++) {
//			if (!v[i]) {
//				// 한번도 안썼다면
//				v[i] = true;
//				output[depth] = spooling[i]; // 현재 뎁스에서 저장해야됨.
//				perm(depth + 1);
//				v[i] = false; // 함수 호출 이후로는 다른 case도 사용해야되니까 check에 다시 false를 넣는다.
//			}
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> m = new HashMap();
		// Value 값으로 오름차순 정렬

		spooling = new int[n];
		output = new long[n];
		v = new boolean[n];
		min = Integer.MAX_VALUE;
		for (int j = 1; j <= n; j++) {
			m.put(j, Integer.parseInt(st.nextToken()));
		}
		List<Integer> keySet = new ArrayList<>(m.keySet());
		keySet.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return m.get(o1).compareTo(m.get(o2));
			}
		});
		int[] dp = new int[n];
		int idx =0;
		for (Integer key : keySet) {
			dp[idx++] = m.get(key);
		}
		for(int i=1; i<n; i++) {
			dp[i] += dp[i-1];
		}
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += dp[i];
		}
		System.out.println(sum);
		br.close();
	}
}