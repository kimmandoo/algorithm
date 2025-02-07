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
            String target = br.readLine();
            int t = Integer.parseInt(target);
            String ts = String.valueOf(t * t);
            if ((ts).endsWith(target)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void go() {

    }
}