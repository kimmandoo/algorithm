import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean map[][];
    static boolean[] checkCol;
    static boolean[] checkLeft;
    static boolean[] checkRight;
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int max = 15;
        checkCol = new boolean[max+1];
        checkLeft = new boolean[2*(max+1)-1]; // 2n-1 이 끝 일 것
        checkRight = new boolean[2*(max+1)-1];
        search(0); // 시작지점
        System.out.println(cnt);
    }

    static void search(int x) {
        if(x == n) {
            cnt++;
            return;
        }
        for(int y=0;y<n;y++) {
        // 순서대로 가로줄, 대각1, 대각2
            if(checkCol[y] || checkLeft[x+y] || checkRight[x-y+n])continue;
            checkCol[y]= true;
            checkLeft[x + y] = true;
            checkRight[x - y + n] = true;
            search(x+1);
            checkCol[y] = false;
            checkLeft[x+y] = false;
            checkRight[x-y+n] = false;
        }
    }
}