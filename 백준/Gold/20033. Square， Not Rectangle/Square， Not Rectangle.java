import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] input;
    static int low, high;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, input[i]);
            low = Math.min(low, input[i]);
        }
        // k * k 가 최대가 되는 시점이 필요함 
        go();
    }

    public static void go() {
        int l = low;
        int r = high;
        int res = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (check(m)) {
                res = m;
                l = m + 1; // 정사각형을 만들 수 있으면 더 크게 만들기
            } else {
                r = m - 1;
            }
        }
        System.out.println(res);
    }

    public static boolean check(int size) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt >= size) return true;
            if (input[i] >= size){
                cnt++;
            }else{
                // 이게 아니면
                if (n - i + 1 < size) return false;
                cnt = 0;
            }
        }

        return cnt >= size;
    }
}