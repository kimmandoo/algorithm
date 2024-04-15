import java.util.*;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] sy = new int[n];
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			sy[i] = sc.nextInt();
		}

		for (int i = 0; i <= n - k; i++) {
			int tmp = 0;
			for (int j = i; j < i + k; j++) {
				tmp += sy[j];
			}
			l.add(tmp);
		}
		Collections.sort(l, null);
		System.out.println(l.get(l.size() - 1));
		sc.close();
	}
}