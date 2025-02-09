import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long w, h, k, t;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static long mod = 998244353;
    static long ans;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        w = Long.parseLong(st.nextToken());
        h = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());

        ans = 1;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // i번째 바이러스 위치
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            go(x, y);
        }

        System.out.println(ans);
    }

    public static void go(long x, long y) {
        long wCase = (Math.min(w, x + t) - Math.max(1, x - t) + 1) % mod;
        long hCase = (Math.min(h, y + t) - Math.max(1, y - t) + 1) % mod;

        ans = (ans * wCase) % mod;
        ans = (ans * hCase) % mod;
    }
}