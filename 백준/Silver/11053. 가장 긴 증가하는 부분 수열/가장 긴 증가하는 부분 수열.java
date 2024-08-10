import java.util.*;
import java.io.*;

public class Main {

    public static int lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 각 위치에서 수열길이 1로 채워넣고 시작
        Arrays.fill(dp, 1);
        int len = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }

        return len;
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(lis(input));
    }
}
