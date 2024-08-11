import java.util.*;
import java.io.*;

public class Main {
    static int[][] input;
    static int size;

    public static int lis() {
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int len = 1;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i][1] > input[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }

        return len;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        size = Integer.parseInt(br.readLine());
        input = new int[size][2];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int max = lis();

        System.out.println(size - max);
    }
}