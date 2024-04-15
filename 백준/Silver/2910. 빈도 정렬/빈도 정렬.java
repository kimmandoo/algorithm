import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		Integer[] input = new Integer[n];
		Map<Integer, Integer> m = new HashMap<>();
		Map<Integer, Integer> seq = new HashMap<>();

		int idx = 1;
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			input[i] = tmp;
			if (!m.containsKey(tmp)) {
				m.put(tmp, 1);
				seq.put(tmp, idx++);
			} else {
				int val = m.get(tmp);
				m.put(tmp, val + 1);
			}
		}
//		System.out.println(seq.toString());

		Arrays.sort(input, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (m.get(o2) - m.get(o1) == 0) {
					return seq.get(o1) - seq.get(o2);
				} else {
					return m.get(o2) - m.get(o1);
				}
			}

		});

		StringBuilder sb = new StringBuilder();
		for (int i : input) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}