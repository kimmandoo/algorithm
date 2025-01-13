import java.io.*;
import java.util.*;

public class Main {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int r, c;
    static boolean[] v;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = new boolean[26];
        // 'A'가 65니까, -65하면 idx가 딱 맞을듯
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // 입력 끝
        go(1, 0, 0);
        System.out.println(maxLen);
    }

    static int maxLen = -1;

    public static void go(int depth, int ci, int cj) {
        if (!v[map[ci][cj] - 65]) {
            v[map[ci][cj] - 65] = true;
        }
        maxLen = Math.max(maxLen, depth);

        for (int d = 0; d < 4; d++) {
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if (isValid(ni, nj) && !v[map[ni][nj] - 65]) {
                go(depth + 1, ni, nj);
                v[map[ni][nj] - 65] = false; // 반환 됐으면 원복시키기
            }
        }
    }

    public static boolean isValid(int ci, int cj) {
        return ci < r && ci >= 0 && cj < c && cj >= 0;
    }
}