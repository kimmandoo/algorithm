import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] money;
    static int sum, max;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        money = new int[n];
        sum = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            money[i] = Integer.parseInt(st.nextToken()); // i번째 날 이용할 금액
            sum += money[i];
            max = Math.max(max, money[i]); // 이분탐색에 사용할 값들
        }
        go();
    }

    public static void go() {
        int l = max; // 이렇게 세팅안하면 계속 인출하게 된다! 
        int r = sum;
        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                // m번 뽑을 경우에 k값을 줄이자
//                System.out.println(mid);
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(res);
    }

    public static boolean check(int k) {
        int cnt = 1;
        int prev = k; // 처음 출금해서 k원 들고있는 것

        for (int i = 0; i < n; i++) {
//            if (money[i] > prev) {
//                cnt++;
//                prev = k;
//            } else {
//                prev -= k;
//            }

            prev -= money[i]; // 0이상이면 인출한 돈이 모자라므로 한번 더 인출

            if (prev < 0) {
                cnt++;
                prev = k - money[i];
            }
        }
//        System.out.println(cnt);

        return cnt <= m;
    }
}