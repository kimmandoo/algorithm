import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] checker;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        checker = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            checker[i][0] = Integer.parseInt(st.nextToken()); // x
            checker[i][1] = Integer.parseInt(st.nextToken()); // y
        }
        go();
        System.out.println(sb);
    }

    public static void go() {
        for (int k = 1; k <= n; k++) {
            // k일때 최소거리합
            int res = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int centerX = checker[i][0]; // 원 대상의 X
                    int centerY = checker[j][1]; // 비교 대상의 Y

                    int[] dist = new int[n];
                    for (int p = 0; p < n; p++) {
                        dist[p] = Math.abs(checker[p][0] - centerX) + Math.abs(checker[p][1] - centerY);
                    }
//                    System.out.println(Arrays.toString(dist));
                    Arrays.sort(dist);

                    int sum = 0;
                    for (int d = 0; d < k; d++) {
                        sum += dist[d];
                    }

                    res = Math.min(res, sum);
                }
            }
            sb.append(res).append(" ");
        }
    }
}