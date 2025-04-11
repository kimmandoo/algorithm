import java.io.*;
import java.util.*;

public class Main {

    static int n, k, a, b;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        go();
    }

    public static void go() {
        int[] p = new int[n];
        Arrays.fill(p, k);
        int res = 0;
        int time = 1;
        while (p[0] >= time) {
            for (int i = 0; i < a; i++) { // 연속된 a개에 b만큼 물주기
                p[i] += b;
            }
            time++;
            Arrays.sort(p);
            res++;
        }
        System.out.println(res);
    }
}