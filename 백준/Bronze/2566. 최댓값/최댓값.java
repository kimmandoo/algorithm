import java.util.*;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] m = new int[9][9];
		int x = 0;
		int y = 0;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				m[i][j] = sc.nextInt();
				if (max < m[i][j]) {
					max = m[i][j];
					x = i;
					y = j;
				}
			}
		}
		System.out.println(max + "\n" + (x + 1) + " " + (y + 1));
	}
}