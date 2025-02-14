import java.io.*;
import java.util.*;

public class Main {
    static int n, a, b, c;
    static String input;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(br.readLine());
        input = br.readLine();
        go();
    }

    public static void go() {
        long res = 0;
        long mod = 1234567891;
        long r = 31;
        long pow = 1;
        for(int i = 0; i < n; i++) {
            res += ((input.charAt(i) - 96) * pow);
            pow = (pow * r) % mod;
        }
        System.out.println(res % mod);
    }
}