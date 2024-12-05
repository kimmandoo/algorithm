import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static LinkedList<Character> st;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            if (go(br.readLine())) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    public static Boolean go(String input) {
        st = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            // ( 랑 ) 가 들어오는데, 닫는게 들어오는 거면 넣지않고 pop, 여는게 들어오는 그냥 push
            if (input.charAt(i) == ')') {
                if (st.isEmpty()) return false;
                st.pop();
            } else {
                st.push(input.charAt(i));
            }
        }

        if (st.isEmpty()) return true;

        return false;
    }
}