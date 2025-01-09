import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int x;
        long a; // 인구

        Node(int x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Node o2) {
            return this.x - o2.x;
        }
    }

    public static int n;
    public static StringBuilder sb = new StringBuilder();
    public static List<Node> villages;
    public static long total;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        villages = new ArrayList<>();
        total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            villages.add(new Node(x, a));
            total += a;
        }
        Collections.sort(villages);
        go();
    }

    public static void go() {
        long sum = 0;
        for (Node v : villages) {
            sum += v.a;
            // 전체 인구의 절반 이상이 되는 지점이 중앙값
            if (sum >= (total + 1) / 2) {
                System.out.println(v.x);
                break;
            }
        }
    }
}