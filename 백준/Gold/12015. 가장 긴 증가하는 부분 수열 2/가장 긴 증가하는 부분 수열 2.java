import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] input;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        input = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        go();
    }

    static List<Integer> lis = new ArrayList<>();

    public static void go() {
        for (int target : input) {
            int pos = find(target);
            if (pos == lis.size()) {
                lis.add(target); // 현재 위치가 가장 큰 경우라면 마지막위치+1 에 있어야 됨
            } else {
                lis.set(pos, target); // pos는 target이 위치하는 가장 작은 idx이므로, 교체해줘도 LIS가 유지될 것
            }
        }

        System.out.println(lis.size());
    }

    public static int find(int t) {
        int l = 0;
        int r = lis.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (lis.get(m) >= t) r = m - 1;
            else l = m + 1;
        }
        return l; // lower-bound 방식이었구나
    }
}