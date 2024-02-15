import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// S1(2 ≤ S1 ≤ 20), S2(2 ≤ S2 ≤ 20), S3(2 ≤ S3 ≤ 40)
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int s3 = sc.nextInt();
		int[] cnt = new int[81];
		int max = 0;
		int mIdx = 0;
		for (int i = 1; i <= s1; i++) {
			for (int j = 1; j <= s2; j++) {
				for (int k = 1; k <= s3; k++) {
					cnt[i + j + k]++;
					if (max < cnt[i + j + k]) {
						max = cnt[i + j + k];
						mIdx = i+j+k;
					}
				}
			}
		}
		System.out.println(mIdx);

	}
}