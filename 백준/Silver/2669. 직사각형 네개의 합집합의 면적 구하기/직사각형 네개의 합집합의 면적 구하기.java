import java.util.*;

class Main {
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					if(map[x][y] == 0) {
						map[x][y] = 1;
						res++;
					}
				}
			}
		}
		
		System.out.println(res);

		sc.close();
	}
}