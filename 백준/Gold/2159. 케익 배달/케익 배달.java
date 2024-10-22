import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n = 0;
    static long INF = Long.MAX_VALUE;
    static int[] di = {-1, 1, 0, 0, 0}; // 상하좌우중
    static int[] dj = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        ArrayList<Node> l = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 출발지를 첫 원소로
            st = new StringTokenizer(br.readLine(), " ");
            l.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        // 입력 끝
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        Arrays.fill(dp[0],1);
        dp[0][4] = 0;

        // 각 시작 좌표 -> 끝나는 좌표의 각 경우의수 총 25가지를 고려해야됨
        for (int k = 1; k <= n; k++) {
            Node prev = l.get(k - 1); // 출발지
            Node next = l.get(k); // 첫번째 목적지
            for (int i = 0; i < 5; i++) {
                // 출발지부터 세기
                int si = di[i] + next.i;
                int sj = dj[i] + next.j;
                long min = INF;
                if (isValid(si, sj)) {
                    for (int j = 0; j < 5; j++) { // 25가지 돌기
                        int ni = di[j] + prev.i;
                        int nj = dj[j] + prev.j;
                        if (isValid(ni, nj)) {
                            // 만약 i가 2이고 j가 2면, i=1인 j=1,2,3,4,5 와의 최단거리가 2에 들어가 있어야된다.
                            min = Math.min(dp[k-1][j] + getDist(si, sj, ni, nj), min);
                        }
                    }
                }
                dp[k][i] = min;
            }
        }
        long res = INF;
        for(int i=0; i<5; i++){
            res = Math.min(res, dp[n][i]);
        }

//        for (long[] line : dp) {
//            System.out.println(Arrays.toString(line));
//        }
        System.out.println(res);
    }

    // isValid
    static boolean isValid(int ni, int nj) {
        return ni < 100000 && nj < 100000 && ni >= 0 && nj >= 0;
    }

    // 두 목적지 간 거리 계산
    static long getDist(int si, int sj, int ei, int ej) {
        return Math.abs(si - ei) + Math.abs(sj - ej);
    }

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
