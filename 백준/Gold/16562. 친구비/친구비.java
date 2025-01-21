import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] p, pay;

    public static void make() {
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

    public static int find(int a) {
        if (p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (pay[pa] < pay[pb]) {
                p[pb] = pa;
            } else {
                p[pa] = pb;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pay = new int[n + 1];
        make();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        go();
    }

    public static void go() {
        HashSet<Integer> friends = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            friends.add(find(i)); 
        }

        int money = 0;
        for (int f : friends) {
            money += pay[f];
        }

        if (money > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(money);
        }
    }
}
