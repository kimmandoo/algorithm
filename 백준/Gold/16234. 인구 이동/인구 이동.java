import java.util.*;
import java.io.*;

public class Main {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] v = new boolean[N][N];
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // i,j에 위치한 값이 인구값.
			}
		}
		int move = 0;
		// 입력받기 끝
		boolean moved;
        do {
            moved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j]) {
                        boolean union = false;
                        Deque<int[]> s = new ArrayDeque<>();
                        Deque<int[]> apply = new ArrayDeque<>();
                        int[] node = new int[]{i, j};
                        s.add(node);
                        apply.add(node);

                        v[i][j] = true;
                        int terri = 1;
                        int totalPop = map[i][j];
                        while (!s.isEmpty()) {
                            int[] cur = s.pollFirst();
                            for (int d = 0; d < 4; d++) {
                                int ni = cur[0] + di[d];
                                int nj = cur[1] + dj[d];
                                if (ni >= 0 && nj >= 0 && ni < N && nj < N && !v[ni][nj]) {
                                    int popular = Math.abs(map[cur[0]][cur[1]] - map[ni][nj]);
                                    if (L <= popular && popular <= R) {
                                        union = true;
                                        terri++;
                                        totalPop += map[ni][nj];
                                        v[ni][nj] = true;
                                        int[] next = new int[]{ni, nj};
                                        apply.add(next);
                                        s.add(next);
                                    }
                                }
                            }
                        }
                        if (union) {
                            moved = true;
                            int moving = totalPop / terri;
                            while (!apply.isEmpty()) {
                                int[] target = apply.pollFirst();
                                map[target[0]][target[1]] = moving;
                            }
                        }
                    }
                }
            }
            if (moved) {
                move++;
                sb.append("Move ").append(move).append(":\n");
                for (int a = 0; a < N; a++) {
                    for (int b = 0; b < N; b++) {
                        sb.append(map[a][b]).append(" ");
                    }
                    sb.append("\n");
                }
            }
            v = new boolean[N][N]; // 초기화
        } while (moved);
        System.out.println(move);
	}
}
