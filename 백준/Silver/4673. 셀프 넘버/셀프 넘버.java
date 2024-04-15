import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        dp = new int[10036]; // 1~10036
        dp[2] = 1;
        for (int i = 2; i <= 10000; i++) {
            if(i<10){
                dp[i+i]++;
            }
            else if (i < 100) {
                dp[i+i/10+i%10]++;
            }
            else if (i < 1000) {
                dp[i+i/100+(i%100)/10+((i%100)%10)%10]++;
            }
            else {// i <= 10000
                dp[i+i/1000+(i%1000)/100+((i%1000)%100)/10+((i%1000)%100)%10]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++){
            if(dp[i] == 0){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
