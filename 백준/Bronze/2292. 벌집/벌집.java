import java.io.*;
import java.util.*;

public class Main {
    static int n, a, b, c;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(br.readLine());
        go();
    }

    public static void go() {
        int f = 1;
        int range = 1;

        while (range < n) { // n이 해당 범위 안에 포함될 때까지 반복
            range += 6 * f;
            f++;
        }

        System.out.println(f);
    }
}