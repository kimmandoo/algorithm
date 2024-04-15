import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        dp = new int[11];
        int n = sc.nextInt();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=10; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3]; // 점화식
        }
        for(int i=0; i<n; i++){
            int input = sc.nextInt();
            System.out.println(dp[input]);
        }
    }
}

