import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int maxProfit = 0;
    static int[][] input;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        input = new int[n][2];
        for (int i = 0; i < n; i++) {
            // n일 간 작업
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken()); // days
            input[i][1] = Integer.parseInt(st.nextToken()); // profits
        }
        go(0, 0);
        System.out.println(maxProfit);
    }

    public static void go(int s, int acc) { // 끝나는 날만 보면 됨
        if (s == n) {
            maxProfit = Math.max(maxProfit, acc);
            return;
        }

        if (s > n) return;

        go(s + input[s][0], acc + input[s][1]); // 상담을 했을경우
        go(s + 1, acc); // 상담 안한경우
    }
}