import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int sanggun[];
    static int find[];
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        sanggun = new int[n];
        for (int i = 0; i < n; i++) {
            sanggun[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        find = new int[m];
        for (int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }
        // 탐색을 위한 정렬
        Arrays.sort(sanggun);
        sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(isExist(find[i])).append(" ");
        }
        System.out.println(sb);

    }

    public static int isExist(int t) {
        int l = 0;
        int r = n - 1; // 양 끝값 세팅
        while (l <= r) {
            int m = (l + r) / 2;
            if (sanggun[m] == t) {
                return 1;
            }
            if (sanggun[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
}