import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char map[][] = new char[n][m];
		char[][] sol1 = new char[8][8]; // sol1, sol2의 크기를 8x8로 수정
		char[][] sol2 = new char[8][8];
		char[] wb = new char[] { 'W', 'B' };
		char[] bw = new char[] { 'B', 'W' };
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		int s1 = Integer.MAX_VALUE; // 충분히 큰 값으로 초기화
		int s2 = Integer.MAX_VALUE;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sol1[i][j] = wb[(i + j) % 2];
				sol2[i][j] = bw[(i + j) % 2];
			}
		}

		for (int i = 0; i <= n - 8; i++) { // n - 8로 수정
			for (int j = 0; j <= m - 8; j++) { // m - 8로 수정
				// 시작 지점부터 8x8 체크하기
				int tmp1 = 0;
				int tmp2 = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if (sol1[k - i][l - j] != map[k][l]) {
							tmp1++;
						}
						if (sol2[k - i][l - j] != map[k][l]) {
							tmp2++;
						}
					}
				}
				s1 = Math.min(tmp1, s1);
				s2 = Math.min(tmp2, s2);
			}
		}

		System.out.println(Math.min(s1, s2)); // 두 값 중 최소값 출력
	}
}