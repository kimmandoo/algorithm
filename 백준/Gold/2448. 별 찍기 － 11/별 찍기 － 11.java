import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] b;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        // N은 항상 3×2k 수
        b = new char[n * 2 + 10][n * 2 + 10]; // 넉넉하게
        for (char[] l: b){
            Arrays.fill(l, ' ');
        }
        go(0,n-1,n);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            for (int j=0; j<n*2; j++){
                sb.append(b[i][j]);
            }
            sb.append("\n");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
    }

    public static void go(int ci, int cj, int size) {
        if (size == 3) {
            // 가장 작은 삼각형이 그려질 때
            b[ci][cj] = '*';

            b[ci + 1][cj - 1] = '*';
            b[ci + 1][cj + 1] = '*';

            b[ci + 2][cj - 2] = '*';
            b[ci + 2][cj - 1] = '*';
            b[ci + 2][cj] = '*';
            b[ci + 2][cj + 1] = '*';
            b[ci + 2][cj + 2] = '*';
            return;
        }

        int nextSize = size / 2;
        go(ci, cj, nextSize);  // 위쪽 삼각형
        go(ci + nextSize, cj - nextSize, nextSize);  // 왼쪽 아래 삼각형
        go(ci + nextSize, cj + nextSize, nextSize);  // 오른쪽 아래 삼각형
    }
}