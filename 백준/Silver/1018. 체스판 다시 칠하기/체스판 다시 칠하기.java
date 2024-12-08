import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static char[][] b;
    public static char[] wb;
    public static char[] bw;
    static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = new char[n][m];
        wb = new char[]{'W', 'B'};
        bw = new char[]{'B', 'W'};
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = line.charAt(j);
            }
        }
        // 입력받기 끝
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt = Math.min(cnt, go(i, j));
            }
        }
        System.out.println(cnt);
    }

    public static int go(int ci, int cj) { // 둘 수 있는 경우의 수
        // 한 칸 씩 돌면서 8x8을 비교할 것
        if (ci + 8 > n || cj + 8 > m) return Integer.MAX_VALUE; // 범위를 벗어나면 그냥 안돌림

        int cntWB = 0;
        int cntBW = 0;
        for (int i = ci; i < ci + 8; i++) {
            for (int j = cj; j < cj + 8; j++) {
                if (wb[(i + j) % 2] != b[i][j]) {
                    cntWB++;
                }
                if (bw[(i + j) % 2] != b[i][j]) {
                    cntBW++;
                }
            }
        }
        return Math.min(cntBW, cntWB);
    }
}