import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 나무, 집으로 가져가려는 나무 길이 M
        tree = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        go();
    }

    public static void go() {
        int l = 0;
        int r = tree[n - 1];
        while (l <= r) {
            int mid = (l + r) / 2; // mid는 나무 길이를 의미한다.
            if (bulmok(mid)) { // 조건을 만족한 경우에는 값을 좀 나무 높이를 더 올릴 수 있나 봐야됨
                l = mid + 1;
            } else {
                r = mid - 1; // 조건 만족 못하면 내려야됨
            }
        }
        System.out.println(r);
    }

    public static boolean bulmok(int mid) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i] > mid) {
                sum += tree[i] - mid;
            }
        }
        return sum >= m;
    }
}