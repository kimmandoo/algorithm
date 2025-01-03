import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] pre;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pre = new int[n + 2];
        st = new StringTokenizer(br.readLine(), " ");
        int[] input = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        // prefix 입력 끝
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // s부터 e 까지 k만큼 더하기
            pre[s] = pre[s] + k;
            pre[e + 1] = pre[e + 1] + (-k); // 원복 위치 -> 이거때문에 누적합 배열 크기 +1 해줬다.
        }
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + pre[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            input[i] = input[i] + pre[i];
            sb.append(input[i]).append(" ");
        }
        System.out.println(sb);
    }
}