import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Character> st;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(go(st.nextToken()));
    }

    public static int go(String input) {
        st = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            // 레이저 기준으로 다 더하면 된다 그랬는데 기억이 안나서 무식하게 풀었음
            if (i < input.length() - 1 && input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
                cnt += st.size();
                i++;
            } else if (input.charAt(i) == '(') {
                st.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                st.pop();
                cnt++;
            }
        }
        return cnt;
    }
}