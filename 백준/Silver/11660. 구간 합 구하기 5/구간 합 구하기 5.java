import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] prefix;
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        prefix = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // map setting
        // prefix setting
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                // 현재 좌표의 누적합은 위에 맞닿은 칸 + 왼쪽에 맞닿은 칸 + 해당 칸 값
                prefix[i][j] = prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1] + map[i-1][j-1]; // 겹치는거 하나 빼고
            }
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken()); // 좌측 위
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()); // 우측 아래
            System.out.println(calc(x1, y1, x2, y2));
        }

    }

    private static int calc(int x1, int y1, int x2, int y2) {
        // 두 면적을 빼고, 중복된 면적 부분을 한번 더한다.
        // x1-1, y1-1을 한번 더하고, x2,y1랑 x1,y2를 빼면 됨
        return prefix[x2][y2] + prefix[x1-1][y1-1] - prefix[x2][y1-1] - prefix[x1-1][y2] ;
    }
}