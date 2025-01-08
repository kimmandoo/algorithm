import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        go(s, f);
    }

    public static void go(int s, int f) {
        System.out.println(s<=f ? "high speed rail\n" : "flight");
    }
}