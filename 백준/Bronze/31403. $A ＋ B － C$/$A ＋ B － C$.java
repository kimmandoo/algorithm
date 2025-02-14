import java.io.*;
import java.util.*;

public class Main {
    static int n, a, b, c;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        go();
    }

    public static void go() {
        // 숫자
        System.out.println(a+b-c);
        String line = String.valueOf(a)+String.valueOf(b);
        System.out.println(Integer.parseInt(line)-c);
    }
}