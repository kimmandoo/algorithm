import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int mx = -1;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            input[i] = target;
            mx = Math.max(mx, target);
        }

        memo = new int[mx + 1];
        Arrays.fill(memo, -1);

        // 최대값까지 한 번 계산
        go(mx);

        StringBuilder sb = new StringBuilder();
        for (int e : input) {
            sb.append(go(e)).append('\n');
        }
        System.out.print(sb);
    }

    static int go(int x) {
        if (x == 0) return 1;
        if (x < 0) return 0;

        if (memo[x] != -1) return memo[x];

        memo[x] = (go(x - 1) + go(x - 2) + go(x - 3)) % 1_000_000_009;
        return memo[x] % 1_000_000_009;
    }
}