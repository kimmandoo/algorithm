import java.io.*;
import java.util.*;

public class Main {
    static int n, t, p;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        List<int[]> scores = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        scores.add(new int[]{Integer.parseInt(st.nextToken()), 1}); // 첫 번째 값
        
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int rank = (scores.get(i - 1)[0] > cur) ? i + 1 : scores.get(i - 1)[1];
            scores.add(new int[]{cur, rank});
        }

        if (n == p && scores.get(n - 1)[0] >= t) {
            System.out.println(-1);
            return;
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (scores.get(i)[0] > t) ans = i + 2;
            else break;
        }

        System.out.println(ans);
    }
}