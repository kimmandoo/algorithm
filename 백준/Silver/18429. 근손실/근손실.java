import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int cnt = 0;
    static int[] days;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 8까지니까 재귀 태워도 될 듯
        k = Integer.parseInt(st.nextToken());
        // 3대 500 인데, 키트별 중량 차이가 있음
        // 하루가 지날 때 k만큼 감소한다
        days = new int[n];
        v = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 500);
        System.out.println(cnt);
    }

    public static void go(int idx, int now) {
        if (now < 500) return;
        if (idx == n) {
//            System.out.println("idx: " + idx + ", now: " + now);
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                go(idx + 1, now - k + days[i]);
                v[i] = false;
            }
        }
    }
}