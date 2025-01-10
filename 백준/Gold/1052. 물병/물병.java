import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 물통
        k = Integer.parseInt(st.nextToken()); // k개 만큼 물통 가져나가기
//        cnt = new int[10000001];
        // 각 칸에는 xL 담긴 물통의 개수가 있을 것
//        cnt[1] = n; // 처음에는 1L가 무조건 담겨있다.
        go();
    }

    public static void go() {
        int res = 0;

        while (true) {
            int count = 0;
            int tmp = n;

            // 1의 개수는 합칠 수 없는 물병의 개수(꽉찬거) -> 최대로 합쳤다고 봐야됨
            while (tmp > 0) {
                if (tmp % 2 == 1) {
                    count++;
                }
                tmp /= 2;
            }

            if (count <= k) {
                break;
            }

            n++;
            res++;
        }

        System.out.println(res);
    }
}