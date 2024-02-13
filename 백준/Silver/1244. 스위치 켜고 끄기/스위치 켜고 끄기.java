import java.util.*;

class Main {
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			s[i] = sc.nextInt();
		} // 스위치 초기화

		int stu = sc.nextInt();
		for (int i = 0; i < stu; i++) {
			int gender = sc.nextInt();
			int t = sc.nextInt();
			if (gender == 1) {
				// 남자
				for (int j = t; j <= n; j++) {
					if (j % t == 0) {
						if (s[j] == 1) {
							s[j] = 0;
						} else {
							s[j] = 1;
						}
					}
				}
			} else { // gender == 2;
				// 여자
				int left = t - 1;
				int right = t + 1;
				while (left >= 1 && right <= n && s[left] == s[right]) {
					left--;
					right++;
				}
				for (int j = left + 1; j < right; j++) {
					if (s[j] == 1) {
						s[j] = 0;
					} else {
						s[j] = 1;
					}
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(s[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}

		System.out.println(sb);

		sc.close();
	}
}