import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
    	long[] dp = new long[1000_002];
    	dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4; //111 12 21 3

        for(int i=4; i<=1000001; i++) {
        	dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1_000_000_009;
        }

        for(int t=0; t<tc;t++) {
        	int n = sc.nextInt();
            
            System.out.println(dp[n]);
        }
    }
}