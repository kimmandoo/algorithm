import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] v;
    static int[][][] pattern = {
            {{0}},
            {
                    {1}
            },
            {
                    {1, 1},
                    {1, 1}
            },
            {
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1}
            },
            {
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
            },
            {
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
            },
    };

    static int[] p;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = 10;
        map = new int[10][10];
        v = new boolean[10][10];
        p = new int[6]; // 1~5
        StringTokenizer st = null;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (map[i][j] == 1){
//                    go(i, j, 5);
//                }
//            }
//        }
        dfs(0,0,0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void go(int ci, int cj, int size) {
        if (ci+size >= n || cj + size >= n) return; // 사이즈 체크
        int cnt = 0; // pow size
        for (int i=ci; i<ci+size; i++){
            for (int j=cj; j<cj+size; j++){
                if (map[i][j] == 1) cnt++;
            }
        }
        if (cnt != Math.pow(size, 2)){
            // 다음 사이즈로
            go(ci, cj, size-1);
        }else{
            p[size]++;
            for (int i=ci; i<ci+size; i++){
                for (int j=cj; j<cj+size; j++){
                    map[i][j] = 0;
                }
            }
        }
    }

    static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 1~5
    static int ans = Integer.MAX_VALUE;

    public static void dfs(int ci, int cj, int cnt) {
        // 맨 끝점에 도달하였을 경우, ans와 cnt 비교하고 종료.
        if (ci >= 9 && cj > 9) {
            ans = Math.min(ans, cnt);
            return;
        }

        // 최솟값을 구해야하는데 ans보다 cnt가 커지면 더 이상 탐색할 필요가 없어짐.
        if (ans <= cnt) {
            return;
        }

        if (cj > 9) { // 열 다돌았으니 행 돌기
            dfs(ci + 1, 0, cnt);
            return;
        }

        if (map[ci][cj] == 1) {
            for (int i = 5; i >= 1; i--) { // 큰 사이즈 부터 붙인다
                if (paper[i] > 0 && check(ci, cj, i)) {
                    // 처리할 거 하고
                    put(ci, cj, i, 0); // 색종이 붙이기
                    paper[i]--;
                    dfs(ci, cj + 1, cnt + 1);
                    // 원복하기
                    put(ci, cj, i, 1); // 색종이 떼기
                    paper[i]++;
                }
            }
        } else { // 오른쪽으로 이동.
            dfs(ci, cj + 1, cnt); // 아무것도 안하고 그냥 다음 칸
        }
    }

    // 색종이 탈부착
    public static void put(int ci, int cj, int size, int state) {
        for (int i = ci; i < ci + size; i++) {
            for (int j = cj; j < cj + size; j++) {
                map[i][j] = state;
            }
        }
    }

    // 색종이를 붙일 수 있는지 확인
    public static boolean check(int ci, int cj, int size) {
        for (int i = ci; i < ci + size; i++) {
            for (int j = cj; j < cj + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }

                if (map[i][j] != 1) { // 중간에 0이면 안된다!
                    return false;
                }
            }
        }
        return true;
    }

}