import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> input;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        input = new ArrayList<>();
        while (st.hasMoreTokens()) {
            input.add(st.nextToken()); // - 기준으로 분리하기
        }
        go();
    }

    public static void go() {
        int res = Integer.MAX_VALUE;
        for (String line : input) {
            StringTokenizer st = new StringTokenizer(line, "+");
            int tmp = 0;
            while (st.hasMoreTokens()) {
                tmp += Integer.parseInt(st.nextToken());
            }
            if (res == Integer.MAX_VALUE) {
                res = 0;
                res += tmp;
            } else {
                res -= tmp;
            }
        }
        System.out.println(res);
    }
}