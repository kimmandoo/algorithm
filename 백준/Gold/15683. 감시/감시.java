import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] b;
    static int min = Integer.MAX_VALUE;

    public static class Node {
        int t, i, j;

        Node(int t, int i, int j) {
            this.t = t;
            this.i = i;
            this.j = j;
        }
    }

    static ArrayList<Node> cctv;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = new int[n][m];
        cctv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int item = Integer.parseInt(st.nextToken());
                b[i][j] = item;
                if (item > 0 && item < 6) {
                    cctv.add(new Node(item, i, j)); // 몇 번 타입의 cctv가 어디에 위치했는지
                }
            }
        }
        // 입력완료
        // 0은 빈칸, 6은 벽, 1~5는 cctv, cctv끼리는 통과 가능
        go(0);
        System.out.println(min);
    }

    // 감시하는 cctv 별 회전 방향 다 고려해야될 것 같다
    static int[][][] dir = {
            {}, // 0번 (사용 안 함)
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    static int[] di = {-1, 0, 1, 0}; // 12부터 시계방향
    static int[] dj = {0, 1, 0, -1};

    public static void go(int idx) {
        if (idx == cctv.size()) {
            // cctv 다 돌면 0인 곳만 싹 세서 min 비교
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 0) tmp++; // 0이면 도달하지않은 곳
                }
            }
            min = Math.min(tmp, min);
            return;
        }
        Node ct = cctv.get(idx);
        int ci = ct.i;
        int cj = ct.j;

        for (int[] dirs : dir[ct.t]) {
            // 처리할거하고
            gamsi(ci, cj, dirs, true);
            go(idx + 1);
            // 원복
            gamsi(ci, cj, dirs, false);
        }
    }

    public static void gamsi(int i, int j, int[] dirs, boolean v) {
        for (int dir : dirs) {
            int ni = i, nj = j;
            while (true) {
                ni += di[dir]; // 계속 쭉 뻗어나가게
                nj += dj[dir];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m || b[ni][nj] == 6) break; // 유효범위가 아니면 끝내기
                if (b[ni][nj] > 0) continue; // cctv는 통과할 수 있다
                if (v) {
                    b[ni][nj]--;
                } else {
                    b[ni][nj]++;
                }
            }
        }
    }
}