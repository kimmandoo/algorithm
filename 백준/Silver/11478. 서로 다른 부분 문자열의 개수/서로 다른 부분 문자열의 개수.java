import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static StringBuilder sb = new StringBuilder();
    static String input;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        n = Integer.parseInt(st.nextToken()); // 10억까지
        input = br.readLine();
        go();
    }

    public static void go() {
        Set<String> res = new HashSet<>();
        int n = input.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (j - i >= 1) {
                    res.add(input.substring(i, j));
                }
            }
        }
        System.out.println(res.size());
    }
}