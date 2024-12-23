import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] input;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        input = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input); // 오름차순 정렬
        go();
    }

    public static void go() {
        // 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값
        // -99 -2 -1 4 98
        // l이 처음, r이 마지막 끝 잡기.
        // 합이 0에 가까운게 min값인데, 그 때의 두 용액을 들고 있어야한다.
        int l = 0;
        int r = n - 1;
        int ll = -1;
        int rr = -1;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            // 정렬을 해놨으니까, 왼쪽은 작은거, 오른쪽은 큰 게 있다.
            // 작아지려면 왼쪽을 더하고, 커지려면 오른쪽을 빼면 됨(인덱스)
            int tmp = input[l] + input[r];
            if (Math.abs(tmp) < Math.abs(min)) {
                min = tmp;
                ll = input[l];
                rr = input[r];
            }
            if (tmp < 0) { // 음수일 경우에는 더 큰 값을 만들기 위해 음수 값을 줄여야하고
                l++;
            } else if (tmp > 0) { // 양수면 더 작은 값을 만들기 위해 양수 값을 줄여야한다.
                r--;
            } else {
                // 0이면
                break;
            }
        }
        System.out.println(ll + " " + rr);
    }
}