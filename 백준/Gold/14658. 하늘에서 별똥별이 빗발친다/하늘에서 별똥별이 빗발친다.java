import java.io.*;
import java.util.*;

public class Main {
    static int n, m, l, k;
    static Node[] arr;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Node[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }

        go();
    }

    public static void go() {
        Arrays.sort(arr, (a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });

        int max = 0;

        for (int i = 0; i < k; i++) {
            int sx = arr[i].x;

            for (int j = 0; j < k; j++) {
                int sy = arr[j].y;
                int cnt = 0;

                for (int t = 0; t < k; t++) {
                    int x = arr[t].x;
                    int y = arr[t].y;

                    if (x < sx) continue;
                    if (x > sx + l) break;

                    if (sy <= y && y <= sy + l) {
                        cnt++;
                    }
                }

                max = Math.max(max, cnt);
            }
        }

        System.out.println(k - max);
    }
}