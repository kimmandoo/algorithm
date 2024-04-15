import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n+1];
        for(int i=1; i<=n; i++){
            nArr[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
            nArr[i] = nArr[i-1]^nArr[i];
        }
        int res = 0;
        for(int i=0; i<m; i++){
            int s = sc.nextInt(); // start
            int e = sc.nextInt(); // end
            if(s==e){
                res ^= 0;
            }
            res ^= nArr[e]^nArr[s-1];
        }
        System.out.println(res);
    }
}