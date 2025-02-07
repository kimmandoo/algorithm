import java.io.*;
import java.util.*;

public class Main {
    static int n, t, p;
    static int[] size;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        size = new int[6];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        go();
    }

    public static void go() {
        int penEach = n % p;
        int pen = n / p;
        int tShirts = 0;
        for (int i = 0; i < 6; i++) {
            if (size[i] <= t && size[i] > 0) tShirts++;
            else {
                int mok = size[i] / t;
                tShirts += mok;
                int left = size[i] % t;
                if (left > 0) tShirts++;
            }
        }

        System.out.println(tShirts);
        System.out.println(pen + " " + penEach);
    }
}