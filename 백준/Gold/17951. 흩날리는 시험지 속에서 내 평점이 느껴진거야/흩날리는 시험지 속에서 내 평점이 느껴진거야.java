import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int maxT, minT;
    static int[] input;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        input = new int[n];
        k = Integer.parseInt(st.nextToken());
        minT = 100000000;
        maxT = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            input[i] = t;
            minT = Math.min(minT, t);
            maxT += t;
        }
        go();
    }

    public static void go() {
        int l = minT;
        int r = maxT;
        while (l <= r) {
            int m = (l + r) / 2; // 타겟 점수
            if (grouping(m) >= k) {
//                System.out.println("l: " + l + " r: " + r);
                // 조건에 부합하니까 점수를 올리자
                l = m + 1;
            } else {
                r = m - 1; // 조건에 안맞으니까 점수를 내려야됨
            }
        }
        System.out.println(l - 1);
    }

    public static int grouping(int m) {
        int cnt = 0;
        int acc = 0;
        for (int i = 0; i < n; i++) {
            acc += input[i]; //  와 이위치하나때문에...
            if (acc >= m) {
                cnt++;
//                System.out.println("acc: " + acc);
                acc = 0;
            }
        }

//        System.out.println("m: " + m + " cnt: " + cnt);
        return cnt;
    }


}