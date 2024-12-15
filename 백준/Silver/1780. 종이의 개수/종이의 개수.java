import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] b;
    static int zero = 0;
    static int minus = 0;
    static int plus = 0;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        b = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝
        go(0,0,n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void go(int ci, int cj, int size) {
        // 종이가 모두 같은 수로 되어있으면 그만
        // 그게 아니면 9등분
        // 그리고 그거 반복
        boolean allSame = true;
        int tmp = -2;
        a:
        for (int i = ci; i < ci + size; i++) {
            for (int j = cj; j < cj + size; j++) {
                if (tmp == -2) tmp = b[i][j];
                else {
                    if (tmp != b[i][j]) {
                        allSame = false;
                        break a;
                    }
                }
            }
        }
        if (!allSame) {
            // 위에 세칸
            go(ci, cj, size / 3);
            go(ci, cj + size / 3, size / 3);
            go(ci, cj + (size * 2) / 3, size / 3);
            // 중안 세칸
            go(ci + size / 3, cj, size / 3);
            go(ci + size / 3, cj + size / 3, size / 3);
            go(ci + size / 3, cj + (size * 2) / 3, size / 3);
            // 아래 세칸
            go(ci + (size * 2) / 3, cj, size / 3);
            go(ci + (size * 2) / 3, cj + size / 3, size / 3);
            go(ci + (size * 2) / 3, cj + (size * 2) / 3, size / 3);
        } else {
            switch (tmp) {
                case 0:
                    zero++;
                    return;
                case -1:
                    minus++;
                    return;
                case 1:
                    plus++;
                    return;
            }
        }
    }
}