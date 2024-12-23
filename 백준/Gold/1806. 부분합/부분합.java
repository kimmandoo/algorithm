import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] input;
    static int[] prefix;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        input = new int[n];
        prefix = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            prefix[i + 1] = prefix[i] + input[i];
        }
        // System.out.println(Arrays.toString(prefix));
        go();
    }

    public static void go() {
        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        boolean find = false;
        while (r <= n) {
            if (l < r && prefix[r] - prefix[l] >= s) {
                // 최소값 갱신하기
                len = Math.min(r - l, len);
                find = true;
                l++;
            } else {
                r++; // 구간 확장하기
            }
        }
        if (find){
            System.out.println(len);
        }else{
            System.out.println(0);
        }
        // 불가능한 경우를 안찾았다.
    }
}