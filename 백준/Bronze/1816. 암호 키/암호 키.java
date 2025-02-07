import java.io.*;
import java.util.*;

public class Main {
    static int n, t, p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(br.readLine());
            for (int k = 2; k <= 1000_000; k++) {
                if (t % k == 0) { // 100만 이하에서 나눠지면 조건에 맞지않는다!
                    sb.append("NO").append("\n");
                    break;
                }
                if (k == 1000_000) {
                    sb.append("YES").append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void go() {

    }
}