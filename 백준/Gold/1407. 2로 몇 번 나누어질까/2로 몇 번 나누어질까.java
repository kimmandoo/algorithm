import java.io.*;
import java.util.*;

public class Main {
    static long n, m;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        System.out.println(go(m) - go(n - 1));
    }

    public static long go(long k) {
        long sum = k;
        long exp = 1;

        while (exp <= k) {
            sum = sum + (k / exp) * (exp / 2);
            exp *= 2;
        }

        return sum;
    }
}