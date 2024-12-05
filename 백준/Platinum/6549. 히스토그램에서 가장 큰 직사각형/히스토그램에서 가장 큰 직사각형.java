import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    //    public static ArrayList<Long> arr;
    public static Long[] arr;
    public static LinkedList<Long> st1;
    public static LinkedList<Integer> st2; // idx
    public static int n;
    public static long max;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            arr = new Long[st.countTokens() + 1];
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            // idx 계산 1부터
            arr[0] = 0L;
            for (int i = 1; i <= n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            // 입력 끝
            st1 = new LinkedList<>();
            st2 = new LinkedList<>();
            max = Long.MIN_VALUE;
            go();
            System.out.println(max);
        }
    }

    public static void go() {
        for (int i = 1; i <= n; i++) {
            while (!st1.isEmpty()) {
                if (st1.peek() > arr[i]) {
                    long nowVal = st1.pop();
                    int nowIdx = st2.pop(); // nowIdx는 따로 쓰지 않는다. 그냥 pop한걸로 충분
                    int leftIdx = -1;
                    int rightIdx = i - 1;
                    if (st2.isEmpty())
                        leftIdx = 1; // 2 1 4
                    else
                        leftIdx = st2.peek() + 1;
                    long width = rightIdx - leftIdx + 1;
                    long area = width * nowVal;
                    max = Math.max(max, area);
                } else {
                    break;
                }
            }
            st1.push(arr[i]);
            st2.push(i);
        }
        // 남은 스택 정리
        while (!st1.isEmpty()) {
            Long nowVal = st1.pop();
            int nowIdx = st2.pop();
            int rightIdx = n; // 오른쪽 끝
            int leftIdx = -1;
            if (st2.isEmpty()) {
                leftIdx = 1;
            } else {
                leftIdx = st2.peek() + 1;
            }
            long width = rightIdx - leftIdx + 1;
            long area = width * nowVal;
            max = Math.max(max, area);
        }
    }
}