import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] child;
    static int[] dp;
    static int[] p;
    static int[] sum;
    static int[] cnt;

    public static void make() {
        for (int i = 1; i <= n; i++) {
            p[i] = i; // 자기 자신을 일단 부모로 해둠
        }
    }

    public static int find(int a) {
        if (a == p[a]) return a;
        return p[a] = find(p[a]);
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (child[pa] < child[pb]) {
                p[pa] = pb; // 최대로 사탕뺏어야되니까 사탕 더 많이 갖고있는 애한테 묶어버리기
            } else {
                p[pb] = pa;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 울릴 수 있는 아이 최소 하한 -> 불포함돼야됨
        child = new int[n + 1];
        p = new int[n + 1];
        sum = new int[n + 1];
        cnt = new int[n + 1];
        make();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            child[i] = Integer.parseInt(st.nextToken()); // i번째 아이들이 받은 사탕의 수
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); // a와 b가 친구다
            union(a, b);
        }
        for (int i = 1; i <= n; i++) {
            sum[find(i)] += child[i];
            cnt[find(i)]++;
        }

//        System.out.println(Arrays.toString(sum));
//        System.out.println(Arrays.toString(cnt));
        go();
    }

    public static void go() {
        dp = new int[k];  // k명을 울리지 않도록 하면서 최대 사탕 개수 저장할 것임

        for (int i = 1; i <= n; i++) {
            if (find(i) == i) { // 그룹 대장 찾기
                int candy = sum[i];  // 그룹의 총 사탕 개수
                int kids = cnt[i];   // 그룹 총원

                for (int j = k - 1; j >= kids; j--) {
                    // j명에 저장될건데, 현재 값을 그대로 둘건지, 아니면 현재 그룹을 포함하는 경우를 저장할건지
                    dp[j] = Math.max(dp[j], dp[j - kids] + candy);
                }
            }
        }

        int max = 0;
        for (int j = 0; j < k; j++) {
            max = Math.max(max, dp[j]);
        }
        System.out.println(max);
    }
}