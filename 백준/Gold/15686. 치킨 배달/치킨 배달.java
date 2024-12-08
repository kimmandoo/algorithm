import java.util.*;
import java.io.*;

public class Main {
    static int min;
    static List<Node> hs;
    static List<Node> cs;
    static int[] mChicken;
    static boolean[] v;
    static int m;
    static List<Node> selected;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mChicken = new int[m];
        min = Integer.MAX_VALUE;
        hs = new ArrayList<>();
        cs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    // 집
                    hs.add(new Node(i, j));
                }
                if (tmp == 2) {
                    // 치킨
                    cs.add(new Node(i, j));
                }
            }
        }
        v = new boolean[cs.size()];

        go(0, m);
        System.out.println(min);
    }

    public static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    // 이제 치킨집 M개로 줄일 차례
    public static void go(int start, int target) {
        if (target == 0) {
            // 다 뽑았다.
            selected = new ArrayList<>();
            for (int i = 0; i < cs.size(); i++) {
                if (v[i]) {
                    selected.add(cs.get(i));
                }
            }
            min = Math.min(min, findAll());
        }
        for (int i = start; i < cs.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                go(i + 1, target - 1);
                v[i] = false;
            }
        }
    }

    public static int dist(Node home, Node chicken) {
        return Math.abs(home.i - chicken.i) + Math.abs(home.j - chicken.j);
    }

    public static int find(Node home) {
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            // m개 중에 뽑아야됨.
            int tmpD = dist(home, selected.get(i));
            if (tmp > tmpD) {
                tmp = tmpD;
            }
        }
        return tmp;
    }

    public static int findAll() {
        int res = 0;
        for (int i = 0; i < hs.size(); i++) {
            res += find(hs.get(i));
        }
        return res;
    }
}