import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //12시부터 8방
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int res = 0;
        for(int i=0; i<n; i++){
            res += sc.nextInt()*sc.nextInt();
        }
        if(x==res){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
